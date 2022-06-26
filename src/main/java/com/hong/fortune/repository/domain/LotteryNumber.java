package com.hong.fortune.repository.domain;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.Instant;

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
    private String issue;

    @NotNull(message = "must not be null")
    @Column(name = "first_number")
    private String firstNumber;

    @NotNull(message = "must not be null")
    @Column(name = "second_number")
    private String secondNumber;

    @NotNull(message = "must not be null")
    @Column(name = "third_number")
    private String thirdNumber;

    @NotNull(message = "must not be null")
    @Column(name = "fourth_number")
    private String fourthNumber;

    @NotNull(message = "must not be null")
    @Column(name = "fifth_number")
    private String fifthNumber;

    @NotNull(message = "must not be null")
    @Column(name = "sixth_number")
    private String sixthNumber;

    @NotNull(message = "must not be null")
    @Column(name = "seventh_number")
    private String seventhNumber;

    @NotNull(message = "must not be null")
    @Column(name = "type")
    private String type;

    @NotNull(message = "must not be null")
    @Column(name = "gmt_lottery")
    private Instant gmtLottery;

    @NotNull(message = "must not be null")
    @Column(name = "gmt_create", updatable = false)
    private Instant gmtCreate = Instant.now();
}
