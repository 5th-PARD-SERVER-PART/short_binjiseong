package com.pard.hw5;

import com.pard.hw5.member.security.CustomOAuth2User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class HomeController {

    @GetMapping("/home")
    public String home(@AuthenticationPrincipal CustomOAuth2User user, Model model) {
        if(user != null) {
            String userName = user.getMember().getName();
            Long userId = user.getMember().getId();
            model.addAttribute("userName", userName);
            model.addAttribute("userId", userId);
        }
        return "home";
    }
}