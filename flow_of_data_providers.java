package Data_providers;

import org.testng.annotations.Test;



import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;

public class flow_of_data_providers {
	static WebDriver driver;

  @Test
public void f(String n, String s) throws InterruptedException {
	  driver.findElement(By.id("email")).sendKeys(n);
	  driver.findElement(By.id("pass")).sendKeys(s);
	  driver.findElement(By.xpath("//*[@aria-label='Log In']")).click();
	  Thread.sleep(4000);
	  driver.navigate().back();
	  Thread.sleep(4000);
	  driver.findElement(By.id("email")).clear();
	  driver.findElement(By.id("pass")).clear();
	  Thread.sleep(4000);
	  Reporter.log("This is just checking if invalid credentials works or not");
  }

  @DataProvider
  public Object[][] dp() {
    return new Object[][] {
      new Object[] {"abc@gmail.com", "abc" },
      new Object[] {"def@gmail.com", "def" },
      new Object[] {"ghi@gmail.com", "ghi"},
      new Object[] {"jkl@gmail.com", "jkl"}
    };
  }
  @BeforeClass
@Parameters("browser")
  public void beforeClass(String browsers) throws Exception {
    if(browsers.equalsIgnoreCase("chrome")) {
     System.setProperty("webdriver.chrome.driver", "C:\\Users\\VAADMIN\\AppData\\Roaming\\Microsoft\\Windows\\Start Menu\\Programs\\Eclipse\\core_java\\Automation_aps_code\\Drivers\\chromedriver.exe");
      driver=new ChromeDriver();
      driver.navigate().to("https://www.facebook.com");
      }else if (browsers.equalsIgnoreCase("firefox")){
         System.setProperty("webdriver.gecko.driver", "C:\\Users\\VAADMIN\\AppData\\Roaming\\Microsoft\\Windows\\Start Menu\\Programs\\Eclipse\\core_java\\Automation_aps_code\\src\\geckodriver.exe");
         driver=new FirefoxDriver();
         driver.navigate().to("https://www.facebook.com");
         
      }else {
         throw new Exception("the browser not found");
      }
  }

  @AfterClass
  public void afterClass() throws InterruptedException {
	  Thread.sleep(4000);
	  driver.quit();
	  
  }

}
