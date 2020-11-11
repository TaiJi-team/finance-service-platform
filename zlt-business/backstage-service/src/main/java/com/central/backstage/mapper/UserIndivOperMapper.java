package com.central.backstage.mapper;

import com.central.backstage.model.UserCompOper;
import com.central.backstage.model.UserIndivOper;
import com.central.db.mapper.SuperMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * 个体户经办人表
 *
 * @author ljb
 * @date 2020-11-02 15:22:46
 */
@Mapper
public interface UserIndivOperMapper extends SuperMapper<UserIndivOper> {
    /**
     * 分页查询用户列表
     * @param page
     * @param params
     * @return
     */
    List<UserIndivOper> findList(Page<UserIndivOper> page, @Param("p") Map<String, Object> params);

    /**
     * 查询
     * @param id
     * @return
     */
    List<UserIndivOper> findUserById(String id);

    /**
     * 新增
     * @param userIndivOper
     * @return
     */
    Boolean saveAdd(UserIndivOper userIndivOper);
}
