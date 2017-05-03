package com.zhmz.user.controller;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
class UserController {

	@ModelAttribute("module")
	String module() {
		return "user";
	}

	@GetMapping("/")
	String index() {
		return "user/list";
	}
}
