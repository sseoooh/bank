package service;

import java.util.ArrayList;

import domain.AccountBean;

/**
 * @author Seowoo
 * @date 2018. 12. 26.
 * @desc
 */
public class AccountServiceImpl implements AccountService {
	private ArrayList<AccountBean> list;// 필드에서 은닉화는 필수

	public AccountServiceImpl() {// 메소드는 은닉화무조건
		list = new ArrayList<>(); // 안에 <> 넣은것을 제너릭스 //AccountBean[]과 같은느낌
	}

	/**********************************************
	 * CRATE
	 *********************************************/
	@Override
	public void createAccount(int money) {
		AccountBean account = new AccountBean();
		account.setAccountNum(createAccountNum());
		account.setMoney(money);
		account.setToday(findDate());
		list.add(account);

	}

	@Override
	public String createAccountNum() {
		// TODO Auto-generated method stub
		return null;
	}

	/**********************************************
	 * READ
	 *********************************************/

	@Override
	public ArrayList<AccountBean> findAll() {
		return list;
	}

	@Override
	public AccountBean findByAccountNum(String accountNum) {
		AccountBean account = new AccountBean();
		for (int i = 0; i < list.size(); i++) { // ()메소드로 처리된다// 러퍼런스들은 모두 메소드로 처리된다
			if (list.get(i).getAccountNum().equals(accountNum)) { // list.get(i)가 Bean하나다
				account = list.get(i);// for룸안에서만 돌기때문에 list가 밖으로나오면 죽음
			}
		}
		return account;
	}

	@Override
	public int countAccount() {
		// TODO Auto-generated method stub
		return list.size();
	}

	@Override
	public boolean existAccountNum(String accountNum) {
		boolean exist = false;
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getAccountNum().equals(accountNum)) {
				exist = true;
			}
		}
		return exist;
	}

	@Override
	public String findDate() {
		// TODO Auto-generated method stub
		return null;
	}

	/**********************************************
	 * UPDATE
	 *********************************************/
	@Override
	public void depositMoney(String accountNum, int money) {
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getAccountNum().equals(accountNum)) {
				list.get(i).setMoney(list.get(i).getMoney() + money);
				break;
			}
		}
	}

	@Override
	public void withdrawMoney(String accountNum, int money) {
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getAccountNum().equals(accountNum)) {
				list.get(i).setMoney(list.get(i).getMoney() - money);
				break;
			}
		}
	}

	/**********************************************
	 * DELETE
	 *********************************************/
	@Override
	public void deleteAccountNum(String accountNum) {
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getAccountNum().equals(accountNum)) {
				list.remove(i);
				break;
			}
		}
	}

}
