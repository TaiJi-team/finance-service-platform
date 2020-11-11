package com.central.finance.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;

import com.central.finance.model.DictData;
import com.central.finance.service.IDictDataService;
import com.central.common.model.PageResult;
import com.central.common.model.Result;

/**
 * 字典数据表
 *
 * @author zlt
 * @date 2020-10-27 09:38:04
 */
@Slf4j
@RestController
@RequestMapping("/dictdata")
@Api(tags = "字典数据表")
public class DictDataController {
    @Autowired
    private IDictDataService dictDataService;

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
        return dictDataService.findList(params);
    }

    /**
     * 查询
     */
    @ApiOperation(value = "根据字典类型id查询对应字典数据")
    @GetMapping("/findUserById/{id}")
    public Result findUserById(@PathVariable String id) {
        List<DictData> model = dictDataService.findUserById(id);
        return Result.succeed(model, "查询成功");
    }

    /**
     * 新增or更新
     */
    @ApiOperation(value = "保存字典数据")
    @PostMapping("/saveDictData")
    public Result saveDictData(@RequestBody DictData dictData) {
        dictDataService.saveDictData(dictData);
        return Result.succeed("保存成功");
    }

    /**
     * 删除
     */
    @ApiOperation(value = "删除指定字典数据")
    @DeleteMapping("/deleteDict/{id}")
    public Result deleteDict(@PathVariable String id) {
        dictDataService.removeById(id);
        return Result.succeed("删除成功");
}

    /**
     * 更新
     */
    @ApiOperation(value = "关停/开启数据")
    @PostMapping("/updateDict/{id}")
    public Result updateDict(@PathVariable String id) {
        DictData dictData = new DictData();
        DictData dictData1 = dictDataService.selectDist(id);
          if("0".equals(dictData1.getStatus())|| dictData1.getStatus()==null){
              dictData.setStatus("1");
          }else {
              dictData.setStatus("0");
          }
        dictData.setId(id);
        dictDataService.updateById(dictData);
        return Result.succeed("修改成功");
    }
}
