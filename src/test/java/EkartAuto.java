import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class EkartAuto {
	public WebDriver driver;
	//@Test
	public void Search() throws InterruptedException, IOException {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\Drivers\\chromedriver.exe");
		driver=new ChromeDriver();
		
		String[] items = {"Brocolli","Cucumber","Beetroot","Carrot"};
		int j=0;
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(40,TimeUnit.SECONDS);
		
		List<WebElement> products=driver.findElements(By.cssSelector("h4.product-name"));
		for(int i=0;i<products.size();i++) 
		{
			String[] name=products.get(i).getText().split("-");
			String formatedname=name[0].trim();
			
			
			
			//convert into array list form
            List itemsNeeded=Arrays.asList(items);
           
			if(itemsNeeded.contains(formatedname)) 
			{
				j++;
				//click on add to cart
				driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
				//Thread.sleep(2000);
				
				if(j==items.length) {
					break;
				}
				
			}
			
		}
	}

}
