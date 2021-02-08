package org.example.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.vo.Student;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@Controller
public class MyController {

    /*
    * 处理器方法返回String, 表示逻辑视图名称，需要配置视图解析器
    * */
    @RequestMapping(value = "returnString.do",method = RequestMethod.POST)
    public String doReturnView(HttpServletRequest request, String name, Integer age){
        // 可以手动添加数据到request作用域
        request.setAttribute("myName", name);
        request.setAttribute("myAge", age);
        // show: 逻辑视图名称，项目中配置了视图解析器
        // 框架对视图执行forward转发操作
        return "show";
    }
    // 处理器方法返回String，表示完整视图路径，此时不能配置视图解析器
//    @RequestMapping(value = "returnString2.do",method = RequestMethod.POST)
//    public String doReturnView2(HttpServletRequest request, String name, Integer age){
//        System.out.println("doReturnView2, name=" + name + ", age = " + age);
//        // 可以手动添加数据到request作用域
//        request.setAttribute("myName", name);
//        request.setAttribute("myAge", age);
//        // show: 完整视图路径 ，项目中不能配置视图解析器
//        // 框架对视图执行forward转发操作
//        return "/WEB-INF/View/show/show.jsp";
//    }

    // returnVoid-ajax.do
    // 处理器方法返回void, 响应ajax请求
    // 手工实现Ajax，json数据代码有重复 1. Java对象转为json；2.通过HttpServletResponse输出json数据
    @RequestMapping(value = "returnVoid-ajax.do",method = RequestMethod.POST)
    public void doReturnVoidAjax(HttpServletResponse response, String name, Integer age) throws IOException {
        System.out.println("doReturnView2, name=" + name + ", age = " + age);
        // 处理ajax，使用json格式做数据的格式
        // service调用完了，使用Student表示处理结果
        Student student = new Student();
        student.setName(name);
        student.setAge(age);

        String json = "";
        //将结果的对象转为json格式的数据
        if (student != null){
            ObjectMapper objectMapper = new ObjectMapper();
            json = objectMapper.writeValueAsString(student);
            System.out.println("student转换的json===" + json);
        }

        //输出数据，响应ajax的请求
        response.setContentType("application/json;charset=utf-8");
        PrintWriter writer = response.getWriter();
        writer.println(json);
        writer.flush();
        writer.close();
    }
    /*
    * 处理器方法返回一个student，通过框架转为json，响应ajax请求
    * @ResponseBody: 把处理器方法返回值对象转为json后，通过HttpServletResponse输出给浏览器
    * 位置：方法上，和其他注解没有先后顺序
    * 返回框架对象处理流程：
    * 1. 框架会把Student类型，调用框架中的ArrayList<HttpMessageConverter>中的每个类的canwrite()方法，检查哪个实现类能够处理Student类型的数据
    * 2. 框架会调用实现类的write(), MappingJackson2HttpMessageConverter的write()方法把student对象转为json，调用JackSon的ObjectMapper实现转为json
    * 3. 框架会调用@Responsebody把2的结果数据输出到浏览器，ajax请求处理完成
    * */
    @RequestMapping(value = "returnStudentJson.do",method = RequestMethod.POST)
    @ResponseBody
    public Student doStudentJsonObject(HttpServletResponse response, String name, Integer age)  {
        //调用service，获取请求结果
        Student student = new Student();
        student.setName("Lisi");
        student.setAge(18);
        return student; // 会被框架转为Json
    }
    /*
    *返回List<Student>
    * */
    @RequestMapping(value = "returnStudentJsonArray.do",method = RequestMethod.POST)
    @ResponseBody
    public List<Student> doStudentJsonObjectArray(HttpServletResponse response, String name, Integer age)  {
        //调用service，获取请求结果
        ArrayList<Student> list = new ArrayList<>();
        Student student = new Student();
        student.setName("Lisi");
        student.setAge(18);
        list.add(student);

        Student student2 = new Student();
        student.setName("Lisan");
        student.setAge(18);
        list.add(student2);

        return list; // 会被框架转为Json
    }
    /*
    * 返回String，表示数据
    * 区分表示的是视图还是数据，看有没有@ResponseBody
    * 不会周过滤器，默认会中文乱码
    * 解决方案：给RequestMapping增加一个属性produces，使用这个属性指定新的contentType
    * */
    @RequestMapping(value = "returnStringData.do",method = RequestMethod.POST,produces = "text/plain;charset=utf-8")
    @ResponseBody
    public String doStringData(String name, Integer age)  {
        return "hello springmvc";

    }
}
