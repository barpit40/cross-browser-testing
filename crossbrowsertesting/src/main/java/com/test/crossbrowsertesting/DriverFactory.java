package com.test.crossbrowsertesting;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringDecorator;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {
	
	  ThreadLocal<WebDriver> driver =  new ThreadLocal<>();
	
	private static DriverFactory instatnce= new DriverFactory();

	private DriverFactory() {
		// TODO Auto-generated constructor stub
	}
	
	public static DriverFactory getInstatnce() {
		return instatnce;
	}

	public void setDriver(WebDriver driverParam) {
		driver.set(driverParam);
	}
	
	public WebDriver getDriver() {
		return driver.get();
	}
	
	public void removeDriver() {
		//driver.get().quit();
		driver.remove();
	}
}
