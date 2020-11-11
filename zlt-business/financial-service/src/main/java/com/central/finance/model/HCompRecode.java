package com.central.finance.model;

import com.baomidou.mybatisplus.annotation.TableName;
import com.central.common.model.SuperEntity;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * 企业认证记录表
 *
 * @author ljb
 * @date 2020-10-26 16:45:33
 */
@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
@TableName("auth_comp_recode")
public class HCompRecode extends SuperEntity {
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
