import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

public class LoggerDemo {

	private static final Logger LOGGER =
			Logger.getLogger(LoggerDemo.class.getName());

	public static void main(String[] args) {
		BasicConfigurator.configure();
		LOGGER.trace("Trace message");
		LOGGER.error("Error message");
		LOGGER.debug("Debug message");
		helloWorld();
	}

	private static void helloWorld(){

		System.out.println("Hello world");
		LOGGER.trace("Trace message");
		LOGGER.error("Error message");
		LOGGER.debug("Debug message");

	}
}
