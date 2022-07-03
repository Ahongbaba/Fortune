package com.hong.fortune.service.impl;

import com.hong.fortune.repository.LotteryNumberRepository;
import com.hong.fortune.repository.domain.LotteryNumber;
import com.hong.fortune.service.LotteryNumberService;
import com.hong.fortune.service.dto.LotteryNumberDTO;
import com.hong.fortune.service.mapper.LotteryNumberMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Ahong
 */
@Service
@RequiredArgsConstructor
public class LotteryNumberServiceImpl implements LotteryNumberService {

    private final LotteryNumberRepository lotteryNumberRepository;

    private final LotteryNumberMapper lotteryNumberMapper;

    @Override
    public void createOrModify(List<LotteryNumberDTO> lotteryNumberDTOList) {
        final List<LotteryNumber> lotteryNumbers = lotteryNumberMapper.toEntity(lotteryNumberDTOList);
        lotteryNumberRepository.saveAll(lotteryNumbers);
    }

    @Override
    public List<LotteryNumberDTO> getNumbersByTicketIds(List<Long> ticketIds) {
        final List<LotteryNumber> lotteryNumbers = lotteryNumberRepository.findByLotteryTicketIdIn(ticketIds);

        return lotteryNumberMapper.toDto(lotteryNumbers);
    }
}
