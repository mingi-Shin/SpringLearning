package kr.co.sist.img;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class imgController {

	@GetMapping("/img/img_view")
	public String img(Model model) {
		
		model.addAttribute("winter_img", "winter.gif"); //Spring Boot는 기본적으로 다음 경로에서 정적 파일(이미지, CSS, JS 등)을 찾습니다 :/static/, /resources/
		
		ImgDTO iDTO = new ImgDTO();
		iDTO.setImg("karina.jpg");
		iDTO.setTitle("에스파 윈터 컴백 06.27!");
		
		model.addAttribute("iDTO", iDTO);
		
		
		return "img/img_view"; // => templates/img/img_view.html
	}
}
