package kr.co.sist.loosely;

import org.springframework.stereotype.Component;

/**
 * 1. 의존성 주입할 객체를 생성하고, 
 * 2. 의존성 주입받을 객체를 생성하여 의존성을 주입하고, 
 * 3. 의존성 주입받은 객체를 반환하는 일
 */
//scan대상이 되게끔 Component 어노테이션 해줘
@Component
public class Assembly {

	public Service getBean() {
		//1.의존성 주입받을 객체를 생성
		//MySqlDAOImpl msDAO = new MySqlDAOImpl();
		OracleDAOImpl msDAO = new OracleDAOImpl();
		
		//2.
		Service service = new ServiceImpl(msDAO);
		
		//3.
		return service;
	}
	
	
}
