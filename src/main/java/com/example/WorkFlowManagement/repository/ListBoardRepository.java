package com.example.WorkFlowManagement.repository;

import com.example.WorkFlowManagement.entity.ListBoard;
import org.hibernate.type.descriptor.converter.spi.JpaAttributeConverter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ListBoardRepository extends JpaRepository<ListBoard, Long> {
    List<ListBoard> findByUserId(String userId);
}
