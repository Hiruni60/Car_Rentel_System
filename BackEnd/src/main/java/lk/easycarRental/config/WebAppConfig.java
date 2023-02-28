package lk.easycarRental.config;

import lk.easycarRental.advisor.AppWideExceptionHandler;
import lk.easycarRental.controller.AdminController;
import lk.easycarRental.controller.CarController;
import lk.easycarRental.controller.CustomerController;
import lk.easycarRental.controller.DriverController;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;


    @Configuration
    @EnableWebMvc
    @ComponentScan(basePackageClasses = {CustomerController.class, AppWideExceptionHandler.class, DriverController.class, CarController.class, AdminController.class})
    public class WebAppConfig {
        @Bean(name = "multipartResolver")
        public CommonsMultipartResolver multipartResolver() {
            CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
            multipartResolver.setMaxUploadSize(100000);
            return multipartResolver;
        }

    }

