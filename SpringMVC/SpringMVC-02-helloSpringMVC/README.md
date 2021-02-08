需求：用户页面发起一个请求，请求交给springmvc的控制对象，并显示请求的处理结果（在结果显示页面显示一个欢迎语句）

实现步骤：
1) 新建web maven工程
2) 加入spring-webmvc，jsp，servlet依赖
3) 重点：在web.xml中注册springmvc框架核心对象DispatcherServlet 
    - DispatcherServlet叫做中央调度器，是一个Servlet，它的父类继承httpServlet
    - DispatcherServlet负责接收用户提交的请求，调用其他的控制器对象，并把请求结果显示给用户
    
4) 创建一个发起请求的页面 index.jsp
5) 创建控制器类
    - 在类的上面加入@Controller注解，创建对象，并放入springmvc容器中
    - 在方法中的方法上加入@RequestMapping注解，@RequestMapping可放在方法和类上
    
6) 创建一个组为结果的jsp
7) 创建springmvc配置文件(与spring配置文件一样)
    - 声明组件扫描器，指定@Controller注解所在的包名
    - 声明视图解析器，帮助处理视图
   
## springmvc请求的处理流程

1) 发起some.do
2) tomcat(web.xml--url-pattern知道*.do的请求给DispatcherServlet)
3) DispatcherServlet(根据springmvc.xml配置知道 some.do()) 
4) DispatcherServlet把some.do转发给MyController.doSome()方法
5) 框架执行doSome()把得到ModelAndView进行处理，转发到show.jsp

## springmvc执行过程源码分析
1) Tomcat启动，创建容器的过程  
通过load-on-start标签指定1，创建DispatcherServlet对象，DispatcherServlet它的父类是继承HttpServlet，它是一个Servlet，在被创建时会执行init()方法
```java
// 在init()中
// 创建容器，读取配置文件
WebApplicationContext ctx = new ClassPathXmlApplicationContext("springmvc.xml");
getServletContext().setAttribute(key, ctx);
```
上面创建容器的作用：创建@Controller注解所在的类的对象，这个对象放入到springmvc的容器中，容器是map，类似`map.put("myController", MyController)`
2) 请求处理过程
   1) 执行servlet的service(): `HttpMethod httpMethod = HttpMethod.resolve(request.getMethod());`
   ```java
   protected void service(HttpServletRequest request, HttpServletResponse response)
   protected abstract void doService(HttpServletRequest request, HttpServletResponse response)
   doDispatch(request, response){
   //调用MyController的.doSome()方法
   }
   ```
   

