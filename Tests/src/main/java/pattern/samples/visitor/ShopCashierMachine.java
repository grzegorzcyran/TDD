package pattern.samples.visitor;

public class ShopCashierMachine implements CashierMachine {

	@Override
	public int visit(Fruit fruit) {
		int cost = 0;
		if (fruit.getFruitPrice() > 50) {
			cost = fruit.getFruitPrice() - 5;
		} else {
			cost = fruit.getFruitPrice();
		}
		System.out.println("Fruit " + fruit.getFruitName() + " price=" + fruit.getFruitPrice()
		 + " to pay=" + cost);
		return cost;
	}

	@Override
	public int visit(Vegetable vegetable) {
		System.out.println("Vegetable " + vegetable.getVegetableName()
				+ " cost=" + vegetable.getVegetablePrice());
		return vegetable.getVegetablePrice();
	}
}
