package com.central.finance.mapper;

import com.central.db.mapper.SuperMapper;
import com.central.finance.model.IndivRecode;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 个体户认证记录表
 *
 * @author zlt
 * @date 2020-10-27 15:54:28
 */
@Mapper
public interface IndivRecodeMapper extends SuperMapper<IndivRecode> {
    /**
     * 查询个体户列表
     *
     * @param compId
     * @return
     */
    List<IndivRecode> findList(String compId);

    /**
     * 新增个体户入驻记录
     * @param indivRecode
     * @return
     */
    Boolean saveAdd(IndivRecode indivRecode);
}
