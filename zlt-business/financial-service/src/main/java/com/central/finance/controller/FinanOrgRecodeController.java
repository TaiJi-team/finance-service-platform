package com.central.finance.controller;

import java.util.List;

import com.central.finance.model.FinanOrgRecode;
import com.central.finance.service.FinanOrgRecodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;


import com.central.common.model.Result;

/**
 * 金融机构认证记录表
 *
 * @author zlt
 * @date 2020-10-27 11:39:02
 */
@Slf4j
@RestController
@RequestMapping("/hfinanorgrecode")
@Api(tags = "金融机构认证记录表")
public class FinanOrgRecodeController {
    @Autowired
    private FinanOrgRecodeService hFinanOrgRecodeService;

    /**
     * 金融机构入驻签约记录，记录签约人信息等
     */
    @ApiOperation(value = "保存")
    @PostMapping("/save")
    public Result save(@RequestBody FinanOrgRecode hFinanOrgRecode) {
        hFinanOrgRecodeService.saveAdd(hFinanOrgRecode);
        return Result.succeed("保存成功");
    }

    /**
     * 查询企金融机构入驻记录
     *
     * @param compId
     * @return
     */
    @ApiOperation(value = "查看金融机构入驻记录")
    @PostMapping("/selectList/{compId}")
    public Result selectList(@PathVariable String compId) {
        List<FinanOrgRecode> list = hFinanOrgRecodeService.findList(compId);
        return Result.succeed(list, "查询成功");
    }
}
