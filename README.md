
## Spring Boot 入门 ##

首先创建一个maven项目，就是当前工程了

然后编写这个maven项目的pom文件

指定一些全局版本
>
    <properties>
        <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
        <project.reporting.outputEncoding>UTF-8</project.reporting.outputEncoding>
        <java.version>1.8</java.version>
    </properties>
    
指定 parent 为 spring-boot-starter-parent
>      
    <parent>
       <groupId>org.springframework.boot</groupId>
       <artifactId>spring-boot-starter-parent</artifactId>
       <version>1.4.7.RELEASE</version>
       <relativePath/>
    </parent>
    
再依赖一下Spring Boot的jar包

spring-boot-starter-web 是要用的

spring-boot-starter-test 是单元测试用的
    
>
    <dependencies>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>
    
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-test</artifactId>
            <scope>test</scope>
        </dependency>
    </dependencies>

编译的时候也需要 Spring-boot 帮忙
>
    <build>
        <plugins>
            <plugin>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-maven-plugin</artifactId>
            </plugin>
        </plugins>
    </build>

这样pom配置就好了

再写个启动类 使用@SpringBootApplication注解
>
    package com.douma.springboot;
    
    import org.springframework.boot.SpringApplication;
    import org.springframework.boot.autoconfigure.SpringBootApplication;
    
    @SpringBootApplication
    public class SpringApp {
    
        public static void main(String[] args) {
            SpringApplication.run(SpringApp.class, args);
        }
    
    }

再用个controller试试效果
>
    package com.douma.springboot.web.controller;
    
    import org.springframework.web.bind.annotation.GetMapping;
    import org.springframework.web.bind.annotation.RestController;
    
    @RestController
    public class HelloController {
    
        @GetMapping("hello")
        public String helloWold(String name) {
            return "Hello World, " + name;
        }
    }

页面请求 http://localhost:8080/hello?name=张三

可以看到结果 Hello World, 张三 说明干活了



## 多环境和多配置 ##

首先在 resources 目录下搞3个配置文件，

application.yml

application-dev.yml

application-test.yml

这里只用到了开发和测试，准生产和生产我没弄，你去弄弄也是同样的玩法

application.yml 中得指定当前的配置使用的是哪个环境的，我这里用的是 `dev` 环境
>
    spring:
      profiles:
        active: dev

除了这种方法 还有2种方法可以改变当前运行环境

方法1： 用jar运行的时候 指定 `spring.profiles.active` 的参数
>
    java -jar 你要运行的文件.jar --spring.profiles.active=dev
方法2： idea启动的时候 在 `Program arguments` 中指定 `spring.profiles.active` 的参数
>
    --spring.profiles.active=dev
    
然后再分别在 application-dev.yml 和 application-test.yml 使用不同的配置信息

application-dev.yml 中说这是开发环境
>
    profile: dev_envrimont
application-test.yml 中说着是测试环境
>
    profile: test_envrimont
    
然后代码中获取配置 profile 时，他都肯定是 dev_envrimont ，你如果把环境换成 test ， 那拿到的就是 test_envrimont 了

获取配置的方式1：
> 
        @Value("${profile}")
        private String profile;
获取配置的方式2：
>
        @Autowired
        private Environment environment;
        
        environment.getProperty("profile");
    
