package domain;


/**
 * @author Seowoo
 *@date 2018. 12. 26.
 *@desc 은행계좌 빈객체
  */
public class AccountBean {
	private String accountNum,today;
	private int money; 
	
	public void setAccountNum(String accountNum) {
		this.accountNum = accountNum;
	}
	public String getAccountNum() {
		return accountNum;
	}
	public void setToday(String today) {
		this.today = today;
	}
	public String getToday() {
		return today;
	}
	public void setMoney(int money) {
		this.money = money;
	}
	public int getMoney() {
		return money;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return String.format("계좌: %s\n"
				+ "날짜: %s\n"
				+ "금액: %d\n", accountNum, today, money);
	}
}
