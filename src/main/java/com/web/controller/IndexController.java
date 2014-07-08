package com.web.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.web.service.UserService;

@Controller
public class IndexController {
	
//	private final static Logger logger = LoggerFactory.getLogger(IndexController.class);
	
	@Autowired UserService serv;

	@RequestMapping("/user")
	public String getUsers(Model model) throws ClassNotFoundException, IOException{
		model.addAttribute("users", serv.findAll());
		return "user";
	}
	
	@RequestMapping("/ajax/{id}")
	@ResponseBody
	public Object getUser(@PathVariable() Long id){
		return serv.get(id);
	}
	
	@RequestMapping("/")
	public String index(){
		return "index";
	}
}
