package sw05;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

//console font = consolas normal 11

public class Main2  {
	public static WebDriver driver;
	public static String url = "http://emart.ssg.com/sale/main.ssg?Egnb=sale";
	public static WebElement element;
	//Properties
	public static String WEB_DRIVER_ID = "webdriver.chrome.driver";
	public static String WEB_DRIVER_PATH = "C:\\Users\\J\\chromedriver_win32\\chromedriver.exe";
	
	public static void main(String[] args) throws IOException, InterruptedException {
		Main2 test = new Main2();
		entrance();
	}
	//class
	public Main2() {
		//System Property SetUp
		System.setProperty(WEB_DRIVER_ID, WEB_DRIVER_PATH);
		//Driver SetUp
		ChromeOptions options = new ChromeOptions();
		options.setCapability("ignoreProtectedModeSettings", true);
		driver = new ChromeDriver(options);
	}
	
	public static void entrance() throws IOException, InterruptedException {
		String[] ITEM = new String [144];
		String[] PRICE = new String [144];
		driver.get(url);
		Thread.sleep(3000);
		try {
			for(int i = 45; i < 75; i++) {
			String itemURL = "/html/body/div[4]/div[4]/div[2]/div/div[8]/div[2]/div[4]/div/div[1]/ul/li[" + i + "]/div[2]/div[2]/div/a/em[1]";
			String priceURL = "/html/body/div[4]/div[4]/div[2]/div/div[8]/div[2]/div[4]/div/div[1]/ul/li[" + i + "]/div[2]/div[3]/div[1]/em";
			
			ITEM[i] = driver.findElement(By.xpath(itemURL)).getText();
			String price = driver.findElement(By.xpath(priceURL)).getText();
			price = price.replace(",", "");
			PRICE[i] = price;
			
			
			Thread.sleep(2);
			//System.out.print("\"" + ITEM[i] + "\", ");
			
			System.out.print(PRICE[i] + ", ");
			}
		}catch(NoSuchElementException e) {
		}
	}
}
	

	


