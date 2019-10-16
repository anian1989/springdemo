package com.springdb.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author zhangjunshuai
 * @date 2019/10/16
 * @description
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class WarehouseAreaLimitBak {
    private static final long serialVersionUID = -2366124350000948609L;

    private Long id;

    private Integer wareId;

    private String areaId;

    private Date ts;

    private String parentWareId;

    private String cityId;

    private String countyId;

    private Integer level;

    private Integer status;
}
