package com.central.backstage.controller;

import java.util.List;
import java.util.Map;

import com.central.backstage.model.UserCompOper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;

import com.central.backstage.model.UserCompLegpers;
import com.central.backstage.service.IUserCompLegpersService;
import com.central.common.model.PageResult;
import com.central.common.model.Result;

/**
 * 企业管法人代表表
 *
 * @author ljb
 * @date 2020-11-02 15:21:07
 */
@Slf4j
@RestController
@RequestMapping("/usercomplegpers")
@Api(tags = "企业管法人代表表")
public class UserCompLegpersController {
    @Autowired
    private IUserCompLegpersService userCompLegpersService;

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
        return userCompLegpersService.findList(params);
    }

    /**
     * 新增or更新
     */
    @ApiOperation(value = "保存")
    @PostMapping("/save")
    public Result save(@RequestBody UserCompLegpers userCompLegpers) {
        userCompLegpersService.saveAdd(userCompLegpers);
        return Result.succeed("保存成功");
    }

    /**
     * 更新
     */
    @ApiOperation(value = "修改")
    @PostMapping("/update")
    public Result update(@RequestBody UserCompLegpers userCompLegpers) {
        userCompLegpersService.updateById(userCompLegpers);
        return Result.succeed("修改成功");
    }

    /**
     * 查询
     */
    @ApiOperation(value = "查询")
    @GetMapping("/selectList/{id}")
    public List<UserCompLegpers> findUserById(@PathVariable String id) {
        return userCompLegpersService.findUserById(id);
    }
}
