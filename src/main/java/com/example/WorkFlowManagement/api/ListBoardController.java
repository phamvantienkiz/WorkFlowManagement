package com.example.WorkFlowManagement.api;

import com.example.WorkFlowManagement.dto.request.ListBoardCreationRequest;
import com.example.WorkFlowManagement.dto.response.ListBoardResponse;
import com.example.WorkFlowManagement.dto.response.UserDetail;
import com.example.WorkFlowManagement.entity.ListBoard;
import com.example.WorkFlowManagement.service.ListBoardService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/list-board")
public class ListBoardController {
    @Autowired
    private ListBoardService listBoardService;

    @PostMapping("/create")
    public ListBoardResponse createListBoard(@RequestBody ListBoardCreationRequest listBoard, HttpServletRequest request ){
        String userId = (String) request.getAttribute("userId");
        return listBoardService.createListBoard(userId, listBoard);
    }

    @GetMapping("/get-listboard/{id}")
    public ListBoardResponse getListBoard(@PathVariable("id") Long id){
        return listBoardService.getListBoard(id);
    }

    @GetMapping("/get-listboards")
    public List<ListBoard> getListBoards(HttpServletRequest request){
        String userId = (String) request.getAttribute("userId");
        return listBoardService.getListBoards(userId);
    }

    @PutMapping("/update/{id}")
    public ListBoardResponse updateListBoard(@PathVariable("id") Long id, @RequestBody ListBoardCreationRequest request){
        return listBoardService.updateListBoard(id, request);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteListBoard(@PathVariable("id") Long id){
        listBoardService.deleteListBoard(id);
        return "ListBoard has been deleted!";
    }
}
