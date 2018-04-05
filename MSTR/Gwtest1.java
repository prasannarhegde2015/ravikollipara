package com.test.sikuli;

import java.io.IOException;
import java.util.Date;

import org.sikuli.script.FindFailed;
import org.sikuli.script.ImagePath;
import org.sikuli.script.Key;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;



public class Gwtest1 {
	
	public static String colnamearay= "TestTye;Gatwway;DataVolume;ResponseTime";
	public static Helper hlp = new Helper();
	public static Screen s = null;
	public static void main(String[] args) throws Exception
	{
		s = new Screen();
		launchTableau();
		ConnecttoMSSQL();
		//**********  Test 1 K Records *****************///
		Pattern ptn = new Pattern("imgs/imgtest.png");
		Pattern rptn = new Pattern("imgs/img1klat.png");
		recordResponseTime(ptn,rptn, "1K");
		Pattern viewptn = new Pattern("imgs/img1kView.png");
		clearview(viewptn);
		//*********** Test 2K Records ******************//
		 ptn = new Pattern("imgs/img2ktable.png");
		 rptn = new Pattern("imgs/img1klat.png");
		 recordResponseTime(ptn,rptn, "2K");
		 viewptn = new Pattern("imgs/img2kView.png");
		 clearview(viewptn);
		//*********** Test 3K Records ******************//
		 ptn = new Pattern("imgs/img3ktable.png");
		 rptn = new Pattern("imgs/img1klat.png");
		 recordResponseTime(ptn,rptn, "3K");
		 viewptn = new Pattern("imgs/img3kView.png");
		 clearview(viewptn);
		//*********** Test 4K Records ******************//
		 ptn = new Pattern("imgs/img4ktable.png");
		 //\img4kView.png
		 rptn = new Pattern("imgs/img1klat.png");
		 recordResponseTime(ptn,rptn, "4K");
		 viewptn = new Pattern("imgs/img4kView.png");
		 clearview(viewptn);
		//*********** Test 5K Records ******************//
		 ptn = new Pattern("imgs/img5ktable.png");
		 rptn = new Pattern("imgs/img1klat.png");
		 recordResponseTime(ptn,rptn, "5K");
		 viewptn = new Pattern("imgs/img5kView.png");
		 clearview(viewptn);
		 
		 
	}
	
	public static void launchTableau() throws IOException
	{
		Runtime rt =  Runtime.getRuntime();
		Process pr = rt.exec("C:\\Program Files\\Tableau\\Tableau 10.0\\bin\\tableau.exe");
	}
	
	public static void ConnecttoMSSQL() throws FindFailed, InterruptedException
	{
		s.wait("imgs/imgMSSQL.png",70);
		s.click("imgs/imgMSSQL.png",0);
		s.wait("imgs/imgSignIn.png",500);
		s.type(null,"10.103.22.119",0);
		s.type(null,Key.TAB,0);
		s.type(null,"MSTR_POC",0);
		s.type(null,Key.TAB,0);
		s.type(null,Key.TAB,0);
		s.type(null,"poctest",0);
		s.type(null,Key.TAB,0);
		s.type(null,"test@123",0);
		s.click("imgs/imgSignIn.png",0);
		Thread.sleep(1000);
	}
	
	public static void recordResponseTime(Pattern pt,Pattern resultptn,String datavolume) throws Exception
	{
		System.out.println("Image path is "+ImagePath.getBundlePath());
		//Pattern ptn = new Pattern("imgs/imgtest.png");
		Pattern ptn1 = new Pattern("imgs/imgTableDropArea.png");
		Thread.sleep(1000);
		s.wait(pt,50);
		s.dragDrop(pt, ptn1);
		System.out.println("Image path is "+ImagePath.getBundlePath());
		s.wait(new Pattern("imgs/imgExtract.png"),10);
		s.click(new Pattern("imgs/imgExtract.png"),0);
		s.click("imgs/imgUpdateNow.png",0);
		Date dtstart = new Date();
		s.wait("imgs/img1klat.png",500);
		s.wait(resultptn,500);
		Date dtend = new Date();
		long diff = dtend.getTime() - dtstart.getTime();
		System.out.println("Time diff is "+diff/1000);
		hlp.createCSVFile("d:\\poc\\result.csv", colnamearay, "GatewayTest;MSSLQ;"+datavolume+";"+String.valueOf((diff/1000)));
	}
   
	public static void clearview(Pattern pt) throws FindFailed 
	{
		s.wait(pt,10);
		s.click(pt,0);
		Pattern arrowptn = new Pattern("imgs/imgviewArrow.png");
		s.click(arrowptn,0);
		Pattern rmptn = new Pattern("imgs/imgRemove.png");
		s.click(rmptn,0);
	}
}
