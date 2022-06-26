package com.hong.fortune.repository;

import com.hong.fortune.repository.domin.LotteryTicket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 * 大乐透彩票
 *
 * @author Ahong
 */
@Repository
public interface LotteryTicketRepository extends JpaRepository<LotteryTicket, Long>, JpaSpecificationExecutor<LotteryTicket> {
}
