package com.hong.fortune.repository;

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
}
