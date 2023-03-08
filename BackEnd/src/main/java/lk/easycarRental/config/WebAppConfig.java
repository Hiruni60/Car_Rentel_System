package lk.easycarRental.config;

import lk.easycarRental.advisor.AppWideExceptionHandler;
import lk.easycarRental.controller.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;


    @Configuration
    @EnableWebMvc
    @ComponentScan(basePackageClasses = {CustomerController.class, AppWideExceptionHandler.class, DriverController.class, CarController.class, BookingController.class, AdminController.class})
    public class WebAppConfig {
        @Bean(name = "multipartResolver")
        public CommonsMultipartResolver multipartResolver() {
            CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
            multipartResolver.setMaxUploadSize(1000000);
            return multipartResolver;
        }

    }

