package com.blacktensor.stockWeb.service;

import com.blacktensor.stockWeb.entity.TradeHistory;

import java.util.List;

public interface TradeHistoryService {
    public void insertBuyHistory(TradeHistory history) throws Exception;
    public void insertSellHistory(TradeHistory history) throws Exception;
    public List<TradeHistory> getTotalHistory(String apiId) throws Exception;
    public List<TradeHistory> getHistoryByStockName(String apiId, String stockName) throws Exception;
    public List<TradeHistory> getTotalHistoryByType(String apiId, String type) throws Exception;
    public List<TradeHistory> getTotalHistoryByDate(String apiId, String datestr)throws Exception;
    public List<TradeHistory> getTotalHistoryByPeriod(String apiId, String startstr, String endstr) throws Exception;
    public List<TradeHistory> getHistoryByStockNameAndType(String apiId, String stockName, String type) throws Exception;
    public List<TradeHistory> getHistoryByStockNameAndDate(String apiId, String stockName, String datestr) throws Exception;
    public List<TradeHistory> getHistoryByStockNameAndPriod(String apiId, String stockName, String startstr, String endstr) throws Exception;
}
