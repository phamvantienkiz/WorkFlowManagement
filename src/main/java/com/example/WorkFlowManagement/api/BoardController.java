package com.example.WorkFlowManagement.api;

import com.example.WorkFlowManagement.dto.request.BoardCreationRequest;
import com.example.WorkFlowManagement.dto.response.BoardResponse;
import com.example.WorkFlowManagement.entity.Board;
import com.example.WorkFlowManagement.service.BoardService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/boards")
public class BoardController {
    @Autowired
    private BoardService boardService;

    @PostMapping("/create/{listBoardId}")
    public BoardResponse createBoard(@PathVariable Long listBoardId, @RequestBody BoardCreationRequest board,
                                     HttpServletRequest request){
        String userId = (String) request.getAttribute("userId");
        return boardService.createBoard(listBoardId, board, userId);
    }

    @GetMapping("/get-boards/{listBoardId}")
    public List<Board> getBoards(@PathVariable Long listBoardId){
        return boardService.getBoards(listBoardId);
    }

    @GetMapping("/get-board/{id}")
    public BoardResponse getBoard(@PathVariable Long id){
        return boardService.getBoard(id);
    }

    @PutMapping("update/{id}")
    public BoardResponse updateBoard(@PathVariable Long id, @RequestBody BoardCreationRequest request){
        return boardService.updateBoard(id, request);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteBoard(@PathVariable Long id){
        boardService.deleteBoard(id);
        return "Board has been deleted!";
    }
}
