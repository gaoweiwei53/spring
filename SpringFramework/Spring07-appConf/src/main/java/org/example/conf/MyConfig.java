package org.example.conf;

import org.example.pojo.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan("org.example.pojo")
@Import(MyConfig2.class)  //导入其他配置
public class MyConfig {
    // 方法的名字相当于bean配置文件里的 id属性
    // 返回值相当于bean配置文件里的 class属性
    @Bean
    public User getUser(){
        return new User(); //就是要注入到bean中的对象
    }
}
