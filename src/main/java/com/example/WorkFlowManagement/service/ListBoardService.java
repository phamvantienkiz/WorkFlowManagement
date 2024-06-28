package com.example.WorkFlowManagement.service;

import com.example.WorkFlowManagement.dto.request.ListBoardCreationRequest;
import com.example.WorkFlowManagement.entity.ListBoard;
import com.example.WorkFlowManagement.repository.ListBoardRepository;
import com.example.WorkFlowManagement.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.PrimitiveIterator;

@Service
public class ListBoardService {
    @Autowired
    private ListBoardRepository listBoardRepository;

    @Autowired
    private UserRepository userRepository;

    public List<ListBoard> getListBoards(){
        return listBoardRepository.findAll();
    }

    public ListBoard getListBoard(Long id){
        return listBoardRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("ListBoard not found!"));
    }

//    public ListBoard createListBoard(ListBoardCreationRequest request){
//        tra ve branch service
//    }
}
