package jan29;

import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Rowcount {

	public static void main(String[] args)throws Throwable {
		FileInputStream fi = new FileInputStream("D:/Sample.xlsx");
		XSSFWorkbook wb = new XSSFWorkbook(fi);
		XSSFSheet ws = wb.getSheet("Emp");
		XSSFRow row = ws.getRow(0);
		int rc = ws.getLastRowNum();
		int cc = row.getLastCellNum();
		System.out.println("no of rows::"+rc+"   "+"no of cells in firstrow"+"  "+cc);
		fi.close();
		wb.close();
		
		

	}

}
