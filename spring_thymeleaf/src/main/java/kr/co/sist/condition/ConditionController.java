package kr.co.sist.condition;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import kr.co.sist.img.ImgDTO;
import kr.co.sist.obj.ObjDTO;

@SessionAttributes("oDTO")
@Controller
public class ConditionController {

	@GetMapping("/condition/condition_view")
	public String condition(Model model) {
		
		model.addAttribute("name", "신민기");
		model.addAttribute("score", 99);
		model.addAttribute("score2", 101);
		
		//-------------------------------------------------------------------------
		ObjDTO oDTO = new ObjDTO();
		oDTO.setName("신민기");
		oDTO.setAge(36);
		oDTO.setRole("ROLE_USER"); //ADMIN, USER
		
		model.addAttribute("oDTO", oDTO);
		
		//-------------------------------------------------------------------------
		List<String> list = new ArrayList<String>();
		list.add("윈터");
		list.add("카리나");
		list.add("닝닝");
		list.add("지젤");
		
		model.addAttribute("listNames", list);
		
		//-------------------------------------------------------------------------
		List<ImgDTO> list2 = new ArrayList<ImgDTO>();
		list2.add(new ImgDTO("winter.jpg", "윈터이미지"));
		list2.add(new ImgDTO("karina.jpg", "카리나이미지"));
		list2.add(new ImgDTO("ningning.jpg", "닝닝이미지"));
		list2.add(new ImgDTO("jijel.jpg", "지젤이미지"));
		
		model.addAttribute("listImgs", list2);
		
		return "condition/condition_view";
	}
}
