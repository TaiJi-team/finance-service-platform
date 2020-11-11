package com.central.finance.mapper;

import com.central.finance.model.DictType;
import com.central.db.mapper.SuperMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * 字典类型表
 * 
 * @author zlt
 * @date 2020-10-27 09:36:44
 */
@Mapper
public interface DictTypeMapper extends SuperMapper<DictType> {
    /**
     * 分页查询用户列表
     * @param page
     * @param params
     * @return
     */
    List<DictType> findList(Page<DictType> page, @Param("p") Map<String, Object> params);


    List<DictType> seleDictType();
}
