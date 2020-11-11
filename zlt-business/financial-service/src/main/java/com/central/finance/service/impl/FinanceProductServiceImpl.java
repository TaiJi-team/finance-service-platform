package com.central.finance.service.impl;

import com.central.common.utils.Sequence;
import org.springframework.stereotype.Service;
import com.central.common.model.PageResult;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.central.common.service.impl.SuperServiceImpl;

import java.util.List;
import java.util.Map;
import org.apache.commons.collections4.MapUtils;
import lombok.extern.slf4j.Slf4j;

import com.central.finance.model.FinanceProduct;
import com.central.finance.mapper.FinanceProductMapper;
import com.central.finance.service.IFinanceProductService;

/**
 * 金融产品表
 *
 * @author ljb
 * @date 2020-11-03 14:11:44
 */
@Slf4j
@Service
public class FinanceProductServiceImpl extends SuperServiceImpl<FinanceProductMapper, FinanceProduct> implements IFinanceProductService {
    /**
     * 列表
     * @param params
     * @return
     */
    @Override
    public PageResult<FinanceProduct> findList(Map<String, Object> params){
        Page<FinanceProduct> page = new Page<>(MapUtils.getInteger(params, "page"), MapUtils.getInteger(params, "limit"));
        List<FinanceProduct> list  =  baseMapper.findList(page, params);
        return PageResult.<FinanceProduct>builder().data(list).code(0).count(page.getTotal()).build();
    }

    /**
     * 查询金融产品详情
     * @param id
     * @return
     */
    @Override
    public FinanceProduct findUserById(String id) {
        return baseMapper.findUserById(id);
    }

    /**
     * 添加金融产品
     * @param financeProduct
     * @return
     */
    @Override
    public Boolean saveAdd(FinanceProduct financeProduct) {
        //雪花算法生成id
        Sequence sequence = new Sequence();
        long id = sequence.nextId();
        financeProduct.setId(id);
        return baseMapper.saveAdd(financeProduct);
    }


}
