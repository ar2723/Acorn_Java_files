package test.dto;

public class AccountDto {
	private int num;
	private String day;
	private String item;
	private int income;
	private int expense;
	private int balance;
	
	public AccountDto() {}

	public AccountDto(int num, String day, String item, int income, int expense, int balance) {
		super();
		this.num = num;
		this.day = day;
		this.item = item;
		this.income = income;
		this.expense = expense;
		this.balance = balance;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}

	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	public int getIncome() {
		return income;
	}

	public void setIncome(int income) {
		this.income = income;
	}

	public int getExpense() {
		return expense;
	}

	public void setExpense(int expense) {
		this.expense = expense;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}
}
