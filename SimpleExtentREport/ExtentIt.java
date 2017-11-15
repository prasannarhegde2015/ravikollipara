package com.test.extent;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
public class ExtentIt {
	
	
	public void creatextentReport(WebDriver drv,String reportfilepath, ExtentTest logger , String colnamesarr , String colvals, String screenshot_path) throws IOException
	{
		
		String[] arrcolvalues = colvals.split(";");
		String  tcdesc = arrcolvalues[0].trim();
		String  strfld = arrcolvalues[1].trim();
		String  strexp = arrcolvalues[2].trim();
		String  stract = arrcolvalues[3].trim();
		String  status = arrcolvalues[4].trim();

		if (status.equalsIgnoreCase("pass"))
		{
			String imgpath = System.getProperty("user.dir") + "\\Report\\"+screenshot_path;
			this.CaptureScreesnhot(drv, imgpath);
			String image= logger.addScreenCapture(imgpath);
			logger.log(LogStatus.PASS, tcdesc+ ": Field Name- "+strfld+" Expected Result- "+strexp+" : Actual Result-"+stract, image);
		}
		else if (status.equalsIgnoreCase("fail"))
		{
			String imgpath = System.getProperty("user.dir") + "\\Report\\"+screenshot_path;
			this.CaptureScreesnhot(drv, imgpath);
			String image= logger.addScreenCapture(imgpath);
			logger.log(LogStatus.FAIL, tcdesc+ ": Field Name- "+strfld+" Expected Result- "+strexp+" : Actual Result-"+stract, image);
		}
		else if (status.equalsIgnoreCase("info"))
		{
			String imgpath = System.getProperty("user.dir") + "\\Report\\"+screenshot_path;
			this.CaptureScreesnhot(drv, imgpath);
			String image= logger.addScreenCapture(imgpath);
			logger.log(LogStatus.INFO, tcdesc+ ": Field Name- "+strfld+" Expected Result- "+strexp+" : Actual Result-"+stract, image);
		}
		else if (status.equalsIgnoreCase("warn"))
		{
			String imgpath = System.getProperty("user.dir") + "\\Report\\"+screenshot_path;
			this.CaptureScreesnhot(drv, imgpath);
			String image= logger.addScreenCapture(imgpath);
			logger.log(LogStatus.WARNING, tcdesc);
		}

	}
  
	public void CaptureScreesnhot(WebDriver drv , String filename) throws IOException
	{
		 File src  =   ((TakesScreenshot)drv).getScreenshotAs(OutputType.FILE);
		 FileUtils.copyFile(src, new File(filename));
	}
	
	public String  getscreenshotfilename()
	{
		String timestamp = new SimpleDateFormat("dd-MM-yyyy_hh_mm_ss").format(new Date());
		String shtname = "Image_"+timestamp+".jpg";
		return shtname;
	}
}
