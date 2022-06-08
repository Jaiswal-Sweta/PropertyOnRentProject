package com.example.credential.config;

import com.example.credential.services.CustomUserdetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;


import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class SecurityConfigure extends WebSecurityConfigurerAdapter {

    @Autowired
    DataSource dataSource;

    @Autowired
     CustomUserdetail customUserdetail;

    @Autowired
    JwtRequestFilter jwtRequestFilter;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {  // which is use to configure conncection with authentication
        // configure authentication so that it knows from where to load.
        // user for matching credentials.
        auth.userDetailsService(customUserdetail).passwordEncoder(encoder());
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return authenticationManager();
    }

    @Bean
    public PasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .cors().disable()
                .csrf().disable()// kind of attack
                //don't authenticate this particular request.
                .authorizeRequests().antMatchers("/registration/**", "/login/authentication").permitAll()
                //all other requests need to be authenticate
                .antMatchers("/user/**").hasRole("User")
                .antMatchers("/admin/**").hasRole("Admin")
                .antMatchers("/vendor/**").hasRole("Vendor")
                .antMatchers("/login/changepassword/**", "/login/updateuser/**", "/login/profile/**").hasAnyRole("Admin", "User", "Vendor")
                .anyRequest().authenticated().and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS); //it's remain same when change state

        http.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
    }
}
