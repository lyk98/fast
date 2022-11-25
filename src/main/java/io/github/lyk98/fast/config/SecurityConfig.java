package io.github.lyk98.fast.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.DefaultSecurityFilterChain;

/**
 * @author 罗益宽
 * @date 2022/11/25 13:16
 */
@Configuration
public class SecurityConfig {
    @Bean
    public DefaultSecurityFilterChain springSecurity(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .headers().frameOptions().disable();

        return http.build();
    }
}
