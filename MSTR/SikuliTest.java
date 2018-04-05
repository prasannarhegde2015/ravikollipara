package com.test.sikuliload;

import java.util.Date;

import org.sikuli.script.Key;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

public class Sikulitest {
	public static String colnamearay = "TestTye;Gatwway;DataVolume;ResponseTime";
	public static Screen s = null;

	public static void main(String[] args) throws Exception {
		s = new Screen();
		Pattern viewptn = new Pattern("img/1515604434321.png");
		s.click(viewptn, 10);
		Pattern viewptnc = new Pattern("img/dots.png");
		s.click(viewptnc, 15);
		Thread.sleep(1000);
		for (int i = 0; i < 3; i++) {
			s.type(null, Key.DOWN, 0);
		}
		s.type(null, Key.ENTER, 0);
		// Pattern viewptnss = new Pattern("img/sss.png");
		// s.click(viewptnss, 10);
		// Match txtrr = s.findText("New incognito window", 30);
		// s.click(txtrr);
		// // Pattern viewptn2 = new Pattern("img/browerser1.PNG");
		// s.click(viewptn2, 10);
		Thread.sleep(1000);
		s.type(null, "http://dev46183.service-now.com", 0);
		s.type(null, Key.ENTER, 0);
		Date dt1 = new Date();
		Pattern viewptn3 = new Pattern("img/lginbtn.PNG");
		s.wait(viewptn3, 50);
		Date dt2 = new Date();
		System.out.println("Load time is " + (dt2.getTime() - dt1.getTime()));

	}
}
