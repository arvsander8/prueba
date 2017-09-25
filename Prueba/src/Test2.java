

import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileReader;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

import javax.imageio.ImageIO;

import org.junit.*;
import static org.junit.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test2 {
  private WebDriver driver;
  private String baseUrl;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
	System.setProperty("webdriver.chrome.driver", "c:/Instaladores/chromedriver_win32/chromedriver.exe");
    driver = new ChromeDriver();
    baseUrl = "http://www.sunat.gob.pe/cl-ti-itmrconsruc/jcrS00Alias";
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
  }

  @Test
  public void test1() throws Exception {
    driver.get(baseUrl);
    driver.switchTo().frame("leftFrame");
    driver.findElement(By.name("search1")).sendKeys("20456166149");
    
    File outputfile = new File("saved.png");
    byte[] arrScreen = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
    BufferedImage imageScreen = ImageIO.read(new ByteArrayInputStream(arrScreen));
    WebElement cap = driver.findElement(By.name("imagen"));
    Dimension capDimension = cap.getSize();
    Point capLocation = cap.getLocation();
    BufferedImage imgCap = imageScreen.getSubimage(capLocation.x, capLocation.y, capDimension.width, capDimension.height);
    ImageIO.write(imgCap, "png", outputfile);
    Thread.sleep(1000);
    
    Runtime rt = Runtime.getRuntime();
    rt.exec("tesseract saved.png out");
    
    Thread.sleep(1000);
    
    String cadena="";
    FileReader f=new FileReader("out.txt");
	try{
		BufferedReader b = new BufferedReader(f);
	    cadena = b.readLine();
	    b.close();
	} catch (Exception e) {
		
	}
	finally {
		 f.close();
	}
    
   
    driver.findElement(By.name("codigo")).sendKeys(cadena);
    
        
    if (driver instanceof JavascriptExecutor) {
        ((JavascriptExecutor)driver).executeScript("evalSearch()");
    } else {
        throw new IllegalStateException("This driver does not support JavaScript!");
    }
    Thread.sleep(1500);
    driver.switchTo().defaultContent();
    driver.switchTo().frame("mainFrame");

    String CIIU = driver.findElement(By.name("select")).getText();
    
    //System.out.println(CIIU);
    Logger loger = Logger.getGlobal();
    loger.info(CIIU);
    
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
