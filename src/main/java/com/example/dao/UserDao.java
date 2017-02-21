package com.example.dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.entity.User;
@Repository
public interface UserDao extends JpaRepository<User, Long> {
	
	User findByLoginNameLike(String name);

	User readByLoginName(String name);

	List<User> getByCreatedateLessThan(Date star);
}
