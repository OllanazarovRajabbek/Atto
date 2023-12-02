package com.company.service;

import com.company.controller.AdmenController;
import com.company.controller.UserController;
import com.company.dto.Card;
import com.company.dto.Profile;
import com.company.repository.ProfileRepository;
import com.company.status.ProfileRole;
import com.company.status.ProfileStatus;

import java.time.LocalDateTime;
import java.util.List;

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
        List<Profile> profileList = profileRepository.profileList(phone);
        Profile profile = profileList.get(0);
        if (profile.getPassword().equals(password)) {
            if (profile.getRole().equals(ProfileRole.ADMEN)) {
                AdmenController admenController= new AdmenController();
                admenController.start();
            }else {
                UserController userController = new UserController();
                userController.start();
            }
        }else System.out.println("Phone or password invalid!");
    }

    // User service

}
