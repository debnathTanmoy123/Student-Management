package com.jspiders.app.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.jspiders.app.dto.StudentDto;
import com.jspiders.app.service.StudentService;

@Controller
@SessionAttributes("studentFromSession")
public class StudentController {
	
	
	@Autowired
	StudentService service;
	
	@RequestMapping("/updatePage")
	String displayUpdateStudentPage(StudentDto stdFromJsp ,HttpSession httpSession , Model model){
		
		StudentDto stdFromSession = (StudentDto)httpSession.getAttribute("studentFromSession");
	
		model.addAttribute("stdObj", stdFromSession);
	
		
	return "updateStudentPage";	
	}
	
	@RequestMapping(value = "/update" , method = RequestMethod.POST )
	String updateStudent(StudentDto stdFromJsp , Model model , HttpSession httpSession){
			
		// update db
		
		// use in case of get mettod in dao 
		StudentDto stdFromSession = (StudentDto)httpSession.getAttribute("studentFromSession");
		stdFromJsp.setId(stdFromSession.getId());
		
		// using query in dao
		service.updateStudent(stdFromJsp);
		
		// upadte session
		model.addAttribute("studentFromSession", stdFromJsp);
		
	return "dashboard";	
	}
	
	@RequestMapping(value = "/deletePage")
	String deleteStudentPage(){
		System.out.println("delete");
	return "deleteStudentPage";	
	}
	@RequestMapping(value = "/delete")
	String deleteStudent(HttpSession httpSession,SessionStatus status){
		System.out.println("delete");
		StudentDto stdFromSession=(StudentDto) httpSession.getAttribute("studentFromSession");
		service.deleteStudent(stdFromSession);
	status.setComplete();
		System.out.println("Delete");
	return "signInUp";	
	}
	
	

	
	@RequestMapping(value = "/logout")
	String logout(SessionStatus sessionStatus) //to cleane the data from session we use SessionStatus Interface it has only one method to clean the session=> setComplete()
	{
		System.out.println("logout");
		sessionStatus.setComplete();
	return "signInPage";	
	}
	
}
