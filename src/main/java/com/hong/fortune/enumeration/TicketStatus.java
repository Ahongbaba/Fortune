package com.hong.fortune.enumeration;

import lombok.Getter;

/**
 * 彩票状态
 *
 * @author Ahong
 */
public enum TicketStatus {
    /**
     * 1-待开奖
     * 2-未中奖
     * 3-已中奖
     */
    WAIT_LOTTERY(1),
    LOSE_LOTTERY(2),
    WIN_LOTTERY(3);

    @Getter
    private final Integer code;

    TicketStatus(Integer code) {
        this.code = code;
    }
}
