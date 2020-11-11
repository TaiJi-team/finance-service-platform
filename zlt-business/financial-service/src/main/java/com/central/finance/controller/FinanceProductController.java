package com.central.finance.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;

import com.central.finance.model.FinanceProduct;
import com.central.finance.service.IFinanceProductService;
import com.central.common.model.PageResult;
import com.central.common.model.Result;

/**
 * 金融产品表
 *
 * @author ljb
 * @date 2020-11-03 14:11:44
 */
@Slf4j
@RestController
@RequestMapping("/financeproduct")
@Api(tags = "金融产品表")
public class FinanceProductController {
    @Autowired
    private IFinanceProductService financeProductService;

    /**
     * 查询金融产品列表
     */
    @ApiOperation(value = "查询列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", value = "分页起始位置", required = true, dataType = "Integer"),
            @ApiImplicitParam(name = "limit", value = "分页结束位置", required = true, dataType = "Integer")
    })
    @GetMapping("findAll")
    public PageResult list(@RequestParam Map<String, Object> params) {
        return financeProductService.findList(params);
    }

    /**
     * 查询金融产品详情
     */
    @ApiOperation(value = "查询")
    @GetMapping("/selectById/{id}")
    public Result findUserById(@PathVariable String id) {
        FinanceProduct model = financeProductService.findUserById(id);
        return Result.succeed(model, "查询成功");
    }

    /**
     * 添加金融产品
     */
    @ApiOperation(value = "保存")
    @PostMapping("/save")
    public Result save(@RequestBody FinanceProduct financeProduct) {
        financeProductService.saveAdd(financeProduct);
        return Result.succeed("保存成功");
    }

    /**
     * 删除金融产品
     */
    @ApiOperation(value = "删除")
    @DeleteMapping("/delete/{id}")
    public Result delete(@PathVariable Long id) {
        financeProductService.removeById(id);
        return Result.succeed("删除成功");
    }

    /**
     * 修改金融产品，金融产品上架，下架等
     */
    @ApiOperation(value = "修改")
    @PostMapping("/update")
    public Result update(@RequestBody FinanceProduct financeProduct) {
        financeProductService.updateById(financeProduct);
        return Result.succeed("修改成功");
    }
}
