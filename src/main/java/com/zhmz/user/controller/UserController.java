package com.zhmz.user.controller;

import java.security.Principal;
import java.util.List;

import com.zhmz.user.entity.UserInfo;
import com.zhmz.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
class UserController {
    @Autowired
    private UserService userService;

	@ModelAttribute("module")
	String module() {
		return "user";
	}

	@GetMapping("/")
	String index() {
		// return "user/list";
		return "user/data";
	}

    @ResponseBody
    @GetMapping("/user/list")
    List<UserInfo> list() {
        return userService.list();
    }
}
