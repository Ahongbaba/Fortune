package com.hong.fortune.Schedule;

import com.hong.fortune.service.CrawlerService;
import com.hong.fortune.service.LotteryNumberService;
import com.hong.fortune.service.LotteryTicketService;
import com.hong.fortune.service.dto.LotteryGovDTO;
import com.hong.fortune.service.dto.LotteryNumberDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableScheduling;
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

    private final LotteryNumberService lotteryNumberService;

    private final LotteryTicketService lotteryTicketService;

    private final CrawlerService crawlerService;

//    @Scheduled(cron = "0 0 22 ? 1-12 2,4,7 *")
    public void lottoRandom() {
        log.info("lottoRandom time: {}", System.currentTimeMillis() / 1000);
        // 爬虫获取大乐透上期开奖数据
        final LotteryGovDTO lastLotteryGov = crawlerService.getLotteryGov();
        String lastIssue = lastLotteryGov.getIssue();
        // 创建上期中奖号码
        final LotteryNumberDTO lastLotteryNumberDTO = LotteryNumberDTO.build(lastLotteryGov);
        // TODO: 2022/6/26 获取用户已购买的彩票 -等待用户模块开发
        // TODO: 2022/6/26 计算中奖等级和金额
        String level = "";
        int bonus = 0;
        int status = 0;
        // 更新上期彩票状态、奖金
        lotteryTicketService.updateLastTicket(lastIssue, level, bonus, status);

        // TODO: 2022/6/26 随机生成号码
        // TODO: 2022/6/26 创建本期彩票
    }
}
