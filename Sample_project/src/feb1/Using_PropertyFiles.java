package feb1;

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

public class Using_PropertyFiles {
Properties conprop;
WebDriver driver;
@BeforeTest
public void setUp()throws Throwable
{
	conprop = new Properties();
	//load property file
	conprop.load(new FileInputStream("D:\\project_live\\Sample_project\\branch.properties"));
	driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	driver.get(conprop.getProperty("Url"));
	driver.findElement(By.xpath(conprop.getProperty("Objuser"))).sendKeys(conprop.getProperty("EnterUser"));
	driver.findElement(By.xpath(conprop.getProperty("Objpass"))).sendKeys(conprop.getProperty("Enterpass"));
	driver.findElement(By.xpath(conprop.getProperty("ObjLogin"))).click();
}
@Test
public void startTest() throws Throwable
{
	driver.findElement(By.xpath(conprop.getProperty("ObjBranches"))).click();
	driver.findElement(By.xpath(conprop.getProperty("ObjNewBranch"))).click();
	driver.findElement(By.xpath(conprop.getProperty("ObjBname"))).sendKeys(conprop.getProperty("EnterBname"));
	driver.findElement(By.xpath(conprop.getProperty("ObjAdd1"))).sendKeys(conprop.getProperty("EnterAdd1"));
	driver.findElement(By.xpath(conprop.getProperty("ObjAdd2"))).sendKeys(conprop.getProperty("EnterAdd2"));
	driver.findElement(By.xpath(conprop.getProperty("ObjAdd3"))).sendKeys(conprop.getProperty("EnterAdd3"));
	driver.findElement(By.xpath(conprop.getProperty("ObjArea"))).sendKeys(conprop.getProperty("EnterArea"));
	driver.findElement(By.xpath(conprop.getProperty("Objzip"))).sendKeys(conprop.getProperty("Enterzip"));
	new Select(driver.findElement(By.xpath(conprop.getProperty("Objcountry")))).selectByVisibleText(conprop.getProperty("SelectCountry"));
	new Select(driver.findElement(By.xpath(conprop.getProperty("Objstate")))).selectByVisibleText(conprop.getProperty("Selectstate"));
	new Select(driver.findElement(By.xpath(conprop.getProperty("Objcity")))).selectByVisibleText(conprop.getProperty("SelectCity"));
	driver.findElement(By.xpath(conprop.getProperty("Objsubmit"))).click();
	String Expected_Alert =driver.switchTo().alert().getText();
	Thread.sleep(4000);
	driver.switchTo().alert().accept();
	Thread.sleep(4000);
	Reporter.log(Expected_Alert,true);
	
}
@AfterTest
public void tearDown()
{
	driver.quit();
}
}



