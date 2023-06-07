package com.jsp.library_management_simple_mini_project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.jsp.library_management_simple_mini_project.dto.Admin;

public interface AdminRepository extends JpaRepository<Admin, Integer> {

	@Query(value="SELECT * FROM mainadmin WHERE adminemail=?1 AND adminname=?2",nativeQuery = true)
	Admin getByNameEmail(String adminEmail,String adminName);
	
	Admin getByAdminName(String adminName);
}
