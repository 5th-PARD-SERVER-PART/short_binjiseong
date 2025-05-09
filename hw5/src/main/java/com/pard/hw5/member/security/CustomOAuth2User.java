package com.pard.hw5.member.security;

import com.pard.hw5.member.domain.Member;
import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.core.user.OAuth2User;

import java.util.Collection;
import java.util.Collections;
import java.util.Map;

@Getter
public class CustomOAuth2User implements OAuth2User {
    private final Member member;

    public CustomOAuth2User(Member member) {
        this.member = member;
    }

    @Override
    public Map<String, Object> getAttributes() {
        return Collections.singletonMap("email", member.getEmail());
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.emptyList(); // 권한 미사용
    }

    @Override
    public String getName() {
        return member.getName();
    }
}

