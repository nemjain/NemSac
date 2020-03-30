package com.practice.nemsac;

import java.util.ArrayList;
import java.util.List;

import org.testng.TestNG;

public class TestController {
	
	public static void main(String[] args) {
		
		// Create object of TestNG Class
		TestNG runner=new TestNG();
		 
		// Create a list of String 
		List<String> suitefiles=new ArrayList<String>();
		 
		// Add xml file which you have to execute
		suitefiles.add("C:\\Users\\jindals\\git\\NemSac\\nemsac\\testng.xml");
		 
		// now set xml file for execution
		runner.setTestSuites(suitefiles);
		 
		// finally execute the runner using run method
		runner.run();
		
		/*ReadExcel objReadExcel;
		String filePath = System.getProperty("user.home") + "\\git\\NemSac\\nemsac\\resources";
		String fileName = "TestExecutionManagement.xlsx";
		String sheetName = "Test Suite";
		ArrayList<String> arrayList = new ArrayList<String>();
		objReadExcel = new ReadExcel();
		arrayList = objReadExcel.readExcel(filePath, fileName, sheetName);
		
		import java.util.ArrayList;
		import java.util.List;

		import org.testng.TestNG;

		public class RunTestNG {

		public static void main(String[] args) {

		// Create object of TestNG Class
		TestNG runner=new TestNG();

		// Create a list of String 
		List<String> suitefiles=new ArrayList<String>();

		// Add xml file which you have to execute
		suitefiles.add("C:\\Users\\Documents\\Blog6March\\dummy16june\\testng.xml");

		// now set xml file for execution
		runner.setTestSuites(suitefiles);

		// finally execute the runner using run method
		runner.run();
		}

		}

		
	}*/
	
}
}

