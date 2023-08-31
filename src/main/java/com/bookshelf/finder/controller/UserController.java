package com.bookshelf.finder.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import com.bookshelf.finder.service.UserService;

import jakarta.servlet.http.HttpServletRequest;
 
@Controller
public class UserController {

	 @Autowired
	    private UserService userService;
	 

	@GetMapping("/register")
	public String showRegistrationForm() {
		return "registration" ;
	}
	@PostMapping("/register")
	//Retrieve incoming HTTP request headers and form data using HttpServletRequest
    public String processRegistrationForm(HttpServletRequest request) {
        String name = request.getParameter("name");
        String userId = request.getParameter("userId");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String confirmPassword=request.getParameter("confirmPassword");
        userService.registerUser(name, userId, email, password,confirmPassword);

        return "redirect:/login";
	}
	
	
}
