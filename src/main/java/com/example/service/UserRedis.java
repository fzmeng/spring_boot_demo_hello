package com.example.service;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import com.example.entity.User;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

/** 
* @ClassName: UserRedis 
* @Description:  redis 提供5种数据类型的操作
* String ,hash ,list , set , zset
* @author mengfanzhu
* @date 2017年2月21日 下午2:01:43 
*/
@Repository
public class UserRedis {
	
	@Autowired
	private RedisTemplate<String, String> redisTemplate;
	
	public void addUser(String key,Long time,User user){
		Gson gson = new Gson();
		redisTemplate.opsForValue().set(key, gson.toJson(user),time,TimeUnit.MINUTES);
	}
	
	public void addUserList(String key,Long time,List<User> userList){
		Gson gson = new Gson();
		redisTemplate.opsForValue().set(key, gson.toJson(userList),time,TimeUnit.MINUTES);
	}
	
	public User getUserByKey(String key){
		Gson gson = new Gson();
		User user = null;
		String userJson = redisTemplate.opsForValue().get(key);
		if(StringUtils.isNotEmpty(userJson)){
			user =  gson.fromJson(userJson, User.class);
		}
		return user;
	}
	
	public List<User> getUserListByKey(String key){
		Gson gson = new Gson();
		List<User> userList = null;
		String userJson = redisTemplate.opsForValue().get(key);
		if(StringUtils.isNotEmpty(userJson)){
			userList =  gson.fromJson(userJson, new TypeToken<List<User>>(){}.getType()	);
		}
		return userList;
	}
	
	public void deleteByKey(String key){
		redisTemplate.opsForValue().getOperations().delete(key);
	}
}
