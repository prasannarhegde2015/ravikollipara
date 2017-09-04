package com.test.firefox;

import java.io.IOException;

public class Proractor {

	public void tc2_protractor() throws IOException {

		try {
			String[] command = { "cmd.exe", "/C", "Start", "build.bat" };
			Process p = Runtime.getRuntime().exec(command);
		} catch (IOException ex) {
		}
	}

}
