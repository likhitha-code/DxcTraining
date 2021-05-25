
package StepDefinition;


import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class openSteps {

	public static ExtentHtmlReporter reporter = new ExtentHtmlReporter("./ExtentReports/report1.html");
	public static ExtentReports extent = new ExtentReports();
	public static WebDriver driver; 
	public static String er,ar;
	public static String screenshot;

	@BeforeTest
	public static void OpenBrowser()
	{
		System.out.println("Open");
		extent .attachReporter(reporter);
		ExtentTest logger1 = extent.createTest("OpenBrowser");
	    logger1.log(Status.INFO,"Opening The Browser");
	    try
	    {
	    	String driverPath = System.getProperty("user.dir")+"\\Driver\\chromedriver.exe";
			System.setProperty("webdriver.chrome.driver", driverPath);
			driver=new ChromeDriver();
			logger1.log(Status.PASS,"Closing PASS");
			
	    }
	    catch(Exception e) 
	    {
	    	logger1.log(Status.FAIL,"Closing FAIL");
	    }
	    extent.flush();
	}
	
	@Test
	public static void navigation() throws Exception
	{
		System.out.println("Navigating");
		extent.attachReporter(reporter);
		ExtentTest logger2 = extent.createTest("Navigating");
		logger2.log(Status.INFO,"Navigating The Browser");
		 try
		    {
			 er="Google";
			 driver.navigate().to("https:\\google.com");
			 ar=driver.getTitle();
			 Assert.assertTrue((er.equals(ar)) ? false : true);
			 System.out.println("Title verified");
			 logger2.log(Status.PASS,"Title verified");
		    }
		    catch(AssertionError ae) 
		    {
		    	logger2.log(Status.FAIL,"Title verification FAIL");
		    	System.out.println("failed");
		    	//logger2.log(Status.FAIL,logger2.addScreenCaptureFromPath("C:\\Users\\likhitha thota\\Desktop\\flower.jfif"));
		    	//logger2.addScreenCaptureFromPath("C:\\Users\\likhitha thota\\Desktop\\flower.jfif");
		    	//screenshot = .screen();
		    	logger2.addScreenCaptureFromPath(screenshot);
		    }
		extent.flush();
	}
	
	@AfterTest
	public static void CloseBrowser()
	{
		System.out.println("Closing");
		extent.attachReporter(reporter);
		ExtentTest logger3 = extent.createTest("Closing");
		logger3.log(Status.INFO,"Closing The Browser");
		 try
		    {
		    	driver.close();
		    	logger3.log(Status.PASS,"Closing PASS");
		    	
		    }
		    catch(Exception e) 
		    {
		    	logger3.log(Status.FAIL,"Closing FAIL");
		    }
		extent.flush();
	}
}
