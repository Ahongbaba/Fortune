package com.hong.fortune.service;

import com.hong.fortune.service.dto.LotteryRandomNumberDTO;
import com.hong.fortune.service.dto.LotteryTicketDTO;

import java.util.List;

/**
 * @author Ahong
 */
public interface LotteryService {
    /**
     * 创建彩票
     *
     * @param lotteryTicketDTO lotteryTicketDTO
     * @param lotteryRandomNumberDTOList lotteryRandomNumberDTOList
     * @return 彩票ID
     */
    Long create(LotteryTicketDTO lotteryTicketDTO, List<LotteryRandomNumberDTO> lotteryRandomNumberDTOList);
}
