package com.eurotech.tests;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class day3 {

    AppiumDriver<MobileElement> driver;

    @Test
    public void amazon() throws InterruptedException, MalformedURLException {

        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();

        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, Platform.ANDROID);
        desiredCapabilities.setCapability(MobileCapabilityType.VERSION,"12.0");
        desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME,"Pixel_3");

        desiredCapabilities.setCapability("appPackage","com.amazon.mShop.android.shopping");

        desiredCapabilities.setCapability("appActivity","com.amazon.windowshop.home.HomeLauncherActivity");

        driver = new AppiumDriver<MobileElement>(new URL("http://localhost:4723/wd/hub"),desiredCapabilities);

        Thread.sleep(2000);

        //open amazon app
        //click skip sign in
        //search apple watch 7
        //click watch 7 in the search result

        MobileElement skipSignIn = driver.findElement(By.xpath("//*[@text='Skip sign in']"));
        //*[@text='Skip sign in']     -->Mobile Test(Appium)
        //*[text()='Skip sign in']    --> Selenium

        skipSignIn.click();
        Thread.sleep(2000);

        MobileElement searchBtn = driver.findElement(By.xpath("//*[@text='Search Amazon']"));
        searchBtn.click();

        Thread.sleep(1000);
        searchBtn.sendKeys("Apple Watch");

        Thread.sleep(2000);
        MobileElement watch7 = driver.findElement(By.xpath("//*[@text='apple watch series 7']"));
        watch7.click();

        
        Thread.sleep(3000);

        driver.closeApp();

    }
}
