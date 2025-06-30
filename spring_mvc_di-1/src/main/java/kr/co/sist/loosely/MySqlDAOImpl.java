package kr.co.sist.loosely;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * DBMS의 업무 목록을 구현. 
 */
public class MySqlDAOImpl implements DAO{

	@Override
	public int insert(TestDTO tDTO) throws SQLException {
		int cnt = new Random().nextInt(2); // 0, 1
		if(cnt == 0) {
			throw new SQLException("Oracle DB 추가 실패~");
		}
		System.out.println("Oracle DB 추가 성공!!");
		return cnt;
	}

	@Override
	public List<TestDomain> select() throws SQLException {
		List<TestDomain> list = new ArrayList<TestDomain>();
		list.add(new TestDomain("라파엘", 1000));
		list.add(new TestDomain("미카엘", 900));
		list.add(new TestDomain("가브리엘", 800));
		list.add(new TestDomain("신민기", 100));
		list.add(new TestDomain("윈터", 50));
		return list;
	}

	
}
