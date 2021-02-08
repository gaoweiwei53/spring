import org.example.dao.UserDaoMysqlImpl;
import org.example.service.UserServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest {
    public static void main(String[] args) {
//
//        //用户实际调用的是业务层。dao层不需要接触。dao层自己调用业务层
//        UserServiceImpl userService = new UserServiceImpl();
//        // 调用者自己new不同的对象
//        ((UserServiceImpl) userService).setUserDao(new UserDaoMysqlImpl());
//        userService.getUser();
        // 获取applicationContext
        // 拿到Spring的容器
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        UserServiceImpl userServiceImpl = (UserServiceImpl) context.getBean("UserServiceImpl");
        userServiceImpl.getUser();
    }
}
