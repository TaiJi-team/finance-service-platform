package com.central.finance.mapper;

import com.central.db.mapper.SuperMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.central.finance.model.IndivHouseh;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * 个体户企业表
 *
 * @author zlt
 * @date 2020-10-27 16:21:31
 */
@Mapper
public interface IndivHousehMapper extends SuperMapper<IndivHouseh> {
    /**
     * 分页查询用户列表
     *
     * @param page
     * @param params
     * @return params
     */
    List<IndivHouseh> findList(Page<IndivHouseh> page, @Param("p") Map<String, Object> params);

    /**
     * 查询企业入驻记录
     * compId
     * @param indivHouseh
     * @return indivHouseh
     */
    Boolean saveAdd(IndivHouseh indivHouseh);

    /**
     * 查询
     *
     * @param id
     * @return id
     */
    IndivHouseh getById(String id);
}
