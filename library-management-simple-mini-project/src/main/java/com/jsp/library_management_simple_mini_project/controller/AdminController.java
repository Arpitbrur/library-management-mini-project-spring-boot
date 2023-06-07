package com.jsp.library_management_simple_mini_project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.library_management_simple_mini_project.ResponseStructure.ResponseStructure;
import com.jsp.library_management_simple_mini_project.dto.Admin;
import com.jsp.library_management_simple_mini_project.service.AdminService;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@SuppressWarnings("serial")
@RestController
public class AdminController extends HttpServlet{

	@Autowired
	AdminService adminService;
	
	@Autowired
	HttpServletRequest httpServletRequest;

	@Autowired
	HttpSession httpSession ;
	
	@Autowired
	ResponseStructure<Admin> responseStructure;
	
	// insert method
	@PostMapping("/saveAdmin")
	public ResponseStructure<Admin> saveAdmin(@RequestBody Admin admin)
	{
		return adminService.saveAdmin(admin);
	}
	
	// login Admin with adminName and Password
	@GetMapping("/loginAdmin/{adminName}/{adminEmail}")
	public ResponseStructure<Admin> loginWithAdmin(@PathVariable String adminName,@PathVariable String adminEmail) {			
		httpSession.setAttribute("adminEmail",adminEmail);
		return adminService.loginWithAdmin(adminName, adminEmail);
	}
	
	
	// delete method
	@DeleteMapping("deleteAdmin/{adminId}")
	public String deleteAdmin(@PathVariable int adminId) {
		return adminService.deleteAdmin(adminId);
			
	}
	// for log out
	@GetMapping(value = "/logoutAdmin")
	public String logoutAdmin() {		
		if(httpSession.getAttribute("adminEmail")!=null){
			
			httpSession.invalidate();
			
			return "admin logout successfully";
		}else {
			return "please login again then logout";
		}
	}
	
}
