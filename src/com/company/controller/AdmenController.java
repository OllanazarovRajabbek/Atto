package com.company.controller;

import com.company.dto.Profile;
import com.company.service.UserService;

import java.util.Scanner;

public class AdmenController {
    static Scanner scanner = new Scanner(System.in);
    private static final String GREEN = "\u001B[32m";
    private static final String YELLOW = "\u001B[33m";
    public void start() {
        boolean a = true;
        while (a) {
            adminMenu();
            switch (getAction()) {
                case 1:
                    //Card menu
//                    CardController controller = new CardController();
//                    controller.start();
                    break;
                case 2:
                    //terminal menu
//                    TerminalController terminalController = new TerminalController();
//                    terminalController.start();
                    break;
                case 3:
                    //profile settings
//                    ProfileServise profileServise = new ProfileServise();
//                    profileServise.allProfile();
                    break;
                case 4:
                    changeProfileStatus();
                    break;
                case 5:
                    //Statistic
                    break;
                case 6:
                    //Statistic
                    break;
                case 0:
                    a=false;
                    break;
                default:
                    System.out.println("select correct menu");
                    break;
            }
        }
    }

    public void adminMenu() {
        System.out.println(GREEN + "\n*****Admen Menu*****");
        System.out.println("1.Card menu");
        System.out.println("2.Terminal menu");
        System.out.println("3.Profile list");
        System.out.println("4.Change profile status");
        System.out.println("4.Transaction");
        System.out.println("5.Statistic");
        System.out.println("0.exist" + "\n");
    }
    private void changeProfileStatus(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter phone: ");
        String phone = scanner.next();

        Profile profile = new Profile();
        profile.setPhone(phone);

        UserService userService = new UserService();
//        userService.changeCardSatus(profile);
    }



    private int getAction() {
        System.out.print(YELLOW+"Enter the number: ");
        return scanner.nextInt();
    }
}
