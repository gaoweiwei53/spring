package org.example.pojo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

// 等价于 <bean id="user" class="org.example.pojo.User"
@Component
@Scope("singleton")
public class User {
    @Value("Spring")
    public String name;
}
