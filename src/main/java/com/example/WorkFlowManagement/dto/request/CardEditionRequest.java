package com.example.WorkFlowManagement.dto.request;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CardEditionRequest {
    Long boardId;

    String title;

    String description;

    Date dueDate; //ngay het han
}
