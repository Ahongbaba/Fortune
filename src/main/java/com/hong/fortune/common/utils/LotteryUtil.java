package com.hong.fortune.common.utils;

import com.hong.fortune.common.pojo.LotteryInfo;
import com.hong.fortune.enumeration.LotteryNumberType;
import com.hong.fortune.enumeration.TicketStatus;
import com.hong.fortune.service.dto.LotteryNumberDTO;

import java.util.*;

/**
 * @author Ahong
 */
public class LotteryUtil {

    /**
     * 计算获取中奖信息
     *
     * @param redNumber 红球
     * @param blueNumber 篮球
     * @param redWinNumber 正确红球
     * @param blueWinNumber 正确蓝球
     * @return 中奖信息
     */
    public static LotteryInfo getLotteryInfo(List<Integer> redNumber, List<Integer> blueNumber,
                                             List<Integer> redWinNumber, List<Integer> blueWinNumber) {
        // 红球对比
        int redEqual = 0;
        for (Integer checkRed : redNumber) {
            for (Integer winRed : redWinNumber) {
                if (checkRed.equals(winRed)) {
                    ++redEqual;
                }
            }
        }
        // 蓝球对比
        int blueEqual = 0;
        for (Integer checkBlue : blueNumber) {
            for (Integer winBlue : blueWinNumber) {
                if (checkBlue.equals(winBlue)) {
                    ++blueEqual;
                }
            }
        }

        String level = "";
        int bonus = 0;
        int status = TicketStatus.WIN_LOTTERY.getCode();
        // 计算中奖等级和金额
        if (redEqual == 5 && blueEqual == 2) {
            // TODO: 2022/7/3 一等奖
        } else if (redEqual == 5 && blueEqual == 1) {
            // TODO: 2022/7/3 二等奖
        } else if (redEqual == 5 && blueEqual == 0) {
            level = "三等奖";
            bonus = 10000;
        } else if (redEqual == 4 && blueEqual == 2) {
            level = "四等奖";
            bonus = 3000;
        } else if (redEqual == 4 && blueEqual == 1) {
            level = "五等奖";
            bonus = 300;
        } else if (redEqual == 3 && blueEqual == 2) {
            level = "六等奖";
            bonus = 200;
        } else if (redEqual == 4 && blueEqual == 0) {
            level = "七等奖";
            bonus = 100;
        } else if ((redEqual == 3 && blueEqual == 1)
                || (redEqual == 2 && blueEqual == 2)) {
            level = "八等奖";
            bonus = 15;
        } else if ((redEqual == 3 && blueEqual == 0)
                || (redEqual == 1 && blueEqual == 2)
                || (redEqual == 2 && blueEqual == 1)
                || (redEqual == 0 && blueEqual == 2)) {
            level = "九等奖";
            bonus = 5;
        } else {
            level = "未中奖";
            status = TicketStatus.LOSE_LOTTERY.getCode();
        }

        return LotteryInfo.builder()
                .level(level)
                .bonus(bonus)
                .status(status)
                .build();
    }

    /**
     * 随机生成号码
     *
     * @param ticketId 彩票ID
     * @param issue 期号
     * @return 生成的号码
     */
    public static List<LotteryNumberDTO> randomNumbers(Long ticketId, Integer issue) {
        // 随机生成号码
        final Random random = new Random();
        // 随机几注
        final int notes = random.nextInt(5) + 1;
        // 随机号码
        final List<LotteryNumberDTO> currentNumbers = new ArrayList<>();
        for (int i = 0; i < notes; i++) {
            final Set<Integer> redSet = new HashSet<>();
            while (redSet.size() != 5) {
                redSet.add(random.nextInt(35) + 1);
            }
            final Set<Integer> blueSet = new HashSet<>();
            while (blueSet.size() != 2) {
                blueSet.add(random.nextInt(12) + 1);
            }
            final List<Integer> redNumber = new ArrayList<>(redSet);
            final List<Integer> blueNumber = new ArrayList<>(blueSet);

            final LotteryNumberDTO currentNumber = LotteryNumberDTO.builder()
                    .lotteryTicketId(ticketId)
                    .issue(issue)
                    .redNumber(redNumber)
                    .blueNumber(blueNumber)
                    .type(LotteryNumberType.AUTO)
                    .build();
            currentNumbers.add(currentNumber);
        }
        return currentNumbers;
    }
}
