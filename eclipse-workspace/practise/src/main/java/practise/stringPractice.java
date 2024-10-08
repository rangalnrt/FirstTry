package practise;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class stringPractice {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		//System.out.println(readexcel("C:\\Users\\ranga\\OneDrive\\Desktop\\name.xlsx", "Sheet1"));
		sum();
	}
	
public static Object[][] readexcel(String filename, String sheetname) throws IOException {
		
		FileInputStream f= new FileInputStream(filename);
		Workbook wb = new XSSFWorkbook(f);
		Sheet sg= wb.getSheet(sheetname);
		
		int rows = sg.getPhysicalNumberOfRows();
		int cols = sg.getRow(0).getPhysicalNumberOfCells();
		
		System.out.println(rows);
		System.out.println(cols);
		Object[][] data = new Object[rows-1][cols];
		for(int i=0;i<rows;i++) {
			Row row = sg.getRow(i);
			
			for(int j=0;j<cols;j++) {
				Cell ce=row.getCell(j);
				data[i-1][j] = ce;
				if(ce!=null) {
					switch(ce.getCellType()) {
					
					case STRING:
						data[i-1][j] = ce.getStringCellValue();
						break;
					case NUMERIC :
						data[i-1][j] = ce.getNumericCellValue();
						break;
					case BOOLEAN :
						data[i-1][j] = ce.getBooleanCellValue();
						break;
					default:
						break;
						
					}
					
				}
			}
		}
		
		
		wb.close();
		f.close();
		System.out.println(data);
		return data;
		
		
	}

public static void evenodd() {
	
	ArrayList<Integer> even = new ArrayList<>();
	ArrayList<Integer> odd = new ArrayList<>();
	
	int[] evenodd = {1,2,4,3,6,5,7,8,9,10};
	
	for(int a:evenodd) {
		
		if(a%2==0) {
			even.add(a);
		}else {odd.add(a);}
	}
	System.out.println(even);
	System.out.println(odd);
	
}
public static void reverse() {
	String name = "ACKNOWLDGE";
	String reve="";
	for(int i=0;i<name.length();i++) {
		reve=name.charAt(i)+reve;
	}
	System.out.println(reve);
}

public static void removedups() {
	
	HashMap<Integer,Boolean> map = new HashMap<>();
	ArrayList<Integer> list = new ArrayList<>();
	ArrayList<Integer> result = new ArrayList<>();
	for(int i=0;i<10;i++) {
	list.add(i);
	}
	for(int j=0;j<10;j++) {
		list.add(j);
	}
	for(int a:list) {
	if(!map.containsKey(list)) {
		map.put(a, true);
		result.add(a);
	}
}
	System.out.println(map);
}

public static void merger() {
	
	HashMap<String,Integer> list = new HashMap<>();
	list.put("a", 1);
	list.put("b", 2);
	
	HashMap<String,Integer> list1 = new HashMap<>();
	list1.put("a", 1);
	list1.put("b", 2);
	list1.put("c", 3);
	
	for(String key:list1.keySet()) {
		list.merge(key, list1.get(key), Integer::sum);
	}
	System.out.println(list);
}
public static void vowels() {
	int vowels=0;
	int cons=0;
	String str= "newmeric";
	str=str.toLowerCase();
	for(char ch:str.toCharArray()) {
		if("aeiou".indexOf(ch)!=-1) {
			vowels++;
		}else {cons++;}
		
	}
	System.out.println(vowels);
	System.out.println(cons);
}



    public static void countOccurrences() {
    	int[] nums = {1, 2, 2, 3, 3, 3};
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        
    }
    
        public static void main1() {
            String workingDirectory = System.getProperty("user.dir");
            System.out.println("Working Directory: " + workingDirectory);
        }
    // Given int sum = 10; and an array {1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, find the pairs that add up to 10 (e.g., {1, 9}, {2, 8}, etc.).
    public static void sum() {
    	int[] a= {1,2,3,4,5,6,7,8,9,10};
    	
    	
    	
    	for(int i=0;i<a.length;i++) {
    		for(int j=0;j<a.length;j++) {
    			int sum =a[i]+a[j];
        		if(sum==10) {
        			System.out.println("Pair of values is "+a[i]+" second value "+a[j]);
    		}
    		
    		}
    	}
    }

  
}




