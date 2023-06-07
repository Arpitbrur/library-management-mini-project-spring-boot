package com.jsp.library_management_simple_mini_project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.library_management_simple_mini_project.ResponseStructure.ResponseStructure;
import com.jsp.library_management_simple_mini_project.dto.Librarian;
import com.jsp.library_management_simple_mini_project.service.LibrarianService;

import jakarta.servlet.http.HttpSession;

@RestController
public class LibrarianController {

	
	@Autowired
	private LibrarianService  librarianService;
	
	@Autowired
	private HttpSession httpSession;
	
	
	// save librarian-------------------------------------------------------------------------------------------------
	@PostMapping("/saveLibrarian")
	public ResponseStructure<Librarian> saveLibrarian(@RequestBody Librarian librarian) {
		return librarianService.saveLibrarian(librarian);
	}
	
	
	// update librarian-----------------------------------------------------------------------------------------------
	@PutMapping("/updateLibrarian/{librarianId}")
	public ResponseStructure<Librarian> updateLibrarian(@RequestBody Librarian librarian, @PathVariable int librarianId) {
		return librarianService.updateLibrarian(librarian, librarianId);
	}
	
	
	// LogIn librarian-------------------------------------------------------------------------------------------------
	@GetMapping("/loginLibrarian/{librarianName}/{librarianEmail}")
	public String librarianLogin(@PathVariable String librarianName, @PathVariable String librarianEmail) {
		List<Librarian> librarians = librarianService.getAllLibrarianData();
		
		for (Librarian librarian : librarians) {
			
			if((librarian.getLibrarianEmail().equalsIgnoreCase(librarianEmail)) && 
					(librarian.getLibrarianName().equalsIgnoreCase(librarianName)) ){
				httpSession.setAttribute("librarianEmail", librarianEmail);
				
				return "Librarian LogIn Successfully";
			}else {
				return "Please check your name and email";
			}
		}
		return null;
	}	
}
