package com.blacktensor.stockWeb.service;

import com.blacktensor.stockWeb.entity.TradeHistory;

import java.util.List;

public interface TradeHistoryService {
    public void insertBuyHistory(TradeHistory history) throws Exception;
    public void insertSellHistory(TradeHistory history) throws Exception;
    public List<TradeHistory> getTotalHistory(String apiId) throws Exception;
    public List<TradeHistory> getHistoryByStockName(String apiId, String stockName) throws Exception;
}
