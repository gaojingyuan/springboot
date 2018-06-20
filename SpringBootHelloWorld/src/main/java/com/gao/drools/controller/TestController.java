package com.gao.drools.controller;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gao.drools.model.fact.Address;
import com.gao.drools.model.res.AddressCheckResult;
import com.gao.drools.model.res.TestCheckResult;

/**
 * 你的支持是我努力的最大动力！社区的建立离不开你的支持。
 * 此系列课程正在持续更新中，相关讨论QQ（593177274）已经建立，欢迎大家加入讨论。
 * 如有疑问可以留言也可以发送本人邮箱secbro2@gmail.com。
 */
@RequestMapping("/drools")
@Controller
public class TestController {

    private final static Logger logger = LoggerFactory.getLogger(TestController.class);

//    @Resource
//    private KieSession kieSession;

    @ResponseBody
    @RequestMapping("/address")
    public void test(){
        testRule();
    }

    private void testRule() {
        KieServices ks = KieServices.Factory.get();

        KieContainer kc = ks.getKieClasspathContainer();
        KieSession kieSession = kc.newKieSession("ksession-rules");

        Address address = new Address();
        address.setPostcode("99425");

        AddressCheckResult addressResult = new AddressCheckResult();
        TestCheckResult testResult = new TestCheckResult();
        kieSession.insert(address);
        kieSession.insert(addressResult);
        kieSession.insert(testResult);
        int ruleFiredCount = kieSession.fireAllRules();
        logger.info("触发了" + ruleFiredCount + "条规则");

        if(addressResult.isPostCodeResult()){
            logger.info("address规则校验通过");
        }
        if(testResult.isPostCodeResult()){
            logger.info("test规则校验通过");
        }
        if(!testResult.isPostCodeResult()){
            logger.info("test规则校验不通过");
        }
    }
}
