package com.example.cntr;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.dto.User;
import com.example.serv.UserService;

@Controller
public class UserApp {
	@Autowired
	private UserService userService;
	@RequestMapping(value="/prep_login_form.htm")
	public String prepLoginForm(ModelMap map){
		map.put("user", new User());
		return "login";	
	}
	
	
	@RequestMapping(value="/prep_reg_form.htm")
	public String prepRegForm(ModelMap model) {
		model.put("user", new User());
		return "reg";
	}
	
	@RequestMapping(value="/reg.htm")
	public String register(User user,ModelMap model) {
		model.put("user", new User());
		userService.add(user);
		return "reg";
	}
	
	@RequestMapping(value="/login.htm")
	public String preplogin(User user,ModelMap model) {
		boolean flag = true;
		userService.login(user);
		if(flag) {
			
			return "home";
		}
		model.put("user", user);
		return "login";
	}
	
	
	@RequestMapping(value="/login.htm",method=RequestMethod.POST)
	public String login(User user,BindingResult errors,ModelMap model,HttpSession session) {
		boolean flag = userService.login(user);
		if(flag) {
			List<User> ulist = userService.selectAll();
			model.put("users", ulist);
			return "home";
		}
		model.put("user", user);
		return "login";
	}
	@RequestMapping(value="/update.htm",method=RequestMethod.POST)
	public String select(User user,ModelMap model) {
		userService.update(user);
		List<User> ulist = userService.selectAll();
		model.put("users", ulist);
		return "home";
	}
	@RequestMapping(value="/select.htm",method=RequestMethod.GET)
	public String select(@RequestParam int userId,ModelMap model) {
		User u = userService.select(userId);
		model.put("user", u);	
		return "update_form";
	}
	@RequestMapping(value="/delete.htm",method=RequestMethod.GET)
	public String delete(@RequestParam int userId,ModelMap model) {
		userService.remove(userId);
		List<User> ulist = userService.selectAll();
		model.put("users", ulist);
		return "home";
	}
	
}
