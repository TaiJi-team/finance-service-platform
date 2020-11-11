package com.central.finance.mapper;

import com.central.finance.model.Company;
import com.central.db.mapper.SuperMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.central.finance.model.IndivHouseh;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * 企业表
 *
 * @author ljb
 * @date 2020-10-28 15:02:14
 */
@Mapper
public interface CompanyMapper extends SuperMapper<Company> {
    /**
     * 分页查询用户列表
     *
     * @param page
     * @param params
     * @return
     */
    List<Company> findList(Page<Company> page, @Param("p") Map<String, Object> params);

    /**
     * 查询
     *
     * @param id
     * @return
     */
     Company getById(String id);

    /**
     * 新增
     * @param company
     * @return
     */
     int save(Company company);
}
