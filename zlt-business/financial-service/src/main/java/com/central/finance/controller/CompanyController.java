package com.central.finance.controller;

import java.util.Map;

import com.central.finance.model.CompanyVo;
import com.central.finance.model.FinanceOrgVo;
import com.central.finance.model.IndivVo;
import com.central.finance.service.CompanyService;
import com.central.finance.service.IFinanceOrgService;
import com.central.finance.service.IndivHousehService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import com.google.gson.Gson;
import com.central.common.model.PageResult;
import com.central.common.model.Result;

/**
 * 企业表
 *
 * @author ljb
 * @date 2020-10-28 15:02:14
 */
@Slf4j
@RestController
@RequestMapping("/company")
@Api(tags = "企业表")
public class CompanyController {
    @Autowired
    private CompanyService companyService;
    @Autowired
    private IndivHousehService hIndivHousehService;
    @Autowired
    private Gson gson;
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
    @GetMapping("/findAll")
    public PageResult list(@RequestParam Map<String, Object> params) {
        return companyService.findList(params);
    }

    /**
     * 查询
     */
    @ApiOperation(value = "查询")
    @GetMapping("selectByid/{id}")
    public Result findUserById(@PathVariable String id) {
        CompanyVo model = companyService.getById(id);
        return Result.succeed(model, "查询成功");
    }

    /**
     * 新增
     */
    @ApiOperation(value = "保存")
    @PostMapping("/save")
    public Result save(@RequestBody CompanyVo companyVo) {
        companyService.saveAdd(companyVo);
        return Result.succeed("保存成功");
    }

    /**
     * 修改
     */
    @ApiOperation(value = "修改")
    @PostMapping("/update")
    public Result update(@RequestBody CompanyVo companyVo) {
        companyService.updateCompany(companyVo);
        return Result.succeed("修改成功");
    }

    /**
     * 删除
     */
    @ApiOperation(value = "删除")
    @DeleteMapping("delete/{id}")
    public Result delete(@PathVariable String id) {
        companyService.removeById(id);
        return Result.succeed("删除成功");
    }

    /**
     * 新增 01.表示企业，02.表示个人，03.表示金融机构
     */
    @ApiOperation(value = "保存")
    @PostMapping("/saveAll/{type}")
    public Result saveAll(@PathVariable("type") String type, @RequestBody String params) {
        if (StringUtils.isNotBlank(type)) {
            switch (type) {
                case "01":
                    CompanyVo companyVo = gson.fromJson(params, CompanyVo.class);
                    companyService.saveAdd(companyVo);
                    break;
                case "02":
                    IndivVo indivVo = gson.fromJson(params, IndivVo.class);
                    hIndivHousehService.saveAdd(indivVo);
                    break;
                case "03":
                    FinanceOrgVo financeOrgVo = gson.fromJson(params, FinanceOrgVo.class);
                    financeOrgService.saveAdd(financeOrgVo);
                    break;
                default:
                    break;
            }
        }
        return Result.succeed("保存成功");
    }

    /**
     * 入驻修改接口 01.表示企业，02.表示个人，03.表示金融机构
     */
    @ApiOperation(value = "修改")
    @PostMapping("/upateAll/{type}")
    public Result upateAll(@PathVariable("type") String type, @RequestBody String params) {
        if (StringUtils.isNotBlank(type)) {
            switch (type) {
                case "01":
                    CompanyVo companyVo = gson.fromJson(params, CompanyVo.class);
                    companyService.updateCompany(companyVo);
                    break;
                case "02":
                    IndivVo indivVo = gson.fromJson(params, IndivVo.class);
                    hIndivHousehService.updateIndiv(indivVo);
                    break;
                case "03":
                    FinanceOrgVo financeOrg = gson.fromJson(params, FinanceOrgVo.class);
                    financeOrgService.updateFinance(financeOrg);
                    break;
                default:
                    break;
            }
        }
        return Result.succeed("修改成功");
    }
}
