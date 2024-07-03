package com.example.WorkFlowManagement.repository;

import com.example.WorkFlowManagement.entity.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CardRepository extends JpaRepository<Card, Long> {
    List<Card> findByBoardId(Long boardId);
}
