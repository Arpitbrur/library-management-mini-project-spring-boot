package com.jsp.library_management_simple_mini_project.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.library_management_simple_mini_project.dto.Admin;
import com.jsp.library_management_simple_mini_project.repository.AdminRepository;
@Repository
public class AdminDao {

	@Autowired
	AdminRepository adminRepository;
	
	// insert method
	public void saveAdmin(Admin admin) {
		adminRepository.save(admin);
		System.out.println("Data insert");
	}
	
	
	// login Admin with adminName and Password
		public Admin loginWithAdmin(String adminName) {		
			return adminRepository.getByAdminName(adminName);
		}
	
	// delete method
	public String deleteAdmin(int adminId)
	{
		Optional<Admin> optional=adminRepository.findById(adminId);
		if(optional.isPresent()) {
			adminRepository.delete(optional.get());
			return "data deleted successfully";
		}else {
			return "given id is not present";
		}
		

	}
	
	
	//this method will fetch all the data from main admin table
	public List<Admin> getAllAdmins(){
		return adminRepository.findAll();
	}
}
