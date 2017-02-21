package com.example.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.entity.Department;

@Repository
public interface DepartmentDao extends JpaRepository<Department, Long> {

}
