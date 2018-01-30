package com.gao.selenium;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Set;

public class WalletTest {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "/Users/jionglu/Downloads/chromedriver");
        ChromeDriver driver = new ChromeDriver();
        try {
            // 网址 网址
            // driver.get("https://www.huodaipay.com/");
            driver.get("http://182.92.84.166:8080/");
            http: // 182.92.84.166:8080/
            // driver.get("http://localhost:8080//");

            // 登录 需要8秒内手动验证极验验证码
            driver.findElement(By.xpath("//a[contains(text(), '登录')]")).click();
            switchToWindow(driver, "登录");
            Thread.sleep(200L);
            driver.findElement(By.className("userName")).sendKeys("13121381612");
            Thread.sleep(200L);
            driver.findElement(By.id("userPass")).sendKeys("1234qwer");
            Thread.sleep(200L);
            driver.findElement(By.id("btn-login")).click();
            Thread.sleep(8000L);

            // 发起运单支付 上传单证需要8秒内完成 手机验证码16秒内完成
            driver.findElement(By.id("toAddOrder")).click();
            Thread.sleep(200L);
            driver.findElement(By.id("toUserId")).sendKeys("囧");
            Thread.sleep(1000L);
            driver.findElement(By.xpath("//strong[contains(text(), '囧')]")).click();
            driver.findElement(By.xpath("//input[@name='blNo']")).sendKeys("AN0001");
            driver.findElement(By.xpath("//textarea[@name='shipper']")).sendKeys("fff");
            driver.findElement(By.xpath("//textarea[@name='consignee']")).sendKeys("sss");
            driver.findElement(By.xpath("//textarea[@name='noticeParties']")).sendKeys("ttt");
            // 日期控件直接插入值
            driver.findElement(By.xpath("//input[@name='etd']")).sendKeys("2017-11-12");
            // 点日期控件选择某一天
            // driver.findElement(By.xpath("//input[@name='etd']")).click();
            // Thread.sleep(500L);
            // driver.findElement(By.xpath("//td[contains(text(), '12')]")).click();
            driver.findElement(By.id("shipCompanyCode")).sendKeys("MSK");
            Thread.sleep(1000L);
            driver.findElement(By.xpath("//strong[contains(text(), 'MSK')]")).click();
            driver.findElement(By.xpath("//input[@name='vessel']")).sendKeys("顺风号");
            driver.findElement(By.xpath("//input[@name='voyage']")).sendKeys("25");
            driver.findElement(By.id("loadingPortCode")).sendKeys("SHANGHAI");
            Thread.sleep(1000L);
            driver.findElement(By.xpath("//strong[contains(text(), 'SHANGHAI')]")).click();
            driver.findElement(By.id("dischargePortCode")).sendKeys("LOSANGELES");
            Thread.sleep(1000L);
            driver.findElement(By.xpath("//strong[contains(text(), 'LOSANGELES')]")).click();
            driver.findElement(By.xpath("//input[@name='receiptPlace']")).sendKeys("纽约");
            driver.findElement(By.xpath("//input[@name='deliveryPlace']")).sendKeys("洛杉矶");
            driver.findElement(By.xpath("//input[@name='issuePlace']")).sendKeys("上海");
            driver.findElement(By.xpath("//input[@name='issueDate']")).sendKeys("2017-11-20");
            driver.findElement(By.xpath("//input[@name='boxList[][containerNo]']")).sendKeys("NO0001");
            driver.findElement(By.id("freightCny")).sendKeys("6666");
            driver.findElement(By.id("surchargeCny")).sendKeys("2222");
            driver.findElement(By.id("note")).sendKeys("能装多少装多少");
            driver.findElement(By.id("btn-order")).click();
            Thread.sleep(200L);
            driver.findElement(By.id("documents-fileupload")).click();
            Thread.sleep(8000L);
            driver.findElement(By.id("btn-done")).click();
            Thread.sleep(200L);
            driver.findElement(By.id("payPwd")).sendKeys("1234qwer");
            driver.findElement(By.id("sendCode")).click();
            Thread.sleep(2000L);
            driver.findElement(By.xpath("//button[contains(text(), '确定')]")).click();
            Thread.sleep(20000L);
            driver.findElement(By.id("btn-pay")).click();

            // 充值
            // driver.findElement(By.id("toRecharge")).click();
            // Thread.sleep(100L);
            // switchToWindow(driver, "充值");
            // Thread.sleep(100L);
            // driver.findElement(By.id("moneyNum")).sendKeys("10000");
            // Thread.sleep(100L);
            // driver.findElement(By.id("bankNum")).sendKeys("5555666677778888");
            // Thread.sleep(100L);
            // driver.findElement(By.id("btnSubmit")).click();
            // Thread.sleep(100L);

            // 我的消息
            // driver.findElement(By.id("myNews")).click();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static boolean switchToWindow(WebDriver driver, String windowTitle) {
        boolean flag = false;
        try {
            String currentHandle = driver.getWindowHandle();
            Set<String> handles = driver.getWindowHandles();
            for (String s : handles) {
                if (s.equals(currentHandle)) {
                    continue;
                } else {
                    driver.switchTo().window(s);
                    if (driver.getTitle().contains(windowTitle)) {
                        flag = true;
                        break;
                    } else {
                        continue;
                    }
                }
            }
        } catch (Exception e) {
            flag = false;
        }
        return flag;
    }

}
