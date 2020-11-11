package com.central.finance.controller;

import com.central.common.model.Result;
import com.central.finance.model.*;
import com.central.finance.service.CompRecodeService;
import com.central.finance.service.FinanOrgRecodeService;
import com.central.finance.service.IndivRecodeService;
import com.google.gson.Gson;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 企业认证记录表
 *
 * @author ljb
 * @date 2020-10-26 16:45:33
 */
@Slf4j
@RestController
@RequestMapping("/hcomprecode")
@Api(tags = "企业认证记录表")
public class CompRecodeController {
    @Autowired
    private CompRecodeService hCompRecodeService;
    @Autowired
    private Gson gson;
    @Autowired
    private FinanOrgRecodeService hFinanOrgRecodeService;
    @Autowired
    private IndivRecodeService hIndivRecodeService;

    /**
     * 企业入驻签约记录，记录签约人信息等
     */
    @ApiOperation(value = "保存")
    @PostMapping("/save")
    public Result save(@RequestBody HCompRecode hCompRecode) {
        hCompRecodeService.saveAdd(hCompRecode);
        return Result.succeed("保存成功");
    }

    /**
     * 查询企业入驻记录
     *
     * @param compId
     * @return
     */
    @ApiOperation(value = "查看企业入驻记录")
    @PostMapping("/selectList/{compId}")
    public Result selectList(@PathVariable String compId) {
        List<HCompRecode> list = hCompRecodeService.findList(compId);
        return Result.succeed(list, "查询成功");
    }

    /**
     * 新增
     */
    @ApiOperation(value = "保存")
    @PostMapping("/saveAll/{type}")
    public Result saveAll(@PathVariable("type") String type, @RequestBody String params) {
        if (StringUtils.isNotBlank(type)) {
            switch (type) {
                case "01":
                    HCompRecode hCompRecode = gson.fromJson(params, HCompRecode.class);
                    hCompRecodeService.saveAdd(hCompRecode);
                    break;
                case "02":
                    IndivRecode indivRecode = gson.fromJson(params, IndivRecode.class);
                    hIndivRecodeService.saveAdd(indivRecode);
                    break;
                case "03":
                    FinanOrgRecode finanOrgRecode = gson.fromJson(params, FinanOrgRecode.class);
                    hFinanOrgRecodeService.saveAdd(finanOrgRecode);
                    break;
                default:
                    break;
            }
        }
        return Result.succeed("保存成功");
    }
}
