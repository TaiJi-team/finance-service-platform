package com.central.finance.feign.fallback;

import cn.hutool.core.collection.CollectionUtil;
import com.central.finance.feign.UserFeign;
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
public class UserFeignFallbackFactory implements FallbackFactory<UserFeign> {
    @Override
    public UserFeign create(Throwable throwable) {
        return new UserFeign() {

            /**
             * 入驻时新增用户关联表信息
             * @param userRelation
             * @return
             */
            @Override
            public UserRelation saveRelation(UserRelation userRelation) {
                return userRelation;
            }

            @Override
            public UserRelation updatePer(UserRelation userRelation) {
                return userRelation;
            }

            @Override
            public List<UserRelation> selectList(String id) {
                log.error("调用selectList异常：{}", id, throwable);
                return CollectionUtil.newArrayList();            }
        };
    }
}
