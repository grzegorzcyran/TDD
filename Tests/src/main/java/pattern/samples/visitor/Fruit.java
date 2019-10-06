package pattern.samples.visitor;

public class Fruit implements Merchandise{

	private String fruitName;
	private int fruitPrice;

	public Fruit(String fruitName, int fruitPrice) {
		this.fruitName = fruitName;
		this.fruitPrice = fruitPrice;
	}

	@Override
	public int accept(CashierMachine cashierMachine) {
		return cashierMachine.visit(this);
	}

	public String getFruitName() {
		return fruitName;
	}

	public int getFruitPrice() {
		return fruitPrice;
	}
}
