package com.example.demo.config;

import com.example.demo.Security.AuthProviderImple;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
@Configuration
@EnableWebSecurity
@ComponentScan("com.example.demo.Security")
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private AuthProviderImple authProviderImple;
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/","/adminlogin","/timetable").anonymous()
                .antMatchers("/admin", "/admin/add", "/admin/ad", "/admin/edit/{id}", "/admin/edit/{id}", "/admin/delite/{id}", "/admin/search",
                        "/day", "/day/add", "/day/ad", "/day/delite/{id}", "/day/edit/{id}", "/day/edit/{id}",
                        "/grouup", "/grouup/add", "/grouup/ad", "/grouup/edit/{id}", "/grouup/edit/{id}", "/grouup/delite/{id}", "/grouup/search",
                        "/lessons", "/lessons/add", "/lessons/ad", "/lessons/edit/{id}", "/lessons/edit/{id}", "/lessons/delite/{id}", "/lessons/search",
                        "/pair", "/pair/add", "/pair/ad", "/pair/delite/{id}", "/pair/edit/{id}", "/pair/edit/{id}",
                        "/room", "/room/add", "/room/ad", "/room/edit/{id}", "/room/edit/{id}", "/room/delite/{id}", "/room/search",
                        "/timetablee", "/timetable/search", "/timetable/delite/{id}", "/timetable/add", "/timetable/ad", "/timetable/edit/{id}", "/timetable/edit/{id}",
                        "/students", "/students/add", "/students/ad", "/students/edit/{id}", "/students/edit/{id}", "/students/delite/{id}", "/students/search",
                        "/list", "/list/search", "/list/delite/{id}", "/list/add", "/list/ad", "/list/edit/{id}", "/list/edit/{id}"
                ).authenticated()
                .and().csrf().disable()
                .formLogin().loginPage("/adminlogin")
                .loginProcessingUrl("/login")
                .usernameParameter("username")
                .and().exceptionHandling().accessDeniedPage("/admin")
                .and().logout();
    }
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authProviderImple);
    }
}
