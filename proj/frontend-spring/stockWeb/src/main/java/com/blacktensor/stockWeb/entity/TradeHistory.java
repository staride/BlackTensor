package com.blacktensor.stockWeb.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Data
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of="historyNo")
@ToString
@Entity
public class TradeHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "historyNo")
    private Long historyNo;

    @ManyToOne
    @JoinColumn(name = "memberNo", nullable = false)
    private Member memberNo;

    @Column(nullable = false)
    private String stockName;

    @Column(nullable = false)
    private String stockCode;

    @Column(nullable = false)
    private String tradeType;

    @Column(nullable = true)
    private String buyPrice;

    @Column(nullable = true)
    private String sellPrice;

    @Column(nullable = true)
    private String diffPrice;

    @Column(nullable = true)
    private String yield;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(nullable = false, columnDefinition = "timestamp default now()", name = "regdate")
    private Date regDate;
}
