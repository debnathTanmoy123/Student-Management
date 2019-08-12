package com.jspiders.app.service;

import java.io.Serializable;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jspiders.app.dao.StudentDao;
import com.jspiders.app.dto.StudentDto;

@Service
public class StudentService {

	@Autowired
	private StudentDao dao;
	
	public Serializable saveStudent(StudentDto  studentDto){
		return dao.saveStudent(studentDto);
	}

	public StudentDto fetchStudentByEmailOrId(String loginCrd) {
		
	return dao.fetchStudentByEmailOrLoginId( loginCrd);
	}

	public void updateStudent(StudentDto stdFromJsp){
		dao.updateStudent(stdFromJsp);
	}
	
	public void deleteStudent(StudentDto studentFromSession){
		dao.deleteStudent(studentFromSession);
	}
	
	
}
