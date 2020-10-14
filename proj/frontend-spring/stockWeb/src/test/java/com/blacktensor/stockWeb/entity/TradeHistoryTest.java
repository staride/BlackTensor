package com.blacktensor.stockWeb.entity;

import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class TradeHistoryTest {

    @Test
    void testEquals() {
        final TradeHistory history1 = new TradeHistory();
        final TradeHistory history2 = new TradeHistory();

        history1.setHistoryNo(Long.valueOf(1));
        history2.setHistoryNo(Long.valueOf(1));

        assertEquals(history1, history2);
    }

    @Test
    void getHistoryNo() {
        final TradeHistory history = new TradeHistory();
        history.setHistoryNo(Long.valueOf(1));

        assertEquals(1, history.getHistoryNo());
    }

    @Test
    void getMember() {
        final TradeHistory history = new TradeHistory();
        final Member member1 = new Member();

        member1.setMemberNo(Long.valueOf(1));
        history.setMember(member1);

        final Member member2 = new Member();
        member2.setMemberNo(Long.valueOf(1));

        assertEquals(member2, history.getMember());
    }

    @Test
    void getStockName() {
        final TradeHistory history = new TradeHistory();
        history.setStockName("StockName");

        assertEquals("StockName", history.getStockName());
    }

    @Test
    void getStockCode() {
        final TradeHistory history = new TradeHistory();
        history.setStockCode("000000");

        assertEquals("000000", history.getStockCode());
    }

    @Test
    void getTradeType() {
        final TradeHistory history = new TradeHistory();
        history.setTradeType("Buy");

        assertEquals("Buy", history.getTradeType());
    }

    @Test
    void getBuyPrice() {
        final TradeHistory history = new TradeHistory();
        history.setBuyPrice("1000");

        assertEquals("1000", history.getBuyPrice());
    }

    @Test
    void getBuyCount() {
        final TradeHistory history = new TradeHistory();
        history.setBuyCount("10");

        assertEquals("10", history.getBuyCount());

    }

    @Test
    void getSellPrice() {
        final TradeHistory history = new TradeHistory();
        history.setSellPrice("1000");

        assertEquals("1000", history.getSellPrice());
    }

    @Test
    void getSellCount() {
        final TradeHistory history = new TradeHistory();
        history.setSellCount("10");

        assertEquals("10", history.getSellCount());
    }

    @Test
    void getDiffPrice() {
        final TradeHistory history = new TradeHistory();
        history.setDiffPrice("5000");

        assertEquals("5000", history.getDiffPrice());
    }

    @Test
    void getYield() {
        final TradeHistory history = new TradeHistory();
        history.setYield("10%");

        assertEquals("10%", history.getYield());
    }

    @Test
    void getHistoryDate() throws ParseException {
        final TradeHistory history = new TradeHistory();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = format.parse("2020-10-14 12:00:00");
        history.setHistoryDate(date);

        assertEquals("2020-10-14 12:00:00", format.format(history.getHistoryDate()));
    }

    @Test
    void getEventDate() throws ParseException {
        final TradeHistory history = new TradeHistory();

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = format.parse("2020-10-14 18:00:00");
        history.setEventDate(date);

        assertEquals("2020-10-14 18:00:00", format.format(history.getEventDate()));
    }
}