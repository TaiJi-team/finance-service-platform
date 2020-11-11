package com.central.finance.controller;

import java.util.List;

import com.central.finance.model.IndivRecode;
import com.central.finance.service.IndivRecodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;

import com.central.common.model.Result;

/**
 * 个体户认证记录表
 *
 * @author zlt
 * @date 2020-10-27 15:54:28
 */
@Slf4j
@RestController
@RequestMapping("/hindivrecode")
@Api(tags = "个体户认证记录表")
public class IndivRecodeController {
    @Autowired
    private IndivRecodeService hIndivRecodeService;
    /**
     * 个体户入驻签约记录，记录签约人信息等
     */
    @ApiOperation(value = "保存")
    @PostMapping("/save")
    public Result save(@RequestBody IndivRecode indivRecode) {
        hIndivRecodeService.saveAdd(indivRecode);
        return Result.succeed("保存成功");
    }

    /**
     * 查询个体户入驻记录
     *
     * @param compId
     * @return
     */
    @ApiOperation(value = "查看个体户入驻记录")
    @PostMapping("/selectList/{compId}")
    public Result selectList(@PathVariable String compId) {
        List<IndivRecode> list = hIndivRecodeService.findList(compId);
        return Result.succeed(list,"查询成功");
    }
}
