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
     * @return 号码ID
     */
    void createOrModify(List<LotteryNumberDTO> lotteryNumberDTOList);
}
