P1-P15.总结

    关于SpringBoot运行后的一系列组件配置--底层源码的作用

    >通过注解进行一列系的组建装配，起始注解@SpringBootApplication配置为MainApplication，表示一个配置主类

    >@SpringBootApplication注解分为：(详细参考代码中的笔记以及pdf笔记或者语雀笔记)
                                >@SpringBootConfiguration
                                >@ComponentScan
                                >@EnableAutoConfiguration

    >@EnableAutoConfiguration注解起到了至关重要的作用:
                                >@AutoConfigurationPackage-->包含了:@Import+@AutoConfigurationPackage(扫描当前包下所有子包)
                                >@Import-->会导入各种组件

    >@Configuration-->包含了:@Improt+@Component


    >@ConditionalOn... :  当...条件下，注解所在方法/类/属性将失效/生效,常用于底层源码的自动配置；
    >自动装配时，加载类取得配置文件的值:xxxxxAutoConfiguration —> 组件 > xxxxProperties里面拿值 > application.properties
