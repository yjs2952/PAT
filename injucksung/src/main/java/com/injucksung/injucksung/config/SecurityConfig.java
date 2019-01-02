package com.injucksung.injucksung.config;

import com.injucksung.injucksung.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    private final UserService userService;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/resoures/**", "/static/**", "/css/**", "js/**", "/images/**");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
//        http
//            .logout()
//                .logoutRequestMatcher(new AntPathRequestMatcher("/session"))
//                .logoutSuccessUrl("/")
//                .permitAll().and()
//            .authorizeRequests()
//                .antMatchers("/errors/**").permitAll()
//                .antMatchers("/").permitAll()
//                .antMatchers("/admin").hasRole("ADMIN")
//                .antMatchers("/users").permitAll()
//                .antMatchers("/users/**").hasRole("USER")
//                .anyRequest().fullyAuthenticated().and()
//            .formLogin()
//                .loginPage("/session")
//                .usernameParameter("email").passwordParameter("password")
//                .loginProcessingUrl("/session")
//                .failureUrl("/session")
//                .permitAll();


        http
            .authorizeRequests()
                .antMatchers("/","/users").permitAll()
                .antMatchers("/admin").hasAuthority("ROLE_ADMIN")
                .anyRequest().authenticated()
                .and()
            .formLogin()
                .loginPage("/session")
                .loginProcessingUrl("/session")
                .permitAll()
                .and()
            .logout()
                .logoutSuccessUrl("/")
                .permitAll();
    }
}
