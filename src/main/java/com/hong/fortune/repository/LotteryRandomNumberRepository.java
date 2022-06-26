package com.hong.fortune.repository;

import com.hong.fortune.repository.domin.LotteryRandomNumber;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * 大乐透随机号码
 *
 * @author Ahong
 */
public interface LotteryRandomNumberRepository extends JpaRepository<LotteryRandomNumber, Long>, JpaSpecificationExecutor<LotteryRandomNumber> {
}
