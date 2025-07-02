package kr.co.sist.emp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor //final 또는 @NonNull 필드를 대상으로 자동으로 생성자를 만들어줍니다.
@Service
public class CpEmp8Service {


	private final CpEmp8Repository cer;

	/**
	 * 모든 Entity를 조회
	 * @return
	 */
	public List<CpEmp8Entity> searchAllCpEmp8(){
		int count = (int) cer.count();
		System.out.println("총 " + count + "개 데이터 발견");
		return cer.findAll();
	}
	
	/**
	 * 입력되는 Entity객체 @Id값이 Target table에 존재하지 않으면 insert, 존재하면 update수행!
	 * @param cee
	 * @return
	 */
	public CpEmp8Entity addModifyCpEmp8(CpEmp8Entity cee) throws IllegalArgumentException {
		
		if(cee.getEmpno() != null && !(cee.getEmpno() > 0 && cee.getEmpno() < 10000)) {
			throw new IllegalArgumentException("사원번호는 0~9999까지 허용됩니다.");
		}
		
		CpEmp8Entity ce8 = cer.save(cee);
		
		
		return ce8;
	}
	
	public CpEmp8Entity searchOneEmp(int empno) {
		CpEmp8Entity ceeResult = null; 
		
		Optional<CpEmp8Entity> optional = cer.findById(empno);
		//사원번호가 입력 되었을 때 사원 번호로 검색된 객체가 있는지? 편하게 알수있다. 
		System.out.println("--------------------------------------------------" + optional.isPresent());  
		if(optional.isPresent()) {
			ceeResult = optional.get(); //객체가 존재하면 객체를 얻을거야.
			
		}
		
		return ceeResult;
	}
	
	
}
