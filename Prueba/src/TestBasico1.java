import java.util.logging.Logger;

import org.junit.Test;

public class TestBasico1 {

	@Test
	public void probarLog() {
	Logger loger = Logger.getGlobal();
    loger.info("Texto de prueba");
	}
	
}
