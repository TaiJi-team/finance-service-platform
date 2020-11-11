package com.central.finance.mapper;

import com.central.finance.model.FinanceOrgExtend;
import com.central.db.mapper.SuperMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * 金融机构扩展表
 * 
 * @author ljb
 * @date 2020-10-30 11:08:20
 */
@Mapper
public interface FinanceOrgExtendMapper extends SuperMapper<FinanceOrgExtend> {
    /**
     * 分页查询用户列表
     * @param page
     * @param params
     * @return
     */
    List<FinanceOrgExtend> findList(Page<FinanceOrgExtend> page, @Param("p") Map<String, Object> params);
}
