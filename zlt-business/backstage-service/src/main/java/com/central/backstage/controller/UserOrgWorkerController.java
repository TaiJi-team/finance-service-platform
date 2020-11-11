package com.central.backstage.controller;

import java.util.Map;

import com.central.backstage.model.UserOrgProdmanag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;

import com.central.backstage.model.UserOrgWorker;
import com.central.backstage.service.IUserOrgWorkerService;
import com.central.common.model.PageResult;
import com.central.common.model.Result;

/**
 * 机构业务员表
 *
 * @author ljb
 * @date 2020-11-02 15:23:54
 */
@Slf4j
@RestController
@RequestMapping("/userorgworker")
@Api(tags = "机构业务员表")
public class UserOrgWorkerController {
    @Autowired
    private IUserOrgWorkerService userOrgWorkerService;

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
        return userOrgWorkerService.findList(params);
    }

    /**
     * 新增or更新
     */
    @ApiOperation(value = "保存")
    @PostMapping("/save")
    public Result save(@RequestBody UserOrgWorker userOrgWorker) {
        userOrgWorkerService.saveWork(userOrgWorker);
        return Result.succeed("保存成功");
    }

    /**
     * 更新
     */
    @ApiOperation(value = "修改")
    @PostMapping("/update")
    public Result update(@RequestBody UserOrgWorker userOrgWorker) {
        userOrgWorkerService.updateById(userOrgWorker);
        return Result.succeed("修改成功");
    }
}
