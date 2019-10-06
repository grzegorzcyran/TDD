package pattern.samples.visitor;

import java.util.Arrays;
import java.util.List;

public class Main {

	public static void main(String[] args) {

		Fruit banana = new Fruit("banana", 10);
		Fruit apple = new Fruit("apple", 4);
		Fruit coconut = new Fruit("coconut",80);

		Vegetable carrot = new Vegetable("carrot", 2);
		Vegetable tomato = new Vegetable("tomato", 8);

		//	Merchandise[] merchandises = {
		//			banana, apple, carrot, coconut, tomato
		//	};

		CashierMachine cashierMachine = new ShopCashierMachine();
		List<Merchandise> merchandises = Arrays.asList(
				banana, apple, carrot, coconut, tomato);
		int shoppingCartValue = 0;

		for(Merchandise merchandise : merchandises){
			shoppingCartValue += merchandise.accept(cashierMachine);
		}
		System.out.println("To pay: " + shoppingCartValue);
	}



}
