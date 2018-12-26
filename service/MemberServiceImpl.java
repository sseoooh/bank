package service;

import domain.*;
import service.*;
import controller.BankController;

/**
 * @author Park Seowoo
 * @date 2018. 12. 26.
 * @desc 멤버기능구현
 */
public class MemberServiceImpl implements MemberService{
	private int count;
	private MemberBean[] members;
	
	
	public MemberServiceImpl(){ //클래스끼리는 앞에 없어도 default값이 들어가지만 패키지끼리는 접근제한자 public 써줘야함
		this.members = new MemberBean[10];
		
	}
	
	
	@Override
	public void join(String id, String pass, String name, String ssn) {
		MemberBean bean = new MemberBean(); //void로 바뀌니까 밑에 return있으면 안된다
		bean.setId(id);	//for로쓰면 join을 부를때마다 i가 0이되기때문에 분리
		bean.setName(name);
		bean.setPass(pass);
		bean.setSsn(ssn);
		members[count] = bean;//처음에는다 i였다 for문이 있었던자리 해체함
		count++;
		//System.out.println("카운트: "+count);
		}

	@Override
	public MemberBean[] findAll() {
		// TODO Auto-generated method stub
		return members;
	}

	@Override
	public MemberBean[] findByName(String name) {
		for(int i=0;i<count;i++) {
			if(members[i].getName().equals(name)) {
				
				break;
			}
		}
		// TODO Auto-generated method stub
		return members;
	} 

	@Override
	public MemberBean findById(String id) {
		MemberBean bean = new MemberBean();
		for(int i=0;i<count;i++) {
			if(members[i].getId().equals(id)) {
				bean = members[i]; 
				break;
			}
		}
		// TODO Auto-generated method stub
		return bean;
	} 

	@Override
	public int countMember() {
		// TODO Auto-generated method stub
		return count;
	}

	@Override
	public boolean existMember(String id, String pass) {
		boolean ok = false;
		for(int i=0;i<count;i++) {
			if(members[i].getId().equals(id)&&members[i].getPass().equals(pass)) {
				ok = true;
				break;
			}
		}
		return ok;
	}

	@Override
	public void updatePass(String id, String pass, String newPass) {
		
		for(int i = 0;i<count;i++) {
			if(existMember(id, pass)) {
				members[i].setPass(newPass);
			}
		}
		
	}

	@Override
	public void deleteMember(String id, String pass) {
		for(int i=0;i<count;i++) {
			if(existMember(id, pass)) {
				members[i] = members[count-1];
				members[count-1] = null;
				count--;
				break;
			}
		}
		
	}
	
}
