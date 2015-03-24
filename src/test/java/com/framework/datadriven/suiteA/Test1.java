package com.framework.datadriven.suiteA;

import java.util.Hashtable;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.framework.datadriven.TestBase;
import com.framework.datadriven.util.Constants;
import com.framework.datadriven.util.Utility;
import com.framework.datadriven.util.Xls_Reader;

public class Test1 extends TestBase  {

	@Test(dataProvider="getData")
	public void test1(Hashtable<String, String> table){
		/*
		Xls_Reader xls = new Xls_Reader("C:\\maven\\Data\\Suite.xlsx");
	    System.out.println(Utility.isRunnable("SuiteA", xls));
	    System.out.println(Utility.isRunnable("SuiteB", xls));
	    System.out.println(Utility.isRunnable("SuiteC", xls));
	    Xls_Reader xls1 = new Xls_Reader("C:\\maven\\Data\\SuiteA.xlsx");
	    System.out.println(Utility.isTestCaseRunnable("TestCase1", xls1));
	    	    table.get("RunMode");*/
		validateRunModes("Test1",Constants.FIRST_SUITE, table.get(Constants.RunMode_COL));
	
	}
	
   @DataProvider
   public Object[][] getData(){
	   Xls_Reader xls1 = new Xls_Reader("C:\\maven\\Data\\SuiteA.xlsx");
	   
	   return Utility.getData("TestCase1", xls1);
   }
}
