package com.central.backstage.mapper;

import com.central.backstage.model.UserOrgSales;
import com.central.db.mapper.SuperMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * 运营机构推广员表
 * 
 * @author ljb
 * @date 2020-11-02 15:23:52
 */
@Mapper
public interface UserOrgSalesMapper extends SuperMapper<UserOrgSales> {
    /**
     * 分页查询用户列表
     * @param page
     * @param params
     * @return
     */
    List<UserOrgSales> findList(Page<UserOrgSales> page, @Param("p") Map<String, Object> params);
}
