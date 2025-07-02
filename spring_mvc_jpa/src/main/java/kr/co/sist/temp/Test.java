package kr.co.sist.temp;

import java.util.Objects;

public class Test {

	private String name;
	private Integer age;
	
	@Override
	public int hashCode() {
		//필드를 모두 사용하여 hashCode를 생성하고 반환, 필드값이 유일한 주소로 관리
		//값을 가지고 hashCode생성: 객체가 달라도 값이 같으면 같은 code가 생성.
		return Objects.hash(name, age);
	}
	
	
	
	public static void main(String[] args) {
		Test t = new Test();
		t.name="라파엘";
		t.age=20;
		
		Test t2 = new Test();
		t2.name="신민기";
		t2.age=20;
		
		System.out.println(t.hashCode());
		System.out.println(t2.hashCode());
		
	}
}
