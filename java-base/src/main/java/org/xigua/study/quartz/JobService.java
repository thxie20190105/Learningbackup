package org.xigua.study.quartz;

import org.quartz.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.xigua.study.quartz.constant.Constant;
import org.xigua.study.quartz.job.APP000000Server2;
import org.xigua.study.quartz.job.AbstractServer;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Properties;
import java.util.Set;


/**
 * @author 山五洲
 */
@Service
public class JobService {
    private static final Logger LOGGER = LoggerFactory.getLogger(JobService.class);

    static HashMap<String, String> hashMap;

    @Autowired
    Scheduler scheduler;


    /**
     * 启动所有任务
     */
    void startAll() throws SchedulerException {
        start();
    }

    /**
     * 启动一个定时任务
     */
    private void start() throws SchedulerException {
        try {
            inti();
            String[] strings = JobService.hashMap.get("systemType").split(",");
            for (int i = 0, j = strings.length; i < j; i++) {
                if (Constant.ZERO.equals(strings[i])) {

                    //execute(new APP000000Server());
                    //Thread.sleep(2000);
                    executeTest(new APP000000Server2());
                } else {
                    LOGGER.info("需要配置");
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void executeTest(APP000000Server2 app000000Server2) throws SchedulerException {

        //任务构建者
        JobBuilder jobBuilder = JobBuilder.newJob(app000000Server2.getClass());
        jobBuilder.withIdentity("定时任务名称", "定时任务分组");
        jobBuilder.setJobData(new JobDataMap());


        //构建出任务细节
        JobDetail jobDetail = jobBuilder.build();


        //时间表生成器构建者，下面定义了重复模式还有重复间隔
        SimpleScheduleBuilder simpleScheduleBuilder = SimpleScheduleBuilder.simpleSchedule();
        simpleScheduleBuilder.withIntervalInSeconds(1);
        simpleScheduleBuilder.repeatForever();

        CronScheduleBuilder cronScheduleBuilder = CronScheduleBuilder.cronSchedule("0/5 * * * * ? *");



        //触发器建造者
        TriggerBuilder<Trigger> triggerTriggerBuilder = TriggerBuilder.newTrigger();
        triggerTriggerBuilder.withIdentity("触发器名称", "触发器所在分组");
        triggerTriggerBuilder.startNow();
        triggerTriggerBuilder.withSchedule(cronScheduleBuilder);
        Trigger trigger = triggerTriggerBuilder.build();


        scheduler.scheduleJob(jobDetail, trigger);

        if (scheduler.isShutdown()) {
            scheduler.start();
        }

    }


    private void execute(AbstractServer o) throws SchedulerException {
        //调度器
        // Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();


        //具体工作内容
        JobDetail jobDetail = JobBuilder.newJob(
                o.getClass())
                .withIdentity(o.getClass().getName(),
                        o.getClass().getName() + "group")
                .build();


        //设置触发器，默认30秒
        SimpleScheduleBuilder simpleScheduleBuilder = SimpleScheduleBuilder.simpleSchedule()
                .withIntervalInSeconds(hashMap.get("ftpScanInterval") == null
                        ? Constant.FTP_SCAN_INTERVAL : Integer.parseInt(hashMap.get("ftpScanInterval")))
                .repeatForever();


        Trigger trigger = TriggerBuilder.newTrigger().withIdentity(o.getClass().getName(), o.getClass().getName() + "group")
                .startNow().withSchedule(simpleScheduleBuilder).build();


        //加入调度器管理
        scheduler.scheduleJob(jobDetail, trigger);
    }

    private void inti() throws Exception {
        JobService.hashMap = new HashMap<>(16);
        Properties config = new Properties();
        InputStream inStream;
        String confFileName = "src/main/resources/quartz.properties";
        inStream = new FileInputStream(confFileName);
        config.load(inStream);
        Set set = config.keySet();
        for (Object o : set) {
            String keyName = (String) o;
            JobService.hashMap.put(keyName, config.getProperty(keyName));
        }
        inStream.close();
    }
}
