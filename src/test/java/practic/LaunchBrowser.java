package practic;

import java.io.FileInputStream;

import java.time.Duration;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LaunchBrowser {

	public static void main(String[] args) throws Exception  
	{
		// TODO Auto-generated method stub
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		String filepath = "../SDET_RAM/sheet.xlsx";
		FileInputStream excelfile = new FileInputStream(filepath);
		Workbook book = WorkbookFactory.create(excelfile);
		Sheet s = book.getSheet("Sheet1");
		int rowcount = s.getLastRowNum();
		
		Cell sal;
		for(int i=1;i<=rowcount;i++)
		{
            sal = s.getRow(i).getCell(2);
            int salary= (int) sal.getNumericCellValue();
			if(salary>=17000)
			{
				Cell name= s.getRow(i).getCell(1);
				System.out.println("name : "+name);
			}
			
		}

	}

}










