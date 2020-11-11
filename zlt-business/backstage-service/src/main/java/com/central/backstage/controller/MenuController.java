package com.central.backstage.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;

import com.central.backstage.model.Menu;
import com.central.backstage.service.IMenuService;
import com.central.common.model.PageResult;
import com.central.common.model.Result;

/**
 * 系统菜单表
 *
 * @author yzb
 * @date 2020-11-04 11:21:15
 */
@Slf4j
@RestController
@RequestMapping("/menu")
@Api(tags = "系统菜单表")
public class MenuController {
    @Autowired
    private IMenuService menuService;

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
        return menuService.findList(params);
    }

    /**
     * 查询
     */
    @ApiOperation(value = "查询")
    @GetMapping("/{menuId}")
    public Result findUserById(@PathVariable Long menuId) {
        Menu model = menuService.getById(menuId);
        return Result.succeed(model, "查询成功");
    }

    /**
     * 新增or更新
     */
    @ApiOperation(value = "保存")
    @PostMapping
    public Result save(@RequestBody Menu menu) {
        menuService.saveOrUpdate(menu);
        return Result.succeed("保存成功");
    }

    /**
     * 删除
     */
    @ApiOperation(value = "删除")
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Long menuId) {
        menuService.removeById(menuId);
        return Result.succeed("删除成功");
    }
}
