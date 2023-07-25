package com.bitspondon.rokibspringboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;

import java.util.Date;

@SpringBootApplication

@EnableScheduling
@EnableAsync
//@EnableZipkinServer
public class RokibspringbootApplication {

    @Autowired
    private TaskScheduler taskScheduler;

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(RokibspringbootApplication.class, args);
        for (var bean: context.getBeanDefinitionNames()) {
            System.out.println(bean);
        }
    }


    //    @Scheduled(fixedDelay = 2000) /
//    @Scheduled(cron = "*/2 * * * * *") //crontab.guru
//    public void job1() {
//        System.out.println("job 1 = " + new Date());
//    }
//
//    @Async
//    @Scheduled(cron = "*/2 * * * * *") //crontab.guru
//    public void job2() {
//        System.out.println("job 2 = " + new Date());
//    }
//
//
//    @Bean
//    public TaskScheduler taskScheduler() {
//        ThreadPoolTaskScheduler taskScheduler = new ThreadPoolTaskScheduler();
//        taskScheduler.setPoolSize(10);
//        taskScheduler.setThreadNamePrefix("ThreadPoolTaskScheduler");
//        return taskScheduler;
//    }


}
