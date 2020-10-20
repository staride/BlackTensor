package com.blacktensor.stockWeb.repository;

import com.blacktensor.stockWeb.entity.Member;
import com.blacktensor.stockWeb.entity.MyPage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MyPageRepository extends JpaRepository<MyPage, Long> {
    public List<MyPage> findByMember(Member member);
}
