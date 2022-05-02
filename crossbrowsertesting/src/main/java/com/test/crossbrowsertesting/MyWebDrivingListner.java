package com.test.crossbrowsertesting;



import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver.Navigation;
import org.openqa.selenium.support.events.WebDriverListener;

public class MyWebDrivingListner implements WebDriverListener {

	public MyWebDrivingListner() {
		// TODO Auto-generated constructor stub
	}
 
  @Override
public void afterAnyNavigationCall(Navigation navigation, Method method, Object[] args, Object result) {
	// TODO Auto-generated method stub
	  System.out.println("Ole ole ole ");
}

}
