package service;

import java.util.ArrayList;

import domain.AccountBean;
import domain.MemberBean;

/**
 * @author Seowoo
 * @date 2018. 12. 26.
 * @desc 은행계좌 서비스
 */

public interface AccountService {
	// CRAETE
	public void createAccount(int money);
	public String createAccountNum();	//계좌번호 생성 - 랜덤으로만들기때문에 파라미터 필요없음
	// READ
	public ArrayList<AccountBean> findAll();
	public AccountBean findByAccountNum(String accountNum);
	public int countAccount();
	public boolean existAccount(String accountNum);
	public String findDate();	// 날짜반환
	// UPDATE
	public void depositMoney(int money);
	public void withdrawMoney(int money);
	// DELETE
	public void deleteAccountNum(String accountNum);
	
}