package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/** 
* @ClassName: SpringBootDemoHelloApplication 
* @Description: 
* SpringBootDemoHelloApplication.java 是SpringBoot应用程序入口，或者叫主程序。
* 注解@SpringBootApplication 标注他是一个SpringBoot应用，main方法使他成为一个主程序，将在应用启动时首先被执行。
* 注解@RestController 标注这也是一个控制器。
* @author mengfanzhu
* @date 2017年2月21日 下午12:28:07 
*/
@SpringBootApplication
public class SpringBootDemoHelloApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootDemoHelloApplication.class, args);
	}
}
