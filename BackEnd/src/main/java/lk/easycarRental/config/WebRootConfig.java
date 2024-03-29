package lk.easycarRental.config;

import lk.easycarRental.service.impl.*;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;


    @Configuration
    @Import(JPAConfig.class)
    @ComponentScan(basePackageClasses = {CustomerServiceImpl.class, DriverServiceImpl.class, CarServiceImpl.class, BookingServiceImpl.class, AdminServiceImpl.class})
    public class WebRootConfig {
        @Bean
        public ModelMapper modelMapper(){
            return new ModelMapper();
        }
    }

