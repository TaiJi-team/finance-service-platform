package com.central.finance.mapper;

import com.central.finance.model.FinanceOrgOpenBank;
import com.central.db.mapper.SuperMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * 金融机构银行账户表
 *
 * @author ljb
 * @date 2020-10-30 11:08:18
 */
@Mapper
public interface FinanceOrgOpenBankMapper extends SuperMapper<FinanceOrgOpenBank> {
    /**
     * 分页查询用户列表
     * @param page
     * @param params
     * @return
     */
    List<FinanceOrgOpenBank> findList(Page<FinanceOrgOpenBank> page, @Param("p") Map<String, Object> params);

    /**
     * 新增
     * @param financeOrgOpenBank
     */
    void saveAdd(FinanceOrgOpenBank financeOrgOpenBank);
}
