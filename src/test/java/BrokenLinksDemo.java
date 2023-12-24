import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class BrokenLinksDemo {

	public static void main(String[] args) throws MalformedURLException, IOException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\Drivers\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.manage().window().maximize();
		
		
		SoftAssert soft=new SoftAssert();
		
		List<WebElement> links=driver.findElements(By.cssSelector("li[class='gf-li'] a"));
		for(WebElement link: links) {
			String url=link.getAttribute("href");
			
			//java method will call Urls and gets the status code
			HttpURLConnection conn=(HttpURLConnection)new URL(url).openConnection();
			conn.setRequestMethod("HEAD");
			conn.connect();
			int responsecode=conn.getResponseCode();
			System.out.println(responsecode);
			soft.assertTrue(responsecode<400, "The link with text "+link.getText()+" is broken with code "+responsecode);
			
		}
		soft.assertAll();
		
		//broken URL
		//step 1 get all url tied up using selenium
		//a[href*='soapui']

		
		

	}

}
