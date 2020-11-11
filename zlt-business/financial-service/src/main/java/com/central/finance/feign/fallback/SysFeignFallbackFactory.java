package com.central.finance.feign.fallback;

import cn.hutool.core.collection.CollectionUtil;
import com.central.finance.feign.SysFeign;
import com.central.finance.model.*;
import feign.hystrix.FallbackFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * menuService降级工场
 *
 * @author lib
 * @date 2020/11/3
 */
@Slf4j
@Component
public class SysFeignFallbackFactory implements FallbackFactory<SysFeign> {
    @Override
    public SysFeign create(Throwable throwable) {
        return new SysFeign() {
            /**
             * 查询企业法人信息
             * @param id
             * @return
             */
            @Override
            public List<UserCompLegpers> selectList(String id) {
                log.error("调用selectList异常：{}", id, throwable);
                return CollectionUtil.newArrayList();
            }

            /**
             * 查询企业经办人信息数据
             * @param id
             * @return
             */
            @Override
            public List<UserCompOper> selectCompOper(String id) {
                log.error("调用selectCompOper异常：{}", id, throwable);
                return CollectionUtil.newArrayList();
            }

            /**
             * 查询企业经办人信息数据
             * @param id
             * @return
             */
            @Override
            public List<UserIndivOwer> selectListOwer(String id) {
                return CollectionUtil.newArrayList();
            }

            /**
             * 查询个体户经办人信息数据
             * @param id
             * @return
             */
            @Override
            public List<UserIndivOper> selectListOper(String id) {
                return CollectionUtil.newArrayList();
            }

            /**
             * 查询金融机构信息数据
             * @param id
             * @return
             */
            @Override
            public List<UserOrgLegpers> selectPers(String id) {
                return CollectionUtil.newArrayList();
            }

            /**
             * 查询融机构经办人信息数据
             * @param id
             * @return
             */
            @Override
            public List<UserOrgOper> selectOper(String id) {
                return CollectionUtil.newArrayList();
            }

            /**
             * 新增企业经办人信息
             * @param userCompOper
             * @return
             */
            @Override
            public UserCompOper save(UserCompOper userCompOper) {
                log.error("调用save异常：{}", userCompOper, throwable);
                return userCompOper;
            }

            /**
             * 修改企业经办人信息
             * @param userCompOper
             * @return
             */
            @Override
            public UserCompOper update(UserCompOper userCompOper) {
                return userCompOper;
            }

            /**
             * 新增企业法人信息
             * @param userCompLegpers
             * @return
             */
            @Override
            public UserCompLegpers savePer(UserCompLegpers userCompLegpers) {
                return userCompLegpers;
            }

            /**
             * 修改企业法人信息
             * @param userCompLegpers
             * @return
             */
            @Override
            public UserCompLegpers updatePer(UserCompLegpers userCompLegpers) {
                return userCompLegpers;
            }

            /**
             * 新增个体户经办人信息
             * @param userIndivOper
             * @return
             */
            @Override
            public UserIndivOper saveIn(UserIndivOper userIndivOper) {
                return userIndivOper;
            }

            /**
             * 修改个体户经办人信息
             * @param userIndivOper
             * @return
             */
            @Override
            public UserIndivOper updateIn(UserIndivOper userIndivOper) {
                return userIndivOper;
            }

            /**
             * 新增个体户
             * @param userIndivOwer
             * @return
             */
            @Override
            public UserIndivOwer saveOwer(UserIndivOwer userIndivOwer) {
                return userIndivOwer;
            }

            /**
             * 修改个体户
             * @param userIndivOwer
             * @return
             */
            @Override
            public UserIndivOwer updateOwer(UserIndivOwer userIndivOwer) {
                return userIndivOwer;
            }

            /**
             * 新增金融机构信息
             * @param userOrgLegpers
             * @return
             */
            @Override
            public UserOrgLegpers saveOrg(UserOrgLegpers userOrgLegpers) {
                return userOrgLegpers;
            }

            /**
             * 修改金融机构法人信息
             * @param userOrgLegpers
             * @return
             */
            @Override
            public UserOrgLegpers updateOrg(UserOrgLegpers userOrgLegpers) {
                return userOrgLegpers;
            }

            /**
             * 新增金融机构经办人信息
             * @param userOrgOper
             * @return
             */
            @Override
            public UserOrgOper saveOrgPer(UserOrgOper userOrgOper) {
                return userOrgOper;
            }

            /**
             * 修改金融机构经办人信息
             * @param userOrgOper
             * @return
             */
            @Override
            public UserOrgOper updateOrgPer(UserOrgOper userOrgOper) {
                return userOrgOper;
            }

            /**
             * 入驻时新增用户关联表信息
             * @param userRelation
             * @return
             */
            @Override
            public UserRelation saveRelation(UserRelation userRelation) {
                return userRelation;
            }
        };
    }
}
