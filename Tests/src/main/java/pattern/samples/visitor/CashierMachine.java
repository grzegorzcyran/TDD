package pattern.samples.visitor;

public interface CashierMachine {
	int visit(Fruit fruit);
	int visit(Vegetable vegetable);
}
