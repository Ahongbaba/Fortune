package com.hong.fortune.repository.domain;

import com.hong.fortune.common.converter.NumberConverter;
import com.hong.fortune.enumeration.LotteryNumberType;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.Instant;
import java.util.List;

/**
 * 大乐透随机号码表
 *
 * @author Ahong
 */
@Data
@Entity
@Table(name = "lottery_number")
public class LotteryNumber implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 彩票ID
     */
    @Column(name = "lottery_ticket_id")
    private Long lotteryTicketId;

    /**
     * 期号
     */
    @NotNull(message = "must not be null")
    @Size(max = 64)
    @Column(name = "issue")
    private Integer issue;

    @NotNull(message = "must not be null")
    @Convert(converter = NumberConverter.class)
    @Column(name = "red_number")
    private List<Integer> redNumber;

    @NotNull(message = "must not be null")
    @Convert(converter = NumberConverter.class)
    @Column(name = "blue_number")
    private List<Integer> blueNumber;

    @NotNull(message = "must not be null")
    @Column(name = "type")
    private LotteryNumberType type;

    @Column(name = "gmt_lottery")
    private Instant gmtLottery;

    @NotNull(message = "must not be null")
    @Column(name = "gmt_create", updatable = false)
    private Instant gmtCreate = Instant.now();
}
