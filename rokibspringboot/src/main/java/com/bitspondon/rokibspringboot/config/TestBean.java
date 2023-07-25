package com.bitspondon.rokibspringboot.config;


import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.beans.factory.config.SingletonBeanRegistry;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Description;
import org.springframework.context.annotation.Scope;

@Configuration
public class TestBean {


    @Bean
//    @Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
//    @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
//    @Scope(ConfigurableBeanFactory.)
    @Description("this is a bean for string class")
    public String stringBean() {
        return new String();
    }



}
