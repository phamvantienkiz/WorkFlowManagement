package com.example.WorkFlowManagement.service;

import com.example.WorkFlowManagement.dto.request.BoardCreationRequest;
import com.example.WorkFlowManagement.dto.response.BoardResponse;
import com.example.WorkFlowManagement.dto.response.ListBoardResponse;
import com.example.WorkFlowManagement.entity.Board;
import com.example.WorkFlowManagement.entity.ListBoard;
import com.example.WorkFlowManagement.entity.User;
import com.example.WorkFlowManagement.exception.AppException;
import com.example.WorkFlowManagement.exception.ErrorCode;
import com.example.WorkFlowManagement.repository.BoardRepository;
import com.example.WorkFlowManagement.repository.ListBoardRepository;
import com.example.WorkFlowManagement.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class BoardService {
    @Autowired
    private BoardRepository boardRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ListBoardRepository listBoardRepository;

    public BoardResponse createBoard(Long listBoardId, BoardCreationRequest request, String userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new AppException(ErrorCode.USER_EXISTED));

        ListBoard listBoard = listBoardRepository.findById(listBoardId)
                .orElseThrow(() -> new AppException(ErrorCode.LIST_BOARD_NOT_EXISTED));

        Board board = new Board();
        board.setUser(user);
        board.setTitle(request.getTitle());
        board.setListBoard(listBoard);
        board.setCreateAt(new Date());
        board.setUpdateAt(new Date());
        boardRepository.save(board);

        BoardResponse response = new BoardResponse(board.getId(), board.getUser().getId(), board.getTitle(),
                board.getListBoard().getId(), board.getCreateAt(), board.getUpdateAt());

        return response;
    }

    public List<Board> getBoards(Long listBoardId){
        return boardRepository.findByListBoardId(listBoardId);
    }

    public BoardResponse getBoard(Long id){
        Board board = boardRepository.findById(id)
                .orElseThrow(() -> new AppException(ErrorCode.BOARD_NOT_EXISTED));

        BoardResponse response = new BoardResponse(board.getId(), board.getUser().getId(), board.getTitle(),
                board.getListBoard().getId(), board.getCreateAt(), board.getCreateAt());

        return response;
    }

    public BoardResponse updateBoard(Long id, BoardCreationRequest request){
        Board board = boardRepository.findById(id)
                .orElseThrow(() -> new AppException(ErrorCode.BOARD_NOT_EXISTED));

        board.setTitle(request.getTitle());
        board.setUpdateAt(new Date());
        boardRepository.save(board);

        BoardResponse response = new BoardResponse(board.getId(), board.getUser().getId(), board.getTitle(),
                board.getListBoard().getId(), board.getCreateAt(), board.getCreateAt());

        return response;
    }

    public void deleteBoard(Long id){
        boardRepository.deleteById(id);
    }
}
