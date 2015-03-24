package rough;

import java.io.FileInputStream;
import java.util.Properties;

public class reading_properties {

	public static void main(String[]args){
		//String path = "C:\\maven\\DataDrivenFramework\\src\\test\\resources\\";
		String path = System.getProperty("user.dir")+"\\src\\test\\resources\\project.properties";
		Properties p= new Properties();
		try {
		FileInputStream fs = new FileInputStream(path); // has to be enclosed in a try catch block
		p.load(fs);
		}
		catch ( Exception e){
			
		}
		System.out.println(p.getProperty("fileLocation"));
		
	}
}
