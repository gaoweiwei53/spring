import org.example.handler.MyInvocationHandler;
import org.example.service.SomeService;
import org.example.service.impl.SomeServiceImpl;
import org.junit.Test;

import java.lang.reflect.Proxy;

public class Mytest {
    @Test
    public void test01(){
//        SomeServiceImpl service = new SomeServiceImpl();
//        service.doOther();
        // 使用jdk的Proxy创建代理对象
        // 创建目标对象
        SomeServiceImpl target = new SomeServiceImpl();

        //创建InvocationHandler对象
        MyInvocationHandler handler = new MyInvocationHandler(target);

        //使用Proxy创建代理
        SomeService proxy = (SomeService) Proxy.newProxyInstance(
                target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                handler);
        //通过执行代理方法，会调用handler中的invoker()
        proxy.doSome();
    }
    @Test
    public void test02(){

        byte[] bytes = new byte[1024];
        Class c = bytes.getClass();

        System.out.println(c);
    }
}
