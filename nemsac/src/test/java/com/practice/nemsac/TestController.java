package com.practice.nemsac;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.testng.ITestNGListener;
import org.testng.TestListenerAdapter;
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
		// mySuite.setParallel(XmlSuite.ParallelMode.METHODS);

		/*
		 *Adding Listeners TestListenerAdapter tla = new TestListenerAdapter();
		 * List<Class> listenerClasses = new ArrayList<Class>();
		 * listenerClasses.add(utility.Listeners.TestListener.class); mySuite.
		 * //mySuite.addListener(tla);
		 */
		
		// *Adding Listeners
		TestListenerAdapter tla = new TestListenerAdapter();
		List<Class<? extends ITestNGListener>> listenerClasses = new ArrayList<Class<? extends ITestNGListener>>();
		listenerClasses.add(utility.Listeners.TestListener.class);
		
		myTestNG.setListenerClasses(listenerClasses);
		myTestNG.setUseDefaultListeners(true);
		myTestNG.addListener(tla);
		
		// Create an instance of XmlTest and assign a name for it.
		XmlTest myTest = new XmlTest(mySuite);
		myTest.setName("MyTest");

		// Add any parameters that you want to set to the Test.
		// myTest.setParameters(testngParams);

		// Create a list which can contain the classes that you want to run.
		List<XmlClass> myClasses = new ArrayList<XmlClass>();
		for (String className : classNamesToBeExecuted) {
			System.out.println(className);
			myClasses.add(new XmlClass("com.practice.nemsac." + className));
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
		

		// Create physical XML file based on the virtual XML content
		for (XmlSuite suite : mySuites) {
			createXmlFile(suite);
		}
		System.out.println("Filerated successfully.");
		myTestNG.run();
	}

	// This method will create an Xml file based on the XmlSuite data
	public static void createXmlFile(XmlSuite mSuite) 
    { 
       FileWriter writer; 
       try { 
            writer = new FileWriter(new File("myTemp.xml")); 
            writer.write(mSuite.toXml()); 
            writer.flush(); 
            writer.close(); 
            System.out.println(new File("myTemp.xml").getAbsolutePath());          
           } 
       catch (IOException e)
            {
              e.printStackTrace(); 
            }
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
			// ExtentHtmlReporter reporter=new
			// ExtentHtmlReporter(System.getProperty("user.home") +
			// "\\git\\NemSac\\nemsac\\TestExecutionOutputReport\\Report.html");
			generateAndExecuteTestNGXML(classNames);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
