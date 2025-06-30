package kr.co.sist.controller;

import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Controller
public class MainController {

	@RequestMapping(value="/",method= {GET,POST})
	public String index(Model model) {
		model.addAttribute("helloMsg", "Hello Thymeleaf");
		model.addAttribute("helloMsg2", "<strong>안녕! Thymeleaf</strong>");
		
		model.addAttribute("name", "이여진");
		model.addAttribute("name2", "김민경");
		// Prefix /templates/ , suffix=.html
		
		//model.addAttribute("id", "shinmingi");
		
		return "index";
	} //index
	
}//class
