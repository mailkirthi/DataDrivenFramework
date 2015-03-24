package com.framework.datadriven;

import java.io.FileInputStream;
import java.util.Properties;

import org.testng.SkipException;
import org.testng.annotations.Test;

import com.framework.datadriven.util.Constants;
import com.framework.datadriven.util.Utility;
import com.framework.datadriven.util.Xls_Reader;


public class TestBase 
{
public Properties p;

public void init(){
	if (p==null){
		String path = System.getProperty("user.dir")+"\\src\\test\\resources\\project.properties";
		Properties p = new Properties();
		try{
		FileInputStream fs= new FileInputStream(path);
		p.load(fs);
		}
		catch (Exception e){
			
		}
		
	}
}

	public void validateRunModes(String testName, String SuiteName,String dataRunMode){
		init();
		
	//suite runmode
      boolean isSuiteRunnable= Utility.isRunnable(SuiteName, new Xls_Reader(p.getProperty("xlsFileLocation"+"\\Suite.xlsx")));
	  boolean isTestCaseRunnable= Utility.isTestCaseRunnable(testName, new Xls_Reader(p.getProperty("xlsFileLocation"+SuiteName+".xlsx")));//depending of wht suite is being passed
	  boolean datasetRunMode =false;
	   if(dataRunMode.equals(Constants.RUNMODE_YES))
	   { 		   datasetRunMode = true; 	   }
	   
	   if (!isSuiteRunnable && isTestCaseRunnable && datasetRunMode)
		   throw new SkipException("Skipping ");
	}
}