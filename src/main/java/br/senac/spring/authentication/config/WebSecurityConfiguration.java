package br.senac.spring.authentication.config;

import br.senac.spring.authentication.filter.JWTAuthenticationFilter;
import br.senac.spring.authentication.security.TokenValidation;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;

import java.util.List;

@Configuration
@EnableWebSecurity
@AllArgsConstructor
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {

//    private final ObjectMapper objectMapper;
//    private final TokenValidation tokenValidation;

    private final String[] AUTH_WHITELIST = {
            "/account/*",
            "/h2-console",
            "/h2-console/*"
    };

//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.cors()
//                .configurationSource(request -> {
//                    var cors = new CorsConfiguration();
//                    cors.setAllowedOrigins(List.of("*"));
//                    cors.setAllowedMethods(List.of("GET", "POST", "PUT", "DELETE", "OPTIONS", "PATCH"));
//                    cors.setAllowedHeaders(List.of("*"));
//                    return cors;
//                })
//                .and()
//                .csrf().disable().authorizeRequests()
//                .anyRequest().authenticated()
//                .and()
//                .addFilterBefore(new JWTAuthenticationFilter(objectMapper, tokenValidation), UsernamePasswordAuthenticationFilter.class);
//    }

    @Override
    public void configure(WebSecurity web) {
        web.ignoring().antMatchers(AUTH_WHITELIST);
    }

}

