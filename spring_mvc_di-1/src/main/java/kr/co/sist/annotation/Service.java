package kr.co.sist.annotation;

import java.util.List;

/**
 * 사용자에게 제공해야될 업무로직만 정의
 */
public interface Service {

	public boolean add(TestDTO tDTO);
	public List<TestDomain> search();
}
