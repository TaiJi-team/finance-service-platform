package com.central.finance.mapper;

import com.central.finance.model.CompExtend;
import com.central.db.mapper.SuperMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * 企业扩展表
 * 
 * @author ljb
 * @date 2020-10-30 10:08:39
 */
@Mapper
public interface CompExtendMapper extends SuperMapper<CompExtend> {
    /**
     * 分页查询用户列表
     * @param page
     * @param params
     * @return
     */
    List<CompExtend> findList(Page<CompExtend> page, @Param("p") Map<String, Object> params);
}
