package com.central.finance.mapper;

import com.central.db.mapper.SuperMapper;
import com.central.finance.model.HCompRecode;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 企业认证记录表
 *
 * @author zlt
 * @date 2020-10-26 16:45:33
 */
@Mapper
public interface CompRecodeMapper extends SuperMapper<HCompRecode> {
    /**
     * 查询用户列表
     *
     * @param compId
     * @return
     */
    List<HCompRecode> findList(String compId);

    /**
     * 查询企业入驻记录
     * @param hCompRecode
     *
     * @return
     */
    Boolean saveAdd(HCompRecode hCompRecode);
}
