package com.hong.fortune.service;

import com.hong.fortune.service.dto.LotteryTicketDTO;

import java.util.List;

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
     * @param id id
     * @param level 几等奖
     * @param bonus 奖金
     * @param status 状态
     */
    void updateLastTicket(Long id, String level, Integer bonus, Integer status);

    /**
     * 获取彩票 by issue
     *
     * @param issue 期数
     * @return 彩票集合
     */
    List<LotteryTicketDTO> getTicketsByIssue(Integer issue);
}
