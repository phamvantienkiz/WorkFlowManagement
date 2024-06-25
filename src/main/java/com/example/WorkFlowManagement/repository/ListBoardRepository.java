package com.example.WorkFlowManagement.repository;

import com.example.WorkFlowManagement.entity.ListBoard;
import org.hibernate.type.descriptor.converter.spi.JpaAttributeConverter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ListBoardRepository extends JpaRepository<ListBoard, Long> {
}
