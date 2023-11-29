package com.company.controller;

import com.company.dto.Card;

import com.company.service.ProfileService;

import java.util.Scanner;

public class UserController {
    static Scanner scanner = new Scanner(System.in);
    static ProfileService profileService = new ProfileService();

    public void start() {
        boolean exit = true;

        while (exit) {
            shouMenu();
            switch (getAction()) {
                case 1:
                    //add card
                    addCard();
                    break;
                case 2:
                    //my card list
                    myCardList();
                    break;
                case 3:
                    //change cart status
                    changeCartStatus();
                    break;
                case 4:
                    //delete card
                    deleteCard();
                    break;
                case 0:
                    exit = false;
                    break;
                default:
                    System.out.println("Boshqa son kirit Mazgi");
                    break;
            }
        }
    }


    private void changeCartStatus() {
        myCardList();
        System.out.print("\n" + "Enter the Card number: ");
        String number = scanner.nextLine();
//        profileService.changeCardStatus(number);
    }

    private void deleteCard() {
//        profileService.myCardList();
    }
   private void myCardList() {
//        profileService.myCardList();
    }

    private void addCard() {
        System.out.print("Enter the Card number: ");
        String number = scanner.nextLine();
        System.out.print("Enter the expDate: ");
        String expDate = scanner.nextLine();
        System.out.print("Enter the balance: ");
        double balance = scanner.nextInt();

        Card card = new Card();
        card.setNumber(number);
        card.setEx_date(expDate);
        card.setBalance(balance);

        profileService.addCard(card);

    }

    private void shouMenu() {
        System.out.println( "\n*****User Menu*****");
        System.out.println("1.Add card: ");
        System.out.println("2.My Card List: ");
        System.out.println("3.Change Card Status: ");
        System.out.println("4.Delete Card: ");
        System.out.println("0. Exit");
    }

    private int getAction() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number: ");
        return scanner.nextInt();
    }
}
