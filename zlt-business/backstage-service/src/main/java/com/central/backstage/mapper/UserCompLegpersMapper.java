package com.central.backstage.mapper;

import com.central.backstage.model.UserCompLegpers;
import com.central.db.mapper.SuperMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * 企业管法人代表表
 *
 * @author ljb
 * @date 2020-11-02 15:21:07
 */
@Mapper
public interface UserCompLegpersMapper extends SuperMapper<UserCompLegpers> {
    /**
     * 分页查询用户列表
     * @param page
     * @param params
     * @return
     */
    List<UserCompLegpers> findList(Page<UserCompLegpers> page, @Param("p") Map<String, Object> params);

    /**
     * 查询
     * @param id
     * @return
     */
    List<UserCompLegpers> findUserById(String id);

    /**
     * 新增
     * @param userCompLegpers
     * @return
     */
    Boolean saveAdd(UserCompLegpers userCompLegpers);
}
