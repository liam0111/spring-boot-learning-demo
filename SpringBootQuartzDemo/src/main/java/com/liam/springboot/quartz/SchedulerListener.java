package com.liam.springboot.quartz;

import com.liam.springboot.quartz.scheduler.CronSchedulerJob;
import org.quartz.SchedulerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @Author: Liam
 * @Date: 2019/3/12 15:17
 */
@Configuration
@EnableScheduling
@Component
public class SchedulerListener {
    @Autowired
    public CronSchedulerJob schedulerJob;

    @Scheduled(cron = "0 21 15 12 3 ?")
    public void schedule() throws SchedulerException {
        schedulerJob.scheduleJobs();
    }
}
