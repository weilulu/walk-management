package com.walk.management.user.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.walk.management.user.entity.WalkUser;
import com.walk.management.user.service.UserService;

@RestController
@RequestMapping(value="user")
public class UserController {

	@Autowired
	private UserService userService;
	
	@GetMapping(value="login")
	public ModelAndView login(Model model){
		return new ModelAndView("user/login");
	}
	@PostMapping(value="getUser")
	public ModelAndView getUser(Model model,HttpServletRequest request){
		
		String userName = request.getParameter("userName");
		String pwd = request.getParameter("pwd");
		String remeber = request.getParameter("remeber");
		needRemeber(request,remeber);
		WalkUser user = userService.getUser(userName,pwd);
		ModelAndView mv = null;
		if(user != null){
			model.addAttribute("userName",userName);
			mv = new ModelAndView("user/start");
			return mv;
		}
		return new ModelAndView("user/login");
	}
	@RequestMapping(value="addUser")
	public ModelAndView addUser(Model model,
			                    @RequestParam(name="userName")String userName,
			                    @RequestParam(name="pwd")String pwd){
	
		ModelAndView mv = null;
		if(StringUtils.isBlank("userName")){
			model.addAttribute("failMsg","user name is empty!");
			mv = new ModelAndView("user/login");
			return mv;
		}
		if(StringUtils.isBlank("pwd")){
			model.addAttribute("failMsg","pwd is empty!");
			mv = new ModelAndView("user/login");
			return mv;
		}
		int addFlag = userService.addUser(userName,pwd);
		if(addFlag != 1){
			model.addAttribute("failMsg","login fial!");
			mv = new ModelAndView("user/login");
			return mv;
		}
		
		model.addAttribute("successMsg","Login Success!");
		mv = new ModelAndView("user/start");
		return mv;
	}
	
	private void needRemeber(HttpServletRequest request,String remeber){
		
	}
}
