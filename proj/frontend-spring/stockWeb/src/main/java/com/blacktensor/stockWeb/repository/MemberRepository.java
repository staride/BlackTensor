package com.blacktensor.stockWeb.repository;

import com.blacktensor.stockWeb.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {
    public List<Member> findByEmail(String email);
    public List<Member> findByApiId(String apiId);
}
