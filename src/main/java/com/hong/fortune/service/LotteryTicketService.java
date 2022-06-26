package com.hong.fortune.service;

import com.hong.fortune.service.dto.LotteryTicketDTO;

/**
 * 彩票
 *
 * @author Ahong
 */
public interface LotteryTicketService {
    /**
     * 创建/修改 彩票
     *
     * @param lotteryTicketDTO lotteryTicketDTO
     * @return 彩票ID
     */
    Long createOrModify(LotteryTicketDTO lotteryTicketDTO);

    /**
     * 更新上期彩票
     *
     * @param issue 期数
     * @param level 几等奖
     * @param bonus 奖金
     * @param status 状态
     */
    void updateLastTicket(String issue, String level, Integer bonus, Integer status);
}
