package com.central.finance.mapper;

import com.central.finance.model.FinanceOrgStockh;
import com.central.db.mapper.SuperMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * 金融机构股东表
 * 
 * @author ljb
 * @date 2020-10-30 11:08:24
 */
@Mapper
public interface FinanceOrgStockhMapper extends SuperMapper<FinanceOrgStockh> {
    /**
     * 分页查询用户列表
     * @param page
     * @param params
     * @return
     */
    List<FinanceOrgStockh> findList(Page<FinanceOrgStockh> page, @Param("p") Map<String, Object> params);
}
