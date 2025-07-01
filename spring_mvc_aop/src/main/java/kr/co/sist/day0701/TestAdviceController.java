package kr.co.sist.day0701;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestAdviceController {

	@Autowired(required = false)
	private TestAdviceService tas;
	
	@GetMapping("/before")
	public String ctrBefore(String msg, Model model) {
		
		String value=tas.before(msg);//업무로직을 처리하는 method 호출
		model.addAttribute("msg", value);
		model.addAttribute("adviceMsg", "before");
		return "day0701/beforeResult";
		
		
	}
	
	
	
	@GetMapping("/afterReturning")
	public String ctrAfterReturning(String msg, Model model) {
		
		String value=tas.afterReturning(msg);//업무로직을 처리하는 method 호출
		model.addAttribute("msg", value);
		model.addAttribute("adviceMsg", "AfterReturning");
		return "day0701/beforeResult";
		
		
	}//ctrAfterReturning

		@GetMapping("/afterThrowing")
		public String ctrAfter(String msg, Model model) {
			
			String value="";
					
			try {
				value=tas.afterThrowing(msg);
			} catch (Exception e) {
				e.printStackTrace();
			}//업무로직을 처리하는 method 호출
			
			model.addAttribute("msg", value);
			model.addAttribute("adviceMsg", "afterThrowing");
			return "day0701/beforeResult";
			
			
		}//ctrAfterReturning
		
		
		@GetMapping("/around")
		public String ctrAround(String msg, Model model) {
			
			String value=tas.around(msg);//업무로직을 처리하는 method 호출
			
			model.addAttribute("msg", value);
			model.addAttribute("adviceMsg", "around");
			return "day0701/beforeResult";
			
			
		}//ctrAfterReturning
		
}



