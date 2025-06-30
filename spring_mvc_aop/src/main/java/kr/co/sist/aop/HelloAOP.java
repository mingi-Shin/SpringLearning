package kr.co.sist.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class HelloAOP {
	//이게 뭐고 언제 쓰는걸까? 왜 쓰는걸까?
	/**
	 * 여러 메서드에 중복으로 쓰는 코드를 AOP로 한 번에 관리 (sysout필요없음.)
	 * JoinPoint로 호출된 클래스와 메서드, 파라미터 정보를 받아서 처리
	 * 로그, 보안, 트랜잭션, 성능 측정 등 공통 작업에 매우 유용
	 */
	
//	@Before("execution(String kr.co.sist.day0630.TestDAO.selectName(String))") //얘에 대해서만 동작할거야 
//	@Before("execution(String kr.co.sist.day0630.TestService.searchName(String))") //얘에 대해서만 동작할거야 
	@Before("execution(* kr.co.sist.day0630.*.*(..))") //모두 불러볼게
	public void beforeAdvice(JoinPoint jp) {
		//공통코드를 작성
		System.out.println("[AOP] : beforeAdvice");
		
	}

}
