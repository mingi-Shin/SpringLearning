package kr.co.sist.useScope;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import lombok.Data;

@Service
@Scope("prototype")
@Data
public class ScopeService2 {

	private String name;
	private int age;
}
