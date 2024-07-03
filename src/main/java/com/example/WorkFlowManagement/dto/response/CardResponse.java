package com.example.WorkFlowManagement.dto.response;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CardResponse {
    Long id;
    Long boardId;

    String userId;

    String title;

    String description;

    Date dueDate; //ngay het han
    Date createAt;
    Date updateAt;
}
