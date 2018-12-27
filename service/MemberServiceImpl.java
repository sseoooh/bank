package service;

import domain.*;
import service.*;
import controller.BankController;

/**
 * @author Seowoo
 * @date 2018. 12. 26.
 * @desc 멤버기능구현
 */
public class MemberServiceImpl implements MemberService {
	private int count;// 여기서 초기화할수 없으니 밑에서 생성자만들어서 초기화시켜줌
	private MemberBean[] members; // 필드는 램

	public MemberServiceImpl() { // 클래스끼리는 앞에 없어도 default값이 들어가지만 패키지끼리는 접근제한자 public 써줘야함
		this.members = new MemberBean[10];
		this.count = 0;
	}

	@Override
	public void join(String id, String pass, String name, String ssn) {
		MemberBean bean = new MemberBean(); // void로 바뀌니까 밑에 return있으면 안된다
		bean.setId(id); // for로쓰면 join을 부를때마다 i가 0이되기때문에 분리
		bean.setName(name);
		bean.setPass(pass);
		bean.setSsn(ssn);
		members[count] = bean;// 처음에는다 i였다 for문이 있었던자리 해체함
		count++;
	}

	@Override
	public MemberBean[] findAll() {
		return members;
	}

	@Override
	public MemberBean[] findByName(String name) {
		MemberBean[] bean = new MemberBean[count];
		int j = 0;
		for (int i = 0; i < count; i++) {
			if (members[i].getName().equals(name)) {
				bean[j] = members[i];
				j++;
				break;
			}
		}
		return members;
	}

	@Override
	public MemberBean findById(String id) {
		MemberBean bean = new MemberBean();
		for (int i = 0; i < count; i++) {
			if (members[i].getId().equals(id)) {
				bean = members[i];
				break;
			}
		}
		return bean;
	}

	@Override
	public int countMember() {
		return count;
	}

	@Override
	public boolean existMember(String id, String pass) {
		boolean ok = false;
		for (int i = 0; i < count; i++) {
			if (members[i].getId().equals(id) && members[i].getPass().equals(pass)) {
				ok = true;
				break;
			}
		}
		return ok;
	}

	@Override
	public void updatePass(String id, String pass, String newPass) {

		for (int i = 0; i < count; i++) {
			if (existMember(id, pass)) {
				members[i].setPass(newPass);
			}
		}
	}

	@Override
	public void deleteMember(String id, String pass) {
		for (int i = 0; i < count; i++) {
			if (existMember(id, pass)) {
				members[i] = members[count - 1];
				members[count - 1] = null;
				count--;
				break;
			}
		}
	}
}
