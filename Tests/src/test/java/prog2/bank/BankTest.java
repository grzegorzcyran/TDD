package prog2.bank;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class BankTest {

	private Bank bank1;
	private Bank bank2;

	@Before
	public void setUp() throws Exception {
		bank1 = new Bank("Bank Testowy 1");
		bank2 = new Bank("Bank Testowy 2");
		Client client = new Client("Jan", "Kowalski");
		bank2.addClient(client);
	}

	//dodanie pierwszego klienta
	@Test
	public void shouldReturnOneWhenAddClientToEmptyList() {
		Client client = new Client("Jan", "Kowalski");
		bank1.addClient(client);
		int result = bank1.getClients().size();
		bank1.printClients(true);
		assertEquals(1, result, "Should return 1 when add client to empty list");
	}

	//dodanie klienta gdy jeden już wpisany
	@Test
	public void shouldReturnTwoWhenAddClientToNonEmptyList() {
		Client client = new Client("Pawel", "Nowak");
		bank2.addClient(client);
		int result = bank2.getClients().size();
		bank2.printClients(true);
		assertEquals(2, result, "Should return 2 when add client to non empty list");
	}

	//dodanie klienta gdy taki sam jak wpisany
	@Test
	public void shouldReturnOneWhenAddClientThatAlreadyExists() {
		Client client = new Client("Jan", "Kowalski");
		bank2.addClient(client);
		int result = bank2.getClients().size();
		bank2.printClients(true);
		assertEquals(1, result, "Should return 1 when add client that already exists");
	}

	//usuniecie klienta z pustej listy
	@Test
	public void shouldReturnFalseWhenRemoveClientFromEmptyList() {
		Client client = new Client("Jan", "Kowalski");
		boolean result = bank1.removeClient(client);
		bank1.printClients(true);
		assertEquals(false, result, "Should return false when remove client from empty list");
	}

	//usuniecie klienta który istnieje
	@Test
	public void shouldReturnTrueWhenRemoveExistingClient() {
		Client client = new Client("Jan", "Kowalski");
		boolean result = bank2.removeClient(client);
		bank2.printClients(true);
		assertEquals(true, result, "Should return true when remove existing client");
	}

	//usuniecie klienta który nie istnieje
	@Test
	public void shouldReturnFalseWhenRemoveClientThatDoesNotExist() {
		Client client = new Client("Adam", "Kowalski");
		boolean result = bank2.removeClient(client);
		bank2.printClients(true);
		assertEquals(false, result, "Should return false when remove client that does not exist");
	}

	@Test
	public void shouldReturnFalseWhenAddAccountToNonExistingClient() {
		Client client = new Client("Adam", "Kowalski");
		bank1.addClient(client);
		boolean isAddAccount =  bank1.addAccount("2", AccountKind.CURRENT_ACCOUNT);
		bank1.printClients(true);

		assertEquals(false, isAddAccount, "Should return false when adding account to non existing client");
	}

	@Test
	public void shouldReturnTrueWhenAddAccountToExistingClient() {
		Client client = new Client("Adam", "Kowalski");
		bank1.addClient(client);
		boolean isAddAccount =  bank1.addAccount("10", AccountKind.CURRENT_ACCOUNT);
		bank1.printClients(true);

		assertEquals(true, isAddAccount, "Should return true when adding account to existing client");
	}

	//test wpłaty na istniejące konto, dla istniejącego klienta
	@Test
	public void shouldReturnTrueWhenDepositOnExistingAccountExistingClient(){
		Client client = new Client("Adam", "Kowalski");
		bank1.addClient(client);
		bank1.addAccount("1", AccountKind.CURRENT_ACCOUNT);
		bank1.printClients(true);
		boolean isDeposit = bank1.depositMoney("1", "iban0", 10);
		assertEquals(true, isDeposit, "Should return true when deposit to existing account of existing client");
	}

	//test wpłaty na nieistniejące konto, dla istniejącego klienta
	@Test
	public void shouldReturnTrueWhenDepositOnNonExistingAccountExistingClient(){
		Client client = new Client("Adam", "Kowalski");
		bank1.addClient(client);
		bank1.addAccount("1", AccountKind.CURRENT_ACCOUNT);
		bank1.printClients(true);
		boolean isDeposit = bank1.depositMoney("1", "iban_4", 10);
		assertEquals(false, isDeposit, "Should return false when deposit to non existing account of existing client");
	}

	//test wpłaty dla nieistniejącego klienta
	@Test
	public void shouldReturnTrueWhenDepositOnNonExistingClient(){
		Client client = new Client("Adam", "Kowalski");
		bank1.addClient(client);
		bank1.addAccount("1", AccountKind.CURRENT_ACCOUNT);
		bank1.printClients(true);
		boolean isDeposit = bank1.depositMoney("2", "iban_4", 10);
		assertEquals(false, isDeposit, "Should return false when deposit to non existing client");

	}

}