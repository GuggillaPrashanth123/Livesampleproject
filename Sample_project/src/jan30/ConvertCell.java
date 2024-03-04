package jan30;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ConvertCell {

	public static void main(String[] args)throws Throwable {
		FileInputStream fi = new FileInputStream("D:/Sample.xlsx");
		XSSFWorkbook wb = new XSSFWorkbook(fi);
		XSSFSheet ws = wb.getSheet("Emp");
		int rc = ws.getLastRowNum();
		System.out.println(rc);
		for (int i = 1; i <=rc ; i++) {
	if(wb.getSheet("emp").getRow(i).getCell(3).getCellType()==CellType.NUMERIC)
			{
	int celldata =(int) wb.getSheet("Emp").getRow(i).getCell(3).getNumericCellValue();
	String eid = String.valueOf(celldata);
	System.out.println(eid);
			}
		}
	}

}
