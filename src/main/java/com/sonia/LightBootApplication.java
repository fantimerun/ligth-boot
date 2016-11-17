package com.sonia;

import com.sonia.config.JDBCSettings;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.filter.CharacterEncodingFilter;

@RestController
@SpringBootApplication
@EnableAutoConfiguration
public class LightBootApplication {
    private static Logger logger = LoggerFactory.getLogger(LightBootApplication.class);
    @Autowired
    CharacterEncodingFilter filter;
    @Autowired
    JDBCSettings jdbcSettings;
    @Value("${example.name}")
    String projectName;

    @Autowired
    HelloService helloService;

    @RequestMapping("/")
    String index() {
        logger.debug("index ... ");
        return "Hello SpringBoot : " + projectName + " - " + jdbcSettings.getUsername();
    }
    @RequestMapping("/hello")
    String hello(){
        return helloService.sayHello();
    }

    public static void main(String[] args) {
        //SpringApplication.run(LightBootApplication.class, args);
        //new SpringApplicationBuilder(LightBootApplication.class).
        SpringApplication application = new SpringApplication(LightBootApplication.class);
        application.run(args);
    }
}
