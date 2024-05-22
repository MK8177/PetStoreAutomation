package api.utilities;
import java.io.IOException;

import org.testng.annotations.DataProvider;

import api.utilities.*;


public class DataProviders {

	
	 @DataProvider(name="LoginData")
		public String[][]getData() throws IOException
		{
			String path= System.getProperty("user.dir")+"//testData//Book1.xlsx";
			Xls_Reader xlutil= new Xls_Reader(path);
			   int totalrows= xlutil.getRowCount("UserData");
			   int totalcols= xlutil.getCellCount("UserData", 1);
			   String loginData[][]= new String[totalrows][totalcols];
			   for(int i=1; i<=totalrows;i++)
			   {
				   for(int j=0; j<totalcols; j++)
				   {
					   loginData[i-1][j]=xlutil.getCellData("UserData", i, j);
				 }
			   }
			   return loginData;
	    }
		
	 
	 @DataProvider(name="UserNames")
		public String[] getUserNames() throws IOException
		{
			String path= System.getProperty("user.dir")+"//testData//Book1.xlsx";
			Xls_Reader xlutil= new Xls_Reader(path);
			   int totalrows= xlutil.getRowCount("UserData");
			  
			   String[] loginData= new String[totalrows];
			   for(int i=1; i<=totalrows;i++)
			   {
				   
				   
					   loginData[i-1]=xlutil.getCellData("UserData", i, 1);
				 
			   }
			   return loginData;
	    }
		
	}
	

