package com.central.backstage.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;

import com.central.backstage.model.UserOrgProdmanag;
import com.central.backstage.service.IUserOrgProdmanagService;
import com.central.common.model.PageResult;
import com.central.common.model.Result;

/**
 * 机构产品经理表
 *
 * @author ljb
 * @date 2020-11-02 15:23:55
 */
@Slf4j
@RestController
@RequestMapping("/userorgprodmanag")
@Api(tags = "机构产品经理表")
public class UserOrgProdmanagController {
    @Autowired
    private IUserOrgProdmanagService userOrgProdmanagService;

    /**
     * 列表
     */
    @ApiOperation(value = "查询列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", value = "分页起始位置", required = true, dataType = "Integer"),
            @ApiImplicitParam(name = "limit", value = "分页结束位置", required = true, dataType = "Integer")
    })
    @GetMapping("/findAll")
    public PageResult list(@RequestParam Map<String, Object> params) {
        return userOrgProdmanagService.findList(params);
    }

    /**
     * 新增or更新
     */
    @ApiOperation(value = "保存")
    @PostMapping("/save")
    public Result save(@RequestBody UserOrgProdmanag userOrgProdmanag) {
        userOrgProdmanagService.saveManage(userOrgProdmanag);
        return Result.succeed("保存成功");
    }


    /**
     * 更新
     */
    @ApiOperation(value = "修改")
    @PostMapping("/update")
    public Result update(@RequestBody UserOrgProdmanag userOrgProdmanag) {
        userOrgProdmanagService.updateById(userOrgProdmanag);
        return Result.succeed("修改成功");
    }
}
