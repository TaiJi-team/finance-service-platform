package com.central.finance.mapper;

import com.central.finance.model.FinanOrgRecode;
import com.central.finance.model.FinanceOrg;
import com.central.db.mapper.SuperMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * 金融机构表
 *
 * @author ljb
 * @date 2020-10-29 09:21:31
 */
@Mapper
public interface FinanceOrgMapper extends SuperMapper<FinanceOrg> {
    /**
     * 分页查询用户列表
     *
     * @param page
     * @param params
     * @return
     */
    List<FinanceOrg> findList(Page<FinanceOrg> page, @Param("p") Map<String, Object> params);

    /**
     * 查询
     *
     * @param id
     * @return
     */
    FinanceOrg getById(String id);

    /**
     * 新增
     *
     * @param financeOrg
     * @return
     */
    Boolean saveAdd(FinanceOrg financeOrg);

    /**
     * 修改
     *
     * @param financeOrg
     * @return
     */
    Boolean update(FinanceOrg financeOrg);
}
