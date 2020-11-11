package com.central.finance.model;

import com.central.common.model.SuperEntity;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Date;

/**
 * 企业扩展表
 *
 * @author ljb
 * @date 2020-10-30 10:08:39
 */
@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
@TableName("auth_comp_extend")
public class CompExtend implements Serializable {
    private static final long serialVersionUID=1L;
        private Long id;
        private Long compId;
        private Integer province;
        private Integer city;
        private Integer county;
    }
