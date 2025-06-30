package kr.co.sist.loosely;

import java.sql.SQLException;
import java.util.List;

/**
 * 부모인터페이스인 DAO를 의존성 주입(DI)받아서 업무로직에 사용하는 일
 */
public class ServiceImpl implements Service {

	private DAO dao;
	
	public ServiceImpl(DAO dao) {
		this.dao = dao;
	}
	
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
