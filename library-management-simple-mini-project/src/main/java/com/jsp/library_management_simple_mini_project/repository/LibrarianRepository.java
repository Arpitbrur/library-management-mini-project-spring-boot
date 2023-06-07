package com.jsp.library_management_simple_mini_project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsp.library_management_simple_mini_project.dto.Librarian;

public interface LibrarianRepository extends JpaRepository<Librarian, Integer> {

}
