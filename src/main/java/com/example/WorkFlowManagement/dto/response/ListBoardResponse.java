package com.example.WorkFlowManagement.dto.response;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ListBoardResponse {
    String userId;
    String title;
    String position;
    Date createAt;
    Date updateAt;
}
