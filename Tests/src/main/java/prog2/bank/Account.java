package prog2.bank;

public class Account {

	private String iban;
	private AccountKind accountKind;
	private int accountBalance;

	public Account(String iban, AccountKind accountKind) {
		this.iban = iban;
		this.accountKind = accountKind;
		this.accountBalance = 0;
	}

	public Account(String iban) {
		this.iban = iban;
		this.accountBalance = 0;
	}

	public void setAccountKind(AccountKind accountKind) {
		this.accountKind = accountKind;
	}

	public String getIban() {
		return iban;
	}

	public AccountKind getAccountKind() {
		return accountKind;
	}

	public int getAccountBalance() {
		return accountBalance;
	}

	public void setAccountBalance(int accountBalance) {
		this.accountBalance = accountBalance;
	}

	public boolean deposit(int amount){
		this.accountBalance += amount;
		System.out.println("Wpłata wykonana, stan konta = "+accountBalance);
		return true;
	}

	public boolean withdraw(int amount){
		if (accountBalance>= amount) {
			accountBalance -= amount;
			return true;
		}
		System.out.println("Brak srodkow na rachunku");
		return false;
	}

}
