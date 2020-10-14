package com.blacktensor.stockWeb.entity;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WishItemTest {

    @Test
    void getMember() {
        final WishItem item = new WishItem();
        final Member member = new Member();
        member.setMemberNo(Long.valueOf(1));
        item.setMember(member);

        final Member result = new Member();
        result.setMemberNo(Long.valueOf(1));

        assertEquals(result, item.getMember());
    }

    @Test
    void getStockName() {
        final WishItem item = new WishItem();
        item.setStockName("StockName");

        assertEquals("StockName", item.getStockName());
    }

    @Test
    void getStockCode() {
        final WishItem item = new WishItem();
        item.setStockCode("000000");

        assertEquals("000000", item.getStockCode());
    }
}