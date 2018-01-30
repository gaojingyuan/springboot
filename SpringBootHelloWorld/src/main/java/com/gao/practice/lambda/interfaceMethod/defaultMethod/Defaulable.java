package com.gao.practice.lambda.interfaceMethod.defaultMethod;

/**
 * Created by jionglu on 17/4/12.
 */
public interface Defaulable {
    default String notRequired() {
        return "Default implementation";
    }
}
