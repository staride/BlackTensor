package com.blacktensor.stockWeb.service;

import com.blacktensor.stockWeb.entity.Member;

public interface MemberService {
    public boolean login(String id, String password) throws Exception;
    public void signup(Member member) throws Exception;
    public boolean findMail(String email) throws Exception;
    public void updateAppId(String email, String appId) throws Exception;
    public boolean findApiId(String appid) throws Exception;
}
