package com.company.service;

import com.company.controller.UserController;
import com.company.dto.Card;
import com.company.dto.Profile;
import com.company.repository.ProfileRepository;
import com.company.status.ProfileRole;
import com.company.status.ProfileStatus;

import java.time.LocalDateTime;

public class ProfileService {
    static ProfileRepository profileRepository = new ProfileRepository();

    public void addCard(Card card) {

        profileRepository.addCrd(card);
    }

    public void registration(Profile profile) {
        profile.setStatus(ProfileStatus.ACTIVE);
        profile.setRole(ProfileRole.USER);
        profile.setCreated_date(LocalDateTime.now());

        if (profileRepository.registration(profile)) {
            System.err.println("Success");
        }
    }

    public void login(String phone, String password) {
        if (profileRepository.login(phone, password)) {
            UserController userController = new UserController();
            userController.start();
        }
    }
}
