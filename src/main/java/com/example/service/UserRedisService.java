package com.example.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.util.Assert;

import com.example.config.RedisConfiguration;
import com.example.entity.Department;
import com.example.entity.Role;
import com.example.entity.User;


/** 
* @ClassName: UserRedisService 
* @Description: user redis 
* @author mengfanzhu
* @date 2017年2月21日 下午2:25:39 
*/
@Service
@ContextConfiguration(classes = {RedisConfiguration.class,UserRedis.class} )
public class UserRedisService {
	
	private Logger logger = LoggerFactory.getLogger(UserRedisService.class);
	
	@Autowired
	private UserRedis userRedis;
	
	public void redisInitData(){
		Department department = new Department();
		department.setName("科技部REDIS");
		
		Role role = new Role();
		role.setName("管理员REDIS");
		List<Role> roleList = new ArrayList<Role>();
		roleList.add(role);
		
		User user =new User();
		user.setName("管理员REDIS");
		user.setLoginName("adminRedis");
		user.setCreatedate(new Date());
		user.setRoleList(roleList);
		user.setDepartment(department);
		logger.info("key:" + this.getClass().getName()+":userByLoginName:"+user.getLoginName());
		userRedis.deleteByKey(this.getClass().getName()+":userByLoginName:"+user.getLoginName());
		userRedis.addUser(this.getClass().getName()+":userByLoginName:"+user.getLoginName(),3600L,user);
		
	}
	
	public User getUserRedis(String loginName){
		User user = userRedis.getUserByKey(this.getClass().getName()+":userByLoginName:"+loginName);
		Assert.notNull(user,"用户为空！");
		logger.info("===user=== name:{},loginName: {},departmentName:{}, roleName:{}",
				user.getName(),user.getLoginName(),user.getDepartment().getName(),user.getRoleList().get(0).getName());
		return user;
	}
}
