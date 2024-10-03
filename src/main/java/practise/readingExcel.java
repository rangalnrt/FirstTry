package practise;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class readingExcel {

	public static Object[][]getexceldata(String excelpath, String sheetname){
		Object[][] testdata = null;
		try {
			FileInputStream inpustream = new FileInputStream(new String(excelpath));
			
			Workbook workbook = WorkbookFactory.create(inpustream);
			Sheet sheet = workbook.getSheet(sheetname);
			
			int rowcnt = sheet.getLastRowNum()-sheet.getFirstRowNum();
			List<Object[]> data = new ArrayList<>();
			
			for(int i=1;i<=rowcnt ; i++) {
				Row row = sheet.getRow(i);
				
			}
			
		}catch(IOException e) 
		{
			e.printStackTrace();
		}
		return null;
		
	}
}
