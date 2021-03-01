package mavendemo;


import java.io.File;  
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;  
import org.apache.poi.ss.usermodel.Cell;  
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;  
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DataFromExcel {
	

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		XSSFRow row = null;
	    XSSFCell cell = null;
		FileInputStream file=new FileInputStream(new File("E:\\eclipse\\samplefiles\\Read.xlsx"));
		XSSFWorkbook wb=new XSSFWorkbook(file);
		XSSFSheet sheet=wb.getSheetAt(0);
		
		for(Row row1:sheet)
		{
			
			for(Cell cell1:row1)
			{
				
				switch(cell1.getCellType())
				{
				case NUMERIC:    //field that represents number cell type  
				System.out.print(cell1.getNumericCellValue()+ "\t\t");
				break;	
				case STRING:
				System.out.print(cell1.getStringCellValue()+ "\t\t");
				break;
				default:
					break;
				}
			}
			System.out.println();
		}
	 
		row=sheet.getRow(0);
		System.out.println("the name are");
		int colNum=0;
		int rowNum=sheet.getPhysicalNumberOfRows();
		for(int i=0;i<row.getLastCellNum();i++)
		{
			if(row.getCell(i).getStringCellValue().trim().contains("Name"))
			{
				colNum=i;
				
			}
		}
		for(int i=0;i<rowNum-1;i++)
		{
			row=sheet.getRow(i+1);
			System.out.println(row.getCell(colNum).getStringCellValue());
		}
		wb.close();
		
	}

}
