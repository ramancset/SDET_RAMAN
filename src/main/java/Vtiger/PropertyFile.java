
package Vtiger;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class PropertyFile 
{
		private static PropertyFile prop;
		private  PropertyFile () 
		{

		}

		public static PropertyFile getObjectPropfile() 
		{
			return prop= new PropertyFile();
		}
		public String readDatafromPropfile(String key) throws IOException {
			FileInputStream fis = new FileInputStream("../SDET_RAM/src/test/java/text1.txt");

			Properties prop = new Properties();
			prop.load(fis);

			return	prop.getProperty(key);

		}
		public String readDatafromPropfile(String key, String path) throws IOException 
		{
			FileInputStream fis = new FileInputStream(path);

			Properties prop = new Properties();
			prop.load(fis);

			return	prop.getProperty(key);

		}
		
		public int readDatafromExcel(String path, String sheet) throws Throwable
		{
			FileInputStream fis = new FileInputStream("../SDET_RAM/sheet.xlsx");
			Workbook workbook =WorkbookFactory.create(fis);
			Sheet s = workbook.getSheet(sheet);
			return s.getLastRowNum();
		}
		
		public String readDatafromExcel(String path, String sheet,int row ,int cell) throws Throwable
		{
			FileInputStream fis = new FileInputStream("../SDET_RAM/sheet.xlsx");
			Workbook workbook =WorkbookFactory.create(fis);
			Sheet s = workbook.getSheet(sheet);
			return s.getRow(row).getCell(cell).toString();
		}

	}


