package com.example.controller;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.User;
import com.example.service.DataService;
import com.example.service.UserService;

/** 
* @ClassName: UserController 
* @Description: User控制器
* @author mengfanzhu
* @date 2017年2月20日 下午5:58:19 
*/
@RestController
@RequestMapping("/user")
public class UserController {
	
	protected static Logger logger=LoggerFactory.getLogger(UserController.class);  
	@Autowired
	private UserService userService;
	@Autowired
	private DataService dataService;
	
	@RequestMapping("/demo/{name}")
	@ResponseBody
	public String demoShowName(@PathVariable String name){
		 logger.debug("访问getUserByName,Name={}",name);  
		 return "name is " + name;
	}
	/** 
	 * @Title: UserController
	 * @Description: 数据初始化
	 * @author mengfanzhu
	 * @throws 
	 */
	@RequestMapping("/initdata")
	@ResponseBody
	public String initData(){
		dataService.initData();
		return "success";
	}
	
	/** 
	 * @Title: UserController
	 * @Description: 由loginName获取user
	 * @param loginName 
	 * @author mengfanzhu
	 * @throws 
	 */
	@RequestMapping("/getUserByLoginName/{loginName}")
	@ResponseBody
	public Map<String,Object> getUserByName(@PathVariable String loginName){
		Map<String,Object> result = new HashMap<String, Object>();
		User user = userService.readByLoginName(loginName);
		Assert.notNull(user);
		result.put("name", user.getName());
		result.put("loginName", user.getLoginName());
		result.put("departmentName",user.getDepartment().getName());
		result.put("roleName", user.getRoleList().get(0).getName());
		return result;
	}
}
