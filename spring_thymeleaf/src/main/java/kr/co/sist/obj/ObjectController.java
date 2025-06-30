package kr.co.sist.obj;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ObjectController {

	@GetMapping("obj/object_value")
	public String objData(Model model) {
		ObjDTO dto = new ObjDTO();
		dto.setName("이여진");
		dto.setAge(29);
		
		model.addAttribute("data", dto);
		
		return "obj/obj_view";
	} //objData
	
} //class
