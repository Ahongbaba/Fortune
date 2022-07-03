package com.hong.fortune.repository;

import com.hong.fortune.repository.domain.LotteryTicket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 大乐透彩票
 *
 * @author Ahong
 */
@Repository
public interface LotteryTicketRepository extends JpaRepository<LotteryTicket, Long>, JpaSpecificationExecutor<LotteryTicket> {

    /**
     * 通过 期号 查询
     *
     * @param issue 期号
     * @return 详情
     */
    List<LotteryTicket> findByIssue(Integer issue);
}
