package com.bookshelf.finder.controller;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bookshelf.finder.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
 
@Controller
@RequestMapping("/api")
public class UserController {
	Logger logger = LogManager.getLogger(UserController.class);
	 @Autowired
	    private UserService userService;
	 

	@GetMapping("/register")
	public String showRegistrationForm() {
	    logger.info("Displaying user registration form.");

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
        logger.info("redirect to main [age aftre user registration");
        return "redirect:/login";
	}
	
	
}
