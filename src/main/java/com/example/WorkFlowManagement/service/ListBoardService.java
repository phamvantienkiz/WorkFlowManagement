package com.example.WorkFlowManagement.service;

import com.example.WorkFlowManagement.dto.request.ListBoardCreationRequest;
import com.example.WorkFlowManagement.dto.response.ListBoardResponse;
import com.example.WorkFlowManagement.entity.ListBoard;
import com.example.WorkFlowManagement.entity.User;
import com.example.WorkFlowManagement.exception.AppException;
import com.example.WorkFlowManagement.exception.ErrorCode;
import com.example.WorkFlowManagement.repository.ListBoardRepository;
import com.example.WorkFlowManagement.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.PrimitiveIterator;

@Service
public class ListBoardService {
    @Autowired
    private ListBoardRepository listBoardRepository;

    @Autowired
    private UserRepository userRepository;

    public List<ListBoard> getListBoards(String userId){
        List<ListBoard> listBoards = listBoardRepository.findByUserId(userId);

//        List<ListBoardResponse> responses = new ArrayList<>();
//        ListBoardResponse response = new ListBoardResponse();
//        for (ListBoard l : listBoards){
//            response.setUserId(l.getUser().getId());
//            response.setTitle(l.getTitle());
//            response.setPosition(l.getPosition());
//            response.setCreateAt(l.getCreateAt());
//            response.setUpdateAt(l.getUpdateAt());
//            responses.add(response);
//        }

        return listBoards;
    }

    public ListBoardResponse getListBoard(Long id){
        ListBoard listBoard = listBoardRepository.findById(id)
                .orElseThrow(() -> new AppException(ErrorCode.LIST_BOARD_NOT_EXISTED));

        ListBoardResponse response = new ListBoardResponse();
        response.setUserId(listBoard.getUser().getId());
        response.setTitle(listBoard.getTitle());
        response.setPosition(listBoard.getPosition());
        response.setCreateAt(listBoard.getCreateAt());
        response.setUpdateAt(listBoard.getUpdateAt());

        return response;
    }

    public ListBoardResponse createListBoard(String userId, ListBoardCreationRequest request ){
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new AppException(ErrorCode.USER_EXISTED));

        ListBoard listBoard = new ListBoard();
        listBoard.setUser(user);
        listBoard.setTitle(request.getTitle());
        listBoard.setPosition(request.getPosition());
        listBoard.setCreateAt(new Date());
        listBoard.setUpdateAt(new Date());

        listBoardRepository.save(listBoard);

        ListBoardResponse response = new ListBoardResponse();
        response.setUserId(listBoard.getUser().getId());
        response.setTitle(listBoard.getTitle());
        response.setPosition(listBoard.getPosition());
        response.setCreateAt(listBoard.getCreateAt());
        response.setUpdateAt(listBoard.getUpdateAt());

        return response;
    }

    public ListBoardResponse updateListBoard(Long id, ListBoardCreationRequest request){
        ListBoard listBoard = listBoardRepository.findById(id)
                .orElseThrow(() -> new AppException(ErrorCode.LIST_BOARD_NOT_EXISTED));

        listBoard.setTitle(request.getTitle());
        listBoard.setPosition(request.getPosition());
        listBoard.setUpdateAt(new Date());
        listBoardRepository.save(listBoard);

        ListBoardResponse response = new ListBoardResponse();
        response.setUserId(listBoard.getUser().getId());
        response.setTitle(listBoard.getTitle());
        response.setPosition(listBoard.getPosition());
        response.setCreateAt(listBoard.getCreateAt());
        response.setUpdateAt(listBoard.getUpdateAt());

        return response;
    }

    public void deleteListBoard(Long id){
        listBoardRepository.deleteById(id);
    }

}
