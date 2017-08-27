package utils;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;


import java.io.File;
import java.io.IOException;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;


import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;


import org.w3c.dom.Document;


public class base {

	public static WebDriver driver;
	public static ExtentReports extent;
	public static ExtentTest test;
	
	public static String getData (String nodeName) throws ParserConfigurationException, SAXException, IOException {
		File fXmlFile = new File ("C:/workspace/configs/testConfigfb.xml");
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		Document doc = dBuilder.parse(fXmlFile);
		doc.getDocumentElement().normalize();
		return doc.getElementsByTagName(nodeName).item(0).getTextContent();
		}
	
	public static void repInstance() throws ParserConfigurationException, SAXException, IOException{
		extent = new ExtentReports(getData("ReportFilePath") + getData("ReportFileName"), true);			
		}
	
	public static void initTestReport(String testName, String testDescription){
		test = extent.startTest(testName, testDescription);
		}
	
	public static void finalizeTestReport(){
		extent.endTest(test);
		}
	public static void finalizeExtentTestReport(){
		extent.flush();
		extent.close();
		}
	
	public String CaptureScreen() throws IOException, ParserConfigurationException, SAXException{
		String SSpath = getData("ScreenshotFilePath" +  "capture.png");
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrFile,  new File(SSpath));
		return SSpath;
	}
	
	/*
	public static String CaptureScreen(WebDriver driver, String ImagesPath)
	{
		TakesScreenshot oScn = (TakesScreenshot) driver;
		File oScnShot = oScn.getScreenshotAs(OutputType.FILE);
		File oDest = new File(ImagesPath+".jpg");
		try
		{
			FileUtils.copyFile(oScnShot, oDest);
		}
		catch (IOException e)
		{
			System.out.println(e.getMessage());
		}
		return ImagesPath+".jpg";
	}
	*/
}
