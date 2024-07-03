package com.example.WorkFlowManagement.dto.request;

import com.example.WorkFlowManagement.entity.Board;
import com.example.WorkFlowManagement.entity.User;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CardCreationRequest {

    String title;

    String description;

    Date dueDate; //ngay het han
}
