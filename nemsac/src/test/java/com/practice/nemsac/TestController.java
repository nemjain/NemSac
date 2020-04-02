package com.practice.nemsac;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.core.tools.Generate;
import org.testng.TestNG;
import org.testng.xml.XmlClass;
import org.testng.xml.XmlSuite;
import org.testng.xml.XmlTest;

import utility.ReadExcel;

public class TestController {

	public static void generateAndExecuteTestNGXML(ArrayList<String> classNamesToBeExecuted) {

		// Create an instance on TestNG
		TestNG myTestNG = new TestNG();

		// Create an instance of XML Suite and assign a name for it.
		XmlSuite mySuite = new XmlSuite();
		mySuite.setName("MySuite");
		mySuite.setParallel(XmlSuite.ParallelMode.METHODS);

		// Create an instance of XmlTest and assign a name for it.
		XmlTest myTest = new XmlTest(mySuite);
		myTest.setName("MyTest");

		// Add any parameters that you want to set to the Test.
		// myTest.setParameters(testngParams);

		// Create a list which can contain the classes that you want to run.
		List<XmlClass> myClasses = new ArrayList<XmlClass>();
		for (String className : classNamesToBeExecuted) {
			System.out.println(className);
			myClasses.add(new XmlClass("com.practice.nemsac."+className));
		}
		// Assign that to the XmlTest Object created earlier.
		myTest.setXmlClasses(myClasses);

		// Create a list of XmlTests and add the Xmltest you created earlier to it.
		List<XmlTest> myTests = new ArrayList<XmlTest>();
		myTests.add(myTest);

		// add the list of tests to your Suite.
		mySuite.setTests(myTests);

		// Add the suite to the list of suites.
		List<XmlSuite> mySuites = new ArrayList<XmlSuite>();
		mySuites.add(mySuite);

		// Set the list of Suites to the testNG object you created earlier.
		myTestNG.setXmlSuites(mySuites);
		mySuite.setFileName("myTemp.xml");
		mySuite.setThreadCount(3);
		myTestNG.run();
	}

	public static void main(String[] args) {

		// Step 1 . Read List of Test Suites to be executed
		ReadExcel readExcel = new ReadExcel();

		String filePath = System.getProperty("user.home") + "\\git\\NemSac\\nemsac\\resources";
		String fileName = "TestExecutionManagement.xls";
		String sheetName = "Test Suite";
		try {
			ArrayList<String> classNames = readExcel.readExcel(filePath, fileName, sheetName);
			System.out.println(classNames);
			generateAndExecuteTestNGXML(classNames);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		/*
		 * // Create object of TestNG Class TestNG runner = new TestNG();
		 * 
		 * // Create a list of String List<String> suitefiles = new ArrayList<String>();
		 * 
		 * // Add xml file which you have to execute
		 * suitefiles.add("C:\\Users\\jindals\\git\\NemSac\\nemsac\\testng.xml");
		 * 
		 * // now set xml file for execution runner.setTestSuites(suitefiles);
		 * 
		 * // finally execute the runner using run method runner.run();
		 */
		/*
		 * ReadExcel objReadExcel; String filePath = System.getProperty("user.home") +
		 * "\\git\\NemSac\\nemsac\\resources"; String fileName =
		 * "TestExecutionManagement.xlsx"; String sheetName = "Test Suite";
		 * ArrayList<String> arrayList = new ArrayList<String>(); objReadExcel = new
		 * ReadExcel(); arrayList = objReadExcel.readExcel(filePath, fileName,
		 * sheetName);
		 * 
		 * import java.util.ArrayList; import java.util.List;
		 * 
		 * import org.testng.TestNG;
		 * 
		 * public class RunTestNG {
		 * 
		 * public static void main(String[] args) {
		 * 
		 * // Create object of TestNG Class TestNG runner=new TestNG();
		 * 
		 * // Create a list of String List<String> suitefiles=new ArrayList<String>();
		 * 
		 * // Add xml file which you have to execute
		 * suitefiles.add("C:\\Users\\Documents\\Blog6March\\dummy16june\\testng.xml");
		 * 
		 * // now set xml file for execution runner.setTestSuites(suitefiles);
		 * 
		 * // finally execute the runner using run method runner.run(); }
		 * 
		 * }
		 * 
		 * 
		 * }
		 */

	}
}
