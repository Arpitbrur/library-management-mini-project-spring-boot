package com.jsp.library_management_simple_mini_project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.jsp.library_management_simple_mini_project.ResponseStructure.ResponseStructure;
import com.jsp.library_management_simple_mini_project.dao.LibrarianDao;
import com.jsp.library_management_simple_mini_project.dto.Librarian;

import jakarta.servlet.http.HttpSession;

@Service
public class LibrarianService {


	@Autowired
	HttpSession httpSession;

	@Autowired
	LibrarianDao dao;
	
	@Autowired
	ResponseStructure<Librarian> responseStructure;

	// save librarian-----------------------------------------------------------------------------------------------------
	public ResponseStructure<Librarian> saveLibrarian(Librarian librarian) {

		if(httpSession.getAttribute("adminEmail")!=null) {
			
			responseStructure.setStatusCode(HttpStatus.CREATED.value());
			responseStructure.setMsg("Librarian-Data-Added");
			responseStructure.setData(librarian);
			dao.saveLibrarian(librarian);
			return responseStructure;
			
		}else {
			responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
			responseStructure.setMsg("Please-Login-With-Admin");
			responseStructure.setData(null);
			return responseStructure;
		}
	}
	
	
	// update librarian------------------------------------------------------------------------------------------------
	public ResponseStructure<Librarian> updateLibrarian(Librarian librarian, int librarianId) {

		if(httpSession.getAttribute("adminEmail")!=null) {
			
			Librarian librarian2=dao.updateLibrarian(librarian, librarianId);
			
			responseStructure.setStatusCode(HttpStatus.ACCEPTED.value());
			responseStructure.setMsg("Data-Updated-Successfully...");
			responseStructure.setData(librarian2);
			return responseStructure;
		}else {
			responseStructure.setStatusCode(HttpStatus.ACCEPTED.value());
			responseStructure.setMsg("Please Login With Admin And then update...");
			responseStructure.setData(null);
			return responseStructure;
		}
	}
	
	
	// logIn librarian--------------------------------------------------------------------------------------------------
	public List<Librarian> getAllLibrarianData(){
		return dao.getAllLibrarianData();
	}

}
