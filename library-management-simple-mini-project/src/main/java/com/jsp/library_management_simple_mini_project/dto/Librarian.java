package com.jsp.library_management_simple_mini_project.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="library")

public class Librarian {

	@Id
	@Column(name="libraryid")
	private int librarianId;
	@Column(name="libraryname")
	private String librarianName;
	@Column(name="librarymail")
	private String librarianEmail;
	
	public int getLibrarianId() {
		return librarianId;
	}
	public void setLibrarianId(int librarianId) {
		this.librarianId = librarianId;
	}
	public String getLibrarianName() {
		return librarianName;
	}
	public void setLibrarianName(String librarianName) {
		this.librarianName = librarianName;
	}
	public String getLibrarianEmail() {
		return librarianEmail;
	}
	public void setLibrarianEmail(String librarianEmail) {
		this.librarianEmail = librarianEmail;
	}
	
	
	
	
}
