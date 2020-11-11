package com.central.finance.mapper;

import com.central.finance.model.FinanceOrgAttachment;
import com.central.db.mapper.SuperMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * 金融机构附件表
 *
 * @author ljb
 * @date 2020-10-30 11:08:21
 */
@Mapper
public interface FinanceOrgAttachmentMapper extends SuperMapper<FinanceOrgAttachment> {
    /**
     * 分页查询用户列表
     * @param page
     * @param params
     * @return
     */
    List<FinanceOrgAttachment> findList(Page<FinanceOrgAttachment> page, @Param("p") Map<String, Object> params);

    /**
     * 新增
     * @param financeOrgAttachment
     */
    void saveAdd(FinanceOrgAttachment financeOrgAttachment);
}
