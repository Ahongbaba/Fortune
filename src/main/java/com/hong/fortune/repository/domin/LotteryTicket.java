package com.hong.fortune.repository.domin;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.Instant;

/**
 * 大乐透彩票表
 *
 * @author Ahong
 */
@Data
@Entity
@Table(name = "lottery_ticket")
public class LotteryTicket implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 期号
     */
    @NotNull(message = "must not be null")
    @Size(max = 256)
    @Column(name = "issue")
    private String issue;

    /**
     * 是否加注
     */
    @NotNull(message = "must not be null")
    @Max(value = 4)
    @Column(name = "is_filling")
    private Boolean isFilling;

    /**
     * 是否购买
     */
    @NotNull(message = "must not be null")
    @Max(value = 4)
    @Column(name = "is_buy")
    private Boolean isBuy;

    /**
     * 是否中奖
     */
    @NotNull(message = "must not be null")
    @Max(value = 4)
    @Column(name = "is_win")
    private Boolean isWin;

    /**
     * 奖金
     */
    @NotNull(message = "must not be null")
    @Column(name = "bonus")
    private Integer bonus;

    /**
     * 出票方式 1-自动 2-手动
     */
    @NotNull(message = "must not be null")
    @Max(value = 6)
    @Column(name = "generation_type")
    private Integer generationType;

    /**
     * 状态 1-待开奖 2-未中奖 3-已中奖
     */
    @NotNull(message = "must not be null")
    @Max(value = 6)
    @Column(name = "status")
    private Integer status;

    /**
     * 开奖时间
     */
    @NotNull(message = "must not be null")
    @Column(name = "gmt_lottery")
    private Instant gmtLottery;


    @CreatedDate
    @Column(name = "gmt_create", updatable = false)
    private Instant gmtCreate = Instant.now();
}
