import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class ScroollingDemo {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		//https://rahulshettyacademy.com/AutomationPractice/
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\Drivers\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.manage().window().maximize();
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,500)");
		Thread.sleep(3000);
		js.executeScript("document.querySelector('.tableFixHead').scrollTop=5000");
		List<WebElement>values=driver.findElements(By.cssSelector(".tableFixHead td:nth-child(4)"));
		int sum=0;
		for(int i=0;i<values.size();i++) {
		
		sum=sum+Integer.parseInt(values.get(i).getText());
			
		}
		System.out.println("sum of all number is "+sum);
		
		int total=Integer.parseInt(driver.findElement(By.cssSelector(".totalAmount")).getText().split(":")[1].trim());
		Assert.assertEquals(sum, total);
		//System.out.println(text);
		
		List<WebElement> value=driver.findElements(By.cssSelector(".table-display tr td:nth-child(3)"));
		int sum2=0;
		for(int j=0;j<value.size();j++) {
			sum2=sum2+Integer.parseInt(value.get(j).getText());
		}
		System.out.println("Total producy sum is "+sum2);
		

	}

}
