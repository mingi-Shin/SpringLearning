package kr.co.sist.useScope;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import lombok.Data;

//별도지정이 없다면 singleton
@Service
@Data
public class ScopeService {

	private String name;
	private int age;
	
	@Value("${prgData.version}")
	private String version;
	@Value("${prgData.pubData}")
	private String pubData;
	@Value("${prgData.company}")
	private String company;
	
	
	public void info() {
		System.out.println("ss 프로그램 버전: " + version);
		System.out.println("ss 프로그램 배포일자: " + pubData);
		System.out.println("ss 고객사: " + company);
	}
	
}

