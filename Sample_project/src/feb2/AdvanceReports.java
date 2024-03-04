package feb2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class AdvanceReports {
	WebDriver driver;
	ExtentReports report;
	ExtentTest logger;
	@BeforeTest
	public void generatereports()
	{
		report = new ExtentReports("./ExtentReports/Demo.html");
	}
	@BeforeMethod
	public void setup()
	{
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("http://google.com");
	}
	@Test
	public void TestPass()
	{
		logger = report.startTest("Test Pass");
		logger.assignAuthor("prashanth");
		logger.assignCategory("Functional Testing");
		String Expected = "Google";
		String Actual = driver.getTitle();
		if (Actual.equalsIgnoreCase(Expected))
		{
			logger.log(LogStatus.PASS,"Title is Matching"+"  "+Expected+"  "+Actual);	
		}
		else
		{
			logger.log(LogStatus.FAIL,"Title is  not Matching"+"    "+Expected+"      "+Actual);
		}
	}
	@Test
	public void TestFail()
	{
		logger = report.startTest("Test Fail");
		logger.assignAuthor("prashanth");
		logger.assignCategory("Functional Testing");
		String Expected = "Gmail";
		String Actual = driver.getTitle();
		if (Actual.equalsIgnoreCase(Expected))
		{
			logger.log(LogStatus.PASS,"Title is Matching"+"  "+Expected+"  "+Actual);	
		}
		else
		{
			logger.log(LogStatus.FAIL,"Title is  not Matching"+"    "+Expected+"      "+Actual);
		}

	}
	@AfterMethod
	public void teardown()
	{
		report.endTest(logger);
		report.flush();
		driver.quit();
	}
}
































