package com.hong.fortune.service.dto;

import lombok.Data;

/**
 * @author Ahong
 */
@Data
public class LotteryRandomNumberDTO {
    private Long id;
    private Long lotteryTicketId;
    private Integer firstNumber;
    private Integer secondNumber;
    private Integer thirdNumber;
    private Integer fourthNumber;
    private Integer fifthNumber;
    private Integer sixthNumber;
    private Integer seventhNumber;
}
