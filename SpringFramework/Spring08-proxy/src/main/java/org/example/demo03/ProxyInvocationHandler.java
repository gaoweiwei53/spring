package org.example.demo03;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

// 自动生成代理
public class ProxyInvocationHandler implements InvocationHandler {
    // 被代理的接口
    private Rent rent;

    public void setRent(Rent rent) {
        this.rent = rent;
    }

    // 生成代理类
    public Object getProxy(){
        return Proxy.newProxyInstance(this.getClass().getClassLoader(), rent.getClass().getInterfaces(), this);

    }


    // 处理代理实例，并返回
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        seeHouse();
        //动态代理的本质就是使用反射来实现
        Object result = method.invoke(rent, args);
        fee();
        return result;
    }
    public void seeHouse(){
        System.out.println("中介带你看房子");
    }
    public void fee(){
        System.out.println("收中介费");
    }

}
