package com.example.WorkFlowManagement.dto.response;

import com.example.WorkFlowManagement.entity.ListBoard;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class BoardResponse {
    Long id;
    String userId;
    String title;

    Long listBoardId;

    Date createAt;
    Date updateAt;
}
