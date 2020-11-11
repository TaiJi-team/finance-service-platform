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

import com.central.backstage.model.UserOrgWorker;
import com.central.backstage.mapper.UserOrgWorkerMapper;
import com.central.backstage.service.IUserOrgWorkerService;

/**
 * 机构业务员表
 *
 * @author ljb
 * @date 2020-11-02 15:23:54
 */
@Slf4j
@Service
public class UserOrgWorkerServiceImpl extends SuperServiceImpl<UserOrgWorkerMapper, UserOrgWorker> implements IUserOrgWorkerService {
    /**
     * 列表
     * @param params
     * @return
     */
    @Override
    public PageResult<UserOrgWorker> findList(Map<String, Object> params){
        Page<UserOrgWorker> page = new Page<>(MapUtils.getInteger(params, "page"), MapUtils.getInteger(params, "limit"));
        List<UserOrgWorker> list  =  baseMapper.findList(page, params);
        return PageResult.<UserOrgWorker>builder().data(list).code(0).count(page.getTotal()).build();
    }

    /**
     * 新增业务员信息
     * @param userOrgWorker
     */
    @Override
    public void saveWork(UserOrgWorker userOrgWorker) {
        //雪花算法生成id
        Sequence sequence = new Sequence();
        long id = sequence.nextId();
        userOrgWorker.setId(id);
        baseMapper.saveWork(userOrgWorker);
    }
}
