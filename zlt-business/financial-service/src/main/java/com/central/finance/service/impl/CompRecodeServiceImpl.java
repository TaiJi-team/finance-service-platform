package com.central.finance.service.impl;

import com.central.common.service.impl.SuperServiceImpl;
import com.central.common.utils.Sequence;
import com.central.finance.mapper.CompRecodeMapper;
import com.central.finance.model.HCompRecode;
import com.central.finance.service.CompRecodeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * 企业认证记录表
 *
 * @author zlt
 * @date 2020-10-26 16:45:33
 */
@Slf4j
@Service
public class CompRecodeServiceImpl extends SuperServiceImpl<CompRecodeMapper, HCompRecode> implements CompRecodeService {
    /**
     * 查询企业入驻记录
     * compId
     *
     * @return
     */
    @Override
    public List<HCompRecode> findList(String compId) {
        return baseMapper.findList(compId);
    }

    ;

    /**
     * 企业入驻签约记录，记录签约人信息等
     * compId
     *
     * @return
     */
    @Override
    public Boolean saveAdd(HCompRecode hCompRecode) {
        //雪花算法生成id
        Sequence sequence = new Sequence();
        long id = sequence.nextId();
        hCompRecode.setId(id);
        return baseMapper.saveAdd(hCompRecode);
    }
}
