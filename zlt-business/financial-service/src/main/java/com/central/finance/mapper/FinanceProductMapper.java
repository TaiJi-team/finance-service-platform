package com.central.finance.mapper;

import com.central.finance.model.FinanceProduct;
import com.central.db.mapper.SuperMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * 金融产品表
 *
 * @author ljb
 * @date 2020-11-03 14:11:44
 */
@Mapper
public interface FinanceProductMapper extends SuperMapper<FinanceProduct> {
    /**
     * 分页查询用户列表
     * @param page
     * @param params
     * @return
     */
    List<FinanceProduct> findList(Page<FinanceProduct> page, @Param("p") Map<String, Object> params);

    /**
     * 查询金融产品详情
     * @param id
     * @return
     */
    FinanceProduct findUserById(@Param("id") String id);

    /**
     * 添加金融产品
     * @param financeProduct
     * @return
     */
    Boolean saveAdd(FinanceProduct financeProduct);
}
