package com.central.user.controller;

import java.util.List;
import java.util.Map;

import com.central.user.service.IUserRelationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;

import com.central.user.model.UserRelation;

import com.central.common.model.PageResult;
import com.central.common.model.Result;

/**
 * 用户关联表
 *
 * @author yzb
 * @date 2020-11-07 22:59:38
 */
@Slf4j
@RestController
@RequestMapping("/userrelation")
@Api(tags = "用户关联表")
public class UserRelationController {
    @Autowired
    private IUserRelationService userRelationService;

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
        return userRelationService.findList(params);
    }

    /**
     * 查询
     */
    @ApiOperation(value = "查询")
    @GetMapping("/selectList/{id}")
    public List<UserRelation> findUserById(@PathVariable String id) {
        return userRelationService.findUserById(id);
    }
    /**
     * 入驻认证添加用户关联表
     */
    @ApiOperation(value = "保存")
    @PostMapping("/save")
    public Result saveRelation(@RequestBody UserRelation userRelation) {
        userRelationService.saveRelation(userRelation);
        return Result.succeed("保存成功");
    }
    /**
     * 入驻认证修改用户关联表
     */
    @ApiOperation(value = "修改")
    @PostMapping("/update")
    public Result updateRelation(@RequestBody UserRelation userRelation) {
        userRelationService.updateRelation(userRelation);
        return Result.succeed("修改成功");
    }
}
