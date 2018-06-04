package com.gao.drools.controller;

import com.gao.drools.entity.Address;
import com.gao.drools.ruleresult.AddressCheckResult;
import org.kie.api.runtime.KieSession;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/test")
public class DroolsTestController {

    @Resource
    private KieSession kieSession;

    @RequestMapping("/index")
    public String hello(){
        return "Hello word";
    }
    @ResponseBody
    @RequestMapping("/address")
    public String test(){
        Address address = new Address();
        address.setPostcode("99425");

        AddressCheckResult result = new AddressCheckResult();
        kieSession.insert(address);
        kieSession.insert(result);
        int ruleFiredCount = kieSession.fireAllRules();
        System.out.println("触发了" + ruleFiredCount + "条规则");

        if(result.isPostCodeResult()){
            System.out.println("规则校验通过");
        }
        return "成功啦！";
    }

}