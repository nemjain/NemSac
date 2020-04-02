package utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class TestDataFileReader {
	
	public String getValue(String property){
		
		
		String inputTestDataFile = System.getProperty("user.home") + "\\git\\NemSac\\nemsac\\resources\\TestData";
		Properties objProperties = new Properties();
		try {
			objProperties.load(new FileInputStream(inputTestDataFile));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String returnvalue = objProperties.getProperty(property, "");
		
		return returnvalue;
		
	}

}
