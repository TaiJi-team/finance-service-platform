package com.central.finance.controller;

import java.util.List;
import java.util.Map;

import com.central.finance.model.DictType;
import jodd.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;

import com.central.finance.model.DictType;
import com.central.finance.service.IDictTypeService;
import com.central.common.model.PageResult;
import com.central.common.model.Result;

/**
 * 字典类型表
 *
 * @author zlt
 * @date 2020-10-27 09:36:44
 */
@Slf4j
@RestController
@RequestMapping("/dicttype")
@Api(tags = "字典类型表")
public class DictTypeController {
    @Autowired
    private IDictTypeService dictTypeService;

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
        return dictTypeService.findList(params);
    }

    /**
     * 查询
     */
    @ApiOperation(value = "查询所有字典类型")
    @GetMapping("/findUserById")
    public Result findUserById() {
      List<DictType> dictType =  dictTypeService.seleDictType();
        return Result.succeed(dictType, "查询成功");
    }

    /**
     * 新增or更新
     */
    @ApiOperation(value = "添加/修改字典类型")
    @PostMapping("/save")
    public Result save(@RequestBody DictType dictType) {
        dictTypeService.saveOrUpdate(dictType);
        return Result.succeed("保存成功");
    }

    /**
     * 删除
     */
    @ApiOperation(value = "根据id删除数据字典类型")
    @DeleteMapping("/delete/{id}")
    public Result delete(@PathVariable Long id) {
        dictTypeService.removeById(id);
        return Result.succeed("删除成功");
    }
}
