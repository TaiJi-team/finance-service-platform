package com.central.finance.service.impl;

import com.central.common.service.impl.SuperServiceImpl;
import com.central.common.utils.Sequence;
import com.central.finance.feign.SysFeign;
import com.central.finance.feign.UserFeign;
import com.central.finance.mapper.IndivHousehMapper;
import com.central.finance.model.*;
import com.central.finance.service.IndivHousehService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import com.central.common.model.PageResult;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import java.util.List;
import java.util.Map;

import org.apache.commons.collections4.MapUtils;
import lombok.extern.slf4j.Slf4j;

import javax.annotation.Resource;


/**
 * 个体户企业表
 *
 * @author zlt
 * @date 2020-10-27 16:21:31
 */
@Slf4j
@Service
public class IndivHousehServiceImpl extends SuperServiceImpl<IndivHousehMapper, IndivHouseh> implements IndivHousehService {
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
    public PageResult<IndivHouseh> findList(Map<String, Object> params) {
        Page<IndivHouseh> page = new Page<>(MapUtils.getInteger(params, "page"), MapUtils.getInteger(params, "limit"));
        List<IndivHouseh> list = baseMapper.findList(page, params);
        return PageResult.<IndivHouseh>builder().data(list).code(0).count(page.getTotal()).build();
    }

    /**
     * 新增
     * compId
     *
     * @return
     */
    @Override
    public Boolean saveAdd(IndivVo indivVo) {
        IndivHouseh indivHouseh = indivVo;
        //经办人
        UserIndivOper indivOperData = indivVo.getIndivOperData();
        //个体户
        UserIndivOwer indivOwerData = indivVo.getIndivOwerData();
        Sequence sequence = new Sequence();
        long id = sequence.nextId();
        indivHouseh.setId(id);
        Boolean aBoolean = baseMapper.saveAdd(indivHouseh);
        UserRelation userRelation = indivVo.getUserRelation();
        userRelation.setCompId(id);
        userFeign.saveRelation(userRelation);
        if (aBoolean.equals(true)) {
            //判断经办人信息是否为空
            if (indivOperData != null) {
                UserIndivOper indivOper = new UserIndivOper();
                indivOper.setId(sequence.nextId());
                indivOper.setCompId(id);
                sysFeign.saveIn(indivOper);
            }
            //判断个体户主表信息是否为空
            if (indivOwerData != null) {
                //通过for循环取出数据
                UserIndivOwer indivOwer = new UserIndivOwer();
                indivOwer.setId(sequence.nextId());
                indivOwer.setCompId(id);
                sysFeign.saveOwer(indivOwer);
            }
        }
        return aBoolean;
    }

    /**
     * 新增
     * compId
     *
     * @return
     */
    @Override
    public Boolean updateIndiv(IndivVo indivVo) {
        IndivHouseh indivHouseh = indivVo;
        //经办人
        UserIndivOper indivOperData = indivVo.getIndivOperData();
        //个体户
        UserIndivOwer indivOwerData = indivVo.getIndivOwerData();
        UserRelation userRelation = indivVo.getUserRelation();
        userFeign.updatePer(userRelation);
        int i = baseMapper.updateById(indivHouseh);
        Sequence sequence = new Sequence();
        if (i > 0) {
            //判断经办人信息是否为空
            if (indivOperData != null) {
                //新增
                if (indivOperData.getId() == null) {
                    indivOperData.setId(sequence.nextId());
                    indivOperData.setCompId(indivVo.getId());
                    sysFeign.saveIn(indivOperData);
                } else {
                    sysFeign.updateIn(indivOperData);
                }
            }
            //判断个体户主表信息是否为空
            if (indivOwerData != null) {
                //新增
                if (indivOwerData.getId() == null) {
                    indivOwerData.setId(sequence.nextId());
                    indivOwerData.setCompId(indivVo.getId());
                    sysFeign.saveOwer(indivOwerData);
                } else {
                    sysFeign.updateOwer(indivOwerData);
                }
            }

        }
        return true;

    }

    /**
     * 查询
     *
     * @param id
     * @return
     */
    @Override
    public IndivVo getById(String id) {
        IndivVo indivVo = new IndivVo();
        //通过反射将一个对象的值赋值个另外一个对象
        IndivHouseh indivHouseh = baseMapper.getById(id);
        if (indivHouseh != null) {
            BeanUtils.copyProperties(indivHouseh, indivVo);
        }
        //需要调用接口
        List<UserIndivOwer> userIndivOwerList = sysFeign.selectListOwer(id);
        if (userIndivOwerList.size() > 0) {
            //List转为数组
            UserIndivOwer userIndivOwers = userIndivOwerList.get(0);
            indivVo.setIndivOwerData(userIndivOwers);
        }
        //需要调用接口
        List<UserIndivOper> userIndivOperList = sysFeign.selectListOper(id);
        if (userIndivOwerList.size() > 0) {
            //List转为数组
            UserIndivOper userIndivOpers = userIndivOperList.get(0);
            indivVo.setIndivOperData(userIndivOpers);
        }
        List<UserRelation> userRelations = userFeign.selectList(id);
        if (userRelations.size() > 0) {
            //List转为数组
            UserRelation userRelation = userRelations.get(0);
            indivVo.setUserRelation(userRelation);
        }
        return indivVo;
    }
}
