package com.gao.practice.lambda.interfaceMethod.staticMethod;

import com.gao.practice.lambda.interfaceMethod.defaultMethod.Defaulable;

import java.util.function.Supplier;

/**
 * Created by jionglu on 17/4/12.
 */
public interface DefaulableFactory {
    static Defaulable create(Supplier<Defaulable> supplier) {
        return supplier.get();
    }
}
