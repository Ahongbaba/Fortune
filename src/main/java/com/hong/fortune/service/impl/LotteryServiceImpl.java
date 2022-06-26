package com.hong.fortune.service.impl;

import com.hong.fortune.repository.LotteryRandomNumberRepository;
import com.hong.fortune.repository.LotteryTicketRepository;
import com.hong.fortune.repository.domin.LotteryRandomNumber;
import com.hong.fortune.repository.domin.LotteryTicket;
import com.hong.fortune.service.LotteryService;
import com.hong.fortune.service.dto.LotteryRandomNumberDTO;
import com.hong.fortune.service.dto.LotteryTicketDTO;
import com.hong.fortune.service.mapper.LotteryRandomNumberMapper;
import com.hong.fortune.service.mapper.LotteryTicketMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 大乐透彩票
 *
 * @author Ahong
 */
@Service
@RequiredArgsConstructor
public class LotteryServiceImpl implements LotteryService {

    private final LotteryTicketRepository lotteryTicketRepository;

    private final LotteryRandomNumberRepository lotteryRandomNumberRepository;

    private final LotteryTicketMapper lotteryTicketMapper;

    private final LotteryRandomNumberMapper lotteryRandomNumberMapper;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Long create(LotteryTicketDTO lotteryTicketDTO, List<LotteryRandomNumberDTO> lotteryRandomNumberDTOList) {
        final LotteryTicket lotteryTicket = lotteryTicketMapper.toEntity(lotteryTicketDTO);
        final LotteryTicket lotteryTicketSave = lotteryTicketRepository.save(lotteryTicket);
        final Long lotteryTicketId = lotteryTicketSave.getId();
        lotteryRandomNumberDTOList.forEach(e -> e.setLotteryTicketId(lotteryTicketId));

        final List<LotteryRandomNumber> lotteryRandomNumbers = lotteryRandomNumberDTOList.stream().map(e -> {
            e.setLotteryTicketId(lotteryTicketId);
            return lotteryRandomNumberMapper.toEntity(e);
        }).collect(Collectors.toList());
        lotteryRandomNumberRepository.saveAll(lotteryRandomNumbers);
        return lotteryTicketId;
    }
}
