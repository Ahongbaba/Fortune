package com.hong.fortune.service.dto;

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
public class LotteryGovDTO {
    private Integer issue;
    private Instant gmtLottery;
    private List<Integer> redNumber;
    private List<Integer> blueNumber;
}
