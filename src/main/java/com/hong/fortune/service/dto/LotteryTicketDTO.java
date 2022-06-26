package com.hong.fortune.service.dto;

import lombok.Data;

import java.time.Instant;

/**
 * @author Ahong
 */
@Data
public class LotteryTicketDTO {
    private Long id;
    private String issue;
    private Boolean isFilling;
    private Boolean isBuy;
    private Boolean isWin;
    private Integer bonus;
    private Integer generationType;
    private Integer status;
    private Instant gmtLottery;
    private Instant gmtCreate;
}
