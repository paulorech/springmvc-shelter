package com.user.wongi5.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.user.wongi5.dao.UserDao;
import com.user.wongi5.model.User;

@Controller
public class SignUpController {

	@Autowired
	UserDao userDao;
	
	
	/**
	 * Create new signUpForm object for empty from
	 * 
	 * @return
	 */
	@ModelAttribute("user")
	public User setSignUpForm() {
		return new User();
	}

	/**
	 * Method to show the initial HTML form
	 * 
	 * @return
	 */
	@GetMapping("/showSignUpForm")
	public String showForm() {
		return "signup-form";
	}

	/**
	 * Save User sign up form
	 * 
	 * @param signUpForm
	 * @param model
	 * @return
	 */
	@PostMapping("/saveSignUpForm")
	public String saveUser(@ModelAttribute("user") User user, Model model) {

		// Implement business logic to save user details into a database
		// .....

		System.out.println("FirstName : " + user.getFirstName());
		System.out.println("LastName : " + user.getLastName());
		System.out.println("Username : " + user.getUserName());
		System.out.println("Password : " + user.getPassword());
		System.out.println("Email : " + user.getEmail());
		
		List<User> users = userDao.findAll();

		System.out.println(users);

		model.addAttribute("user", users);
				
		model.addAttribute("message", "User SignUp successfully.");
//		model.addAttribute("user", user);

		return "signup-success";
	}
}
