package service;

import domain.AccountBean;
import domain.MemberBean;

/**
 * @author Park Seowoo
 * @date 2018. 12. 26.
 * @desc 은행계좌 서비스
 */

public interface AccountService {
	
	public void createAccount(int money);
	public AccountBean[] findAll();
	public AccountBean findByAccountNum(String accountNum);
	public int countAccount();
	public boolean existAccount(String accountNum);
	public void depositMoney(int money);
	public void withdrawMoney(int money);
	public void deleteAccountNum(String accountNum);;
}