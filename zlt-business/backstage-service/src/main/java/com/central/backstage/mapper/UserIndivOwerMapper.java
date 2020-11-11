package com.central.backstage.mapper;

import com.central.backstage.model.UserCompOper;
import com.central.backstage.model.UserIndivOwer;
import com.central.db.mapper.SuperMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * 个体户户主表
 *
 * @author ljb
 * @date 2020-11-02 15:22:44
 */
@Mapper
public interface UserIndivOwerMapper extends SuperMapper<UserIndivOwer> {
    /**
     * 分页查询用户列表
     * @param page
     * @param params
     * @return
     */
    List<UserIndivOwer> findList(Page<UserIndivOwer> page, @Param("p") Map<String, Object> params);

    /**
     * 查询
     * @param id
     * @return
     */
    List<UserIndivOwer> findUserById(String id);

    /**
     * 新增
     * @param userIndivOwer
     * @return
     */
    Boolean saveAdd(UserIndivOwer userIndivOwer);
}
