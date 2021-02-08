package org.example.controller;

import org.example.vo.Student;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

// @Controller: 创建处理器对象，对象放在springmvc容器中
/*
* @RequestMapping放在类上:
*   Value: 所有请求地址的公共部分(模块名称)：如 /test/
* */
@Controller
@RequestMapping("/test")
public class MyController {
    /*
    * 逐个接收请求参数：
    *   要求：处理器方法的形参名和请求中参数名必须一致，同名的请求参数赋值给同名的形参
    * 框架接收参数
    * 1. 使用request对象接收请求参数
    *       String strName = request.getParameter("name")
    *        String strAge = request.getParameter("age")
    * 2. SpringMVC框架通过DispatcherServlet调用MyController的doSome()方法
    *   调用时按名称对应，把接收的参数赋值给形参
    *   doSome(strName, Integer.valueOf(strAge))
    *   框架会提供类型转换，能把String转换为int, long, float, double等类型
    *
    * 400：客户端错误，表示提交请求参数过程中发生了问题
    *
    * */
    @RequestMapping(value = "receiveProperty.do",method = RequestMethod.POST)
    // 使用Integer类型可避免无法转换空字符串的情况
    public ModelAndView doOther(String name, Integer age){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("myName",name);
        modelAndView.addObject("myAge",age);
        modelAndView.setViewName("other");
        return modelAndView;
    }
    /*
    * 请求参数名和方法形参名不一样
    * @RequestParam: 逐个接收请求参数中，解决请求参数名和方法形参名不一样的问题
    *   属性：1. value 请求中的参数名称
    *        2. required 是一个boolen, 默认是true，表示请求必须包含此参数
    *   位置：在方法形参的前面
    * */
    @RequestMapping(value = "receiveParam.do",method = RequestMethod.POST)
    public ModelAndView doParam(@RequestParam(value = "rname", required = false) String name,
                                @RequestParam(value = "rage",required = false) Integer age){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("myName",name);
        modelAndView.addObject("myAge",Integer.valueOf(age));
        modelAndView.setViewName("other");
        return modelAndView;
    }
    /*
    * 方法形参是定义的参数java对象
    * 框架会创建形参的java对象，给属性赋值。请求中的参数是name，框架会调用setName()
    * */

    @RequestMapping(value = "receiveObject.do",method = RequestMethod.POST)
    public ModelAndView doParam(Student student){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("myName",student.getName());
        modelAndView.addObject("myAge",student.getAge());
        modelAndView.addObject("myStudent", student);
        modelAndView.setViewName("other");
        return modelAndView;
    }
}
