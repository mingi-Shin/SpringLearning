package kr.co.sist.emp;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class CpEmp8Controller {

	private final CpEmp8Service ces;
	
	@RequestMapping(value = "/", method = {RequestMethod.GET, RequestMethod.POST})
	public String index(Model model) {
		
		model.addAttribute("empList", ces.searchAllCpEmp8());
		
		return "index";
	}
	
	@GetMapping("/emp/empAddFrm")
	public String empAddFrm() {
		
		return "emp/empAddFrm";
	}
	
	@PostMapping("/emp/empAddProcess")
	public String empAddFrmProcess(HttpServletRequest request, CpEmp8Entity cee, Model model) {
		System.out.println(request.getRequestURI()); //변경인지 추가인지 분별하기 위해서.
		
		String jobMsg = "추가";
		if("/emp/empAddProcess".equals(request.getRequestURI())) {
			jobMsg = "변경";
		}//end if
		
		CpEmp8Entity ceResult = null;
		try {
			ceResult = ces.addModifyCpEmp8(cee);
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		}//end catch
		
		System.out.println(ceResult);
		
		model.addAttribute("jobMsg", jobMsg);
		model.addAttribute("ceResult", ceResult); //null 또는 값을 가진 객체
		
		return "emp/empAddResult";
	}
	
	@GetMapping("/emp/searchOneEmp")
	public String searchOneEmp(int empno, Model model) {
		
		CpEmp8Entity ceeResult = ces.searchOneEmp(empno);
		
		model.addAttribute("empData", ceeResult);
		
		return "emp/empDetail";
	}
	
	
}
