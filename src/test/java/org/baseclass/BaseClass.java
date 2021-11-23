package org.baseclass;
	
	import java.awt.AWTException;
	import java.awt.Robot;
	import java.io.File;
	import java.io.FileInputStream;
	import java.io.FileOutputStream;
	import java.io.IOException;
	import java.text.SimpleDateFormat;
	import java.util.Date;

	import org.apache.poi.ss.usermodel.Cell;
	import org.apache.poi.ss.usermodel.DateUtil;
	import org.apache.poi.ss.usermodel.Row;
	import org.apache.poi.ss.usermodel.Sheet;
	import org.apache.poi.ss.usermodel.Workbook;
	import org.apache.poi.xssf.usermodel.XSSFWorkbook;
	import org.openqa.selenium.By;
	import org.openqa.selenium.JavascriptExecutor;
	import org.openqa.selenium.Keys;
	import org.openqa.selenium.TakesScreenshot;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.interactions.Actions;
	import org.openqa.selenium.support.ui.Select;
	import io.github.bonigarcia.wdm.WebDriverManager;

	public class BaseClass 
	{
		WebDriver driver;
		Select s;
		Actions a;
		Robot r;
		 
		public void browserLaunch(String url) 
		{
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.get(url);
		}
	//LOCATORS
		public WebElement locators(String locatorType, String value) 
		{
			if(locatorType.equals("tagName"))
			{
				WebElement tagName=driver.findElement(By.tagName(value));
				return tagName;
			}
			else if(locatorType.equals("xpath"))
			{
				WebElement xpath = driver.findElement(By.xpath(value));
				return xpath;
			}	
			else if(locatorType.equals("id"))
			{
				WebElement id = driver.findElement(By.id(value));
				return id;
			}
			else if(locatorType.equals("name"))
			{
				WebElement name = driver.findElement(By.name(value));
				return name;
			}
			else
			{
				WebElement className = driver.findElement(By.className(value));
				return className;
			}
		}
	//WEDRIVER
		public String gettingTitle() 
		{
			String title = driver.getTitle();
			return title;
		}
		public String gettingCurrentUrl() 
		{
			String currentUrl = driver.getCurrentUrl();
			return currentUrl;
		}
//		public String  WindowHandle(WebElement element) 
//		{
//			String windowHandle = driver.getWindowHandle();
//			return windowHandle;
//		}
//		public Set<String> WindowHandles(WebElement element) 
//		{
//			Set<String> windowHandles = driver.getWindowHandles();
//			return windowHandles;
//		}
		public void close() 
		{
		    driver.close();
		}
		public void quit() 
		{
			driver.quit();
		}
		public void maximize() 
		{
			driver.manage().window().maximize();
		}
	//WEBELEMENT
		public void entertext(WebElement element,String text) 
		{
			element.sendKeys(text);
		}
		public void buttonClick(WebElement element) 
		{
			element.click();
		}
		public void clear(WebElement element) {
			element.clear();
		}
		public String gettingText(WebElement element) 
		{
			String text = element.getText();
			return text;
		}
		public String getAttribute(WebElement element, String attributename) 
		{
			String attribute = element.getAttribute(attributename);
			return attribute;
		}
	//ACTIONS
		public void toMove(WebElement element) 
		{
			a=new Actions(driver);
			a.moveToElement(element).perform();
		}
		public void toRightClick(WebElement element) 
		{
			a=new Actions(driver);
			a.contextClick(element).perform();
		}
		public void toDragAndDrop(WebElement source, WebElement destination) 
		{
			a=new Actions(driver);
			a.dragAndDrop(source, destination);
		}
		public void keyUp(WebElement element,String name) 
		{
			a=new Actions(driver);
			a.keyUp(element, Keys.SHIFT);
		}
		public void keyDown(WebElement element,String name) 
		{
			a=new Actions(driver);
			a.keyDown(element, Keys.SHIFT);
		}
		public void toDoubleClick(WebElement element) 
		{
			a=new Actions(driver);
			a.doubleClick(element).perform();
		}
	//ROBOT
		public void keyPress(int pkey) throws AWTException 
		{
			r=new Robot();
			r.keyPress(pkey);
		}
		public void keyRelease(int rkey) throws AWTException 
		{
			r=new Robot();
			r.keyRelease(rkey);
		}
	//SELECT
		public void selectionByIndex(WebElement element,int Index) 
		{
			s = new Select(element);
			s.selectByIndex(Index);
		}
		public void selectionByValue(WebElement element,String value) 
		{
			s = new Select(element);
			s.selectByValue(value);
		}
		public void selectByvisibetext(WebElement element,String value)
		{
			s = new Select(element);
			s.selectByVisibleText(value);
		}
		public void deselectByvalue(WebElement element,String value) 
		{
			s = new Select(element);
			s.deselectByValue(value);
		}
		public void deselectByIndex(WebElement element,int index) 
		{
			s = new Select(element);
			s.deselectByIndex(index);;
		}
		public void deselectByvisibleText(WebElement element,String value) 
		{
			s = new Select(element);
			s.deselectByVisibleText(value);
		}
		public void deselectall(WebElement element) 
		{
			s = new Select(element);
			s.deselectAll();
		}
		public void getAllSelectedOptions(WebElement element) 
		{
			s = new Select(element);
			s.getAllSelectedOptions();
		}
		public void getFirstSelectedOptions(WebElement element) 
		{
			s = new Select(element);
			s.getFirstSelectedOption();
		}
		public void getOPtions(WebElement element) 
		{
			s = new Select(element);
			s.getOptions();
		}
		public void isMultiple(WebElement element) 
		{
			s = new Select(element);
			s.isMultiple();
		}
//		public void Manage(WebElement element) 
//		{
//			 Options manage = driver.manage();
//		}
	//NAVIGATE
		public void forward() 
		{
			driver.navigate().forward();
		}
		public void to(String url) 
		{
			driver.navigate().to(url);
		}
		public void back() 
		{
			driver.navigate().back();
		}
		public void refresh() 
		{
			driver.navigate().refresh();
		}
	//SWITCH_TO
//		public void switchTowindow(WebElement element) 
//		{
//			TargetLocator switchTo = driver.switchTo();
//		}
		public void switchToFrame(int index) 
		{
			driver.switchTo().frame(index);
		}
		public void switchToFrame(String data) 
		{
			driver.switchTo().frame(data);
		}
		public void switchToFrame(WebElement element) 
		{
			driver.switchTo().frame(element);
		}
		public void returnToWindow() 
		{
			driver.switchTo().defaultContent();
		}
//		public void toPrint(String name) 
//		{
//			System.out.println(name);
//		}
	//ALERT
		public void alert() 
		{
			driver.switchTo().alert();
		}
		public void simpleAlert() 
		{
			driver.switchTo().alert().accept();
		}
		public void confirmAlert() 
		{
			driver.switchTo().alert().dismiss();
		}
		public void promptAlert(String data) 
		{
			driver.switchTo().alert().sendKeys(data);
			driver.switchTo().alert().accept();
		}
//		public void submit(WebElement element) 
//		{
//			element.submit();
//		}
	//JAVA SCRIPT EXECUTOR
		public void toJavaScript(WebElement element,String data) 
		{
			JavascriptExecutor executor = (JavascriptExecutor)driver;
			executor.executeScript("arguments[0].setattribute('value'," + data + ")", element);
		}
	//TAKES SCREENSHOT
		public void takeScreenshot() 
		{
			TakesScreenshot ts=(TakesScreenshot) driver;
			ts.getScreenshotAs(null);
		}
	//EXCEL READ
		public String excelRead(String path, String sheetName, int rowIndex, int cellIndex) throws IOException 
		{
			File f=new File(path);
			FileInputStream stream=new FileInputStream(f);
			Workbook w=new XSSFWorkbook(stream);
			Sheet sheet = w.getSheet(sheetName);
			Row row = sheet.getRow(rowIndex);
			Cell cell = row.getCell(cellIndex);
			int cellType = cell.getCellType();
			if(cellType==1)
			{
				String stringCellValue = cell.getStringCellValue();
				return stringCellValue;
			}
			else if(DateUtil.isCellDateFormatted(cell))
			{
				Date dateCellValue = cell.getDateCellValue();
				SimpleDateFormat s=new SimpleDateFormat("dd/MM/yyyy");
				String format = s.format(dateCellValue);
				return format;
			}
			else
			{
				double numericCellValue = cell.getNumericCellValue();
				long l=(long)numericCellValue;
				String valueOf = String.valueOf(l);
				return valueOf;
			}
		}
	//EXCEL WRITE
		public void excelWrite(String path, String sheetName, int rowIndex, int cellIndex, String value) throws IOException 
		{
			File f=new File(path);
			FileOutputStream stream=new FileOutputStream(f);
			Workbook w=new XSSFWorkbook();
			Sheet createSheet = w.createSheet(sheetName);
			Row createRow = createSheet.createRow(rowIndex);
			Cell createCell = createRow.createCell(cellIndex);
			createCell.setCellValue(value);
			w.write(stream);
		}
	}
	
	
	


