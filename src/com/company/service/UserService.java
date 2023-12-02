package com.company.service;

import com.company.container.ComponentContainer;
import com.company.dto.Card;
import com.company.repository.CardRepository;
import com.company.status.CardStatus;

import java.util.List;

public class UserService {
    private CardRepository cardRepository = new CardRepository();
    private UserRepository userRepository = new UserRepository();

    public void addCard(Card card) {
        List<Card> cardlist = cardRepository.getAllCard();

        for (Card card2:cardlist){
            if (card2 == null || !card2.getNumber().equals(card2.getNumber())){
                System.err.println("card not found");
                return;
            }
        }

        for (Card card1:cardlist){
            if (card1 != null && card1.getNumber().equals(card1.getNumber())){
                card1.setId(String.valueOf(Integer.parseInt(card.getId())));
                card1.setNumber(card.getNumber());
                card1.setEx_date(card1.getEx_date());
                card1.setBalance(card1.getBalance());
                card1.setStatus(CardStatus.ACTIVE);
                card1.setPhone(ComponentContainer.currentUser.getPhone());
                card1.setLocalDateTime(card1.getLocalDateTime());//created_date

            }
        }
        userRepository.addCardForUser(card);
    }

    public void cardListForUser() {
        int countCard=1;
        List<Card> cardlist = cardRepository.getAllCard();
        for (Card cardDTO:cardlist){
            if (cardDTO != null && cardDTO.getStatus().equals(CardStatus.ACTIVE)
                    && cardDTO.getPhone().equals(ComponentContainer.currentUser.getPhone())){
                System.out.println((countCard++) +". " +  cardDTO.getNumber() + " - " + cardDTO.getEx_date() + " - " + cardDTO.getBalance() + "$");
            }
        }
    }

    public void changeCardSatus(Card cardDTO) {
        List<Card> cardlist = cardRepository.getAllCard();
        for (Card cardDTO1:cardlist){
            if (cardDTO1 != null && cardDTO1.getNumber().equals(cardDTO.getNumber())
                    && cardDTO1.getPhone().equals(ComponentContainer.currentUser.getPhone())){
                cardDTO.setId(cardDTO1.getId());
                cardDTO.setNumber(cardDTO1.getNumber());
                cardDTO.setEx_date(cardDTO1.getEx_date());
                cardDTO.setBalance(cardDTO1.getBalance());
                cardDTO.setStatus(CardStatus.BLOCK);
                cardDTO.setPhone(ComponentContainer.currentUser.getPhone());
                cardDTO.setLocalDateTime(cardDTO1.getLocalDateTime());

            }
        }
        userRepository.changeCardStatus(cardDTO);
    }

    public void deleteCArd(Card cardDTO) {
        List<Card> cardlist = cardRepository.getAllCard();
        for (Card cardDTO1:cardlist){
            if (cardDTO1 != null && cardDTO1.getNumber().equals(cardDTO.getNumber())
                    && cardDTO1.getPhone().equals(ComponentContainer.currentUser.getPhone())){
                cardDTO.setId(cardDTO1.getId());
                cardDTO.setNumber(cardDTO1.getNumber());
                cardDTO.setEx_date(cardDTO1.getEx_date());
                cardDTO.setBalance(0d);
                cardDTO.setStatus(CardStatus.BLOCK);
                cardDTO.setPhone(null);
                cardDTO.setLocalDateTime(cardDTO.getLocalDateTime());

            }
        }
        userRepository.deleteCard(cardDTO);
    }
}
