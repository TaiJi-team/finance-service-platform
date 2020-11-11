package com.central.finance.service;

import com.central.common.service.ISuperService;
import com.central.finance.model.HCompRecode;

import java.util.List;

/**
 * 企业认证记录表
 *
 * @author zlt
 * @date 2020-10-26 16:45:33
 */
public interface CompRecodeService extends ISuperService<HCompRecode> {
    /**
     * 查询企业入驻记录
     *
     * @param compId
     * @return
     */
    List<HCompRecode> findList(String compId);

    /**
     * 企业入驻签约记录，记录签约人信息等
     *
     * @param hCompRecode
     * @return
     */
     Boolean saveAdd(HCompRecode hCompRecode);
}

