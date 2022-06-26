package com.hong.fortune.repository.domin;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * 大乐透随机号码表
 *
 * @author Ahong
 */
@Data
@Entity
@Table(name = "lottery_random_number")
public class LotteryRandomNumber implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 彩票ID
     */
    @NotNull(message = "must not be null")
    @Column(name = "lottery_ticket_id")
    private Long lotteryTicketId;

    @NotNull(message = "must not be null")
    @Column(name = "first_number")
    private Integer firstNumber;

    @NotNull(message = "must not be null")
    @Column(name = "second_number")
    private Integer secondNumber;

    @NotNull(message = "must not be null")
    @Column(name = "third_number")
    private Integer thirdNumber;

    @NotNull(message = "must not be null")
    @Column(name = "fourth_number")
    private Integer fourthNumber;

    @NotNull(message = "must not be null")
    @Column(name = "fifth_number")
    private Integer fifthNumber;

    @NotNull(message = "must not be null")
    @Column(name = "sixth_number")
    private Integer sixthNumber;

    @NotNull(message = "must not be null")
    @Column(name = "seventh_number")
    private Integer seventhNumber;
}
