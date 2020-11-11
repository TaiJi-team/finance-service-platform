package com.central.finance.mapper;

import com.central.finance.model.FinanOrgRecode;
import com.central.db.mapper.SuperMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 金融机构认证记录表
 *
 * @author zlt
 * @date 2020-10-27 11:39:02
 */
@Mapper
public interface FinanOrgRecodeMapper extends SuperMapper<FinanOrgRecode> {

    /**
     * 查询用户列表
     *
     * @param compId
     * @return
     */
    List<FinanOrgRecode> findList(String compId);

    /**
     * 查询企业入驻记录
     * @param finanOrgRecode
     *
     * @return
     */
    Boolean saveAdd(FinanOrgRecode finanOrgRecode);
}
