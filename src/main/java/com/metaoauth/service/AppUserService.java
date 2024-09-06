package com.metaoauth.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import com.metaoauth.entity.AppUser;
import com.metaoauth.repository.AppUserRepository;

@Service
public class AppUserService {

    @Autowired
    private AppUserRepository appUserRepository;

    public AppUser saveOrUpdateUser(OAuth2User oAuth2User) {
        String email = oAuth2User.getAttribute("email");
        AppUser appUser = appUserRepository.findByEmail(email);

        if (appUser == null) {
            appUser = new AppUser();
            appUser.setName(oAuth2User.getAttribute("name"));
            appUser.setEmail(email);
            appUserRepository.save(appUser);
        }

        return appUser;
    }
}
