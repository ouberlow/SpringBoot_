package com.atguigu.boot.config;


import ch.qos.logback.core.db.DBHelper;
import com.atguigu.boot.bean.Car;
import com.atguigu.boot.bean.Pet;
import com.atguigu.boot.bean.User;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;


/**
 * 1、配置类里面使用@Bean标注在方法上给容器注册组件，默认也是单实例的
 * 2、配置类本身也是组件
 * 3、proxyBeanMethods：代理bean的方法
 *      Full(proxyBeanMethods = true)、【保证每个@Bean方法被调用多少次返回的组件都是单实例的】
 *      Lite(proxyBeanMethods = false)【每个@Bean方法被调用多少次返回的组件都是新创建的】
 *      组件依赖必须使用Full模式默认。其他默认是否Lite模式
 *
 * 4、@Import({User.class, DBHelper.class})
 *      给容器中自动创建出这两个类型的组件、默认组件的名字就是全类名
 *
 *
 * 5、@ImportResource("classpath:beans.xml")导入Spring的配置文件，
 *
 */

//只要该类被依赖，就可以通过该注解对任意被依赖的类进行注入，则容器中就有该类的实例对象！
@Import({User.class, DBHelper.class})


//一经扫描就会被注入到IOC容器中，作为IOC容器的一部分！
@Configuration(proxyBeanMethods = false) //告诉SpringBoot这是一个配置类 == 配置文件


//当容器中没有Bean(name="")则以下代码不会生效也不会注入到容器中！
//@ConditionalOnBean(name = "tom")
//当容器中没有Bean(name="")则以下代码均有效
@ConditionalOnMissingBean(name = "tom")


//引入资源下的文件
@ImportResource("classpath:beans.xml")


/*自动注解原理


*/
//1、开启Car配置绑定功能-->可以将car.class类自动和核心配置文件的一些指定属性进行绑定
//2、把这个Car这个组件自动注册到容器中
//3. 也就意味着可以把第三方包中的指定的类注入到IOC容器中
//直接在要使用Car对象的类上标注@EnableConfigurationProperties注解
@EnableConfigurationProperties(Car.class)  //同时在car类上还有配置一个@ConfigurationProperties(prefix = "mycar")注解表示加载指定前缀的值

public class MyConfig {



    /**
     * Full:外部无论对配置类中的这个组件注册方法调用多少次获取的都是之前注册容器中的单实例对象
     * @return
     */


    @Bean //给容器中添加组件。以方法名作为组件的id。返回类型就是组件类型。返回的值，就是组件在容器中的实例
    public User user01(){
        User zhangsan = new User("zhangsan", 18);

        //user组件依赖了Pet组件
        zhangsan.setPet(tomcatPet());
        return zhangsan;

    }
    @Bean("tom22")
    public Pet tomcatPet(){
        return new Pet("tomcat");
    }

//    @Bean
//    public CharacterEncodingFilter filter(){
//        return null;
//    }
}
