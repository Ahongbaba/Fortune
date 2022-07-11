package com.hong.fortune.service.dto;

import com.hong.fortune.enumeration.LotteryNumberType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.Instant;
import java.util.List;

/**
 * @author Ahong
 */
@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class LotteryNumberDTO {
    private Long id;
    private Long lotteryTicketId;
    private Integer issue;
    private List<Integer> redNumber;
    private List<Integer> blueNumber;
    private LotteryNumberType type;
    private Instant gmtLottery;
    private Instant gmtCreate;

    public static LotteryNumberDTO build(LotteryGovDTO dto) {
        return LotteryNumberDTO.builder()
                .issue(dto.getIssue())
                .redNumber(dto.getRedNumber())
                .blueNumber(dto.getBlueNumber())
                .type(LotteryNumberType.WIN)
                .gmtCreate(Instant.now())
                .build();
    }
}
