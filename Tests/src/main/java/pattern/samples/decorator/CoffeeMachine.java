package pattern.samples.decorator;

public class CoffeeMachine {

	public static void main(String[] args) {
		Coffee blackCoffee = new BasicCoffee();
		blackCoffee.prepare();
		System.out.println("--------------");
		Coffee capuccino1 = new Cappuccino(new BasicCoffee());
		capuccino1.prepare();
		System.out.println("--------------");
		Coffee cappuccino2 = new Cappuccino(new HoneyCoffee(new BasicCoffee()));
		cappuccino2.prepare();
		System.out.println("--------------");
		Coffee latte1 = new CaffeeLatte(new BasicCoffee());
		latte1.prepare();
		System.out.println("--------------");
		Coffee latte2 = new HoneyCoffee(new CaffeeLatte(new BasicCoffee()));
		latte2.prepare();

	}

}
