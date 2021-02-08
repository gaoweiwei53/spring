import org.example.ba01.SomeService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest {
    @Test
    public void test01(){
        String config = "applicationContext.xml";
        ApplicationContext ctx = new ClassPathXmlApplicationContext(config);
        //获取目标对象
        SomeService proxy = ctx.getBean("someService", SomeService.class);
        // 通过代理对象执行方法
        proxy.doSome("lisi",20);
    }
}
