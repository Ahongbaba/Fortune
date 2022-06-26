package com.hong.fortune.Schedule;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * 获取随机数定时任务
 *
 * @author Ahong
 */
@Component
@EnableScheduling
@Async
@Slf4j
@RequiredArgsConstructor
public class RandomTask {


    @Scheduled(cron = "0 0 21 ? 1-12 2,4,7 *")
    public void lottoRandom() {
        log.info("lottoRandom time: {}", System.currentTimeMillis() / 1000);
        
    }
}
