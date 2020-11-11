package com.central.finance.model;

import com.central.common.model.SuperEntity;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;
import lombok.EqualsAndHashCode;
import java.util.Date;

/**
 * 金融机构认证记录表
 *
 * @author zlt
 * @date 2020-10-27 11:39:02
 */
@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
@TableName("auth_finan_org_recode")
public class FinanOrgRecode extends SuperEntity {
    private static final long serialVersionUID=1L;

        private Long compId;
        private Long userId;
        private String signOper;
        private String elecContrUrl;
        private Date applyDate;
        private Date auditDate;
        private String auditStat;
        private String authFailReason;
    }
