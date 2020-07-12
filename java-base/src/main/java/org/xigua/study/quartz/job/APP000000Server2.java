package org.xigua.study.quartz.job;

import org.quartz.DisallowConcurrentExecution;
import org.quartz.JobExecutionContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * @author 山五洲
 */
@Service
@DisallowConcurrentExecution
public class APP000000Server2 extends AbstractServer {

    private static final Logger LOGGER = LoggerFactory.getLogger(APP000000Server2.class);


    @Override
    public void execute(JobExecutionContext context) {
        LOGGER.info("当前线程" + Thread.currentThread().getName());

        System.out.println("测试定时任务APP000000Server2");


    }

}
