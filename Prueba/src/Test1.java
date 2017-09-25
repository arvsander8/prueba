

import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import org.openqa.selenium.*;
//import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Test1 {
  private WebDriver driver;
  private String baseUrl;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
	  System.setProperty("webdriver.gecko.driver", "c:/Instaladores/geckodriver-v0.18.0-win64/geckodriver.exe");
	  //System.setProperty("webdriver.chrome.driver", "c:/Instaladores/chromedriver_win32/chromedriver.exe");
    //driver = new ChromeDriver();
	  driver = new FirefoxDriver();
    baseUrl = "https://www.google.com.pe";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void test1() throws Exception {
    driver.get(baseUrl + "/");
    driver.findElement(By.id("lst-ib")).clear();
    driver.findElement(By.id("lst-ib")).sendKeys("algodon");
    Thread.sleep(2000); 
    driver.findElement(By.id("lst-ib")).sendKeys(Keys.ARROW_DOWN);
    driver.findElement(By.id("lst-ib")).sendKeys(Keys.ARROW_DOWN);
    driver.findElement(By.id("lst-ib")).sendKeys(Keys.ARROW_DOWN);
    Thread.sleep(2000); 
    driver.findElement(By.id("lst-ib")).sendKeys(Keys.RETURN);
    Thread.sleep(2000);
    
    
  }

  @After
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

}
