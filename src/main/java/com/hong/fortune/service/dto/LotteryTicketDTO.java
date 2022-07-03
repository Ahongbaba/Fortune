package com.hong.fortune.service.dto;

import com.hong.fortune.enumeration.TicketGenerationType;
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
public class LotteryTicketDTO {
    private Long id;
    private Integer issue;
    private Boolean isFilling;
    private String level;
    private Integer bonus;
    private TicketGenerationType generationType;
    private Integer status;
    private Instant gmtLottery;
    private Instant gmtCreate;
}
