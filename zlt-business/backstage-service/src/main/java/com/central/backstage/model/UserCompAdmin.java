package com.central.backstage.model;

import com.central.common.model.SuperEntity;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;
import lombok.EqualsAndHashCode;
import java.util.Date;

/**
 * 企业管理员表
 *
 * @author ljb
 * @date 2020-11-02 15:21:18
 */
@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
@TableName("sys_user_comp_admin")
public class UserCompAdmin extends SuperEntity {
    private static final long serialVersionUID=1L;

        private Long compId;
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
