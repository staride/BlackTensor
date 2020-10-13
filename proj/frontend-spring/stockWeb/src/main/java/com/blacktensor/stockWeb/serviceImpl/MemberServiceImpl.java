package com.blacktensor.stockWeb.serviceImpl;

import com.blacktensor.stockWeb.controller.MemberController;
import com.blacktensor.stockWeb.entity.Member;
import com.blacktensor.stockWeb.repository.MemberRepository;
import com.blacktensor.stockWeb.service.MemberService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberServiceImpl implements MemberService {

    @Autowired
    MemberRepository repo;

    private static final Logger log = LoggerFactory.getLogger(MemberServiceImpl.class);

    @Override
    public boolean login(String id, String password) throws Exception {
        return repo.findByEmailAndPassword(id, password).size() == 1;
    }

    @Override
    public void signup(Member member) throws Exception {
        repo.save(member);
    }

    @Override
    public boolean findMail(String email) throws Exception {
        return repo.findByEmail(email).size() == 1;
    }

    @Override
    public void updateAppId(String email, String appId) throws Exception{
        List<Member> list = repo.findByEmail(email);
        Member member = list.size() == 1 ? list.get(0) : null;

        if(member != null){
            member.setApiId(appId);
            repo.save(member);
        }else{
            throw new Exception("is not exist mail");
        }
    }

    @Override
    public boolean findApiId(String appId) throws Exception {
        return repo.findByApiId(appId).size() == 1;
    }
}
