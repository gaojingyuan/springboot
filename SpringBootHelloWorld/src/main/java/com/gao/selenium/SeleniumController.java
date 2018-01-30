/* Copyright 2012-2016 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License. */

package com.gao.selenium;

import org.apache.commons.lang.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Rob Winch
 * @author Doo-Hwan Kwak
 */
@Controller
@RequestMapping("/selenium")
public class SeleniumController {

    public static ArrayBlockingQueue<String> blockingQueue;

    @GetMapping(value = "run")
    @ResponseBody
    public String run() {
        try {
            System.setProperty("webdriver.chrome.driver", "/Users/jionglu/Downloads/chromedriver");
            ChromeDriver driver = new ChromeDriver();
            driver.get("http://www.bjguahao.gov.cn/index.htm");
            blockingQueue = new ArrayBlockingQueue(1);
            driver.findElement(By.className("db_denglu")).click();
            driver.findElement(By.id("mobileQuickLogin")).sendKeys("13121381612");
            driver.findElement(By.id("pwQuickLogin")).sendKeys("gj820421");
            driver.findElement(By.id("quick_login")).click();
            driver.findElement(By.className("ac_input")).sendKeys("北京大学第一医院");
            driver.findElement(By.xpath("//div[@class='sbtn']/input")).click();
            driver.findElement(By.className("yiyuan_co_xzyy")).click();
            driver.findElement(By.xpath("//a[contains(text(), '泌尿外科')]")).click();
            Thread.sleep(100L);
            driver.findElement(By.xpath("//input[@value='2_1_2017-01-19']/parent::*")).click();
            Thread.sleep(100L);
            driver.findElement(By.xpath("//h4[contains(text(), '膀胱灌注')]/../../../p[2]/a")).click();
            Thread.sleep(100L);
            driver.findElement(By.id("btnSendCodeOrder")).click();
//            driver.findElement(By.id("Rese_db_dl_idselect"))
            String code = blockingQueue.take();
            driver.findElement(By.id("Rese_db_dl_dxyzid")).sendKeys(code);
            // driver.findElement(By.id("Rese_db_qryy_btn")).click();
        } catch (InterruptedException e) {
            return "error";
        }
        return "running";
    }

    @PostMapping(value = "setSmsMsg")
    @ResponseBody
    public String setSmsMsg(@RequestBody MsgDTO msgDTO) {
        String msg = msgDTO.getMsg();
        if (StringUtils.isNotEmpty(msg)) {
            Pattern p = Pattern.compile("\\d{6}");
            // 【北京市预约挂号统一平台】您的短信验证码为【052938】
            Matcher m = p.matcher(msg);
            if (m.find()) {
				blockingQueue.add(m.group());
				return "0";
            }
        }
        return "1";
    }

    public static void main(String[] args) {
        Pattern p = Pattern.compile("\\d{6}");
        Matcher m = p.matcher("【北京市预约挂号统一平台】您的短信验证码为【052938】");
        if (m.find()) {
            System.out.println(m.group());
        }
    }
}
