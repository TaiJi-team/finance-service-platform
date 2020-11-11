package com.central.finance.controller;

import java.util.Map;

import com.central.finance.model.IndivVo;
import com.central.finance.service.IndivHousehService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;

import com.central.common.model.PageResult;
import com.central.common.model.Result;

/**
 * 个体户企业表
 *
 * @author zlt
 * @date 2020-10-27 16:21:31
 */
@Slf4j
@RestController
@RequestMapping("/hindivhouseh")
@Api(tags = "个体户企业表")
public class IndivHousehController {
    @Autowired
    private IndivHousehService hIndivHousehService;

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
        return hIndivHousehService.findList(params);
    }

    /**
     * 根据id查询详情
     */
    @ApiOperation(value = "查询")
    @GetMapping("/selectByid/{id}")
    public Result findUserById(@PathVariable String id) {
        IndivVo model = hIndivHousehService.getById(id);
        return Result.succeed(model, "查询成功");
    }

    /**
     * 新增
     */
    @ApiOperation(value = "保存")
    @PostMapping("/save")
    public Result save(@RequestBody IndivVo indivVo) {
        hIndivHousehService.saveAdd(indivVo);
        return Result.succeed("保存成功");
    }

    /**
     * 修改
     */
    @ApiOperation(value = "修改")
    @PostMapping("/update")
    public Result update(@RequestBody IndivVo indivVo) {
        hIndivHousehService.updateIndiv(indivVo);
        return Result.succeed("修改成功");
    }
}
