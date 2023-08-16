package com.example.securitytask.config;


//import com.example.securitytask.filter.V1Filter;
//import com.example.securitytask.filter.V1Interceptor;
import com.example.securitytask.filter.HomeFilter;
import com.example.securitytask.filter.V1Filter;
import com.example.securitytask.service.MyUserService;
import com.fasterxml.jackson.databind.annotation.NoClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.proxy.NoOp;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.method.P;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfigurer{
    @Autowired
    private MyUserService userService;
    @Autowired
    private AuthenticationSuccessHandler authenticationSuccessHandler;
    @Autowired
    private CustomLogoutHandler customLogoutHandler;
    @Autowired
    private HomeFilter homeFilter;

    @Bean
    public PasswordEncoder passwordEncoder(){

        return NoOpPasswordEncoder.getInstance();
    }


    @Autowired
    private V1Filter v1Filter;

    @Bean
    public DaoAuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider auth = new DaoAuthenticationProvider();
        auth.setUserDetailsService(userService);
        auth.setPasswordEncoder(passwordEncoder());
        return auth;
    }

    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        http.csrf().disable()
                .addFilterBefore(v1Filter, UsernamePasswordAuthenticationFilter.class)
                .addFilterBefore(homeFilter,UsernamePasswordAuthenticationFilter.class)
                .authorizeRequests()
                .antMatchers("/register","/login")
                .permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin().loginPage("/login").successHandler(authenticationSuccessHandler)
                .and().csrf().disable()
                .logout().logoutUrl("/logout").logoutSuccessHandler(customLogoutHandler)
                .and()
                .oauth2Login().loginPage("/login").successHandler(authenticationSuccessHandler)
                .and().sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        return http.build();
    }

}
