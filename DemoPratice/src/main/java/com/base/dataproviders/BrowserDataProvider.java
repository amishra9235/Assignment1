package com.base.dataproviders;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.testng.annotations.DataProvider;


/**
 *  Define dataproviders needed for test execution
 * @author anand.mishra
 *
 */
public class BrowserDataProvider {
	File file = null;
	FileInputStream is = null;
	Object data[][] = null;

	/**
	 * This dataprovider read the Browser file and run test cases on readed browsersS
	 * @return Browsers
	 */
	@DataProvider(name = "Browser")
	public Object[][] browserProvider() {
		file = new File(System.getProperty("user.dir") + "\\Browser");
		List<String> browsers = new ArrayList<String>();
		try {
			is = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		Scanner sc = new Scanner(is);
		while (sc.hasNextLine()) {
			browsers.add(sc.nextLine());
		}
		data = new Object[browsers.size()][1];
		for (int i = 0; i < browsers.size(); i++) {
			data[i][0] = browsers.get(i);
		}
		return data;
	}

}
