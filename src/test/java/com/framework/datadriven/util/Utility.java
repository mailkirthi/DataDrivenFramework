package com.framework.datadriven.util;

import java.util.Hashtable;

public class Utility {

	//is the test suite runnable
		public static boolean isRunnable(String suiteName, Xls_Reader xls) {
		int rows = xls.getRowCount(Constants.SUITE_SHEET);//suite: name of the sheet
		//System.out.println(rows);
		for(int rNum=2;rNum<=rows;rNum++){
			String data =xls.getCellData(Constants.SUITE_SHEET,Constants.SUITENAME_COl, rNum);//sheetName, col name, row #																																																																
				if( data.equals (suiteName)){
				//System.out.println("inside");
				String runmode = xls.getCellData(Constants.SUITE_SHEET,Constants.RunMode_COL, rNum);
				//System.out.println(runmode);		
				if(runmode.equals("Y"))
					    	 return true;
					
						else return false;
			}		
		}
		return false;	
	}
	//Is the testCase runnable
	public static boolean isTestCaseRunnable(String testCase,Xls_Reader xls){
     int rows=xls.getColumnCount("TestCase");
     for(int rNum=2;rNum<=rows;rNum++){
    	 String TestCasevalue =xls.getCellData(Constants.TESTCASE_SHEET,Constants.TESTCASE_COl,rNum);
    	 if (TestCasevalue.equals(testCase)){
    		String runMode=xls.getCellData(Constants.TESTCASE_COl,Constants.RunMode_COL ,rNum);
    		if(runMode.equals("Y"))//case Sensitive
    			return true;
    		else return false;
    		
    	 }
     }
     return false;//by default
	}
	
	// will return a two dimentional data array
	public static Object[][] getData (String TestName,Xls_Reader xls){
		//String TestName= "TestCase3";
		//Xls_Reader xls= new Xls_Reader ("C:\\maven\\Data\\SuiteA.xlsx");
		int rows=xls.getRowCount(Constants.DATA_SHEET);
		System.out.println(rows);
		int TestCaseRowNum=1; //
		for(TestCaseRowNum=1;TestCaseRowNum<=rows;TestCaseRowNum++ ){
			String TestNameXls= xls.getCellData(Constants.DATA_SHEET,0, TestCaseRowNum);
				if (TestNameXls.equalsIgnoreCase(TestName))	break;
				
		}
		System.out.println("Test starts from "+TestCaseRowNum);
        
		int DataStartColNum=TestCaseRowNum +2;
		int ColStartColNum =TestCaseRowNum +1;
		
		//rows of data...data end is marked by a blank space
		//here 0 is start row , & DataStartColNum+TestRows is the end row
		int TestRows =1;
		while(!xls.getCellData(Constants.DATA_SHEET, 0, DataStartColNum+TestRows) .equals("")){
			TestRows++;
		}
		System.out.println("Test Rows " +TestRows);
	
	//total cloumns of data
		int TestCols =0;
		while(!xls.getCellData(Constants.DATA_SHEET, 0, ColStartColNum+TestCols) .equals("")){
			TestCols++;
		}
		System.out.println("Test Cols " +TestCols);
		
	
		//Object[][] data = new Object[TestRows][TestCols];
		Object[][] data = new Object[TestRows][1];//for hash table
	//retrieving the data
	int r=0;	
	for( int rNum=DataStartColNum;rNum<DataStartColNum+TestRows;rNum++){
		
		Hashtable<String,String> table = new Hashtable<String,String>();//every row will have a new hashtable
		
		for (int cNum=0;cNum<TestCols;cNum++){
			//data[r][cNum]=xls.getCellData(Constants.DATA_SHEET,cNum, rNum);
			table.put(xls.getCellData(Constants.DATA_SHEET,cNum, ColStartColNum),xls.getCellData(Constants.DATA_SHEET,cNum, rNum));//put(key,value)
		    
		}
		data[r][0]=table; //every row will have a new hash table
		r++;
	}
	return data;
	}
	
	public static void main(String []args){
		Utility u= new Utility();
		Xls_Reader xls = new Xls_Reader("C:\\maven\\Data\\Suite.xlsx");
		boolean value = u.isRunnable("SuiteC", xls);
		System.out.println(value);
	}

}
