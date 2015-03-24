package com.framework.datadriven.util;

public class rough {

	public static void main(String[]args){
		String TestName= "TestCase3";
		Xls_Reader xls= new Xls_Reader ("C:\\maven\\Data\\SuiteA.xlsx");
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
		
	
	//retrieving the data
	for( int rNum=DataStartColNum;rNum<DataStartColNum+TestRows;rNum++){
		for (int cNum=0;cNum<TestCols;cNum++){
			System.out.println(xls.getCellData(Constants.DATA_SHEET,cNum, rNum));
		}
	}
	}
}
