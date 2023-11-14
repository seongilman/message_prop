package com.message.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;

/**
 * 해당 Configuration을 등록하지 않으면
 * 스프링의 기본값인 AcceptHeaderLocaleResolver가 동작한다.
 * 이 경우 URL query string이 아닌 브라우저의 언어를 변경하여 테스트.
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {
    /**
     * LocaleResolver
     * 스프링은 LocaleResolver를 통해 클라이언트의 Locale 정보를 추출
     * LocaleResolver 종류
     * AcceptHeaderLocaleResolver : Http 헤더의 Accept-Language의 값을 사용 (기본값)
     * CookieLocaleResolver : 쿠키의 값을 저장하여 사용
     * SessionLocaleResolver : 세션에 값을 저장하여 사용
     * FixedLocaleResolver : 요청과 관계없이 default locale 사용
     */
    @Bean
    public LocaleResolver localeResolver() {
        return new CookieLocaleResolver();
    }

    /**
     * LocaleChangeInterceptor
     * Locale 값이 변경되면 인터셉터가 동작한
     * query string에 지정한 값이 들어올 때 동작한다.
     * ex) http://localhost:8080?lang=ko
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        LocaleChangeInterceptor localeChangeInterceptor = new LocaleChangeInterceptor();
        localeChangeInterceptor.setParamName("lang");
        registry.addInterceptor(localeChangeInterceptor);
    }
}