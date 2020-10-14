package com.blacktensor.stockWeb.entity;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MemberTest {

    @Test
    void getMemberNo() {
        final Member member = new Member();
        member.setMemberNo(Long.valueOf(1));
        assertEquals(Long.valueOf(1), member.getMemberNo());
    }

    @Test
    void getEmail() {
        final Member member = new Member();
        member.setEmail("test@test.com");

        assertEquals("test@test.com", member.getEmail());
    }

    @Test
    void getPassword() {
        final Member member = new Member();
        member.setPassword("456123");

        assertEquals("456123", member.getPassword());
    }

    @Test
    void getApiId() {
        final Member member = new Member();
        member.setApiId("test");

        assertEquals("test", member.getApiId());
    }

    @Test
    void testEquals() {
        final Member member1 = new Member();
        final Member member2 = new Member();

        member1.setMemberNo(Long.valueOf(1));
        member2.setMemberNo(Long.valueOf(1));

        assertEquals(member1, member2);
    }
}