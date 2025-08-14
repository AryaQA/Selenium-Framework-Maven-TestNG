package ChomaProjects.MavenDemoAugust07;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.io.*;
public class WebFromDemo {

	WebDriver driver;

	 @BeforeTest
	void setUp() {

		// browser session
		driver = new ChromeDriver();

		// open the browser on tab
		driver.get("https://www.selenium.dev/selenium/web/web-form.html");

	}

	@Test
	void fillFrom() {

		WebElement username = driver.findElement(By.id("my-text-id"));
		WebElement password = driver.findElement(By.name("my-password"));
		WebElement textarea = driver.findElement(By.name("my-textarea"));
		WebElement dropdown = driver.findElement(By.name("my-select"));
		WebElement datalist = driver.findElement(By.name("my-datalist"));
		WebElement file = driver.findElement(By.name("my-file"));
		WebElement checkbox_2 = driver.findElement(By.id("my-check-2"));
		WebElement radiobox_2 = driver.findElement(By.id("my-radio-2"));
		WebElement colors = driver.findElement(By.name("my-colors"));
		WebElement date = driver.findElement(By.name("my-date"));
		WebElement range = driver.findElement(By.name("my-range"));
		WebElement sumit = driver.findElement(By.xpath(" //button[@type='submit']"));

		username.sendKeys("Abhishek");
		password.sendKeys("123456");
		textarea.sendKeys("this is text area");

		Select select = new Select(dropdown);
		File classDetails = new File("Class_details.txt");
		file.sendKeys(classDetails.getAbsolutePath());

		file.sendKeys("Class_details.txt");

		select.selectByValue("3");

		datalist.sendKeys("Seattle");

		checkbox_2.click();
		radiobox_2.click();

		colors.sendKeys("#ffa500");

		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("arguments[0].value= arguments[1]", range, "2");

		js.executeScript("arguments[0].dispatchEvent(new Event('change'))", range);

		/// range.sendKeys("2");

		date.sendKeys("07/08/2025");

		sumit.click();

	}

	@AfterTest
	void closing() {
		
		System.out.println("Hello , to check commit");

		driver.quit();

	}

}
