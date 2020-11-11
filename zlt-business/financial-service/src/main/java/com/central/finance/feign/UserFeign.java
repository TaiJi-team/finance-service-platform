package com.central.finance.feign;

import com.central.finance.feign.fallback.UserFeignFallbackFactory;
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
@FeignClient(name = "user-center", fallbackFactory = UserFeignFallbackFactory.class, decode404 = true)
public interface UserFeign {
	/**
	 * 添加用户信息
	 * @param userRelation
	 * @return
	 */
	@PostMapping("/userrelation/save")
	UserRelation saveRelation(@RequestBody UserRelation userRelation);

	/**
	 * 修改用户信息
	 * @param userRelation
	 * @return
	 */
	@PostMapping("/userrelation/update")
	UserRelation updatePer(@RequestBody UserRelation userRelation);

	/**
	 * 查询用户信息
	 * @param id
	 * @return
	 */
	@GetMapping("/userrelation/selectList/{id}")
	List<UserRelation> selectList(@PathVariable("id") String id);
}
