package com.central.backstage.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;

import com.central.backstage.model.Role;
import com.central.backstage.service.IRoleService;
import com.central.common.model.PageResult;
import com.central.common.model.Result;

/**
 * 角色表
 *
 * @author yzb
 * @date 2020-11-04 11:13:41
 */
@Slf4j
@RestController
@RequestMapping("/role")
@Api(tags = "角色表")
public class RoleController {
    @Autowired
    private IRoleService roleService;

    /**
     * 列表
     */
    @ApiOperation(value = "查询列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", value = "分页起始位置", required = true, dataType = "Integer"),
            @ApiImplicitParam(name = "limit", value = "分页结束位置", required = true, dataType = "Integer")
    })
    @GetMapping("/list")
    public PageResult list(@RequestParam Map<String, Object> params) {
        return roleService.findList(params);
    }

    /**
     * 查询
     */
    @ApiOperation(value = "查询")
    @GetMapping("/findUserById/{id}")
    public Result findUserById(@PathVariable Integer id) {
        Role model = roleService.seleRoleById(id);
        return Result.succeed(model, "查询成功");
    }

    /**
     * 新增or更新
     */
    @ApiOperation(value = "保存")
    @PostMapping("/save")
    public Result save(@RequestBody Role role) {
        roleService.saveOrUpdate(role);
        return Result.succeed("保存成功");
    }

    /**
     * 删除
     */
    @ApiOperation(value = "删除")
    @DeleteMapping("deleRoleById/{id}")
    public Result deleRoleById(@PathVariable Integer id) {
        roleService.deleRoleById(id);
        return Result.succeed("删除成功");
    }
}
