package kr.co.sist.annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.co.sist.day0627.Test;
import us.test.OutPack;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import java.util.List;;
@Controller
public class looselyController2 {
	
	@Autowired
	private Service service; //인터페이스
	
	@GetMapping(value = "/member2/add_process")
	public String addMember(TestDTO tDTO, Model model) {
		System.out.println("add_process 실행");
		model.addAttribute("addResult", service.add(tDTO));
		model.addAttribute("data", tDTO);
		
		return "member2/addResult";
	}
	
	@GetMapping("/member2/search")
	public String searchMember(Model model) {
		model.addAttribute("data", service.search());
		
		return "member2/memberList";
	}
	
	
}//class
