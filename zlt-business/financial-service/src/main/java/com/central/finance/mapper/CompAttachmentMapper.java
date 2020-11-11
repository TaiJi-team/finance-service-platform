package com.central.finance.mapper;

import com.central.finance.model.CompAttachment;
import com.central.db.mapper.SuperMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * 企业附件表
 *
 * @author ljb
 * @date 2020-10-30 10:08:29
 */
@Mapper
public interface CompAttachmentMapper extends SuperMapper<CompAttachment> {
    /**
     * 分页查询用户列表
     * @param page
     * @param params
     * @return
     */
    List<CompAttachment> findList(Page<CompAttachment> page, @Param("p") Map<String, Object> params);

    /**
     * 新增
     * @param compAttachment
     */
    void saveAdd(CompAttachment compAttachment);
}
