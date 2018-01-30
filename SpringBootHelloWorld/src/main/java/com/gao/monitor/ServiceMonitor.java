/* Copyright 2012-2013 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License. */

package com.gao.monitor;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ServiceMonitor {

    private static final Logger logger = LoggerFactory.getLogger(ServiceMonitor.class);

    @Pointcut("execution(* com.gao.*Controller.*(..))")
    public void init() {

    }

    // 正常这样配置 @Before("execution(* com.gao.*Controller.*(..))")如果多个切点的execution相同 如下配置
    @Before(value = "init()")
    public void before() {
        logger.info("before.....");
    }

    @AfterReturning(value = "init()")
    public void afterReturning() {
        logger.info("afterReturning.....");
    }

    @AfterThrowing(value = "init()")
    public void throwss() {
        logger.info("throwss.....");
    }

    @After(value = "init()")
    public void after() {
        logger.info("after.....");
    }

    @Around(value = "init()")
    public Object around(ProceedingJoinPoint pjp) {
        logger.info("around start.....");
        Object o = null;
        try {
            o = pjp.proceed();
        } catch (Throwable e) {
            e.printStackTrace();
        }
        logger.info("around end.....");
        return o;
    }

}
