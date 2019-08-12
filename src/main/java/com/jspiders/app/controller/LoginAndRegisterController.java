package com.jspiders.app.controller;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.jspiders.app.dto.StudentDto;
import com.jspiders.app.service.StudentService;
import com.jspiders.app.util.StudentLoginUtil;

@Controller
// to create session object
@SessionAttributes("studentFromSession")
public class LoginAndRegisterController {

	@Autowired
	StudentService service;

	@RequestMapping(value = "/")
	String dashboard() {
		return "signInUp";
	}

	@RequestMapping("/dispalySignUpPage")
	String displayRegisterStudent() {
		System.out.println("page diplayed");
		return "signUpPage";
	}

	// it will recive values
	@RequestMapping("/signUp")
	String registerStudent(StudentDto std, Model model) {
		System.out.println(std);
		model.addAttribute("std", std);

		// save into dB

		Long id = (Long) service.saveStudent(std);

		return "diplayMyDetails";
	}

	@RequestMapping("/dispalySignInPage")
	String displaySigbInPage() {
		System.out.println("page diplayed");
		return "signInPage";
	}

	// @PostMapping("/signIn")
	@RequestMapping(value = "/signIn", method = RequestMethod.POST)
	String signInStudent(StudentLoginUtil stdUtil, Model model) {
		System.out.println(stdUtil);
		// model.addAttribute("std", std);

		// compare to dB object
		StudentDto studentFromDb = service.fetchStudentByEmailOrId(stdUtil.getLoginCrd());

		if (studentFromDb == null) {
			model.addAttribute("msg", "Wrong email or login Id");
			return "signInPage";
		}

		// login and password match then send to dashboard page othersie again send back
		// to login page
		if (studentFromDb.getPassword().equals(stdUtil.getPassword())) {
			model.addAttribute("msg", "Welcome " 
					+ studentFromDb.getFirstName()                                                                                                          
						+ " " + studentFromDb.getLastName());
			// if key matchs with session key
			// add the value to session also
			model.addAttribute("studentFromSession", studentFromDb);
			return "dashboard";
		} else {
			model.addAttribute("msg", "passwrd entered is woring");
		}

		System.out.println(studentFromDb);
		return "signInUp";
	}

}