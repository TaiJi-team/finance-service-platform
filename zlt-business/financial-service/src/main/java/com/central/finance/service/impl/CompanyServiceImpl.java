package com.central.finance.service.impl;

import com.central.common.utils.Sequence;
import com.central.finance.feign.SysFeign;
import com.central.finance.feign.UserFeign;
import com.central.finance.model.*;
import com.central.finance.service.CompanyService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import com.central.common.model.PageResult;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.central.common.service.impl.SuperServiceImpl;

import java.util.List;
import java.util.Map;

import org.apache.commons.collections4.MapUtils;
import lombok.extern.slf4j.Slf4j;

import com.central.finance.mapper.CompanyMapper;

import javax.annotation.Resource;

/**
 * 企业表
 *
 * @author ljb
 * @date 2020-10-28 15:02:14
 */
@Slf4j
@Service
public class CompanyServiceImpl extends SuperServiceImpl<CompanyMapper, Company> implements CompanyService {
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
    public PageResult<Company> findList(Map<String, Object> params) {
        Page<Company> page = new Page<>(MapUtils.getInteger(params, "page"), MapUtils.getInteger(params, "limit"));
        List<Company> list = baseMapper.findList(page, params);
        return PageResult.<Company>builder().data(list).code(0).count(page.getTotal()).build();
    }

    /**
     * 新增
     * compId
     *
     * @return
     */
    @Override
    public Boolean saveAdd(CompanyVo companyVo) {
        Company company = companyVo;
        //法人表
        UserCompLegpers userCompLegpers = companyVo.getUserCompLegpers();
        //经办人
        UserCompOper userCompOpers = companyVo.getUserCompOpers();
        //雪花算法生成id
        Sequence sequence = new Sequence();
        long id = sequence.nextId();
        company.setId(id);
        int insert = baseMapper.save(company);
        UserRelation userRelation = companyVo.getUserRelation();
        userRelation.setCompId(id);
        userFeign.saveRelation(userRelation);
        if (insert > 0) {
            //判断法人信息是否为空
            if (userCompLegpers != null) {
                UserCompLegpers userCompLegpers1 = new UserCompLegpers();
                userCompLegpers1.setId(sequence.nextId());
                userCompLegpers1.setCompId(id);
                sysFeign.savePer(userCompLegpers1);
            }
            //判断经办人表信息是否为空
            if (userCompOpers != null) {
                UserCompOper indivOwer = new UserCompOper();
                indivOwer.setId(sequence.nextId());
                indivOwer.setCompId(id);
                sysFeign.save(indivOwer);
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
    public Boolean updateCompany(CompanyVo companyVo) {
        Company company = companyVo;
        //法人表
        UserCompLegpers userCompLegpers = companyVo.getUserCompLegpers();
        //经办人
        UserCompOper userCompOpers = companyVo.getUserCompOpers();
        UserRelation userRelation = companyVo.getUserRelation();
        userFeign.updatePer(userRelation);
        int i = baseMapper.updateById(company);
        //雪花算法生成id
        Sequence sequence = new Sequence();
        if (i > 0) {
            //判断法人人信息是否为空
            if (userCompLegpers != null) {
                //新增
                if (userCompLegpers.getId() == null) {
                    userCompLegpers.setId(sequence.nextId());
                    userCompLegpers.setCompId(companyVo.getId());
                    sysFeign.savePer(userCompLegpers);
                } else {
                    sysFeign.updatePer(userCompLegpers);
                }
            }
            //判断经办人表信息是否为空
            if (userCompOpers != null) {
                //新增
                if (userCompOpers.getId() == null) {
                    userCompOpers.setId(sequence.nextId());
                    userCompOpers.setCompId(companyVo.getId());
                    sysFeign.save(userCompOpers);
                } else {
                    sysFeign.update(userCompOpers);
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
    public CompanyVo getById(String id) {
        CompanyVo companyVo = new CompanyVo();
        //通过反射将一个对象的值赋值个另外一个对象
        Company byId = baseMapper.getById(id);
        if(byId!=null){
            BeanUtils.copyProperties(byId, companyVo);
        }
        List<UserCompLegpers> userCompLegpersList = sysFeign.selectList(id);
        if (userCompLegpersList.size() > 0) {
            //List转为数组
            UserCompLegpers userIndivOwers = userCompLegpersList.get(0);
            companyVo.setUserCompLegpers(userIndivOwers);
        }
        List<UserCompOper> userCompOperList = sysFeign.selectCompOper(id);
        if (userCompOperList.size() > 0) {
            //List转为数组
            UserCompOper userIndivOpers = userCompOperList.get(0);
            companyVo.setUserCompOpers(userIndivOpers);
        }
        List<UserRelation> userRelations = userFeign.selectList(id);
        if (userRelations.size() > 0) {
            //List转为数组
            UserRelation userRelation = userRelations.get(0);
            companyVo.setUserRelation(userRelation);
        }
        return companyVo;
    }
}
