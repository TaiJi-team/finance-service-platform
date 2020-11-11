package com.central.backstage.model;

import com.central.common.model.SuperEntity;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;
import lombok.EqualsAndHashCode;
import java.util.Date;

/**
 * 运营机构推广员表
 *
 * @author ljb
 * @date 2020-11-02 15:23:52
 */
@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
@TableName("sys_user_org_sales")
public class UserOrgSales extends SuperEntity {
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
