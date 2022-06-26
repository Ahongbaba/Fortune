package com.hong.fortune.service.dto;

import com.hong.fortune.enumeration.LotteryNumberType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

/**
 * @author Ahong
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LotteryNumberDTO {
    private Long id;
    private Long lotteryTicketId;
    private String issue;
    private String firstNumber;
    private String secondNumber;
    private String thirdNumber;
    private String fourthNumber;
    private String fifthNumber;
    private String sixthNumber;
    private String seventhNumber;
    private LotteryNumberType type;
    private Instant gmtLottery;
    private Instant gmtCreate;

    public static LotteryNumberDTO build(LotteryGovDTO dto) {
        return LotteryNumberDTO.builder()
                .issue(dto.getIssue())
                .firstNumber(dto.getFirstNumber())
                .secondNumber(dto.getSecondNumber())
                .thirdNumber(dto.getThirdNumber())
                .fourthNumber(dto.getFourthNumber())
                .fifthNumber(dto.getFifthNumber())
                .sixthNumber(dto.getSixthNumber())
                .seventhNumber(dto.getSeventhNumber())
                .type(LotteryNumberType.WIN)
                .gmtLottery(dto.getGmtLottery())
                .build();
    }
}
