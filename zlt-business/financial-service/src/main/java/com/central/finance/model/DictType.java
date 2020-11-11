package com.central.finance.model;

import com.central.common.model.SuperEntity;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Date;

/**
 * 字典类型表
 *
 * @author zlt
 * @date 2020-10-27 09:36:44
 */
@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
@TableName("sys_dict_type")
public class DictType implements Serializable {
    private static final long serialVersionUID=1L;
        private String id;
        private String engName;
        private String cnName;
        private Date createDate;
        private Date updateDate;
        private Date deleteDate;
    }
