package prog2.bank;

import java.util.HashMap;
import java.util.Map;

public class Bank {

	private static Integer clientNumber = 0;
	private static Integer accountNumber = 0;

	private String name;
	private Map<String, Client> clients;
	//private List<Account> accounts;

	public Bank(String name) {
		this.name = name;
		clients = new HashMap<>();
	}

	public String getName() {
		return name;
	}

	public Map<String, Client> getClients() {
		return clients;
	}

	public boolean addClient(Client client) {
		//check if client already exists in bank
		if(clients.containsValue(client)) {
			System.out.println("Klient " + client + " już istnieje w banku");
			return false;
		}
		//add client when not found
		client.setId(clientNumber.toString());
		clients.put(clientNumber.toString(), client);
		clientNumber++;

		System.out.println("Klient " + client + " założony");
		return true;
	}

	public boolean removeClient(Client client) {
		//check if client exists in bank
		if(clients.containsValue(client)) {
			for(String clientNumber : clients.keySet()) {
				if (clients.get(clientNumber).equals(client)){
					clients.remove(clientNumber);
					System.out.println("Klient " + client + " usuniety z systemu");
					return true;
				}
			}
		}
		//client not found
		System.out.println("Nie znaleziono klienta " + client + ", nie można usunąć");
		return false;
	}

	//dodanie konta klientowi
	public boolean addAccount(String clientNumber, AccountKind accountKind) {
		if(clients.containsKey(clientNumber)){
			Client client = clients.get(clientNumber);
			Account account = new Account("iban"+accountNumber.toString(), accountKind);
			Map<String, Account> accounts = client.getAccounts();
			accounts.put("iban"+accountNumber.toString(), account);
			client.setAccounts(accounts);
			System.out.println("Dla klienta " + client + " założono rachunek "
					+ account.getIban() + " " + account.getAccountKind());
			accountNumber++;
			return true;
		}
		System.out.println("Nie znaleziono klienta o numerze " +  clientNumber + "założenie konta niemożliwe");
		return false;
	}

	//usuniecie konta klienta


	//wpłata na konto
	public boolean depositMoney(String clientNumber, String accountNumber, int amount) {
		if(clients.containsKey(clientNumber)){
			Client client = clients.get(clientNumber);
			if(client.getAccounts().containsKey(accountNumber)){
				client.getAccounts().get(accountNumber).deposit(amount);
				System.out.println("Wpłata poprawnie zaksięgowana na koncie " + accountNumber);
				return true;
			}
			System.out.println("Dla klienta " + client + " nie znaleziono konta " + accountNumber);
			return false;
		}
		System.out.println("Nie znaleziono klienta " + clientNumber);
		return false;
	}


	public void printClients(boolean printAccountBalances){
		for (String clientNumber : clients.keySet()) {
			System.out.println(clients.get(clientNumber));
			//add print account balances here
			printCustomerAccounts(clientNumber, printAccountBalances);
		}
	}

	public void printCustomerAccounts(String clientNumber, boolean printAccountBalances){
		if(clients.containsKey(clientNumber)){
			Client client = clients.get(clientNumber);
			for(Account account : client.getAccounts().values()){
				System.out.println("Konto: " + account.getIban() +
						" rodzaj " + account.getAccountKind() +
						(printAccountBalances ? account.getAccountBalance() : ""));
			}
		} else {
			System.out.println("Client not found");
		}
	}
}
