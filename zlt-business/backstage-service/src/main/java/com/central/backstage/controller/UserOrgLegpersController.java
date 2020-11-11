package com.central.backstage.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;

import com.central.backstage.model.UserOrgLegpers;
import com.central.backstage.service.IUserOrgLegpersService;
import com.central.common.model.PageResult;
import com.central.common.model.Result;

/**
 * 机构法人代表表
 *
 * @author ljb
 * @date 2020-11-02 15:24:07
 */
@Slf4j
@RestController
@RequestMapping("/userorglegpers")
@Api(tags = "机构法人代表表")
public class UserOrgLegpersController {
    @Autowired
    private IUserOrgLegpersService userOrgLegpersService;

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
        return userOrgLegpersService.findList(params);
    }


    /**
     * 新增
     */
    @ApiOperation(value = "保存")
    @PostMapping("/save")
    public Result save(@RequestBody UserOrgLegpers userOrgLegpers) {
        userOrgLegpersService.saveAdd(userOrgLegpers);
        return Result.succeed("保存成功");
    }

    /**
     * 更新
     */
    @ApiOperation(value = "修改")
    @PostMapping("/update")
    public Result update(@RequestBody UserOrgLegpers userOrgLegpers) {
        userOrgLegpersService.saveOrUpdate(userOrgLegpers);
        return Result.succeed("修改成功");
    }

    /**
     * 查询
     */
    @ApiOperation(value = "查询")
    @GetMapping("/selectList/{id}")
    public List<UserOrgLegpers> findUserById(@PathVariable String id) {
        return userOrgLegpersService.findUserById(id);
    }
}
