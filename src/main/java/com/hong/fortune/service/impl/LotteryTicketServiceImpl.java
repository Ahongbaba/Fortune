package com.hong.fortune.service.impl;

import com.hong.fortune.exception.BadRequestAlertException;
import com.hong.fortune.repository.LotteryTicketRepository;
import com.hong.fortune.repository.domain.LotteryTicket;
import com.hong.fortune.service.LotteryTicketService;
import com.hong.fortune.service.dto.LotteryTicketDTO;
import com.hong.fortune.service.mapper.LotteryTicketMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * 大乐透彩票
 *
 * @author Ahong
 */
@Service
@RequiredArgsConstructor
public class LotteryTicketServiceImpl implements LotteryTicketService {

    private final LotteryTicketRepository lotteryTicketRepository;

    private final LotteryTicketMapper lotteryTicketMapper;

    @Override
    public Long createOrModify(LotteryTicketDTO lotteryTicketDTO) {
        final LotteryTicket lotteryTicket = lotteryTicketMapper.toEntity(lotteryTicketDTO);
        final LotteryTicket lotteryTicketSave = lotteryTicketRepository.save(lotteryTicket);

        return lotteryTicketSave.getId();
    }

    @Override
    public void updateLastTicket(String issue, String level, Integer bonus, Integer status) {
        final LotteryTicket lotteryTicket = lotteryTicketRepository.findByIssue(issue).orElse(null);
        if (null == lotteryTicket) {
            throw new BadRequestAlertException(BadRequestAlertException.Type.F404);
        }
        lotteryTicket.setLevel(level);
        lotteryTicket.setBonus(bonus);
        lotteryTicket.setStatus(status);
        lotteryTicketRepository.save(lotteryTicket);
    }

}
