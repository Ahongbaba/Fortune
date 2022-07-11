package com.hong.fortune.repository;

import com.hong.fortune.enumeration.LotteryNumberType;
import com.hong.fortune.repository.domain.LotteryNumber;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 大乐透随机号码
 *
 * @author Ahong
 */
@Repository
public interface LotteryNumberRepository extends JpaRepository<LotteryNumber, Long>, JpaSpecificationExecutor<LotteryNumber> {

    /**
     * 通过彩票IDS获取列表
     *
     * @param lotteryIdTickets 彩票IDS
     * @return 列表
     */
    List<LotteryNumber> findByLotteryTicketIdIn(List<Long> lotteryIdTickets);

    /**
     * 通过期号和生成类型获取
     * 用于检查本期是否已存储过中奖就号码
     *
     * @param issue 期号
     * @param type 类型
     * @return 中奖号码
     */
    LotteryNumber findByIssueAndType(Integer issue, LotteryNumberType type);
}
