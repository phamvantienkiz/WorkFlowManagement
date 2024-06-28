package com.example.WorkFlowManagement.api;

import com.example.WorkFlowManagement.dto.request.ApiResponse;
import com.example.WorkFlowManagement.dto.request.UserCreationRequest;
import com.example.WorkFlowManagement.dto.request.UserUpdateRequest;
import com.example.WorkFlowManagement.dto.response.UserResponse;
import com.example.WorkFlowManagement.entity.User;
import com.example.WorkFlowManagement.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/identity")
public class UserAPI {
    @Autowired
    private UserService userService;

    @PostMapping("/create-users")
    ApiResponse<User> createUser(@RequestBody @Valid UserCreationRequest request){
        ApiResponse<User> apiResponse = new ApiResponse<>();

        apiResponse.setResult(userService.createRequest(request));

        return apiResponse;
    }

    @GetMapping("/get-users")
    List<User> getUsers(){
        return userService.getUsers();
    }

    @GetMapping("/get-user/{userId}")
    User getUser(@PathVariable("userId") String userId){
        return userService.getUser(userId);
    }

    @PutMapping("/edit-user/{userId}")
    User editUser(@PathVariable("userId") String userId, @RequestBody UserUpdateRequest request){
        return userService.updateUser(userId, request);
    }

    @DeleteMapping("/delete-user/{userId}")
    String deleteUser(@PathVariable("userId") String userId){
        userService.deleteUser(userId);
        return "User has been deleted!";
    }
}
