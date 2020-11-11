package com.central.backstage.mapper;

import com.central.backstage.model.UserCompOper;
import com.central.backstage.model.UserOrgLegpers;
import com.central.db.mapper.SuperMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * 机构法人代表表
 *
 * @author ljb
 * @date 2020-11-02 15:24:07
 */
@Mapper
public interface UserOrgLegpersMapper extends SuperMapper<UserOrgLegpers> {
    /**
     * 分页查询用户列表
     * @param page
     * @param params
     * @return
     */
    List<UserOrgLegpers> findList(Page<UserOrgLegpers> page, @Param("p") Map<String, Object> params);

    /**
     * 查询
     * @param id
     * @return
     */
    List<UserOrgLegpers> findUserById(String id);

    /**
     * 新增
     * @param userOrgLegpers
     * @return
     */
    Boolean saveAdd(UserOrgLegpers userOrgLegpers);
}
