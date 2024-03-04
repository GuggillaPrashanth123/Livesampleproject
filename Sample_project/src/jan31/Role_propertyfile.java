package jan31;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Role_propertyfile {
	Properties p;
	WebDriver driver;
	@BeforeTest
	public void setup() throws Throwable
	{
		p = new Properties();
		p.load(new FileInputStream("branch.properties"));
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get(p.getProperty("Url"));
		driver.findElement(By.xpath(p.getProperty("Objuser"))).sendKeys(p.getProperty("EnterUser"));
		driver.findElement(By.xpath(p.getProperty("Objpass"))).sendKeys(p.getProperty("Enterpass"));
		driver.findElement(By.xpath(p.getProperty("ObjLogin"))).click();
	}
	@Test
	public void starttest() throws Throwable
	{
		driver.findElement(By.xpath(p.getProperty("objroles"))).click();
		driver.findElement(By.xpath(p.getProperty("objnewrole"))).click();
		driver.findElement(By.xpath(p.getProperty("objrolename"))).sendKeys(p.getProperty("enterrolename"));
		driver.findElement(By.xpath(p.getProperty("objroledes"))).sendKeys(p.getProperty("enterroledes"));
		new Select(driver.findElement(By.xpath(p.getProperty("objrolety")))).selectByVisibleText(p.getProperty("selectroletype"));
		driver.findElement(By.xpath(p.getProperty("objss"))).click();
		String expected_alert = driver.switchTo().alert().getText();
		Thread.sleep(5000);
		driver.switchTo().alert().accept();
		Thread.sleep(5000);
		Reporter.log(expected_alert,true);
	}
	@AfterTest
	public void teardown()
	{
		driver.quit();
	}
}
