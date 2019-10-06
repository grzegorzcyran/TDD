package pattern.samples.visitor;

public class Vegetable implements Merchandise {

	private String vegetableName;
	private int vegetablePrice;

	public Vegetable(String vegetableName, int vegetablePrice) {
		this.vegetableName = vegetableName;
		this.vegetablePrice = vegetablePrice;
	}

	public String getVegetableName() {
		return vegetableName;
	}

	public int getVegetablePrice() {
		return vegetablePrice;
	}

	@Override
	public int accept(CashierMachine cashierMachine) {
		return cashierMachine.visit(this);
	}
}
