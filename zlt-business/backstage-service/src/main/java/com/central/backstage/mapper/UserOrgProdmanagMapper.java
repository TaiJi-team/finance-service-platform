package com.central.backstage.mapper;

import com.central.backstage.model.UserOrgProdmanag;
import com.central.db.mapper.SuperMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * 机构产品经理表
 *
 * @author ljb
 * @date 2020-11-02 15:23:55
 */
@Mapper
public interface UserOrgProdmanagMapper extends SuperMapper<UserOrgProdmanag> {
    /**
     * 分页查询用户列表
     *
     * @param page
     * @param params
     * @return
     */
    List<UserOrgProdmanag> findList(Page<UserOrgProdmanag> page, @Param("p") Map<String, Object> params);

    /**
     * 指定产品经理新增
     *
     * @param userOrgProdmanag
     * @return
     */
    Boolean saveManage(UserOrgProdmanag userOrgProdmanag);
}


