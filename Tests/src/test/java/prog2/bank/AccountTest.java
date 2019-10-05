package prog2.bank;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Before;
import org.junit.Test;


public class AccountTest {

	private Account account1;
	private Account account2;

	@Before
	public void setup(){
		account1 = new Account("00123", AccountKind.CURRENT_ACCOUNT);
		account2 = new Account("00234", AccountKind.SAVING_ACCOUNT);
		account2.setAccountBalance(20);
	}

	//Test1
	//Jeśli wpłacimy 10 stan konta ma być 10
	@Test
	public void shouldReturnTenWhenDepositOnEmptyAccount() {
		account1.deposit(10);
		int result = account1.getAccountBalance();
		assertEquals(10, result, "Should return 10 when deposit was 10");
	}

	//Test2
	//Jeśli wpłacimy 10 na konto z saldem=20 to stan konta ma być 30
	@Test
	public void shouldReturnSumWhenDepositOnNonEmptyAccount() {
		account2.deposit(10);
		int result = account2.getAccountBalance();
		assertEquals(30, result,
				"Should return 30 when deposit was 10 as entry balance was 20");
	}

	//Test3
	//Jeśli wypłacimy 10 z konta z saldem=0 to mamy dostać błąd
	@Test
	public void shouldReturnFalseWhenWithdrawFromEmptyAccount() {
		boolean withdrawState = account1.withdraw(10);
		assertEquals(false, withdrawState,
				"Should not allow withdraw from empty account");
	}

	//Test4
	//Jeśli wypłacimy 20 z konta z saldem=10 to mamy dostać błąd
	@Test
	public void shouldReturnFalseWhenWithdrawMoreThenAccountBalance() {
		boolean withdrawState = account2.withdraw(30);
		assertEquals(false, withdrawState,
				"Should not allow withdraw more then account balance");
	}

	//Test5
	//Jeśli wypłacimy 5 z konta z saldem=10 mamy
	@Test
	public void shouldReturnTrueWhenWithdrawLessThenAccountBalance() {
		boolean withdrawState = account2.withdraw(5);
		assertEquals(true, withdrawState,
				"Should allow withdraw less then account balance");
	}
}