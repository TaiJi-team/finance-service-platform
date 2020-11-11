package com.central.backstage.mapper;

import com.central.backstage.model.UserOrgWorker;
import com.central.db.mapper.SuperMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * 机构业务员表
 *
 * @author ljb
 * @date 2020-11-02 15:23:54
 */
@Mapper
public interface UserOrgWorkerMapper extends SuperMapper<UserOrgWorker> {
    /**
     * 分页查询用户列表
     * @param page
     * @param params
     * @return
     */
    List<UserOrgWorker> findList(Page<UserOrgWorker> page, @Param("p") Map<String, Object> params);

    /**
     * 新增业务员信息
     * @param userOrgWorker
     */
    void saveWork(UserOrgWorker userOrgWorker);
}
