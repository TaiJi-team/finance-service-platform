package com.central.finance.mapper;

import com.central.finance.model.IndivOpenBank;
import com.central.db.mapper.SuperMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * 个体户企业银行账户表
 *
 * @author ljb
 * @date 2020-10-30 10:06:46
 */
@Mapper
public interface IndivOpenBankMapper extends SuperMapper<IndivOpenBank> {
    /**
     * 分页查询用户列表
     * @param page
     * @param params
     * @return
     */
    List<IndivOpenBank> findList(Page<IndivOpenBank> page, @Param("p") Map<String, Object> params);

    /**
     * 新增
     * @param indivOpenBank
     */
    void saveAdd(IndivOpenBank indivOpenBank);
}
