package lk.easycarRental.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

public class WebAppConfig {
    @Configuration
    @EnableWebMvc
    @ComponentScan(basePackageClasses = {CustomerController.class, AppWideExceptionHandler.class})
    public class WebAppConfig {


    }
}
