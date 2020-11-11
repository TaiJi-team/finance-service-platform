package com.central.finance.controller;

import java.util.Map;

import com.central.finance.model.CompanyVo;
import com.central.finance.model.FinanceOrgVo;
import com.central.finance.model.IndivVo;
import com.central.finance.service.IFinanceOrgAttachmentService;
import com.central.finance.service.IIndivAttachmentService;
import com.google.gson.Gson;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;

import com.central.finance.model.CompAttachment;
import com.central.finance.service.ICompAttachmentService;
import com.central.common.model.PageResult;
import com.central.common.model.Result;

/**
 * 企业附件表
 *
 * @author ljb
 * @date 2020-10-30 10:08:29
 */
@Slf4j
@RestController
@RequestMapping("/compattachment")
@Api(tags = "企业附件表")
public class CompAttachmentController {
    @Autowired
    private ICompAttachmentService compAttachmentService;
    @Autowired
    private Gson gson;
    @Autowired
    private IIndivAttachmentService indivAttachmentService;
    @Autowired
    private IFinanceOrgAttachmentService financeOrgAttachmentService;

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
                    compAttachmentService.updateCompany(companyVo);
                    break;
                case "02":
                    IndivVo indivVo = gson.fromJson(params, IndivVo.class);
                    indivAttachmentService.updateIndiv(indivVo);
                    break;
                case "03":
                    FinanceOrgVo financeOrg = gson.fromJson(params, FinanceOrgVo.class);
                    financeOrgAttachmentService.updateFinance(financeOrg);
                    break;
                default:
                    break;
            }
        }
        return Result.succeed("修改成功");
    }
}
