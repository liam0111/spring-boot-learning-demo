package com.liam.springboot.quartz.job;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 * @Author: Liam
 * @Date: 2019/3/12 15:01
 */
public class ScheduledJob implements Job {
    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        System.out.println("schedule job1 is running...");
    }
}
