package com.example.WorkFlowManagement.api;

import com.example.WorkFlowManagement.dto.request.CardCreationRequest;
import com.example.WorkFlowManagement.dto.request.CardEditionRequest;
import com.example.WorkFlowManagement.dto.response.CardResponse;
import com.example.WorkFlowManagement.entity.Card;
import com.example.WorkFlowManagement.service.CardService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cards")
public class CardController {
    @Autowired
    private CardService cardService;

    @PostMapping("/create/{boardId}")
    public CardResponse createCard(@PathVariable Long boardId, @RequestBody CardCreationRequest card,
                                   HttpServletRequest request){
        String userId = (String) request.getAttribute("userId");
        return cardService.createCard(boardId, card, userId);
    }

    @GetMapping("/get-cards/{boardId}")
    public List<Card> getCards(@PathVariable Long boardId){
        return cardService.getCards(boardId);
    }

    @GetMapping("/get-card/{id}")
    public CardResponse getCrad(@PathVariable Long id){
        return cardService.getCard(id);
    }

    @PutMapping("/update/{id}")
    public CardResponse updateCard(@PathVariable Long id, @RequestBody CardEditionRequest request){
        return cardService.updateCard(id, request);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteCard(@PathVariable Long id){
        cardService.deleteCard(id);
        return "Card has been deleted!";
    }
}
