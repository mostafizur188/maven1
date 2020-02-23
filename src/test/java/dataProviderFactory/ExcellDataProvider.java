package dataProviderFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcellDataProvider {

	XSSFWorkbook wb;
	public ExcellDataProvider() {
		
		try{
			wb= new XSSFWorkbook(new FileInputStream(new File(System.getProperty("user.dir")+"/Testdata/login.xlsx")));
		}
		catch(IOException e){
			System.out.println("unable to read excel:"+e.getMessage());
	
		}}
	
	public String getCellData(String sheetName,int row,int col)
	{
		XSSFCell  cell = wb.getSheet(sheetName).getRow(row).getCell(col);
		String data = null;
		
		if(cell.getCellTypeEnum()==CellType.STRING)
		{
			data=cell.getStringCellValue();
		}
		else if (cell.getCellTypeEnum()==CellType.NUMERIC)
		{
			data=String.valueOf((int)cell.getNumericCellValue());
		}
		else if (cell.getCellTypeEnum()==CellType.BLANK)
		{
			data="";
		}
		return data;
	}
	public int getRows(String sheetName)
	{
		return wb.getSheet(sheetName).getPhysicalNumberOfRows();
	}
	public int getColumns(String sheetName)
	{
		return wb.getSheet(sheetName).getRow(0).getPhysicalNumberOfCells();
		}
}