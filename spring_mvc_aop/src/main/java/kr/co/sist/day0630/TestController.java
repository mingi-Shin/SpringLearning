package kr.co.sist.day0630;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestController {

	@Autowired(required=false)
	private TestService tService;

	@GetMapping("/")
	public String inex() {
		
		return "index";
	}
	
	@GetMapping("/searchName")
	public String ctrSearchName(String id, Model model) {
		System.out.println("[Controller ] : ctrSearchName");
		model.addAttribute("name", tService.searchName(id));
		
		
		return "day0630/searchResult";
	}
	
	
	

}
