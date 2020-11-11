package com.central.finance.mapper;

import com.central.finance.model.DictData;
import com.central.db.mapper.SuperMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * 字典数据表
 * 
 * @author zlt
 * @date 2020-10-27 09:38:04
 */
@Mapper
public interface DictDataMapper extends SuperMapper<DictData> {
    /**
     * 分页查询用户列表
     * @param page
     * @param params
     * @return
     */
    List<DictData> findList(Page<DictData> page, @Param("p") Map<String, Object> params);

    List<DictData> selectDistById(String id);

    DictData selectDist(String id);

    boolean saveDictData(DictData dictData);
}
