package com.central.backstage.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;

import com.central.backstage.model.UserOrgAdmin;
import com.central.backstage.service.IUserOrgAdminService;
import com.central.common.model.PageResult;
import com.central.common.model.Result;

/**
 * 机构管理员表
 *
 * @author ljb
 * @date 2020-11-02 15:23:57
 */
@Slf4j
@RestController
@RequestMapping("/userorgadmin")
@Api(tags = "机构管理员表")
public class UserOrgAdminController {
    @Autowired
    private IUserOrgAdminService userOrgAdminService;

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
        return userOrgAdminService.findList(params);
    }

    /**
     * 查询
     */
    @ApiOperation(value = "查询")
    @GetMapping("/{id}")
    public Result findUserById(@PathVariable Long id) {
        UserOrgAdmin model = userOrgAdminService.getById(id);
        return Result.succeed(model, "查询成功");
    }

    /**
     * 新增or更新
     */
    @ApiOperation(value = "保存")
    @PostMapping
    public Result save(@RequestBody UserOrgAdmin userOrgAdmin) {
        userOrgAdminService.saveOrUpdate(userOrgAdmin);
        return Result.succeed("保存成功");
    }

    /**
     * 删除
     */
    @ApiOperation(value = "删除")
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Long id) {
        userOrgAdminService.removeById(id);
        return Result.succeed("删除成功");
    }
}
