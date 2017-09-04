package com.test.firefox;

import java.io.IOException;

public class TestFF {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws IOException {
		Proractor pt = new Proractor();
		selerun sel = new selerun();
		unixexecutor unx = new unixexecutor();
		pt.tc2_protractor();
		sel.tc1_selenium();

	}

}
