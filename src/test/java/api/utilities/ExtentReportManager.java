package api.utilities;
import java.sql.Date;
import java.text.SimpleDateFormat;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.internal.TestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;


public class ExtentReportManager implements ITestListener{
	
	public ExtentSparkReporter sparkReporter;
	 public ExtentReports extent;
	 public ExtentTest test;
	 String repName;
	 
	 
	  
	 public void onStart(ITestContext testContext)
	 {
	 String timeStamp= new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date(0, 0, 0));
	  repName="Test_Report"+timeStamp+".html";
	  sparkReporter=new ExtentSparkReporter(".\\reports\\"+repName);//specify location of the report
	  sparkReporter.config().setReportName("Pet Store users API");// name of report
	  sparkReporter.config().setTheme(Theme.DARK);
	  
	  extent=new ExtentReports();
	  
	  extent.attachReporter(sparkReporter);
	  extent.setSystemInfo("Application","Pet Store users API");
	  extent.setSystemInfo("Oprating System",System.getProperty("os.name"));
	  extent.setSystemInfo("User Name",System.getProperty("user.name"));
	  extent.setSystemInfo("Environemnt","QA");
	  extent.setSystemInfo("user","Murli");
	 }
	 
	 public void onTestSuccess(ITestResult tr)
	 {
        test=extent.createTest(tr.getName());
        test.log(Status.PASS,MarkupHelper.createLabel("Name of passed test case is:"+tr.getName(), ExtentColor.GREEN));

	 }
	 
	 public void onTestFailure(ITestResult tr)
	 {
	  test=extent.createTest(tr.getName()); // create new entry in th report
	  test.log(Status.FAIL,MarkupHelper.createLabel(tr.getName(),ExtentColor.RED)); // send the passed information to the report with GREEN color highlighted
	  
	  String screenshotPath=System.getProperty("user.dir")+"\\Screenshots\\"+tr.getName()+".png";
	  test.fail("Screenshot is below:" + test.addScreenCaptureFromPath(screenshotPath)); 
	 }
	 
	 public void onTestSkipped(ITestResult tr)
	 {
	  test=extent.createTest(tr.getName()); // create new entry in th report
	  test.log(Status.SKIP,MarkupHelper.createLabel(tr.getName(),ExtentColor.ORANGE));
	 }
	 
	 public void onFinish(ITestContext testContext)
	 {
	  extent.flush();
	 }

}
