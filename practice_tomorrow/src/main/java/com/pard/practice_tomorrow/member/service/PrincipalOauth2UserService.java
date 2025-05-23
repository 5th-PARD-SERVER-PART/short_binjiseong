package com.pard.practice_tomorrow.member.service;

import com.pard.seminar5.member.domain.Member;
import com.pard.seminar5.member.domain.Role;
import com.pard.seminar5.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

@Service
@Slf4j //log를 터미널에 출력하라
@RequiredArgsConstructor
public class PrincipalOauth2UserService extends DefaultOAuth2UserService {
    private final MemberRepository memberRepository;

    @Override
    public OAuth2User loadUser(OAuth2UserRequest oAuth2UserRequest) throws OAuth2AuthenticationException{//throw가 없으면 만들어라

        log.info("구글에서 받아온 UserRequest" + oAuth2UserRequest);//log를 볼 수 있음
        OAuth2User oAuth2User = super.loadUser(oAuth2UserRequest);
        log.info("oauth에서 받아온 정보: " + oAuth2User.getAttributes());

        String email = (String) oAuth2User.getAttributes().get("email");
        String name = (String) oAuth2User.getAttributes().get("name");
        String socialId = (String) oAuth2User.getAttributes().get("sub");

        memberRepository.findByEmail(email)
                .orElseGet(() -> memberRepository.save(
                        Member.builder()
                                .email(email)
                                .name(name)
                                .socialId(socialId)
                                .role(Role.USER)
                                .build()
                ));
        return oAuth2User;

    }
    //위에거는 회원가입
    //밑에거는 세션이나 jwt로 해서 내가 인가를 해주면 됨
}
