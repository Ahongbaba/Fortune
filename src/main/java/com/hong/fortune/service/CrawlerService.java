package com.hong.fortune.service;

import com.hong.fortune.service.dto.LotteryGovDTO;

/**
 * 爬虫
 *
 * @author Ahong
 */
public interface CrawlerService {

    /**
     * 获取大乐透网站信息
     *
     * @return LotteryGovDTO
     */
    LotteryGovDTO getLotteryGov();
}
