package com.metaoauth.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.metaoauth.entity.AppUser;
import com.metaoauth.service.AppUserService;

@Controller
@RequestMapping("/home")
public class HomeController {

    @Autowired
    private AppUserService appUserService;

    @GetMapping
    public String home(Authentication authentication, Model model) {
        OAuth2User oAuth2User = (OAuth2User) authentication.getPrincipal();
        AppUser appUser = appUserService.saveOrUpdateUser(oAuth2User);
        model.addAttribute("appUser", appUser);
        return "home"; 
    }
}