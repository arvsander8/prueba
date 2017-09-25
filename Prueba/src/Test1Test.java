
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test1Test {

	private static WebDriver driver;
	private static String baseUrl;
	 @Before
	  public void setUp() throws Exception {
		  //System.setProperty("webdriver.gecko.driver", "c:/Instaladores/geckodriver-v0.18.0-win64/geckodriver.exe");
		  System.setProperty("webdriver.chrome.driver", "c:/Instaladores/chromedriver_win32/chromedriver.exe");
	    driver = new ChromeDriver();
	    baseUrl = "https://www.google.com.pe";
	  }

	  @Test
	  public void test1() throws Exception {
	    driver.get(baseUrl);
	    //driver.findElement(By.id("lst-ib")).clear();
	    //driver.findElement(By.id("lst-ib")).sendKeys("algodon");
	  }

	  @After
	  public void tearDown() throws Exception {
	    driver.quit();
	  }
}
