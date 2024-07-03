package com.example.WorkFlowManagement.repository;

import com.example.WorkFlowManagement.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findByCardId(Long cardId);
}
