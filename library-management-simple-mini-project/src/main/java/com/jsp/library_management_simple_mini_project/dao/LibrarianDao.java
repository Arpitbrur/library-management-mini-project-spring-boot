package com.jsp.library_management_simple_mini_project.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.library_management_simple_mini_project.dto.Librarian;
import com.jsp.library_management_simple_mini_project.repository.LibrarianRepository;

@Repository
public class LibrarianDao {

	@Autowired
	LibrarianRepository librarianRepository;

	
	 // save librarian---------------------------------------------------------------------------------------------
	public Librarian saveLibrarian(Librarian librarian) {
		
		return librarianRepository.save(librarian);
	}
	
	
	// update librarian-----------------------------------------------------------------------------------------------
	public Librarian updateLibrarian(Librarian librarian, int librarianId) {

		Optional<Librarian> optional = librarianRepository.findById(librarianId);

		if (optional.isPresent()) {

			Librarian librarian2 = optional.get();

			if ((librarian.getLibrarianName() != null) && (librarian.getLibrarianEmail() != null)) {

				librarian2.setLibrarianName(librarian.getLibrarianName());

				librarian2.setLibrarianEmail(librarian.getLibrarianEmail());

				librarianRepository.save(librarian2);

				return librarian2;
			} else if (librarian.getLibrarianName() != null) {
				librarian2.setLibrarianName(librarian.getLibrarianName());
				librarianRepository.save(librarian2);
				return librarian2;
			} else {

				librarian2.setLibrarianEmail(librarian.getLibrarianEmail());
				librarianRepository.save(librarian2);
				return librarian2;
			}
		}

		return null;
	}
	
	// logIn librarian--------------------------------------------------------------------------------------------------
	public List<Librarian> getAllLibrarianData(){
		return librarianRepository.findAll();
	}
}
