package com.central.finance.mapper;

import com.central.finance.model.IndivExtend;
import com.central.db.mapper.SuperMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * 个体户企业扩展表
 * 
 * @author ljb
 * @date 2020-10-30 10:06:48
 */
@Mapper
public interface IndivExtendMapper extends SuperMapper<IndivExtend> {
    /**
     * 分页查询用户列表
     * @param page
     * @param params
     * @return
     */
    List<IndivExtend> findList(Page<IndivExtend> page, @Param("p") Map<String, Object> params);
}
