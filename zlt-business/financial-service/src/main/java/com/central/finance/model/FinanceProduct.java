package com.central.finance.model;

import com.central.common.model.SuperEntity;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Date;

/**
 * 金融产品表
 *
 * @author ljb
 * @date 2020-11-03 14:11:44
 */
@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
@TableName("prod_finance_product")
public class FinanceProduct implements Serializable {
    private static final long serialVersionUID=1L;
        private Long  id;
        private Long compId;
        private String type;
        private String name;
        private String desc;
        private String feature;
        private String loanRange;
        private String loanPeriod;
        private String loanRateRange;
        private String guaMode;
        private String repayMode;
        private String servArea;
        private String enterCondition;
        private String loanChannel;
        private Integer applyNum;
        private Integer isPub;
        private Date pubTime;
        private String subMaterial;
        private String proCase;
        private String specExplain;
        private String province;
        private String city;
        private String county;
    }
