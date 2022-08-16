package com.eurotech.tests;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class day2 {


    AppiumDriver<MobileElement> driver;

    @Test
    public void test1() throws MalformedURLException, InterruptedException {


        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();

        //1. yol
    //    desiredCapabilities.setCapability("platformName","Android");

        //2.yol
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, Platform.ANDROID);
        desiredCapabilities.setCapability(MobileCapabilityType.VERSION,"12.0");
        desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME,"Pixel_2");

        //Set your Application's package name
        desiredCapabilities.setCapability("appPackage","com.google.android.calculator");


        //Set your Application's MainActivity name (Launcher activity name)
        desiredCapabilities.setCapability("appActivity","com.android.calculator2.Calculator");

        driver = new AppiumDriver<MobileElement>(new URL("http://localhost:4723/wd/hub"),desiredCapabilities);

        //Test Case 2+3 = 5

        MobileElement digit2 = driver.findElement(By.id("com.google.android.calculator:id/digit_2"));
        MobileElement digit3 = driver.findElement(By.id("com.google.android.calculator:id/digit_3"));

        MobileElement plus = driver.findElementByAccessibilityId("plus");
        MobileElement equals = driver.findElementByAccessibilityId("equals");

        digit2.click();
        plus.click();
        digit3.click();
        equals.click();

       MobileElement result= driver.findElement(By.id("com.google.android.calculator:id/result_final"));
       String resultText= result.getText();
       Assert.assertEquals("5",resultText);


        //Test Case Verify  that 5 * 8 = 40

        MobileElement digit5= driver.findElement(By.id("com.google.android.calculator:id/digit_5"));
        MobileElement digit8= driver.findElement(By.id("com.google.android.calculator:id/digit_8"));

        MobileElement multiply = driver.findElementByAccessibilityId("multiply");

        digit5.click();
        multiply.click();
        digit8.click();
        equals.click();

        resultText=result.getText();
        Assert.assertEquals("40",resultText);



        Thread.sleep(3000);
        driver.closeApp();




/*
        echo "# EurotechAppiumProject" >> README.md
        git init
        git add README.md
        git commit -m "first commit"
        git branch -M main
        git remote add origin https://github.com/EuroTech-SDET3/EurotechAppiumProject.git
        git push -u origin main

*/


    }

}
