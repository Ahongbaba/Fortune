package com.hong.fortune.service.mapper;

import com.hong.fortune.repository.domain.LotteryNumber;
import com.hong.fortune.service.dto.LotteryNumberDTO;
import org.mapstruct.Mapper;

/**
 * @author Ahong
 */
@Mapper(componentModel = "spring")
public interface LotteryNumberMapper extends EntityMapper<LotteryNumberDTO, LotteryNumber> {}
