package BayBoonDailyReport;

import org.testng.annotations.Test;
import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class EmailReport {
	@Test
	public void test1() throws EmailException{
		//Open chrome browser
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver");
		WebDriver driver = new ChromeDriver();
	
	/*	//Open Firefox browser
	  	System.setProperty("webdriver.gecko.driver","./drivers/geckodriver");
		WebDriver driver = new FirefoxDriver();
		
	*/	
		driver.manage().window().maximize();
		
	    driver.get("https://www.bayboon.com/");
	    driver.manage().window().setSize(new Dimension(1382, 744));
	    
		try{
	    	driver.findElement(By.linkText("No Thanks")).click();
		    driver.findElement(By.cssSelector(".fa-search")).click();
	    }
	    catch (Exception e) {
			// TODO: handle exception
	    	System.out.println("Exception");
	    	driver.close();
			System.out.println("Browser closed");
			test3();
			
		}
		driver.close();
		System.out.println("Opened Search page & Browser closed");
	}
	@Test
	public void test2() throws EmailException{
		Email email = new SimpleEmail();
		email.setHostName("smtp.gmail.com");
		email.setSmtpPort(465);
		email.setAuthenticator(new DefaultAuthenticator("rk@bayboon.com", "Bhavi-rk24"));
		email.setSSLOnConnect(true);
		email.setFrom("rk@bayboon.com");
		email.setSubject("Success - BayBoon Daily Report!!");
		email.setMsg("Your application is up and running !");
		email.addTo("ramakrishna0008@gmail.com");
		email.addTo("ramakrishnak0008@gmail.com");
		email.send();
		System.out.println("Your application is up and running !");
		System.out.println("Email sent to ramakrishnak0008@gmail.com, ramakrishna0008@gmail.com");
	}
	
	public void test3() throws EmailException{
		Email email = new SimpleEmail();
		email.setHostName("smtp.gmail.com");
		email.setSmtpPort(465);
		email.setAuthenticator(new DefaultAuthenticator("rk@bayboon.com", "Bhavi-rk24"));
		email.setSSLOnConnect(true);
		email.setFrom("rk@bayboon.com");
		email.setSubject("Failure - BayBoon Daily Report!!");
		email.setMsg("Your application is down! or some technical issue!");
		email.addTo("ramakrishna0008@gmail.com");
		email.addTo("ramakrishnak0008@gmail.com");
		email.send();
		System.out.println("Your application is down! or some technical issue!");
		System.out.println("Email sent to ramakrishnak0008@gmail.com, ramakrishna0008@gmail.com");
	}
	
}