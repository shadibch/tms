package com.tms.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import com.tms.dao.*;
import com.tms.dto.*;
import com.tms.entity.*;

@Controller
public class MainController {
	@Autowired
	private TaskDao taskDao;
	@RequestMapping(method=RequestMethod.GET,path="/")
	public String home(@PageableDefault(page=0,size=20) Pageable pagable,Model model) {
		model.addAttribute("tasks", taskDao.findAll(pagable));
		model.addAttribute("titles", Title.values());
		model.addAttribute("states", Status.values());
		return "welcome";
	}
	@RequestMapping(method=RequestMethod.GET,path="login")
	public String login() {
		return "login";
	}
}
