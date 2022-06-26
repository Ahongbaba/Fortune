package com.hong.fortune.repository;

import com.hong.fortune.repository.domain.LotteryNumber;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 * 大乐透随机号码
 *
 * @author Ahong
 */
@Repository
public interface LotteryNumberRepository extends JpaRepository<LotteryNumber, Long>, JpaSpecificationExecutor<LotteryNumber> {
}
