package org.example.ba01;

public class SomeServiceImpl implements SomeService {
    @Override
    public void doSome(String name, Integer age) {
        //给doSome方法增加功能，在其执行之前，输出方法啊的执行时间
        System.out.println("目标方法doSome()");

    }
}
