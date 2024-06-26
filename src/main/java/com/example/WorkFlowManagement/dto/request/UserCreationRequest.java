package com.example.WorkFlowManagement.dto.request;

import lombok.Getter;
import lombok.Setter;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

@Getter
@Setter
public class UserCreationRequest {
    @Size(min = 3, message = "Username must be at least 3 characters")
    private String username;

    @Size(min = 8, message = "Password must be at least 8 characters")
    private String password;
    private String firstName;
    private String lastName;
    private LocalDate dob;
}
