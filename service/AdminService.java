package service;

import java.util.ArrayList;

import domain.AdminBean;

public interface AdminService {
	// CREAT
	public void createAdmin(String name, String pass, String auth);

	// READ
	public ArrayList<AdminBean> list(); // 전부다가져오니 파라미터 필요없음

	public ArrayList<AdminBean> findByAuth(String auth);

	public AdminBean findById(String adminNum);

	public int countAdmin(); // 직원수

	public boolean existAdmin(String adminNum, String pass); // 관리자 로그인
	// UPDATE

	public void updatePass(String adminNum, String pass, String newPass);

	public void updateAuth(String adminNum, String auth); // 권한변경
	// DELETE

	public void deleteAdmin(String adminNum); // 퇴사
}
//READ는 기본 무조건 5개 all some one boolean int