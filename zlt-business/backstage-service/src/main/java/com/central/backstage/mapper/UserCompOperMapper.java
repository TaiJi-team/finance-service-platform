package com.central.backstage.mapper;

import com.central.backstage.model.UserCompLegpers;
import com.central.backstage.model.UserCompOper;
import com.central.db.mapper.SuperMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * 企业经办人表
 *
 * @author ljb
 * @date 2020-10-30 18:49:31
 */
@Mapper
public interface UserCompOperMapper extends SuperMapper<UserCompOper> {
    /**
     * 分页查询用户列表
     * @param page
     * @param params
     * @return
     */
    List<UserCompOper> findList(Page<UserCompOper> page, @Param("p") Map<String, Object> params);

    /**
     * 新增
     * @param userCompOper
     * @return
     */
    Boolean saveAdd(UserCompOper userCompOper);

    /**
     * 查询
     * @param id
     * @return
     */
    List<UserCompOper> findUserById(String id);
}
