package trip.one.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jakarta.annotation.Resource;
import trip.one.beans.XingyiTestDO;
import trip.one.manager.XingyiTestManager;

@RestController
@RequestMapping("/xingyi")
public class XingyiTestController {

    @Resource
    private XingyiTestManager xingyiTestManager;

    /**
     * 根据 id 查询企业名称
     * GET /xingyi/corpName?id=1
     */
    @GetMapping("/getCorpName")
    public String getCorpName(@RequestParam Long id) {
        // 根据 id 查询企业信息
        XingyiTestDO record = xingyiTestManager.selectByPrimaryKey(id);
        if (record == null) {
            return "未找到对应企业";
        } else {
            return record.getCorpName();
        }
    }

    /**
     * 新增企业记录
     * POST /xingyi/addCorp?corpId=xxx&corpName=xxx
     */
    @PostMapping("/addCorp")
    public String addCorp(@RequestParam String corpId, @RequestParam String corpName) {
        int rows = xingyiTestManager.insert(corpId, corpName);
        if (rows > 0) {
            return "添加成功";
        } else {
            return "添加失败";
        }
    }
}
