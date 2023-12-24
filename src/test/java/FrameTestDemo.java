import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class FrameTestDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\Drivers\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://jqueryui.com/droppable/");
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.manage().window().maximize();
		WebElement frame=driver.findElement(By.className("demo-frame"));
		//driver.findElement(By.cssSelector("iframe.demo-frame"));
		driver.switchTo().frame(frame);
		WebElement src=driver.findElement(By.id("draggable"));
		WebElement dest=driver.findElement(By.id("droppable"));
		Actions action=new Actions(driver);
		action.dragAndDrop(src,dest).build().perform();
		//System.out.println(driver.findElements(By.tagName("iframe")).size());
		driver.switchTo().defaultContent();
		

	}

}
