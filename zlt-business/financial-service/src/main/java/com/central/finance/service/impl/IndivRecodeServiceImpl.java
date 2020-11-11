package com.central.finance.service.impl;

import com.central.common.utils.Sequence;
import com.central.finance.mapper.IndivRecodeMapper;

import com.central.finance.model.IndivRecode;
import com.central.finance.service.IndivRecodeService;
import org.springframework.stereotype.Service;

import com.central.common.service.impl.SuperServiceImpl;

import java.util.List;

import lombok.extern.slf4j.Slf4j;


/**
 * 个体户认证记录表
 *
 * @author zlt
 * @date 2020-10-27 15:54:28
 */
@Slf4j
@Service
public class IndivRecodeServiceImpl extends SuperServiceImpl<IndivRecodeMapper, IndivRecode> implements IndivRecodeService {
    /**
     * 查询个体户入驻记录
     * compId
     *
     * @return
     */
    @Override
    public List<IndivRecode> findList(String compId) {
        return baseMapper.findList(compId);
    }

    ;

    /**
     * 个体户入驻签约记录，记录签约人信息等
     * compId
     *
     * @return
     */
    @Override
    public Boolean saveAdd(IndivRecode indivRecode) {
        //雪花算法生成id
        Sequence sequence = new Sequence();
        long id = sequence.nextId();
        indivRecode.setId(id);
        return baseMapper.saveAdd(indivRecode);
    }
}
