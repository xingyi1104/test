package trip.one.manager;

import java.util.Date;

import org.springframework.stereotype.Component;

import jakarta.annotation.Resource;
import trip.one.beans.XingyiTestDO;
import trip.one.mapper.XingyiTestDOMapper;

@Component
public class XingyiTestManager {

    @Resource
    private XingyiTestDOMapper xingyiTestDOMapper;

    /**
     * 根据主键查询企业信息
     */
    public XingyiTestDO selectByPrimaryKey(Long id) {
        return xingyiTestDOMapper.selectByPrimaryKey(id);
    }

    /**
     * 新增企业记录
     */
    public int insert(String corpId, String corpName) {
        XingyiTestDO record = new XingyiTestDO();
        record.setCorpId(corpId);
        record.setCorpName(corpName);
        record.setGmtCreate(new Date());
        record.setGmtModified(new Date());
        return xingyiTestDOMapper.insertSelective(record);
    }
}
