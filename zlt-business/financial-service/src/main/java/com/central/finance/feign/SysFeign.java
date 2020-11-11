package com.central.finance.feign;

import com.central.finance.feign.fallback.SysFeignFallbackFactory;
import com.central.finance.model.*;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * @author ljb
 */
@FeignClient(name = "backstage-service", fallbackFactory = SysFeignFallbackFactory.class, decode404 = true)
public interface SysFeign {
	/**
	 * 查询企业法人信息
	 * @param id
	 * @return
	 */
	@GetMapping("/usercomplegpers/selectList/{id}")
	List<UserCompLegpers> selectList(@PathVariable("id") String id);

	/**
	 * 查询企业经办人信息数据
	 * @param id
	 * @return
	 */
	@GetMapping("/usercompoper/selectList/{id}")
	List<UserCompOper> selectCompOper(@PathVariable("id") String id);

	/**
	 * 查询企业经办人信息数据
	 * @param id
	 * @return
	 */
	@GetMapping("/userindivower/selectList/{id}")
	List<UserIndivOwer> selectListOwer(@PathVariable("id") String id);

	/**
	 * 查询个体户经办人信息数据
	 * @param id
	 * @return
	 */
	@GetMapping("/userindivoper/selectList/{id}")
	List<UserIndivOper> selectListOper(@PathVariable("id") String id);

	/**
	 * 查询金融机构信息数据
	 * @param id
	 * @return
	 */
	@GetMapping("/userorglegpers/selectList/{id}")
	List<UserOrgLegpers> selectPers(@PathVariable("id") String id);

	/**
	 * 查询融机构经办人信息数据
	 * @param id
	 * @return
	 */
	@GetMapping("/userorgoper/selectList/{id}")
	List<UserOrgOper> selectOper(@PathVariable("id") String id);

	/**
	 * 新增企业经办人信息
	 * @param userCompOper
	 * @return
	 */
	@PostMapping("/usercompoper/save")
	UserCompOper save(@RequestBody UserCompOper userCompOper);

	/**
	 * 修改企业经办人信息
	 * @param userCompOper
	 * @return
	 */
	@PostMapping("/usercompoper/update")
	UserCompOper update(@RequestBody UserCompOper userCompOper);

	/**
	 * 新增企业法人信息
	 * @param userCompLegpers
	 * @return
	 */
	@PostMapping("/usercomplegpers/save")
	UserCompLegpers savePer(@RequestBody UserCompLegpers userCompLegpers);

	/**
	 * 修改企业法人信息
	 * @param userCompLegpers
	 * @return
	 */
	@PostMapping("/usercomplegpers/update")
	UserCompLegpers updatePer(@RequestBody UserCompLegpers userCompLegpers);

	/**
	 * 新增个体户经办人信息
	 * @param userIndivOper
	 * @return
	 */
	@PostMapping("/userindivoper/save")
	UserIndivOper saveIn(@RequestBody UserIndivOper userIndivOper);

	/**
	 * 修改个体户经办人信息
	 * @param userIndivOper
	 * @return
	 */
	@PostMapping("/userindivoper/update")
	UserIndivOper updateIn(@RequestBody UserIndivOper userIndivOper);

	/**
	 * 新增个体户
	 * @param userIndivOwer
	 * @return
	 */
	@PostMapping("/userindivower/save")
	UserIndivOwer saveOwer(@RequestBody UserIndivOwer userIndivOwer);

	/**
	 * 修改个体户
	 * @param userIndivOwer
	 * @return
	 */
	@PostMapping("/userindivower/update")
	UserIndivOwer updateOwer(@RequestBody UserIndivOwer userIndivOwer);

	/**
	 * 新增金融机构信息
	 * @param userOrgLegpers
	 * @return
	 */
	@PostMapping("/userorglegpers/save")
	UserOrgLegpers saveOrg(@RequestBody UserOrgLegpers userOrgLegpers);

	/**
	 * 修改金融机构法人信息
	 * @param userOrgLegpers
	 * @return
	 */
	@PostMapping("/userorglegpers/update")
	UserOrgLegpers updateOrg(@RequestBody UserOrgLegpers userOrgLegpers);

	/**
	 * 新增金融机构经办人信息
	 * @param userOrgOper
	 * @return
	 */
	@PostMapping("/userorgoper/save")
	UserOrgOper saveOrgPer(@RequestBody UserOrgOper userOrgOper);

	/**
	 * 修改金融机构经办人信息
	 * @param userOrgOper
	 * @return
	 */
	@PostMapping("/userorgoper/update")
	UserOrgOper updateOrgPer(@RequestBody UserOrgOper userOrgOper);

	/**
	 * 入驻时新增用户关联表信息
	 * @param userRelation
	 * @return
	 */
	@PostMapping("/userrelation/save")
	UserRelation saveRelation(@RequestBody UserRelation userRelation);
}
