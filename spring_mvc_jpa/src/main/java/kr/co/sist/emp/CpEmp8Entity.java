package kr.co.sist.emp;

import java.math.BigDecimal;
import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

/**
 * Entity -> DBMS와 매핑되는 클래스 라는 의미
 * Table -> DBMS의 테이블 명을 설정, 생략하면 클래스 이름을 그대로 테이블 이름으로 사용. 명시적으로 @Table 쓰는 걸 권장하는 회사들이 많음
 */
@Data
@Entity
@Table(name="CP_EMP8")
public class CpEmp8Entity {

	//name값은 대문자로 해두는게 안전하다. 
	@Id
	@Column(name="EMPNO")
	private Integer empno;
	
	@Column(name="ENAME", length=20)
	private String ename;
	
	@Column(name="JOB", length=20) 
	private String job;
	
	@Column(name="MGR") //length는 생략가능
	private Integer mgr;
	
	@Column(name="HIREDATE") 
	private Date hiredate;
	
	@Column(name="SAL", precision = 7, scale =2) //precision:전체자릿수, scale:실수자릿수
	private BigDecimal sal;
	
	@Column(name="COMM", precision = 7, scale =2) 
	private BigDecimal comm;
	
	@Column(name="DEPTNO") 
	private Integer deptno;
	
}
