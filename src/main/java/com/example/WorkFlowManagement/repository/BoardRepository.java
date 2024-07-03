package com.example.WorkFlowManagement.repository;

import com.example.WorkFlowManagement.entity.Board;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BoardRepository extends JpaRepository<Board, Long> {
    List<Board> findByListBoardId(Long listBoardId);
}
