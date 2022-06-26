package com.hong.fortune.service.dto;

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
public class LotteryGovDTO {
    private String issue;
    private String firstNumber;
    private String secondNumber;
    private String thirdNumber;
    private String fourthNumber;
    private String fifthNumber;
    private String sixthNumber;
    private String seventhNumber;
    private Instant gmtLottery;
}
