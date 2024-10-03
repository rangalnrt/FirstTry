package practise;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadingExcelforwebtest {
	public static Object[][]getexceldata(String excelpath, String sheetname){
		Object[][] testdata = null;
		try {
			FileInputStream inpustream = new FileInputStream(new String(excelpath));
			
			Workbook workbook = WorkbookFactory.create(inpustream);
			Sheet sheet = workbook.getSheet(sheetname);
			
			int rowcnt = sheet.getPhysicalNumberOfRows();
			int cols = sheet.getRow(0).getPhysicalNumberOfCells();
			
			testdata = new Object[rowcnt-1][cols];
			//System.out.println(rowcnt);
			//System.out.println(cols);
			for(int i=1;i<rowcnt ; i++) {
				Row row = sheet.getRow(i);
				for(int j=0;j<cols;j++) {
					Cell cell = row.getCell(j);
					//System.out.println(cel);
					if (cell != null) {
                        switch (cell.getCellType()) {
                            case STRING:
                            	testdata[i - 1][j] = cell.getStringCellValue();
                                break;
                            case NUMERIC:
                            	testdata[i - 1][j] = cell.getNumericCellValue();
                                break;
                            case BOOLEAN:
                            	testdata[i - 1][j] = cell.getBooleanCellValue();
                                break;
                            default:
                            	testdata[i - 1][j] = null;
                        }
                    } else {
                    	testdata[i - 1][j] = null;
                    }
					//System.out.println(testdata[i-1][j]);
				}
			}
			//System.out.println(data[i][j];)
		}catch(IOException e) 
		{
			e.printStackTrace();
		}
		return testdata;
		
	}

}
