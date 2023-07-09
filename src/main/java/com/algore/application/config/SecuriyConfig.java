package com.algore.application.config;

import com.algore.application.config.handler.AuthenFailHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecuriyConfig {

    private final AuthenFailHandler authenFailHandler;

    public SecuriyConfig(AuthenFailHandler authenFailHandler) {
        this.authenFailHandler = authenFailHandler;
    }


    @Bean
    public PasswordEncoder passwordEncoder(){
        // 비밀번호 암호화 방식
        return new BCryptPasswordEncoder();
    }

    String[] staticResources  =  {
            "/css/**",
            "/img/**",
            "/fonts/**",
            "/scripts/**",
    };

    @Bean
    public SecurityFilterChain configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers(staticResources).permitAll()
                // (/list) -> 이와 같은 것을 리소르라고 한다.
                // 아래의 mvcMatchers는 요청 주소 식별에서 (/list/)와 같이 모호한 요청도 식별을 해준다.
                // 추가됨
                .mvcMatchers("/*","/common/login","/common/loginfail","common/test")
                // 해당 설정은 위에 정의된 리소스 요청에 모든 권한의 사용자를 허용해준다는 것이다.
                .permitAll() //이와 반대인 denyAll()도 있으며 이것은 모두 제안한다.
                // .rememberMe() : 로그인된 사용자만 접근을 허용해준다.
                // .hasalpAddress() : 특정 ip 주소를 갖는 사용자만 접근을 허용해준다.
                // 아래의 antMatchers는 요청 주소 식별을 정확하게 하지 않으면 요청을 인식하지 못한다.
                .antMatchers("/employee/list")
                // 아래 hasAnyRole은 해당 위의 리소스 요청시 다음 권한을 가진 사용자만 접근을 허용해준다.
                .hasAnyAuthority("ADMIN","USER")
                .antMatchers("/employee/file").hasAnyAuthority("ADMIN")
                // 인증된 사용자만 접근이 되어야 한다.
                .anyRequest().authenticated()
                // 이와 반대인 .anonymous()가 있으며 인증되지 않은 사용자도 접근을 허용한다.
                .and()
                .csrf().disable();

        http.formLogin() // 로그인 설정
                .loginPage("/common/login")
                // 로그인을 진행할 페이지 필드명을 맞추야 한다.
                // 로그인 성공시 아래의 페이지로 요청을 보냄
                .defaultSuccessUrl("/common/test")
                // 로그인이 실패되었을때 처리할 핸들러 추가
                .failureHandler(authenFailHandler)
                //login 페이지에서 전달하는 사용자의 파라미터 값
                .usernameParameter("username")
                // login 페이지에서 전달하는 사용자의 패스워드 값
                .passwordParameter("password")
                .and()
                .logout()
                .logoutRequestMatcher(new AntPathRequestMatcher("/common/logout")) // 로그아웃 요청 리소스
                .deleteCookies("JSESSIONID")// session id 쿠키 삭제
                .invalidateHttpSession(true) // session 만료 설정
                .logoutSuccessUrl("/") // logout시 이동되는 페이지
                .and()
                .sessionManagement() // 세션 설정을 해주겠다는 메소드
                .maximumSessions(1) // 동일 세션으로 1명의 사용자만 로그인 허용
                .expiredUrl("/") // 이미 로그인이 되어 세션 생성에 제한이 되었을 경우 리다이렉트 할 주소
                .maxSessionsPreventsLogin(false); // boolean 값으로 false : 이전 사용자의 강제 로그아웃 true : 신규 사용자의 로그인 실패
        return http.build();
    }
}