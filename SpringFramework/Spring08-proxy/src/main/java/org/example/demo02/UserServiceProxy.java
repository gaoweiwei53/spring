package org.example.demo02;

public class UserServiceProxy implements UserService{
    private UserService userService;

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public void add() {
        logs("add");
        userService.add();
    }

    public void delete() {
        logs("delete");
        userService.delete();
    }

    public void update() {
        logs("update");
        userService.update();
    }

    public void query() {
        logs("query");
        userService.query();
    }

    // 增加的日志方法 如果不用代理模式，需要在UserServiceImpl类中每个方法中添加打印的语句, 修改了源代码
    public void logs(String msg){
        System.out.println("使用了" + msg + "方法");
    }
}
