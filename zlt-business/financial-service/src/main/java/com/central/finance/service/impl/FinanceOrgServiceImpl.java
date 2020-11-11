package com.central.finance.service.impl;

import com.central.common.utils.Sequence;
import com.central.finance.feign.SysFeign;
import com.central.finance.feign.UserFeign;
import com.central.finance.model.*;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import com.central.common.model.PageResult;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.central.common.service.impl.SuperServiceImpl;

import java.util.List;
import java.util.Map;

import org.apache.commons.collections4.MapUtils;
import lombok.extern.slf4j.Slf4j;

import com.central.finance.mapper.FinanceOrgMapper;
import com.central.finance.service.IFinanceOrgService;

import javax.annotation.Resource;

/**
 * 金融机构表
 *
 * @author ljb
 * @date 2020-10-29 09:21:31
 */
@Slf4j
@Service
public class FinanceOrgServiceImpl extends SuperServiceImpl<FinanceOrgMapper, FinanceOrg> implements IFinanceOrgService {

    @Resource
    private SysFeign sysFeign;


    @Resource
    private UserFeign userFeign;

    /**
     * 列表
     *
     * @param params
     * @return
     */
    @Override
    public PageResult<FinanceOrg> findList(Map<String, Object> params) {
        Page<FinanceOrg> page = new Page<>(MapUtils.getInteger(params, "page"), MapUtils.getInteger(params, "limit"));
        List<FinanceOrg> list = baseMapper.findList(page, params);
        return PageResult.<FinanceOrg>builder().data(list).code(0).count(page.getTotal()).build();
    }

    /**
     * 新增
     * compId
     *
     * @return
     */
    @Override
    public Boolean saveAdd(FinanceOrgVo financeOrgVo) {
        FinanceOrg financeOrg = financeOrgVo;
        //法人表
        UserOrgLegpers userOrgLegpers = financeOrgVo.getUserOrgLegpers();
        //经办人
        UserOrgOper userOrgOpers = financeOrgVo.getUserOrgOpers();
        Sequence sequence = new Sequence();
        long id = sequence.nextId();
        financeOrg.setId(id);
        UserRelation userRelation = financeOrgVo.getUserRelation();
        userRelation.setCompId(id);
        userFeign.saveRelation(userRelation);
        Boolean aBoolean = baseMapper.saveAdd(financeOrg);
        if (aBoolean.equals(true)) {
            //判断法人信息是否为空
            if (userOrgLegpers != null) {
                UserOrgLegpers userOrgLegpers1 = new UserOrgLegpers();
                userOrgLegpers1.setId(sequence.nextId());
                userOrgLegpers1.setCompId(id);
                sysFeign.saveOrg(userOrgLegpers1);
            }
            //判断经办人表信息是否为空
            if (userOrgOpers != null) {
                UserOrgOper userOrgOper = new UserOrgOper();
                userOrgOper.setId(sequence.nextId());
                userOrgOper.setCompId(id);
                sysFeign.saveOrgPer(userOrgOper);
            }

        }
        return true;
    }

    /**
     * 修改
     * compId
     *
     * @return
     */
    @Override
    public Boolean updateFinance(FinanceOrgVo financeOrgVo) {
        FinanceOrg financeOrg = financeOrgVo;
        //法人表
        UserOrgLegpers userOrgLegpers = financeOrgVo.getUserOrgLegpers();
        //经办人
        UserOrgOper userOrgOpers = financeOrgVo.getUserOrgOpers();
        UserRelation userRelation = financeOrgVo.getUserRelation();
        userFeign.updatePer(userRelation);
        Boolean aBoolean = baseMapper.update(financeOrg);
        Sequence sequence = new Sequence();
        if (aBoolean.equals(true)) {
            //判断法人人信息是否为空
            if (userOrgLegpers != null) {
                //新增
                if (userOrgLegpers.getId() == null) {
                    userOrgLegpers.setId(sequence.nextId());
                    userOrgLegpers.setCompId(financeOrgVo.getId());
                    sysFeign.saveOrg(userOrgLegpers);
                } else {
                    sysFeign.updateOrg(userOrgLegpers);
                }
            }
            //判断经办人表信息是否为空
            if (userOrgOpers != null) {
                //新增
                if (userOrgOpers.getId() == null) {
                    userOrgOpers.setId(sequence.nextId());
                    userOrgOpers.setCompId(financeOrgVo.getId());
                    sysFeign.saveOrgPer(userOrgOpers);
                } else {
                    sysFeign.updateOrgPer(userOrgOpers);
                }
            }

        }
        return aBoolean;


    }

    /**
     * 查询
     *
     * @param id
     * @return
     */
    @Override
    public FinanceOrgVo getById(String id) {
        FinanceOrgVo financeOrgVo = new FinanceOrgVo();
        //通过反射将一个对象的值赋值个另外一个对象
        BeanUtils.copyProperties(baseMapper.getById(id), financeOrgVo);
        //需要调用接口
        List<UserOrgLegpers> userOrgLegpersList = sysFeign.selectPers(id);
        if (userOrgLegpersList.size() > 0) {
            //List转为数组
            UserOrgLegpers userIndivOwers = userOrgLegpersList.get(0);
            financeOrgVo.setUserOrgLegpers(userIndivOwers);
        }
        //需要调用接口
        List<UserOrgOper> userOrgOperList = sysFeign.selectOper(id);
        if (userOrgOperList.size() > 0) {
            //List转为数组
            UserOrgOper userOrgOpers = userOrgOperList.get(0);
            financeOrgVo.setUserOrgOpers(userOrgOpers);
        }
        //需要调用接口
        List<UserRelation> userRelations = userFeign.selectList(id);
        if (userRelations.size() > 0) {
            //List转为数组
            UserRelation userRelation = userRelations.get(0);
            financeOrgVo.setUserRelation(userRelation);
        }
        return financeOrgVo;
    }

}
