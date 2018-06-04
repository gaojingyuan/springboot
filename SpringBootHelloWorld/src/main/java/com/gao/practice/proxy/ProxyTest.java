package com.gao.practice.proxy;


public class ProxyTest {
    public static void main(String[] args) {
        // 实例化目标对象
        UserServiceImpl userServiceImpl = new UserServiceImpl();

        // 实例化InvocationHandler
        MyInvocationHandler invocationHandler = new MyInvocationHandler(userServiceImpl);

        // 根据目标对象生成代理对象
        UserService proxy = (UserService) invocationHandler.getProxy();

        // 调用代理对象的方法
        proxy.add();

    }
}