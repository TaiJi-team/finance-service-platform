package com.central.finance.mapper;

import com.central.finance.model.CompStockh;
import com.central.db.mapper.SuperMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * 企业股东表
 * 
 * @author ljb
 * @date 2020-10-30 10:08:33
 */
@Mapper
public interface CompStockhMapper extends SuperMapper<CompStockh> {
    /**
     * 分页查询用户列表
     * @param page
     * @param params
     * @return
     */
    List<CompStockh> findList(Page<CompStockh> page, @Param("p") Map<String, Object> params);
}
