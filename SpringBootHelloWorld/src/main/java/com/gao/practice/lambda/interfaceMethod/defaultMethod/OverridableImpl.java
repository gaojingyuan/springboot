package com.gao.practice.lambda.interfaceMethod.defaultMethod;

/**
 * Created by jionglu on 17/4/12.
 */
public class OverridableImpl implements Defaulable {
    @Override
    public String notRequired() {
        return "Overridden implementation";
    }
}
