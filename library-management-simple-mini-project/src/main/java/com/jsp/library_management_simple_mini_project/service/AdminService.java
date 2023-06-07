package com.jsp.library_management_simple_mini_project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.jsp.library_management_simple_mini_project.ResponseStructure.ResponseStructure;
import com.jsp.library_management_simple_mini_project.dao.AdminDao;
import com.jsp.library_management_simple_mini_project.dto.Admin;

@Service
public class AdminService {

	@Autowired
	AdminDao adminDao;
	
	@Autowired
	ResponseStructure<Admin> responseStructure;
	
	// register Admin---------------------------------------------------------------------
	public ResponseStructure<Admin> saveAdmin(Admin admin){
		if(admin!=null)
		{
			responseStructure.setStatusCode(HttpStatus.CREATED.value());
			responseStructure.setMsg("data inserted succesfully");
			responseStructure.setData(admin);
			adminDao.saveAdmin(admin);
			return responseStructure;
		}
		else
		{
			responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
			responseStructure.setMsg("check your data....");
			responseStructure.setData(admin);
			return responseStructure;
		}
	}
	
	
	// login Admin--------------------------------------------------------------------------
	 public ResponseStructure<Admin> loginWithAdmin(String adminName,String adminEmail) {
			
			Admin admin=adminDao.loginWithAdmin(adminName);
			
			if(admin!=null) {
				if((admin.getAdminName().equals(adminName))
						&&(admin.getAdminEmail().equals(adminEmail))) {
					responseStructure.setStatusCode(HttpStatus.ACCEPTED.value());
					responseStructure.setMsg("Admin----LoggedIn----Successfully...");
					responseStructure.setData(admin);
					return responseStructure;
					
				}else {
					responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
					responseStructure.setMsg("Admin----LoggedIn----Failed...");
					responseStructure.setData(admin);
					return responseStructure;
				}
			}else {
				responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
				responseStructure.setMsg("Admin----Details not found...");
				responseStructure.setData(admin);
				return responseStructure;
			}
		}
	
	// delete Admin-------------------------------------------------------------	
	public String deleteAdmin(int adminId) {
		return adminDao.deleteAdmin(adminId);
	}
	
	
	// this method will fetch all the data from main admin table
	 
	public List<Admin> getAllAdmins(){
		
		return adminDao.getAllAdmins();
	}
	
}
