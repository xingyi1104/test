package trip.one.manager;

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
}
