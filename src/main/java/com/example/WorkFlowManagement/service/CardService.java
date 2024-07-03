package com.example.WorkFlowManagement.service;

import com.example.WorkFlowManagement.dto.request.CardCreationRequest;
import com.example.WorkFlowManagement.dto.request.CardEditionRequest;
import com.example.WorkFlowManagement.dto.response.CardResponse;
import com.example.WorkFlowManagement.entity.Board;
import com.example.WorkFlowManagement.entity.Card;
import com.example.WorkFlowManagement.entity.User;
import com.example.WorkFlowManagement.exception.AppException;
import com.example.WorkFlowManagement.exception.ErrorCode;
import com.example.WorkFlowManagement.repository.BoardRepository;
import com.example.WorkFlowManagement.repository.CardRepository;
import com.example.WorkFlowManagement.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class CardService {
    @Autowired
    private CardRepository cardRepository;

    @Autowired
    private BoardRepository boardRepository;

    @Autowired
    private UserRepository userRepository;

    public CardResponse createCard(Long boardId, CardCreationRequest request, String userId){
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new AppException(ErrorCode.USER_EXISTED));

        /*Board board = boardRepository.findById(boardId)
                .orElseThrow(() -> new AppException(ErrorCode.BOARD_NOT_EXISTED));*/

        Card card = new Card();
        card.setBoardId(boardId);
        card.setUser(user);
        card.setTitle(request.getTitle());
        card.setDescription(request.getDescription());
        card.setDueDate(request.getDueDate());
        card.setCreateAt(new Date());
        card.setUpdateAt(new Date());
        cardRepository.save(card);

        CardResponse response = new CardResponse(card.getId(), card.getBoardId(), card.getUser().getId(),
                card.getTitle(), card.getDescription(), card.getDueDate(), card.getCreateAt(), card.getUpdateAt());

        return response;
    }

    public List<Card> getCards(Long boardId){
        return cardRepository.findByBoardId(boardId);
    }

    public CardResponse getCard(Long id){
        Card card = cardRepository.findById(id)
                .orElseThrow(() -> new AppException(ErrorCode.CARD_NOT_EXISTED));

        CardResponse response = new CardResponse(card.getId(), card.getBoardId(), card.getUser().getId(),
                card.getTitle(), card.getDescription(), card.getDueDate(), card.getCreateAt(), card.getUpdateAt());

        return response;
    }

    public CardResponse updateCard(Long id, CardEditionRequest request){
        Card card = cardRepository.findById(id)
                .orElseThrow(() -> new AppException(ErrorCode.CARD_NOT_EXISTED));

        card.setBoardId(request.getBoardId());
        card.setTitle(request.getTitle());
        card.setDescription(request.getDescription());
        card.setDueDate(request.getDueDate());
        card.setUpdateAt(new Date());
        cardRepository.save(card);

        CardResponse response = new CardResponse(card.getId(), card.getBoardId(), card.getUser().getId(),
                card.getTitle(), card.getDescription(), card.getDueDate(), card.getCreateAt(), card.getUpdateAt());

        return response;
    }

    public void deleteCard(Long id) {
        cardRepository.deleteById(id);
    }
}
