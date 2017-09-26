package CevaUtilTest;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.winium.DesktopOptions;
import org.openqa.selenium.winium.WiniumDriver;


public class Cevatest {
	public static  WiniumDriver globalWinDriver = null;
	public static String winapp ="E:\\Prasanna\\CEVA\\eAdapterSDK_2013_10\\eAdapterSDK\\eAdapterInboundWebClient\\bin\\Debug\\CargoWise.eAdapterInboundWebClient.exe";
	public static String winiunDriverexe = "E:\\Prasanna\\Winium\\Winium.Desktop.Driver\\Winium.Desktop.Driver.exe";
	
	public static void main(String[] args) throws InterruptedException
	{
		setWindriver();
		getWindowsmehtods();
	}
	
	public static WiniumDriver setWindriver() throws InterruptedException
	{
		
		try {
			String[] command = { "cmd.exe", "/C", "Start", "run.bat" };
			Process p = Runtime.getRuntime().exec(command);
		} catch (IOException ex) {
		}
		Thread.sleep(5000);
		DesktopOptions options = new DesktopOptions();
		options.setApplicationPath(winapp);
		try {
			globalWinDriver = new WiniumDriver(new URL("http://localhost:9999"), options);
			if (globalWinDriver == null)

			{
				System.out.println("global Driver was not created...");
			}
			
		} catch (MalformedURLException ex) {
			ex.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		switchtowindow(globalWinDriver, "eAdapter Sample Client");
		return globalWinDriver;
		
	}
	
	public static void getWindowsmehtods()
	{
		try
		{
			
			globalWinDriver.findElement(By.name("Service Address")).click();
			globalWinDriver.findElement(By.id("ServiceAddress")).click();
		    globalWinDriver.findElement(By.id("ServiceAddress")).sendKeys("https://cevts2services.wisegrid.net/eAdapterStreamedService.svc");
			globalWinDriver.findElement(By.name("Browse")).click();
			switchtowindow(globalWinDriver, "Open");
			globalWinDriver.findElement(By.name("File name:")).click();
			// We can parametesize this sstep to send sequence of Xml files to Utilty
			String filenametoSend = "E:\\Prasanna\\CEVA\\Sample Shipment XML to CWO.XML" ;
			globalWinDriver.findElement(By.name("File name:")).sendKeys(filenametoSend);
			sendkeysEnter();
	     //   List<WebElement> allitems = globalWinDriver.findElements(By.className("Button"));
	     //   System.out.println( "Lenth of buttons count"+allitems.size());
		/*	int i = 0;
	        for(WebElement ielen: allitems )
			{
				System.out.println("Element"+i);
				System.out.println( ielen.getTagName());
				i++;
			}*/
	       // globalWinDriver.findElement(By.id("1")).click();
			switchtowindow(globalWinDriver, "eAdapter Sample Client");
			globalWinDriver.findElement(By.id("RecipientId")).sendKeys("CEVHOUTS2");
			globalWinDriver.findElement(By.id("SenderId")).sendKeys("cevtst2");
			globalWinDriver.findElement(By.id("Password")).sendKeys("123456");
			globalWinDriver.findElement(By.id("SendMessage")).click();
			
			}
		catch(Exception e)
		{
		}
		
		
		
	}
    public static void switchtowindow(WiniumDriver wdrv, String title)
    {
    	try
		{
    		 //"eAdapter Sample Client"
    		wdrv.switchTo().window(title);
		}
		catch(Exception e)
		{
			
		}
    }
    public static void  sendkeysEnter() throws AWTException
	{
		Robot rb = new Robot();
		rb.keyPress(KeyEvent.VK_ENTER);
		
		
	}
}
