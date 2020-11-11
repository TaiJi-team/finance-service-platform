package com.central.finance.service.impl;

import com.central.common.utils.Sequence;
import com.central.finance.mapper.FinanceOrgOpenBankMapper;
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

import com.central.finance.mapper.FinanceOrgAttachmentMapper;
import com.central.finance.service.IFinanceOrgAttachmentService;

/**
 * 金融机构附件表
 *
 * @author ljb
 * @date 2020-10-30 11:08:21
 */
@Slf4j
@Service
public class FinanceOrgAttachmentServiceImpl extends SuperServiceImpl<FinanceOrgAttachmentMapper, FinanceOrgAttachment> implements IFinanceOrgAttachmentService {
    @Autowired
    private FinanceOrgOpenBankMapper financeOrgOpenBankMapper;

    /**
     * 列表
     *
     * @param params
     * @return
     */
    @Override
    public PageResult<FinanceOrgAttachment> findList(Map<String, Object> params) {
        Page<FinanceOrgAttachment> page = new Page<>(MapUtils.getInteger(params, "page"), MapUtils.getInteger(params, "limit"));
        List<FinanceOrgAttachment> list = baseMapper.findList(page, params);
        return PageResult.<FinanceOrgAttachment>builder().data(list).code(0).count(page.getTotal()).build();
    }

    /**
     * 修改
     * compId
     *
     * @return
     */
    @Override
    public Boolean updateFinance(FinanceOrgVo financeOrgVo) {
        //企业附件表
        FinanceOrgAttachment financeOrgAttachments = financeOrgVo.getFinanceOrgAttachments();
        //企业银行账户表
        FinanceOrgOpenBank financeOrgOpenBanks = financeOrgVo.getFinanceOrgOpenBanks();
        //雪花算法生成id
        Sequence sequence = new Sequence();
        //判断企业附件信息是否为空
        if (financeOrgAttachments != null) {
            //新增
            if (financeOrgAttachments.getId() == null) {
                financeOrgAttachments.setId(sequence.nextId());
                baseMapper.saveAdd(financeOrgAttachments);
            } else {
                baseMapper.updateById(financeOrgAttachments);
            }
        }
        //判断经办人表信息是否为空
        if (financeOrgOpenBanks != null) {
            if (financeOrgOpenBanks.getId() == null) {
                financeOrgOpenBanks.setId(sequence.nextId());
                financeOrgOpenBankMapper.saveAdd(financeOrgOpenBanks);
            } else {
                financeOrgOpenBankMapper.updateById(financeOrgOpenBanks);
            }
        }
        return true;
    }
}
