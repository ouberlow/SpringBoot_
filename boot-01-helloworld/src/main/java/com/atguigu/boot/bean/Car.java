package com.atguigu.boot.bean;


import lombok.Data;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;


/**
 * 只有在容器中的组件，才会拥有SpringBoot提供的强大功能
 */
@ToString
@Data
@Component
//该注解表示该类和核心配置文件的指定前缀属性是绑定的
@ConfigurationProperties(prefix = "mycar") //在核心配置文件进行属性的复制
public class Car {

    private String brand;
    private Integer price;


}
