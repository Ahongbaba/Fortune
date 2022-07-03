package com.hong.fortune.service;

import com.hong.fortune.service.dto.LotteryNumberDTO;

import java.util.List;

/**
 * 号码
 *
 * @author Ahong
 */
public interface LotteryNumberService {
    /**
     * 创建/修改号码
     *
     * @param lotteryNumberDTOList lotteryNumberDTOList
     */
    void createOrModify(List<LotteryNumberDTO> lotteryNumberDTOList);

    /**
     * 获取号码 by 彩票IDs
     * @param ticketIds 彩票ids
     *
     * @return 号码列表
     */
    List<LotteryNumberDTO> getNumbersByTicketIds(List<Long> ticketIds);
}
