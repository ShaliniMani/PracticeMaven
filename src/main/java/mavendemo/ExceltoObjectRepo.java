package mavendemo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
public class ExceltoObjectRepo {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Workbook work=null;
		String filename="E:\\eclipse\\samplefiles\\Read.xlsx";
     File file=new File("E:\\eclipse\\samplefiles\\Read.xlsx");
     FileInputStream fio=new FileInputStream(file);
     String fileext=filename.substring(filename.indexOf("."));
     System.out.println(fileext);
     if(fileext.equals(".xlsx"))
     {
    	 work=new XSSFWorkbook(fio);
     }
     else
     {
    	 work=new HSSFWorkbook(fio);
     }
     Sheet sheet=work.getSheetAt(0);
     int rowcount=sheet.getLastRowNum()-sheet.getFirstRowNum();
     int colusheet=sheet.getPhysicalNumberOfRows();
      Object[][] repoobject=null;
      repoobject=new Object[rowcount][colusheet];
      for(int i=0;i<rowcount;i++)
      {
    	  Row row=sheet.getRow(i);
    	  for(int j=0;j<row.getLastCellNum();j++)
    	  {
    		  repoobject[i][j]=row.getCell(j).toString();
    		  System.out.println(repoobject[i][j].toString());
    	  }
      }
     
	}
	

}
