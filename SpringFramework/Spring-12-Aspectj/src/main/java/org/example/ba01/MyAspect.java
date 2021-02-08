package org.example.ba01;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

import java.util.Date;

/*
* @Aspect
* 作用：表示当前类是切面类
* 切面类：是用来给业务方法增加功能的类，在这个类中有切面的功能代码
* */
@Aspect
public class MyAspect {
    /*
    * 定义方法，方法是实现切面功能的
    * 方法的定义要求：
    * 1. 公共方法public
    * 2. 没有返回值
    * 3. 方法名自定义
    * 4. 方法可以有参数也可以没参数。如果有参数，参数不能自定义
    * */

    /*
    * @Before:前置通知注解
    * 属性：value，切入点表达式，表示切面的功能执行的位置
    * 特点:
    * 1. 在目标方法之前执行
    * 2.不会改变目标方法的执行结果
    * 3.不会影响目标方法的执行
    *
    * */
    //public void soSome(String name, Integer age)
    //@Before(value = "execution(public void org.example.ba01.SomeServiceImpl.doSome(String,Integer))")
    @Before(value = "execution(* *..SomeServiceImpl.do*(..))")
    public void myBefore(){
        //切面要执行的功能代码
        System.out.println("前置通知: 在目标方法执行输出执行时间"+ new Date());
    }
}
