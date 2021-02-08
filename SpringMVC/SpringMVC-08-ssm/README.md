# 08-ssm
SSM: SpringMVC+Spring+Mybatis
- SpringMVC: 视图层，负责接收请求，显示处理结果
- Spring: 业务层，管理service，dao，工具类对象的
- Mybatis: 持久层，访问数据库的

用户发起请求 -- SpringMVC接收请求 -- Spring中的service对象 -- Mybatis处理数据

SSM整合也就是容器整合
- SpringMVC容器，管理Controller对象的
- Spring容器，管理Service，Dao，工具类对象的

SpringMVC容器是Spring容器的子容器，类似继承。在子容器的Controller可以访问父容器的service对象，就可以实现controller使用service对象

实现步骤：
1) 建表 student(id auto_increment, name, age)
2) 新建maven项目，加入依赖: SpringMVC, Spring, Mybatis, jackson, mysql Connector, druid, jsp, servlet
3) 写web.xml
   - 注册DispatcherServlet，目的1) 创建SpringMVC对象，才能创建Controller对象 2) 创建Servlet，才能接收用户请求
   - 注册Spring监听器: ContextLoaderListener,目的是创建spring的容器对象，才能创建service, dao等对象
   - 注册字符集过滤器，解决post请求乱码的问题
   
4) 创建包，controller，service，dao，实体类包
5) 写springmvc, spring, myabtis的配置文件
   - springmvc配置文件，spring配置文件， myabtis配置文件，数据库的属性配置文件
   
6) 写代码，dao接口和mapper文件，service和实现类，controller，实体类
7) 写jsp页面

# 07-path
## 访问地址不加"/": user/some
在index.jsp发起user/some.do请求时，当点击链接时，访问地址是当前页面的地址加上链接的地址
  http://localhost:8080/06_path/user/some.do
  
不加/时，第二次跳转到自己的页面会出错
   - 第一次跳转得到http://localhost:8080/SpringMVC_06_path/user/some
   - 第二次跳转会得到http://localhost:8080/SpringMVC_06_path/user/user/some
 
解决方法方法:
1) 加入${pageContext.request.contextPath}
2) 加入base标签，表示当前页面中访问地址的基地址。页面中所有没以"/"开头的地址，都会以base标签中的地址作为参考地址
  
  
## 加"/": /user/some
请求地址加服务器地址:http://localhost:8080/user/some
  如果资源不能访问可加上加上项目名，也可以加入${pageContext.request.contextPath}


# 04- return
return: 处理器方法的返回值表示请求的的处理结果

1) ModelAndView: 有数据和视图，对视图执行forward
2) String: 表示视图名称，可以是逻辑名称，也可以是完整视图路径
3) void: 不能表示数据，也不能表示视图，在处理Ajax的时候可以使用void返回值，通过HttpServletResponse输出数据，响应ajax请求。ajax请求服务器返回的就是数据，和视图无关
4) Object: 例如String，Integer， Map，List，Student，表示数据，和视图无关。可以使用对象表示的数据，响应ajax请求

现象做ajax，主要使用json的格式。实现步骤：
1) 加入处理json的工具库的依赖，springmvc默认使用的jackson
2) 在springMVC配置文件中加入<mvc:annotation-driven>注解驱动：`json = objectMapper.writeValueAsString(student);`
3) 在处理器方法的上面加入`@ResponseBody`注解
```java
response.setContentType("application/json;charset=utf-8");
PrintWriter writer = response.getWriter();
writer.println(json);
```
springMVC处理器方法返回Object，可以转为json输出到浏览器，响应ajax的内部原理
1) <mvc:annotation-driven>注解驱动  
注解驱动实现的功能是完成java对象到json, xml, text二进制等数据格式的转换。
   <mvc:annotation-driven>加入到springmvc配置文件后，会自动创建HttpMessageConverter接口的7个实现类对象，包括`MappingJackson2HttpMessageConverter`(使用jackson工具库中的ObjectMapper实现java对象转为字符串)
   httpMessageConverter接口：消息转化器
   功能：定义了java转为json，xm等数据格式的方法。这个接口有很多实现类。这些实现类完成了java对象到json,XMl,text等数据的转换。
   ```java
   // 下面两个方法是控制器类把结果输出到浏览器时使用的
   boolean canWrite(Class<?> var1, @Nullable MediaType var2);
   void write(T var1, @Nullable MediaType var2, HttpOutputMessage var3)
   ```
   - `canwrite`作用检查处理器方法的返回值，能不能转为var2表示的数据格式
   - `write`把处理器方法的返回值对象，调用jackson中的ObjectMapper转为json字符串`json = objectMapper.writeValueAsString(student);`
2) `@ResponseBody`注解
放在处理器方法上面，通过HttpServletResponse输出数据，响应ajax请求的

接收请求的参数，使用的处理器方法的形参
1) HttpServletRequest
2) HttpServletResponse
3) HttpSession
4) 用户提交的数据

接收用户的参数：
1) 逐个接收
2) 对象接收

注意：
- 在提交参数时，get请求方式没有乱码，post请求中文由乱码，需要使用过滤器解决
- 过滤器可以自定义，也可以使用框架中的过滤器
  需求：用户页面发起一个请求，请求交给springmvc的控制对象，并显示请求的处理结果（在结果显示页面显示一个欢迎语句）

实现步骤：
1) 新建web maven工程
2) 加入spring-webmvc，jsp，servlet依赖
3) 重点：在web.xml中注册springmvc框架核心对象DispatcherServlet
    - DispatcherServlet叫做中央调度器(front controller)，是一个Servlet，它的父类继承httpServlet
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
   

