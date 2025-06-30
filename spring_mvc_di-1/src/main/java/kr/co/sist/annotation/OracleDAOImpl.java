package kr.co.sist.annotation;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

/**
 * DBMS의 업무 목록을 구현. 
 */
//@Component
//@Repository 가 존재하지 않으면, Spring Container에서 component-Scan을 하지 않는다. 이 클래스가 있는지 모른다는 거야 
@Repository("ora")
public class OracleDAOImpl implements DAO{

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
		list.add(new TestDomain("윈터", 25));
		list.add(new TestDomain("카리나", 26));
		list.add(new TestDomain("닝닝", 24));
		list.add(new TestDomain("지젤", 26));
		return list;
	}

	
}
