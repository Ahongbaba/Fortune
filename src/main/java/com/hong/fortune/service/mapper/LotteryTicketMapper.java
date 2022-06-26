package com.hong.fortune.service.mapper;

import com.hong.fortune.repository.domain.LotteryTicket;
import com.hong.fortune.service.dto.LotteryTicketDTO;
import org.mapstruct.Mapper;

/**
 * @author Ahong
 */
@Mapper(componentModel = "spring")
public interface LotteryTicketMapper extends EntityMapper<LotteryTicketDTO, LotteryTicket> {}
