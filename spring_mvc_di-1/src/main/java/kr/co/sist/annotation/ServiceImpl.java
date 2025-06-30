package kr.co.sist.annotation;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

/**
 * 부모인터페이스인 DAO를 의존성 주입(DI)받아서 업무로직에 사용하는 일
 */
@org.springframework.stereotype.Service
public class ServiceImpl implements Service {

	@Autowired
	//@Qualifier("ora")  // @Repository가 두개있는데, ora 이름을 준거 가져올게 
	//근데 보통 이렇게 두개의 dao를 하나??
	@Qualifier("mySql")  
	private DAO dao;
	
	/*
	 * public ServiceImpl(DAO dao) { this.dao = dao; }
	 */
	
	@Override
	public boolean add(TestDTO tDTO) {
		int cnt = 0;
		try {
			if("윈터".equals(tDTO.getName())) {
				tDTO.setName(tDTO.getName()+"님");
			}
			cnt = dao.insert(tDTO);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cnt == 1; //true, false
	}

	@Override
	public List<TestDomain> search() {
		List<TestDomain> list = null;
		try {
			list = dao.select();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

}
