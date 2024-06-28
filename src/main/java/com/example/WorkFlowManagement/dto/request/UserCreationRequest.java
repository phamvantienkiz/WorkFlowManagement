package com.example.WorkFlowManagement.dto.request;

import lombok.*;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserCreationRequest {
    @Size(min = 3, message = "USERNAME_INVALID")
    private String username;

    @Size(min = 8, message = "INVALID_PASSWORD")
    private String password;
    private String firstName;
    private String lastName;
    private LocalDate dob;
}
