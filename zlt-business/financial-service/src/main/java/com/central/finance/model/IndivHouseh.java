package com.central.finance.model;

import com.central.common.model.SuperEntity;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Date;

/**
 * 个体户企业表
 *
 * @author zlt
 * @date 2020-10-27 16:21:31
 */
@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
@TableName("auth_indiv_househ")
public class IndivHouseh implements Serializable {
    private static final long serialVersionUID=1L;
        private Long id;
        private Long legalPersonId;
        private String name;
        private String regNum;
        private String creditCode;
        private String taxpayerNum;
        private Date regDate;
        private String licenseAuthOrg;
        private Double regCapi;
        private String regCapiCucy;
        private String ecoNature;
        private Double paidCapi;
        private String busiScope;
        private Date busiPeriod;
        private String busiStat;
        private String postalCode;
        private String contactNum;
        private String faxNum;
        private String email;
        private String compNatureType;
        private String latestInspectMsg;
        private String changeMsg;
        private String cancelMsg;
        private String personSize;
        private String regAddr;
        private String actualOfficeAddr;
        private String authState;
        private String creditReportUrl;
    }
