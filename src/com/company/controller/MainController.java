package com.company.controller;

import com.company.dto.Profile;
import com.company.service.ProfileService;
import com.company.util.DbUtil;

import java.util.Scanner;

public class MainController {
    private static final String GREEN = "\u001B[32m";
    private static final String YELLOW = "\u001B[33m";
    static Scanner scanner = new Scanner(System.in);
    static Scanner scannerInt = new Scanner(System.in);
    static ProfileService profileService = new ProfileService();

    public void start() {
        DbUtil dbUtil = new DbUtil();
        dbUtil.createProfile();
        if (dbUtil.admenIsExists()) {
            dbUtil.init();
        }

        boolean bool = true;
        while (bool) {
            shouMenu();
            switch (getAction()) {
                case 1:
                    //login
                    login();
                    break;
                case 2:
                    //Registration
                    registration();
                    break;
                case 0:
                    bool = false;
                    break;
                default:
                    System.out.println("Boshqa qiymat kiriting!");
            }
        }
    }

    public void login() {
        System.out.print("Enter phone: ");
        String phone = scanner.next();
        System.out.print("Enter password: ");
        String password = scanner.next();

        profileService.login(phone, password);
    }

    public void registration() {
        System.out.print("Enter the name: ");
        String name = scanner.next();
        System.out.print("Enter the surname: ");
        String surname = scanner.next();
        System.out.print("Enter the phone: ");
        String phone = scanner.next();
        System.out.print("Enter the password: ");
        String password = scanner.next();

        Profile profile = new Profile();
        profile.setName(name);
        profile.setSurname(surname);
        profile.setPhone(phone);
        profile.setPassword(password);

        profileService.registration(profile);
    }

    private void shouMenu() {
        System.out.println(GREEN + "********Main Menu******** ");
        System.out.println("1.Login: ");
        System.out.println("2.Registration: ");
        System.out.println("0.Exit: ");
    }

    private int getAction() {
        System.out.print(YELLOW + "Enter the number: ");
        return scannerInt.nextInt();
    }
}
