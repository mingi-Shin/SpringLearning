package kr.co.sist.link;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LinkController {

	@GetMapping("link/link_value")
	public String link(Model model) {
		LinkDTO lDTO = new LinkDTO();
		lDTO.setUrlName("구글");
		lDTO.setUrl("google.com");
		
		LinkDTO lDTO2 = new LinkDTO();
		lDTO2.setUrlName("객체 값 출력");
		lDTO2.setUrl("obj/object_value");
		lDTO2.setName("이여진");
		lDTO2.setAge(29);
		
		model.addAttribute("lDTO", lDTO);
		model.addAttribute("lDTO2", lDTO2);
		
		return "link/link_view";
	} //link
	
} //class
