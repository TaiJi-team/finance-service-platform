package com.central.finance.service;

import com.central.finance.model.FinanOrgRecode;
import com.central.common.service.ISuperService;

import java.util.List;

/**
 * 金融机构认证记录表
 *
 * @author zlt
 * @date 2020-10-27 11:39:02
 */
public interface FinanOrgRecodeService extends ISuperService<FinanOrgRecode> {

    /**
     * 查询金融机构入驻记录
     *
     * @param compId
     * @return
     */
    List<FinanOrgRecode> findList(String compId);

    /**
     * 金融机构入驻签约记录，记录签约人信息等
     *
     * @param finanOrgRecode
     * @return
     */
     Boolean saveAdd(FinanOrgRecode finanOrgRecode);
}

