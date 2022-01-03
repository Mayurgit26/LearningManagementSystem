package utilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {
	private static XSSFWorkbook ExcelWBook;
	private static XSSFSheet ExcelWSheet;
	private static XSSFCell cell;
	private static XSSFRow row;
	public static void setExcelFile(String path,String SheetName)throws Exception
	{
	try
	{
	FileInputStream Excelfile = new FileInputStream(path);
	ExcelWBook = new XSSFWorkbook(Excelfile);
	ExcelWSheet = ExcelWBook.getSheet(SheetName);

	}
	catch(Exception e)
	{
	throw(e);
	}
	}
	public static String getCellData(int rownum,int colnum)
	{
	try
	{
	cell=ExcelWSheet.getRow(rownum).getCell(colnum);
	String celldata = cell.getStringCellValue();
	return celldata;
	}
	catch(Exception e)
	{
	return "";
	}
	}

	public static void setCellData(String result,int rownum,int colnum) throws Exception
	{
	try
	{
	row=ExcelWSheet.getRow(rownum);
	cell=row.getCell(colnum);
	if(cell == null)
	{
	cell = row.createCell(colnum);
	cell.setCellValue(result);
	}
	else
	{
	cell.setCellValue(result);
	}
	FileOutputStream fout = new FileOutputStream(Constant.filename);
	ExcelWBook.write(fout);
	fout.flush();
	fout.close();

	}
	catch(Exception e)
	{
	throw (e);
	}
	}
	public static int getRowCount()
	{
	int rCount=ExcelWSheet.getLastRowNum()+1;
	return rCount;
	}
	}