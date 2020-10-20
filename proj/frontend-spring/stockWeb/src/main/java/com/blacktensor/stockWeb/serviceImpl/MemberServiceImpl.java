package com.blacktensor.stockWeb.serviceImpl;

import com.blacktensor.stockWeb.controller.MemberController;
import com.blacktensor.stockWeb.entity.Member;
import com.blacktensor.stockWeb.entity.MyPage;
import com.blacktensor.stockWeb.repository.MemberRepository;
import com.blacktensor.stockWeb.repository.MyPageRepository;
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

    @Autowired
    MyPageRepository pageRepo;

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

    @Override
    public Member getMemberInfo(String mail) throws Exception {
        List<Member> list = repo.findByEmail(mail);

        if(list != null && list.size() == 1){
            return list.get(0);
        }else{
            return null;
        }
    }

    @Override
    public MyPage getMyPage(String mail) throws Exception {
        List<Member> list = repo.findByEmail(mail);

        if(list != null && list.size() == 1){
            List<MyPage> pages = pageRepo.findByMember(list.get(0));
            if(pages != null && pages.size() == 1){
                return pages.get(0);
            }
        }

        return null;
    }

    @Override
    public void updateMyPageInfo(String mail, MyPage mypage) throws Exception {
        List<Member> list = repo.findByEmail(mail);

        if(list != null && list.size() == 1){
            List<MyPage> pages = pageRepo.findByMember(list.get(0));
            if(pages != null && pages.size() == 1){
                MyPage info = pages.get(0);

                info.setBirth(mypage.getBirth());
                info.setGender(mypage.getGender());
                info.setPhone(mypage.getPhone());
                info.setMemo(mypage.getMemo());

                pageRepo.save(info);
            }else{
                mypage.setMember(list.get(0));
                pageRepo.save(mypage);
            }
        }
    }
}
