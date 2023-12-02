package com.company.controller;

import com.company.container.ComponentContainer;
import com.company.dto.Card;

import com.company.dto.Profile;
import com.company.service.ProfileService;
import com.company.service.UserService;

import java.util.Scanner;

public class UserController {
    private static final String GREEN = "\u001B[32m";
    private static final String YELLOW = "\u001B[33m";
    static Scanner scanner = new Scanner(System.in);
    static ProfileService profileService = new ProfileService();

    public void start() {
        boolean bool = true;
        while (bool) {
            userMenu();
            switch (getAction()) {
                case 1:
                    //add card
                    addCard();
                    break;
                case 2:
                    //tcard list
                    UserService userService = new UserService();
                    userService.cardListForUser();
                    break;
                case 3:
                    //change status
                    changeCArdStatus();
                    break;
                case 4:
                    //Delete Card
                    deleteCard();
                    break;
                case 5:
                    //ReFill
                    refill();
                    break;
                case 6:
                    //Transaction
                    transaction();
                    break;
                case 7:
                    //Make Payment
                    makePayment();
                case 0:
                    bool = false;
                    break;
                default:
                    System.out.println("Boshqa son kirit Mazgi");
                    break;
            }
        }

    }

    private void userMenu() {
        System.out.println(GREEN + "\n*****User Menu*****");
        System.out.println("1.Add card");
        System.out.println("2.Card List");
        System.out.println("3.Card Change Status");
        System.out.println("4.Delete Card");
        System.out.println("5.ReFill");
        System.out.println("6.Transaction");
        System.out.println("7.Make Payment");
        System.out.println("0.exit" + "\n");
    }

    private void addCard() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("enter card number: ");
        String number = scanner.next();

        Card card = new Card();
        card.setNumber(number);

        UserService userService = new UserService();
        userService.addCard(card);
    }

    private void changeCArdStatus() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("enter card number: ");
        String number = scanner.next();

        Card cardDTO = new Card();
        cardDTO.setNumber(number);

        UserService userService = new UserService();
        userService.changeCardSatus(cardDTO);

        System.out.println("your card status changed");


    }

    private void deleteCard() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("enter card number: ");
        String number = scanner.next();

        Card cardDTO = new Card();
        cardDTO.setNumber(number);

        UserService userService = new UserService();
        userService.deleteCArd(cardDTO);

    }
    private void refill(){
        Scanner scanner = new Scanner(System.in);

        Scanner doubleBalance = new Scanner(System.in);

        System.out.print("enter card number: ");
        String cardNumber = scanner.next();

        System.out.println("enter balance: ");
        Double balance = doubleBalance.nextDouble();

//        TransactionDTO transactionDTO = new TransactionDTO();
//        transactionDTO.setCard_number(cardNumber);
//        transactionDTO.setAmount(balance);
//        transactionDTO.setProfileDTo(ComponentContainer.currentUser);
//
//        TransactionService transactionService = new TransactionService();
//        transactionService.reFill(transactionDTO);
    }
    private void transaction(){
        Scanner scanner = new Scanner(System.in);

        Scanner doubleBalance = new Scanner(System.in);

        System.out.print("enter card number: ");
        String cardNumber = scanner.next();

        System.out.print("enter address: ");
        String address = scanner.next();

        System.out.println("enter balance: ");
        Double balance = doubleBalance.nextDouble();

//        TransactionDTO transactionDTO = new TransactionDTO();
//        transactionDTO.setCard_number(cardNumber);
//        transactionDTO.setAddress(address);
//        transactionDTO.setAmount(balance);
//
//        TransactionService transactionService = new TransactionService();
//        transactionService.transaction(transactionDTO);

    }
    public void makePayment(){
        Scanner scanner = new Scanner(System.in);

        System.out.print("enter card number: ");
        String cardNumber = scanner.next();

        System.out.print("enter terminal code: ");
        String code  = scanner.next();

//        TransactionDTO transactionDTO = new TransactionDTO();
//        transactionDTO.setCard_number(cardNumber);
//        transactionDTO.setTerminal_code(code);
//
//        TransactionService transactionService = new TransactionService();
//        transactionService.makePayment(transactionDTO);

    }

    private void shouMenu() {
        System.out.println(GREEN + "\n*****User Menu*****");
        System.out.println("1.Add card: ");
        System.out.println("2.My Card List: ");
        System.out.println("3.Change Card Status: ");
        System.out.println("4.Delete Card: ");
        System.out.println("0. Exit");
    }

    private int getAction() {
        Scanner scanner = new Scanner(System.in);
        System.out.print(YELLOW + "Enter the number: ");
        return scanner.nextInt();
    }
}
