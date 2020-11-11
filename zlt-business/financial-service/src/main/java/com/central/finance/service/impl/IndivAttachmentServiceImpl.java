package com.central.finance.service.impl;

import com.central.common.utils.Sequence;
import com.central.finance.mapper.IndivOpenBankMapper;
import com.central.finance.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.central.common.model.PageResult;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.central.common.service.impl.SuperServiceImpl;

import java.util.List;
import java.util.Map;

import org.apache.commons.collections4.MapUtils;
import lombok.extern.slf4j.Slf4j;

import com.central.finance.mapper.IndivAttachmentMapper;
import com.central.finance.service.IIndivAttachmentService;

/**
 * 个体户企业附件表
 *
 * @author ljb
 * @date 2020-10-30 10:06:44
 */
@Slf4j
@Service
public class IndivAttachmentServiceImpl extends SuperServiceImpl<IndivAttachmentMapper, IndivAttachment> implements IIndivAttachmentService {
    @Autowired
    private IndivOpenBankMapper indivOpenBankMapper;

    /**
     * 列表
     *
     * @param params
     * @return
     */
    @Override
    public PageResult<IndivAttachment> findList(Map<String, Object> params) {
        Page<IndivAttachment> page = new Page<>(MapUtils.getInteger(params, "page"), MapUtils.getInteger(params, "limit"));
        List<IndivAttachment> list = baseMapper.findList(page, params);
        return PageResult.<IndivAttachment>builder().data(list).code(0).count(page.getTotal()).build();
    }

    /**
     * 修改
     * compId
     *
     * @return
     */
    @Override
    public Boolean updateIndiv(IndivVo indivVo) {
        //企业附件表
        IndivAttachment indivAttachments = indivVo.getIndivAttachments();
        //企业银行账户表
        IndivOpenBank compOpenBanks = indivVo.getIndivOpenBanks();
        //雪花算法生成id
        Sequence sequence = new Sequence();
        //判断企业附件信息是否为空
        if (indivAttachments != null) {
            //新增
            if (indivAttachments.getId() == null) {
                indivAttachments.setId(sequence.nextId());
                baseMapper.saveAdd(indivAttachments);
            } else {
                baseMapper.updateById(indivAttachments);
            }
        }
        //判断经办人表信息是否为空
        if (compOpenBanks != null) {
            //新增
            if (compOpenBanks.getId() == null) {
                compOpenBanks.setId(sequence.nextId());
                indivOpenBankMapper.saveAdd(compOpenBanks);
            } else {
                indivOpenBankMapper.updateById(compOpenBanks);
            }
        }
        return true;
    }
}
