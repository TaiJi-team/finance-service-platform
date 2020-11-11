package com.central.finance.model;

import com.central.common.model.SuperEntity;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;
import lombok.EqualsAndHashCode;
import java.util.Date;

/**
 * 个体户认证记录表
 *
 * @author zlt
 * @date 2020-10-27 15:54:28
 */
@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
@TableName("auth_indiv_recode")
public class IndivRecode extends SuperEntity {
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
