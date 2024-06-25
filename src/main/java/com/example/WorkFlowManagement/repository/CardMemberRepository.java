package com.example.WorkFlowManagement.repository;

import com.example.WorkFlowManagement.entity.CardMember;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CardMemberRepository extends JpaRepository<CardMember, Long> {
}
