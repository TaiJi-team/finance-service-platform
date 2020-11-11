package com.central.finance.controller;

import java.util.Map;

import com.central.finance.model.FinanceOrgVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;

import com.central.finance.model.FinanceOrg;
import com.central.finance.service.IFinanceOrgService;
import com.central.common.model.PageResult;
import com.central.common.model.Result;

/**
 * 金融机构表
 *
 * @author ljb
 * @date 2020-10-29 09:21:31
 */
@Slf4j
@RestController
@RequestMapping("/financeorg")
@Api(tags = "金融机构表")
public class FinanceOrgController {
    @Autowired
    private IFinanceOrgService financeOrgService;

    /**
     * 列表
     */
    @ApiOperation(value = "查询列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", value = "分页起始位置", required = true, dataType = "Integer"),
            @ApiImplicitParam(name = "limit", value = "分页结束位置", required = true, dataType = "Integer")
    })
    @GetMapping("findAll")
    public PageResult list(@RequestParam Map<String, Object> params) {
        return financeOrgService.findList(params);
    }

    /**
     * 查询
     */
    @ApiOperation(value = "查询")
    @GetMapping("/selectByid/{id}")
    public Result findUserById(@PathVariable String id) {
        FinanceOrgVo model = financeOrgService.getById(id);
        return Result.succeed(model, "查询成功");
    }

    /**
     * 新增
     */
    @ApiOperation(value = "保存")
    @PostMapping("save")
    public Result save(@RequestBody FinanceOrgVo financeOrgVo) {
        financeOrgService.saveAdd(financeOrgVo);
        return Result.succeed("保存成功");
    }

    /**
     * 修改
     */
    @ApiOperation(value = "修改")
    @PostMapping("/update")
    public Result update(@RequestBody FinanceOrgVo financeOrgVo) {
        financeOrgService.updateFinance(financeOrgVo);
        return Result.succeed("修改成功");
    }

    /**
     * 删除
     */
    @ApiOperation(value = "删除")
    @DeleteMapping("/delete/{id}")
    public Result delete(@PathVariable String id) {
        financeOrgService.removeById(id);
        return Result.succeed("删除成功");
    }
}
