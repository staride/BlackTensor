package com.blacktensor.stockWeb.util;

import com.blacktensor.stockWeb.entity.Member;
import com.blacktensor.stockWeb.entity.TradeHistory;
import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import static org.junit.jupiter.api.Assertions.*;

class ValidateUtilTest {

    @Test
    void validateLoginInfo(){
        String id = "test@test.com";
        String password = "123456";

        assertTrue(ValidateUtil.validateLoginInfo(id, password));
    }

    @Test
    void validateLoginInfoDataEmptyId(){
        String id = "";
        String password = "123456";

        assertFalse(ValidateUtil.validateLoginInfo(id, password));
    }

    @Test
    void validateSignupInfoDataBlankId() {
        String id = " ";
        String password = "123456";

        assertFalse(ValidateUtil.validateLoginInfo(id, password));
    }

    @Test
    void validateSignupInfoDataEmptyPw() {
        String id = "test@test.com";
        String password = "";

        assertFalse(ValidateUtil.validateLoginInfo(id, password));
    }

    @Test
    void validateSignupInfoDataBlankPw() {
        String id = "test@test.com";
        String password = " ";

        assertFalse(ValidateUtil.validateLoginInfo(id, password));
    }

    @Test
    void validateSignupInfoDataEmptyIdAndPw() {
        String id = "";
        String password = "";

        assertFalse(ValidateUtil.validateLoginInfo(id, password));
    }

    @Test
    void validateSignupInfoDataBlankIdAndPw() {
        String id = " ";
        String password = " ";

        assertFalse(ValidateUtil.validateLoginInfo(id, password));
    }

    @Test
    void validateSignupInfoDataNullIdAndPw() {
        String id = null;
        String password = null;

        assertFalse(ValidateUtil.validateLoginInfo(id, password));
    }

    @Test
    void validateSignupInfoDataNullId() {
        String id = null;
        String password = "123456";

        assertFalse(ValidateUtil.validateLoginInfo(id, password));
    }

    @Test
    void validateSignupInfoDataNullPw() {
        String id = "test@test.com";
        String password = null;

        assertFalse(ValidateUtil.validateLoginInfo(id, password));
    }

    @Test
    void validateBuyHistoryInfo() throws ParseException {
        TradeHistory history = new TradeHistory();
        history.setStockCode("000000");
        history.setStockName("Stock");
        history.setBuyPrice("1000");
        history.setBuyCount("10");

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        history.setEventDate(format.parse("2020-10-14 17:00:00"));

        Member member = new Member();
        member.setApiId("test");
        history.setMember(member);

        assertTrue(ValidateUtil.validateBuyHistoryInfo(history));
    }

    @Test
    void validateBuyHistoryInfoDataNull() throws ParseException {
        TradeHistory history = null;
        assertFalse(ValidateUtil.validateBuyHistoryInfo(history));
    }

    @Test
    void validateBuyHistoryInfoDataStockCodeEmpty() throws ParseException {
        TradeHistory history = new TradeHistory();
        history.setStockCode("");
        history.setStockName("Stock");
        history.setBuyPrice("1000");
        history.setBuyCount("10");

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        history.setEventDate(format.parse("2020-10-14 17:00:00"));

        Member member = new Member();
        member.setApiId("test");
        history.setMember(member);

        assertFalse(ValidateUtil.validateBuyHistoryInfo(history));
    }

    @Test
    void validateBuyHistoryInfoDataStockCodeBlank() throws ParseException {
        TradeHistory history = new TradeHistory();
        history.setStockCode(" ");
        history.setStockName("Stock");
        history.setBuyPrice("1000");
        history.setBuyCount("10");

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        history.setEventDate(format.parse("2020-10-14 17:00:00"));

        Member member = new Member();
        member.setApiId("test");
        history.setMember(member);

        assertFalse(ValidateUtil.validateBuyHistoryInfo(history));
    }

    @Test
    void validateBuyHistoryInfoDataStockCodeNull() throws ParseException {
        TradeHistory history = new TradeHistory();
        history.setStockCode(null);
        history.setStockName("Stock");
        history.setBuyPrice("1000");
        history.setBuyCount("10");

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        history.setEventDate(format.parse("2020-10-14 17:00:00"));

        Member member = new Member();
        member.setApiId("test");
        history.setMember(member);

        assertFalse(ValidateUtil.validateBuyHistoryInfo(history));
    }

    @Test
    void validateBuyHistoryInfoDataStockNameEmpty() throws ParseException {
        TradeHistory history = new TradeHistory();
        history.setStockCode("000000");
        history.setStockName("");
        history.setBuyPrice("1000");
        history.setBuyCount("10");

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        history.setEventDate(format.parse("2020-10-14 17:00:00"));

        Member member = new Member();
        member.setApiId("test");
        history.setMember(member);

        assertFalse(ValidateUtil.validateBuyHistoryInfo(history));
    }

    @Test
    void validateBuyHistoryInfoDataStockNameBlank() throws ParseException {
        TradeHistory history = new TradeHistory();
        history.setStockCode("000000");
        history.setStockName(" ");
        history.setBuyPrice("1000");
        history.setBuyCount("10");

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        history.setEventDate(format.parse("2020-10-14 17:00:00"));

        Member member = new Member();
        member.setApiId("test");
        history.setMember(member);

        assertFalse(ValidateUtil.validateBuyHistoryInfo(history));
    }

    @Test
    void validateBuyHistoryInfoDataStockNameNull() throws ParseException {
        TradeHistory history = new TradeHistory();
        history.setStockCode("000000");
        history.setStockName(null);
        history.setBuyPrice("1000");
        history.setBuyCount("10");

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        history.setEventDate(format.parse("2020-10-14 17:00:00"));

        Member member = new Member();
        member.setApiId("test");
        history.setMember(member);

        assertFalse(ValidateUtil.validateBuyHistoryInfo(history));
    }

    @Test
    void validateBuyHistoryInfoDataBuyPriceEmpty() throws ParseException {
        TradeHistory history = new TradeHistory();
        history.setStockCode("000000");
        history.setStockName("Stock");
        history.setBuyPrice("");
        history.setBuyCount("10");

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        history.setEventDate(format.parse("2020-10-14 17:00:00"));

        Member member = new Member();
        member.setApiId("test");
        history.setMember(member);

        assertFalse(ValidateUtil.validateBuyHistoryInfo(history));
    }

    @Test
    void validateBuyHistoryInfoDataBuyPriceBlank() throws ParseException {
        TradeHistory history = new TradeHistory();
        history.setStockCode("000000");
        history.setStockName("Stock");
        history.setBuyPrice(" ");
        history.setBuyCount("10");

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        history.setEventDate(format.parse("2020-10-14 17:00:00"));

        Member member = new Member();
        member.setApiId("test");
        history.setMember(member);

        assertFalse(ValidateUtil.validateBuyHistoryInfo(history));
    }

    @Test
    void validateBuyHistoryInfoDataBuyPriceNull() throws ParseException {
        TradeHistory history = new TradeHistory();
        history.setStockCode("000000");
        history.setStockName("Stock");
        history.setBuyPrice(null);
        history.setBuyCount("10");

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        history.setEventDate(format.parse("2020-10-14 17:00:00"));

        Member member = new Member();
        member.setApiId("test");
        history.setMember(member);

        assertFalse(ValidateUtil.validateBuyHistoryInfo(history));
    }

    @Test
    void validateBuyHistoryInfoDataBuyCountEmpty() throws ParseException {
        TradeHistory history = new TradeHistory();
        history.setStockCode("000000");
        history.setStockName("Stock");
        history.setBuyPrice("1000");
        history.setBuyCount("");

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        history.setEventDate(format.parse("2020-10-14 17:00:00"));

        Member member = new Member();
        member.setApiId("test");
        history.setMember(member);

        assertFalse(ValidateUtil.validateBuyHistoryInfo(history));
    }

    @Test
    void validateBuyHistoryInfoDataBuyCountBlank() throws ParseException {
        TradeHistory history = new TradeHistory();
        history.setStockCode("000000");
        history.setStockName("Stock");
        history.setBuyPrice("1000");
        history.setBuyCount(" ");

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        history.setEventDate(format.parse("2020-10-14 17:00:00"));

        Member member = new Member();
        member.setApiId("test");
        history.setMember(member);

        assertFalse(ValidateUtil.validateBuyHistoryInfo(history));
    }

    @Test
    void validateBuyHistoryInfoDataBuyCountNull() throws ParseException {
        TradeHistory history = new TradeHistory();
        history.setStockCode("000000");
        history.setStockName("Stock");
        history.setBuyPrice("1000");
        history.setBuyCount(null);

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        history.setEventDate(format.parse("2020-10-14 17:00:00"));

        Member member = new Member();
        member.setApiId("test");
        history.setMember(member);

        assertFalse(ValidateUtil.validateBuyHistoryInfo(history));
    }

    @Test
    void validateBuyHistoryInfoDataEventDateNull() throws ParseException {
        TradeHistory history = new TradeHistory();
        history.setStockCode("000000");
        history.setStockName("Stock");
        history.setBuyPrice("1000");
        history.setBuyCount("10");

        history.setEventDate(null);

        Member member = new Member();
        member.setApiId("test");
        history.setMember(member);

        assertFalse(ValidateUtil.validateBuyHistoryInfo(history));
    }

    @Test
    void validateBuyHistoryInfoDataApiIdEmpty() throws ParseException {
        TradeHistory history = new TradeHistory();
        history.setStockCode("000000");
        history.setStockName("Stock");
        history.setBuyPrice("1000");
        history.setBuyCount("10");

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        history.setEventDate(format.parse("2020-10-14 17:00:00"));

        Member member = new Member();
        member.setApiId("");
        history.setMember(member);

        assertFalse(ValidateUtil.validateBuyHistoryInfo(history));
    }

    @Test
    void validateBuyHistoryInfoDataApiIdBlank() throws ParseException {
        TradeHistory history = new TradeHistory();
        history.setStockCode("000000");
        history.setStockName("Stock");
        history.setBuyPrice("1000");
        history.setBuyCount("10");

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        history.setEventDate(format.parse("2020-10-14 17:00:00"));

        Member member = new Member();
        member.setApiId(" ");
        history.setMember(member);

        assertFalse(ValidateUtil.validateBuyHistoryInfo(history));
    }

    @Test
    void validateBuyHistoryInfoDataApiIdNull() throws ParseException {
        TradeHistory history = new TradeHistory();
        history.setStockCode("000000");
        history.setStockName("Stock");
        history.setBuyPrice("1000");
        history.setBuyCount("10");

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        history.setEventDate(format.parse("2020-10-14 17:00:00"));

        Member member = new Member();
        member.setApiId(null);
        history.setMember(member);

        assertFalse(ValidateUtil.validateBuyHistoryInfo(history));
    }

    @Test
    void validateBuyHistoryInfoDataMemberNull() throws ParseException {
        TradeHistory history = new TradeHistory();
        history.setStockCode("000000");
        history.setStockName("Stock");
        history.setBuyPrice("1000");
        history.setBuyCount("10");

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        history.setEventDate(format.parse("2020-10-14 17:00:00"));

        history.setMember(null);

        assertFalse(ValidateUtil.validateBuyHistoryInfo(history));
    }

    @Test
    void validateSellHistoryInfo() throws ParseException {

        TradeHistory history = new TradeHistory();

        history.setStockCode("000000");
        history.setStockName("Stock");
        history.setSellPrice("1000");
        history.setSellCount("10");

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        history.setEventDate(format.parse("2020-10-14 17:00:00"));
        Member member = new Member();
        member.setApiId("test");
        history.setMember(member);

        assertTrue(ValidateUtil.validateSellHistoryInfo(history));
    }

    @Test
    void validateSellHistoryInfoDataNull() throws ParseException {

        TradeHistory history = null;
        assertTrue(ValidateUtil.validateSellHistoryInfo(history));
    }

    @Test
    void validateWishItem() {
    }
}