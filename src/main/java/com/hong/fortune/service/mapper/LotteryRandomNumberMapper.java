package com.hong.fortune.service.mapper;

import com.hong.fortune.repository.domin.LotteryRandomNumber;
import com.hong.fortune.service.dto.LotteryRandomNumberDTO;
import org.mapstruct.Mapper;

/**
 * @author Ahong
 */
@Mapper(componentModel = "spring")
public interface LotteryRandomNumberMapper extends EntityMapper<LotteryRandomNumberDTO, LotteryRandomNumber> {}
