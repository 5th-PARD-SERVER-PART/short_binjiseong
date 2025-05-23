package com.pard.practice_tomorrow.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Configuration//설정파일이다
public class CorsConfig {//

    @Bean//설정파일돌리고 member 실행해야 함,한번만 만들어놓으면 객체에서 다 주입해서 쓰겠다.
    public CorsFilter corsFilter(){//cors 정책,정책에 맞는지 확인
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();

        CorsConfiguration config = new CorsConfiguration();

        config.setAllowCredentials(true);

        config.addAllowedOrigin("*");//모든 출처 확인, 어떤 ip든 받겠다-> 웹은 3000이라서 3000적으면 이것만 가능

        config.addAllowedHeader("*");//header 다 받겠다

        config.addAllowedMethod("*");//get,post,delete 다 받겠다.

        source.registerCorsConfiguration("/*",config);

        return new CorsFilter(source);//필터링 spring에서 계속 이걸 돌리겠다(설명서 주입)

    }

}
