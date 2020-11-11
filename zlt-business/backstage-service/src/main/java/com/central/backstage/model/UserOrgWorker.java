package com.central.backstage.model;

import com.central.common.model.SuperEntity;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Date;

/**
 * 机构业务员表
 *
 * @author ljb
 * @date 2020-11-02 15:23:54
 */
@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
@TableName("sys_user_org_worker")
public class UserOrgWorker implements Serializable {
    private static final long serialVersionUID=1L;
        private Long id;
        private Long compId;
        private Long orgCateg;
        private String name;
        private String phone;
        private String realName;
        private Integer idNum;
        private String gender;
        private String password;
        private Date regDate;
        private Date updateDate;
        private String headPic;
    }
