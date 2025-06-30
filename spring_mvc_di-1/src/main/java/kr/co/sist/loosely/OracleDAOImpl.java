package kr.co.sist.loosely;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * DBMS의 업무 목록을 구현. 
 */
public class OracleDAOImpl implements DAO{

	@Override
	public int insert(TestDTO tDTO) throws SQLException {
		int cnt = new Random().nextInt(2); // 0, 1
		if(cnt == 0) {
			throw new SQLException("MySQL DB 추가 실패~");
		}
		System.out.println("MySQL DB 추가 성공!!");
		return cnt;
	}

	@Override
	public List<TestDomain> select() throws SQLException {
		List<TestDomain> list = new ArrayList<TestDomain>();
		list.add(new TestDomain("윈터", 25));
		list.add(new TestDomain("카리나", 26));
		list.add(new TestDomain("닝닝", 24));
		list.add(new TestDomain("지젤", 26));
		return list;
	}

	
}
