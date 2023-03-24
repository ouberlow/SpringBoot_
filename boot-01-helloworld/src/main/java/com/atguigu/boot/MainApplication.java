package com.atguigu.boot;


import com.atguigu.boot.bean.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcProperties;
import org.springframework.cache.interceptor.CacheAspectSupport;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
//当前类即为自己的Application
/*
1.主要的注解的应用及其作用
2.底层运行原理
3.前后端交互方式
 */

/**
 * 主程序类;主配置类
 * @SpringBootApplication：这是一个SpringBoot应用
 */

//@SpringBootApplication
@SpringBootConfiguration
/*元注解
   在一系列的注解声明中，有些注解具有多重继承和实现的特性，即一个注解下有多个注解，
而注解作为一个标识，即可以标识到使用了该注解的类，此时当前注解所继承的注解的作用
可以和当前注解所注解的类产生联系。
 */
//该注解底层有按需记载的配置，所以有很多配置类并没有一股脑的加载到容器中，即有一部分配置类并没有生效
//没有加载的原因：使用了@ConditionalOn......类型的注解;
//底层已经配置好了众多所需要的配置类，如DispatcherServlet.MultipartResolver(文件上传解析器)
@EnableAutoConfiguration  //开启自动装配

@ComponentScan("com.atguigu.boot")   //自定义配置类的扫描
public class MainApplication {


    public static void main(String[] args) {
        //1、返回我们IOC容器
        ConfigurableApplicationContext run = SpringApplication.run(MainApplication.class, args);

        //2、查看容器里面的组件
        String[] names = run.getBeanDefinitionNames();
        for (String name : names) {
            System.out.println(name);
        }

        //获取容器中所有bean的总数
        int beanDefinitionCount = run.getBeanDefinitionCount();
        System.out.println(beanDefinitionCount);

        //查看容器中共有多少该类型的组件
        String[] beanNamesForType = run.getBeanNamesForType(CacheAspectSupport.class);
        System.out.println("======"+beanNamesForType.length);

        //3、从容器中获取组件(可以是配置文件)
        String[] beanNamesForType1 = run.getBeanNamesForType(WebMvcProperties.class);
        System.out.println("======"+beanNamesForType1.length);
//

          //可以通过配置的bean名或者方法名来获取bean
//        Pet tom01 = run.getBean("tom", Pet.class);
//
//        Pet tom02 = run.getBean("tom", Pet.class);
//
//        System.out.println("组件："+(tom01 == tom02));
//
//
//        //4、com.atguigu.boot.config.MyConfig$$EnhancerBySpringCGLIB$$51f1e1ca@1654a892
//        MyConfig bean = run.getBean(MyConfig.class);
//        System.out.println(bean);
//
//        //如果@Configuration(proxyBeanMethods = true)代理对象调用方法。SpringBoot总会检查这个组件是否在容器中有。
//        //保持组件单实例
//        User user = bean.user01();
//        User user1 = bean.user01();
//        System.out.println(user == user1);
//
//
//        User user01 = run.getBean("user01", User.class);
//        Pet tom = run.getBean("tom", Pet.class);
//
//        System.out.println("用户的宠物："+(user01.getPet() == tom));
//
//
//        //5、获取组件
//        String[] beanNamesForType = run.getBeanNamesForType(User.class);
//        System.out.println("======");
//        for (String s : beanNamesForType) {
//            System.out.println(s);
//        }
//
//        DBHelper bean1 = run.getBean(DBHelper.class);
//        System.out.println(bean1);

        boolean tom = run.containsBean("tom");
        System.out.println("容器中Tom组件："+tom);

        boolean user01 = run.containsBean("user01");
        System.out.println("容器中user01组件："+user01);

        boolean tom22 = run.containsBean("tom22");
        System.out.println("容器中tom22组件："+tom22);

        User zhangsan =  run.getBean("user01",User.class);
        System.out.println(zhangsan.getPet());



        boolean haha = run.containsBean("haha");
        boolean hehe = run.containsBean("hehe");
        System.out.println("haha："+haha);
        System.out.println("hehe："+hehe);

    }
}
