package com.central.backstage.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;

import com.central.backstage.model.UserOrgSales;
import com.central.backstage.service.IUserOrgSalesService;
import com.central.common.model.PageResult;
import com.central.common.model.Result;

/**
 * 运营机构推广员表
 *
 * @author ljb
 * @date 2020-11-02 15:23:52
 */
@Slf4j
@RestController
@RequestMapping("/userorgsales")
@Api(tags = "运营机构推广员表")
public class UserOrgSalesController {
    @Autowired
    private IUserOrgSalesService userOrgSalesService;

    /**
     * 列表
     */
    @ApiOperation(value = "查询列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", value = "分页起始位置", required = true, dataType = "Integer"),
            @ApiImplicitParam(name = "limit", value = "分页结束位置", required = true, dataType = "Integer")
    })
    @GetMapping
    public PageResult list(@RequestParam Map<String, Object> params) {
        return userOrgSalesService.findList(params);
    }

    /**
     * 查询
     */
    @ApiOperation(value = "查询")
    @GetMapping("/{id}")
    public Result findUserById(@PathVariable Long id) {
        UserOrgSales model = userOrgSalesService.getById(id);
        return Result.succeed(model, "查询成功");
    }

    /**
     * 新增or更新
     */
    @ApiOperation(value = "保存")
    @PostMapping
    public Result save(@RequestBody UserOrgSales userOrgSales) {
        userOrgSalesService.saveOrUpdate(userOrgSales);
        return Result.succeed("保存成功");
    }

    /**
     * 删除
     */
    @ApiOperation(value = "删除")
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Long id) {
        userOrgSalesService.removeById(id);
        return Result.succeed("删除成功");
    }
}
