package com.central.finance.service.impl;

import com.central.common.utils.Sequence;
import com.central.finance.mapper.FinanOrgRecodeMapper;
import com.central.finance.model.FinanOrgRecode;
import com.central.finance.service.FinanOrgRecodeService;
import org.springframework.stereotype.Service;
import com.central.common.service.impl.SuperServiceImpl;

import java.util.List;

import lombok.extern.slf4j.Slf4j;


/**
 * 金融机构认证记录表
 *
 * @author zlt
 * @date 2020-10-27 11:39:02
 */
@Slf4j
@Service
public class FinanOrgRecodeServiceImpl extends SuperServiceImpl<FinanOrgRecodeMapper, FinanOrgRecode> implements FinanOrgRecodeService {
    /**
     * 查询金融机构入驻记录
     * compId
     *
     * @return
     */
    @Override
    public List<FinanOrgRecode> findList(String compId) {
        return baseMapper.findList(compId);
    }

    ;

    /**
     * 金融机构入驻签约记录，记录签约人信息等
     * compId
     *
     * @return
     */
    @Override
    public Boolean saveAdd(FinanOrgRecode finanOrgRecode) {
        //雪花算法生成id
        Sequence sequence = new Sequence();
        long id = sequence.nextId();
        finanOrgRecode.setId(id);
        return baseMapper.saveAdd(finanOrgRecode);
    }
}
