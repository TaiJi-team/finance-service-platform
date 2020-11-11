package com.central.finance.mapper;

import com.central.finance.model.CompOpenBank;
import com.central.db.mapper.SuperMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * 企业银行账户表
 *
 * @author ljb
 * @date 2020-10-30 10:08:35
 */
@Mapper
public interface CompOpenBankMapper extends SuperMapper<CompOpenBank> {
    /**
     * 分页查询用户列表
     * @param page
     * @param params
     * @return
     */
    List<CompOpenBank> findList(Page<CompOpenBank> page, @Param("p") Map<String, Object> params);

    /**
     * 新增
     * @param compOpenBank
     */
    void saveAdd(CompOpenBank compOpenBank);
}
