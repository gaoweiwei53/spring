package org.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/*
* @Controller: 创建处理器对象，对象放在springmvc容器中
* 位置：类上面
* 能处理请求的都是控制器，MyController叫做后端控制器(back controller)
* */
@Controller
public class MyController {
    /*
        处理用户提交的请求，springmvc中是使用方法来处理的
        方法是自定义的，可以有多种返回值，多种参数，方法名称自定义
     */

    /*
    * 准备使用doSome方法处理some.do请求
    * @RequestMapping：请求映射，作用是把一个请求和一个方法绑定在一起
    *                  一个请求指定一个方法
    *   属性：1. Value 是一个String，表示请求的uri地址
    *           Value的值必须是唯一的
    *
    * 说明：使用RequestMapping修饰的方法叫做处理器方法
    *
    * 返回值：ModelAndView 表示本次请求的处理结果
    * Model：数据， 请求处理完成后，要显示给用户的数据
    * View：视图，比如jsp等等
    * */
    @RequestMapping(value = {"/some.do","/first.do"})
    public ModelAndView doSome(){
        // 处理some.do的请求
        ModelAndView modelAndView = new ModelAndView();
        // 添加数据，框架把请求的最后数据放入到request作用域
        // request.serAttribute("msg","欢迎使用SpringMVC")
        modelAndView.addObject("msg","欢迎使用SpringMVC");
        modelAndView.addObject("fun","执行doSome方法");

        //指定视图，指定视图的完整路径
        //框架对视图执行forward操作，request.getRequestDispatcher("/show.jsp").forward(...)
        //modelAndView.setViewName("/WEB-INF/View/show.jsp");
        //modelAndView.setViewName("/WEB-INF/View/other.jsp");
        // 当配置了视图解析器后，可以使用逻辑名称指定视图
        modelAndView.setViewName("show");
        return modelAndView;
    }
    @RequestMapping(value = {"/other.do","/second.do"})
    public ModelAndView doOther(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("msg","欢迎使用SpringMVC");
        modelAndView.addObject("fun","执行doOther方法");
        modelAndView.setViewName("other");
        return modelAndView;
    }

}
