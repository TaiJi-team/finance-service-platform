package com.central.finance.service.impl;

import com.central.common.utils.Sequence;
import com.central.finance.mapper.CompOpenBankMapper;
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

import com.central.finance.mapper.CompAttachmentMapper;
import com.central.finance.service.ICompAttachmentService;

/**
 * 企业附件表
 *
 * @author ljb
 * @date 2020-10-30 10:08:29
 */
@Slf4j
@Service
public class CompAttachmentServiceImpl extends SuperServiceImpl<CompAttachmentMapper, CompAttachment> implements ICompAttachmentService {
    @Autowired
    private CompOpenBankMapper compOpenBankMapper;

    /**
     * 列表
     *
     * @param params
     * @return
     */
    @Override
    public PageResult<CompAttachment> findList(Map<String, Object> params) {
        Page<CompAttachment> page = new Page<>(MapUtils.getInteger(params, "page"), MapUtils.getInteger(params, "limit"));
        List<CompAttachment> list = baseMapper.findList(page, params);
        return PageResult.<CompAttachment>builder().data(list).code(0).count(page.getTotal()).build();
    }

    /**
     * 修改
     * compId
     *
     * @return
     */
    @Override
    public Boolean updateCompany(CompanyVo companyVo) {
        //企业附件表
        CompAttachment compAttachments = companyVo.getCompAttachments();
        //企业银行账户表
        CompOpenBank compOpenBanks = companyVo.getCompOpenBanks();
        //雪花算法生成id
        Sequence sequence = new Sequence();
        //判断企业附件信息是否为空
        if (compAttachments != null) {
            //新增
            if (compAttachments.getId() == null) {
                compAttachments.setId(sequence.nextId());
                baseMapper.saveAdd(compAttachments);
            } else {
                baseMapper.updateById(compAttachments);
            }
        }
        //判断经办人表信息是否为空
        if (compOpenBanks != null) {
            //新增
            if (compOpenBanks.getId() == null) {
                compOpenBanks.setId(sequence.nextId());
                compOpenBankMapper.saveAdd(compOpenBanks);
            } else {
                compOpenBankMapper.updateById(compOpenBanks);
            }
        }
        return true;
    }
}
