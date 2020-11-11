package com.central.backstage.service.impl;

import com.central.common.utils.Sequence;
import org.springframework.stereotype.Service;
import com.central.common.model.PageResult;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.central.common.service.impl.SuperServiceImpl;

import java.util.List;
import java.util.Map;
import org.apache.commons.collections4.MapUtils;
import lombok.extern.slf4j.Slf4j;

import com.central.backstage.model.UserOrgProdmanag;
import com.central.backstage.mapper.UserOrgProdmanagMapper;
import com.central.backstage.service.IUserOrgProdmanagService;

/**
 * 机构产品经理表
 *
 * @author ljb
 * @date 2020-11-02 15:23:55
 */
@Slf4j
@Service
public class UserOrgProdmanagServiceImpl extends SuperServiceImpl<UserOrgProdmanagMapper, UserOrgProdmanag> implements IUserOrgProdmanagService {
    /**
     * 列表
     * @param params
     * @return
     */
    @Override
    public PageResult<UserOrgProdmanag> findList(Map<String, Object> params){
        Page<UserOrgProdmanag> page = new Page<>(MapUtils.getInteger(params, "page"), MapUtils.getInteger(params, "limit"));
        List<UserOrgProdmanag> list  =  baseMapper.findList(page, params);
        return PageResult.<UserOrgProdmanag>builder().data(list).code(0).count(page.getTotal()).build();
    }


    /**
     * 指定产品经理新增
     * @param userOrgProdmanag
     * @return
     */
    @Override
    public Boolean saveManage(UserOrgProdmanag userOrgProdmanag) {
        //雪花算法生成id
        Sequence sequence = new Sequence();
        long id = sequence.nextId();
        userOrgProdmanag.setId(id);
        return baseMapper.saveManage(userOrgProdmanag);
    }
}
