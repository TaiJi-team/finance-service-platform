package com.central.backstage.mapper;

import com.central.backstage.model.UserCompOper;
import com.central.backstage.model.UserOrgOper;
import com.central.db.mapper.SuperMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * 机构经办人表
 *
 * @author ljb
 * @date 2020-11-02 15:23:56
 */
@Mapper
public interface UserOrgOperMapper extends SuperMapper<UserOrgOper> {
    /**
     * 分页查询用户列表
     * @param page
     * @param params
     * @return
     */
    List<UserOrgOper> findList(Page<UserOrgOper> page, @Param("p") Map<String, Object> params);

    /**
     * 查询
     * @param id
     * @return
     */
    List<UserOrgOper> findUserById(String id);

    /**
     * 新增
     * @param userOrgOper
     * @return
     */
    Boolean saveAdd(UserOrgOper userOrgOper);
}
