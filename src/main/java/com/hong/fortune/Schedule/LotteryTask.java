package com.hong.fortune.Schedule;

import com.hong.fortune.common.pojo.LotteryInfo;
import com.hong.fortune.common.utils.LotteryUtil;
import com.hong.fortune.enumeration.TicketGenerationType;
import com.hong.fortune.enumeration.TicketStatus;
import com.hong.fortune.service.CrawlerService;
import com.hong.fortune.service.LotteryNumberService;
import com.hong.fortune.service.LotteryTicketService;
import com.hong.fortune.service.dto.LotteryGovDTO;
import com.hong.fortune.service.dto.LotteryNumberDTO;
import com.hong.fortune.service.dto.LotteryTicketDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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
public class LotteryTask {

    private final LotteryNumberService lotteryNumberService;

    private final LotteryTicketService lotteryTicketService;

    private final CrawlerService crawlerService;

    //    @Scheduled(cron = "0 0 22 ? 1-12 2,4,7 *")
    public void getLastAndBuildCurrent() {
        log.info("lottoRandom time: {}", System.currentTimeMillis() / 1000);
        // 爬虫获取大乐透上期开奖数据
        final LotteryGovDTO lastLotteryGov = crawlerService.getLotteryGov();

        // 保存上期中奖号码
        saveLastWinNumber(lastLotteryGov);

        // 更新上期彩票中奖信息
        updateLastTickets(lastLotteryGov);

        // TODO: 2022/6/26 获取用户已购买的彩票 -等待用户模块开发

        //  创建本期彩票
        final LotteryTicketDTO currentTicket = LotteryTicketDTO.builder()
                .issue(lastLotteryGov.getIssue() + 1)
                .isFilling(false) // TODO: 2022/7/3 等待开发加注
                .generationType(TicketGenerationType.AUTO)
                .status(TicketStatus.WAIT_LOTTERY.getCode())
                .build();
        final Long currentTicketId = lotteryTicketService.createOrModify(currentTicket);
        // 随机生成号码
        final List<LotteryNumberDTO> currentNumbers = LotteryUtil.randomNumbers(currentTicketId, lastLotteryGov.getIssue() + 1);
        lotteryNumberService.createOrModify(currentNumbers);
    }

    private void updateLastTickets(LotteryGovDTO lastLotteryGov) {
        final Integer lastIssue = lastLotteryGov.getIssue();
        // 获取上期彩票
        final List<LotteryTicketDTO> lastTickets = lotteryTicketService.getTicketsByIssue(lastIssue);
        final List<Long> lastTicketIds = lastTickets.stream().map(LotteryTicketDTO::getId).collect(Collectors.toList());
        // 获取对应的彩票号码
        final List<LotteryNumberDTO> allLastNumbers = lotteryNumberService.getNumbersByTicketIds(lastTicketIds);
        final Map<Long, List<LotteryNumberDTO>> allLastNumberMap = allLastNumbers
                .stream().collect(Collectors.groupingBy(LotteryNumberDTO::getLotteryTicketId));
        // 计算每张彩票的中奖金额
        lastTickets.forEach(e -> {
            // 单张彩票可能有多注号码
            final List<LotteryNumberDTO> lastNumbers = allLastNumberMap.get(e.getId());
            lastNumbers.forEach(n -> {
                // 计算彩票，获取彩票信息
                final LotteryInfo lotteryInfo = LotteryUtil.getLotteryInfo(n.getRedNumber(), n.getBlueNumber(),
                        lastLotteryGov.getRedNumber(), lastLotteryGov.getBlueNumber());

                // 更新上期彩票状态、奖金
                lotteryTicketService.updateLastTicket(e.getId(), lotteryInfo.getLevel(),
                        lotteryInfo.getBonus(), lotteryInfo.getStatus());
            });
        });
    }

    private void saveLastWinNumber(LotteryGovDTO lastLotteryGov) {
        final LotteryNumberDTO lastWinNumber = LotteryNumberDTO.build(lastLotteryGov);
        final List<LotteryNumberDTO> lastWinNumbers = new ArrayList<>();
        lastWinNumbers.add(lastWinNumber);
        lotteryNumberService.createOrModify(lastWinNumbers);
    }

}
