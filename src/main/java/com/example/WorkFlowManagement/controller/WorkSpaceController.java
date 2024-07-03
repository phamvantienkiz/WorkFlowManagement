package com.example.WorkFlowManagement.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/boards")
public class WorkSpaceController {
    @GetMapping("/board-list")
    public String showBoard(){
        return "/boards/board-list";
    }
}
