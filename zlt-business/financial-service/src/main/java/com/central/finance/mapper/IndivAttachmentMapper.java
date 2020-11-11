package com.central.finance.mapper;

import com.central.finance.model.IndivAttachment;
import com.central.db.mapper.SuperMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * 个体户企业附件表
 *
 * @author ljb
 * @date 2020-10-30 10:06:44
 */
@Mapper
public interface IndivAttachmentMapper extends SuperMapper<IndivAttachment> {
    /**
     * 分页查询用户列表
     * @param page
     * @param params
     * @return
     */
    List<IndivAttachment> findList(Page<IndivAttachment> page, @Param("p") Map<String, Object> params);

    /**
     * 新增
     * @param indivAttachment
     */
    void saveAdd(IndivAttachment indivAttachment);
}
