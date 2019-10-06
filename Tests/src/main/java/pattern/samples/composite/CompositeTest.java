package pattern.samples.composite;

public class CompositeTest {

	public static void main(String[] args) {
		Shape triangle1 = new Triangle("triangle1");
		Shape circle1 = new Circle("circle1");
		Shape drawing1 = new Drawing("drawing1");
		((Drawing) drawing1).addShape(triangle1);
		((Drawing) drawing1).addShape(circle1);

		Shape circle2 = new Circle("circle2");
		Shape drawing2 = new Drawing("drawing2");
		((Drawing) drawing2).addShape(circle2);
		((Drawing) drawing2).addShape(drawing1);
		drawing2.draw();
	}
}
