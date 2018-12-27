package service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

import domain.AdminBean;

public class AdminServiceImpl implements AdminService {
	private HashMap<String, AdminBean> map;// string에 의해 뽑혀나오는 것은 adminBean
	private int seq; // 글번호

	public AdminServiceImpl() {
		map = new HashMap<>();
		seq = 0;
	}

	@Override
	public void createAdmin(String name, String pass, String auth) {
		AdminBean adminBean = new AdminBean();
		adminBean.setAdminNum(String.valueOf(seq));
		adminBean.setAuth(auth);
		adminBean.setName(name);
		adminBean.setPass(pass);
		seq++;
		map.put(adminBean.getAdminNum(), adminBean);

	}

	@Override
	public ArrayList<AdminBean> list() {
		// Collection c = map.values();
		// ArrayList<AdminBean> c = map.values();
		// ArrayList<AdminBean> c = (ArrayList<AdminBean>) map.values();
		return (ArrayList<AdminBean>) map.values();
	}

	@Override
	public ArrayList<AdminBean> findByAuth(String auth) {
		ArrayList<AdminBean> list = new ArrayList<>();
		Set<String> set = map.keySet();
		/**
		 * for each loop 이라고 합니다. Set은 인덱스가 없어요... 그래서 int i=0 이런식으로 못돌립니다. 그래서 아래처럼
		 * for를 돌립니다.
		 */
		for (String key : set) {
			if (auth.equals(map.get(key).getAuth())) {
				list.add(map.get(key));
			}
		}

		return list;
	}

	@Override
	public AdminBean findById(String adminNum) {
		return map.get(adminNum);
	}

	@Override
	public int countAdmin() {
		return map.size();
	}

	@Override
	public boolean existAdmin(String adminNum, String pass) {
		boolean exist = false;
		if (map.containsKey(adminNum) && map.get(adminNum).getPass().equals(pass)) {
		}
		return exist;
	}

	@Override
	public void updatePass(String adminNum, String pass, String newPass) {
		if (map.get(adminNum).getPass().equals(pass)) {
			map.get(adminNum).setPass(newPass);
		}
	}

	@Override
	public void updateAuth(String adminNum, String auth) {
		if (map.containsKey(adminNum)) {
			map.get(adminNum).setAuth(auth);
		}
	}

	@Override
	public void deleteAdmin(String adminNum) {
		map.remove(adminNum);
	}

}
