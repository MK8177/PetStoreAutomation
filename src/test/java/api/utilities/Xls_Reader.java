package api.utilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Xls_Reader {

	//public static String filename = System.getProperty("user.dir")+"\\src\\com\\qtpselenium\\xlsx\\Suite.xlsx";
		public  String path;
		public  FileInputStream fi= null;
		public  FileOutputStream fo =null;
		private XSSFWorkbook workbook = null;
		private XSSFSheet sheet = null;
		private XSSFRow row   =null;
		private XSSFCell cell = null;
		public CellStyle style;
		
		public Xls_Reader(String path)
		{
			this.path=path;
		}
		
		public int getRowCount(String sheetName) throws IOException
		{
			fi= new FileInputStream(path);
			workbook= new XSSFWorkbook(fi);
			sheet= workbook.getSheet(sheetName);
			int rowcount=sheet.getLastRowNum();
			workbook.close();
			fi.close();
			return rowcount;
		}
		public int getCellCount(String sheetName, int rownum) throws IOException
			{
				fi= new FileInputStream(path);
				workbook= new XSSFWorkbook(fi);
				sheet= workbook.getSheet(sheetName);
				row=sheet.getRow(rownum);
				int cellcount= row.getLastCellNum();
				workbook.close();
				fi.close();
				return cellcount;
			
		}
		public String getCellData(String sheetName, int rownum, int colnum) throws IOException
		{
			fi = new  FileInputStream(path);
			workbook= new XSSFWorkbook(fi);
			sheet= workbook.getSheet(sheetName);
			row= sheet.getRow(rownum);
			cell= row.getCell(colnum); 
			DataFormatter formatter= new DataFormatter(); // data type methods
			String data;
			try {
				data= formatter.formatCellValue(cell); // return the formatted value of a cell as a string regardless of cell type 
			}
			catch(Exception e)
			{
				data="";
			}
			workbook.close();
			fi.close();
			return data;
		}
		public void setCellData(String sheetName, int rownum, int colnum, String data)throws IOException
		{
			fi = new  FileInputStream(path);
			workbook= new XSSFWorkbook(fi);
			sheet= workbook.getSheet(sheetName);
			row= sheet.getRow(rownum);
			cell= row.getCell(colnum); 
			cell.setCellValue(data);
			fo= new FileOutputStream(path);
			workbook.write(fo);
			workbook.close();
			fi.close();
			fo.close();
		}
		public void fillGreenColor(String sheetName, int rownum, int colnum)throws IOException
		{
		
			fi = new  FileInputStream(path);
			workbook= new XSSFWorkbook(fi);
			sheet= workbook.getSheet(sheetName);
			row= sheet.getRow(rownum);
			cell= row.getCell(colnum); 
			style= workbook.createCellStyle();
			style.setFillForegroundColor(IndexedColors.GREEN.getIndex());
			style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
			
			cell.setCellStyle(style);
			workbook.write(fo);
			workbook.close();
			fi.close();
			fo.close();
		}
		
		public void fillRedColor(String sheetName, int rownum, int colnum)throws IOException
		{
		
			fi = new  FileInputStream(path);
			workbook= new XSSFWorkbook(fi);
			sheet= workbook.getSheet(sheetName);
			row= sheet.getRow(rownum);
			cell= row.getCell(colnum); 
			style= workbook.createCellStyle();
			style.setFillForegroundColor(IndexedColors.RED.getIndex());
			style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
			
			cell.setCellStyle(style);
			workbook.write(fo);
			workbook.close();
			fi.close();
			fo.close();
		}
        public static void main(String arg[]) throws IOException{
			
			//System.out.println(filename);
			Xls_Reader datatable = null;
         }

		


		
	
}


