package org.example.controller;

import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
    * @RequestMapping
    *   method: 表示请求的方式。它的值是ReqestMethod枚举值(RequestMethod.GET, RequestMethod.Post)
    *
    * */
    @RequestMapping(value = {"/some.do","first.do"},method = RequestMethod.GET)
    public ModelAndView doSome(HttpServletRequest request, HttpServletResponse response, HttpSession httpSession){

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("msg","欢迎使用SpringMVC==" + request.getParameter("name"));
        modelAndView.addObject("fun","执行doSome方法");
        modelAndView.setViewName("show");
        return modelAndView;
    }
    @RequestMapping(value = {"other.do","second.do"},method = RequestMethod.POST)
    public ModelAndView doOther(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("msg","欢迎使用SpringMVC");
        modelAndView.addObject("fun","执行doOther方法");
        modelAndView.setViewName("other");
        return modelAndView;
    }
}
