package com.blacktensor.stockWeb.entity;

import lombok.*;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of="listNo")
@ToString
@Entity
public class WishItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "listNo")
    private Long listNo;

    @ManyToOne
    @JoinColumn(name = "memberNo", nullable = false)
    private Member member;

    @Column(nullable = false)
    private String stockName;

    @Column(nullable = false)
    private String stockCode;
}
