import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GreenKartSearch {
	//public WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\Drivers\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		String[] items = {"Brocolli","Cucumber","Beetroot","Carrot"};
		
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		driver.manage().window().maximize();
		//driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		addItem(driver,items);
		driver.findElement(By.cssSelector("img[alt='Cart']")).click();
		driver.findElement(By.xpath("//button[contains(text(),'PROCEED TO CHECKOUT')]")).click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input.promoCode")));
		
		driver.findElement(By.cssSelector("input.promoCode")).sendKeys("rahulshettyacademy");
		driver.findElement(By.cssSelector("button.promoBtn")).click();
		
		//Explicit Wait
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span.promoInfo")));
		
		System.out.println(driver.findElement(By.cssSelector("span.promoInfo")).getText());
		
		
		
		
		//Thread.sleep(4000);
		//closeWindow(driver);

	}
	
	


	
	public static void addItem(WebDriver driver,String[] items) {
		int j=0;
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
	
	public static void closeWindow(WebDriver driver) {
		driver.quit();
	}
}

