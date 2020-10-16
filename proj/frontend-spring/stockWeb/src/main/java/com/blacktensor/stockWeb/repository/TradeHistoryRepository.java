package com.blacktensor.stockWeb.repository;

import com.blacktensor.stockWeb.entity.Member;
import com.blacktensor.stockWeb.entity.TradeHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface TradeHistoryRepository extends JpaRepository<TradeHistory, Long> {
    public List<TradeHistory> findByMember(Member member);
    public List<TradeHistory> findByMemberAndStockName(Member member, String stockName);
    public List<TradeHistory> findByMemberAndTradeType(Member member, String tradeType);
    public List<TradeHistory> findByMemberAndEventDateBetween(Member member, Date startDate, Date endDate);
    public List<TradeHistory> findByMemberAndStockNameAndTradeType(Member member, String stockName, String tradeType);
    public List<TradeHistory> findByMemberAndStockNameAndEventDateBetween(Member member, String stockName, Date startDate, Date endDate);
}
