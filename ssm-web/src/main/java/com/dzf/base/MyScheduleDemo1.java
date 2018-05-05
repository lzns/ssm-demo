package com.dzf.base;

import org.springframework.scheduling.annotation.Scheduled;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author dingzf
 * @date 2018/4/19
 * @time 15:22
 */
//@Component
public class MyScheduleDemo1 {

    /**
     * 测试定时任务
     *
     *
     */
    @Scheduled(cron = "0/5 * * ? * *")
    public void testSchedule(){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date();
        String str = simpleDateFormat.format(date);
        System.out.println(str);
    }
}
