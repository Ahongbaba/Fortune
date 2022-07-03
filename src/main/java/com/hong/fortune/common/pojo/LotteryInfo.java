package com.hong.fortune.common.pojo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 中奖信息
 *
 * @author Ahong
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LotteryInfo {
    private String level;
    private Integer bonus;
    private Integer status;
}
