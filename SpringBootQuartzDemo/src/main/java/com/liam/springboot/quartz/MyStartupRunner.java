package com.liam.springboot.quartz;

import com.liam.springboot.quartz.scheduler.CronSchedulerJob;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * @Author: Liam
 * @Date: 2019/3/12 15:14
 */
@Component
public class MyStartupRunner implements CommandLineRunner {
    @Autowired
    public CronSchedulerJob schedulerJob;

    @Override
    public void run(String... args) throws Exception {
        schedulerJob.scheduleJobs();
        System.out.println("----------定时任务开始执行----------");
    }
}
