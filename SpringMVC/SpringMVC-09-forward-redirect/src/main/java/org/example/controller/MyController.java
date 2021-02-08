package org.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MyController {
    /*
    * 处理器方法返回ModelAndView，实现转发forward
    * 语法：setViewName("forward:视图完整的路径")
    * forward特点:不和视图解析器一同使用，就当项目中没有视图解析器
    * */
    @RequestMapping(value = "/doForward.do",method = RequestMethod.POST)
    public ModelAndView doSome(String name, Integer age){
        ModelAndView mv = new ModelAndView();
        mv.addObject("myName",name);
        mv.addObject("myAge",age);
        //显示转发，可转发不在视图解析器下的视图
        mv.setViewName("forward:/WEB-INF/View/show.jsp");
        return mv;
    }
    /*
    * 处理器方法返回ModelAndView，实现重定向
    *语法：setViewName("redirect:视图完整的路径")
    * 在目标页面可以使用参数集合对象${param.}获取请求参数值
    * 重定向不能访问WEB-INFO下的资源
    * */
    @RequestMapping(value = "/doDirect.do",method = RequestMethod.POST)
    public ModelAndView doDirect(String name, Integer age){
        ModelAndView mv = new ModelAndView();
        // 数据放到Request作用域
        mv.addObject("myName",name);
        mv.addObject("myAge",age);
        //重定向
        mv.setViewName("redirect:/hello.jsp");
        return mv;
    }

}
