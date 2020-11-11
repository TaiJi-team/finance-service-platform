package com.central.finance.model;

import com.central.common.model.SuperEntity;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.models.auth.In;
import lombok.Getter;
import lombok.Setter;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Date;

/**
 * 字典数据表
 *
 * @author zlt
 * @date 2020-10-27 09:38:04
 */
@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
@TableName("sys_dict_data")
public class DictData implements Serializable {
    private static final long serialVersionUID=1L;

        private String id;
        private String typeId;
        private String code;
        private String engName;
        private String cnName;
        private Integer order;
        private String remark;
        private Date createDate;
        private Date updateDate;
        private Date deleteDate;
        private String status;
    }
