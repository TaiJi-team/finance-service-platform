package com.central.finance.service;

import com.central.common.service.ISuperService;
import com.central.finance.model.IndivRecode;

import java.util.List;

/**
 * 个体户认证记录表
 *
 * @author zlt
 * @date 2020-10-27 15:54:28
 */
public interface IndivRecodeService extends ISuperService<IndivRecode> {

    /**
     * 查询个体户入驻记录
     *
     * @param compId
     * @return
     */
    List<IndivRecode> findList(String compId);

    /**
     * 个体户入驻签约记录，记录签约人信息等
     *
     * @param indivRecode
     * @return
     */
     Boolean saveAdd(IndivRecode indivRecode);
}

