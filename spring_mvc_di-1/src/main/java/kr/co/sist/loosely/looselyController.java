package kr.co.sist.loosely;

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
public class looselyController {
	
	//의존성 주입
	/*
	 * @Autowired private Assembly ass;
	 * 
	 * @Autowired private Test test;
	 * 
	 * @Autowired private OutPack op;
	 */
	

	@RequestMapping(value = "/", method = {GET, POST})
	public String memberIndex() {
//		System.out.println("ass--- " + ass);
//		System.out.println("test--- " + test);
//		System.out.println("op--- " + op);
		return "index";
	}//memberIndex
	
	
	@GetMapping(value = "/member/add_process")
	public String addMember(TestDTO tDTO, Model model) {
		System.out.println("add_process 실행");
		Assembly ass = new Assembly();
		Service service = ass.getBean();
		model.addAttribute("addResult", service.add(tDTO));
		model.addAttribute("data", tDTO);
		
		return "member/addResult";
	}
	
	@GetMapping("/member/search")
	public String searchMember(Model model) {
		Assembly ass = new Assembly();
		Service service = ass.getBean();
		List<TestDomain> list = service.search();
		
		model.addAttribute("data", list);
		
		return "member/memberList";
	}
	
	
}//class
