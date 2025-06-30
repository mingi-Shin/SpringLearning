package kr.co.sist.useScope;

import kr.co.sist.day0627.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@Scope("prototype")
public class ScopeController {

	@Autowired
	private ScopeService ss;
	@Autowired
	private ScopeService2 ss2;

	/*
	 * @Value("${prgData.version}") private String version;
	 * 
	 * @Value("${prgData.pubData}") private String pubData;
	 * 
	 * @Value("${prgData.company}") private String company;
	 */
	
	/**
	 * Spring 컨테이너 당 단 하나의 인스턴스만 생성
	 * 컨테이너가 시작될 때 딱 한번 인스턴스를 만들고, 이후 계속 같은 객체를 주입 
	 * @return
	 */
	@GetMapping("/singleton") // toc/tou??
	public String useSingleton(String name,@RequestParam(value = "age", defaultValue="0") String age) {
		
		ss.setName(name);
		if(!"0".equals(age)) {
			ss.setAge(Integer.parseInt(age));
		}
		
		System.out.println("사용한 객체: " + ss);
		System.out.println("값: " + ss.getName() + " / " + ss.getAge());
		ss.info(); //정보출력 
		

		return "day0630/result";
	}//useSingleton
	
	/**
	 * 요청할 때마다 매번 새로운 인스턴스를 생성
	 * 컨트롤러가 호출될 때마다 새로운 객체가 생성됨
	 * @return
	 */
	@GetMapping("/prototype")
	public String usePrototype(String name, @RequestParam(value = "age", defaultValue = "0")String age) {
		
		ss2.setName(name);
		if(!"0".equals(age)) {
			ss2.setAge(Integer.parseInt(age));
		}
		
		System.out.println("사용한 객체: " + ss2);
		System.out.println("값: " + ss2.getName() + " / " + ss2.getAge());
		
		
		return "day0630/result";
	}//usePrototype
	
	
	
	
	
	
	
}
