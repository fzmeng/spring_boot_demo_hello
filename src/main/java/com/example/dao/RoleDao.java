package com.example.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.entity.Role;
@Repository
public interface RoleDao extends JpaRepository<Role, Long> {

}
