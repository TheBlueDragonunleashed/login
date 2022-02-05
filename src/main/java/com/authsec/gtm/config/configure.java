package com.authsec.gtm.config;


import com.authsec.gtm.service.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.sql.DataSource;

@EnableWebMvc
@Configuration
public class configure extends WebSecurityConfigurerAdapter {


    @Autowired
    private UserDetailsService userDetailsService;

    @Bean
    protected AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider= new DaoAuthenticationProvider();
//                authProvider.setPasswordEncoder(new BCryptPasswordEncoder());

                authProvider.setPasswordEncoder(NoOpPasswordEncoder.getInstance());
        authProvider.setUserDetailsService(userDetailsService());
        return authProvider;
    }

    //

    @Bean
    public PasswordEncoder passwordEncoder()
    {
        return new BCryptPasswordEncoder(10);
    }
//
//    @Bean
//    public DaoAuthenticationProvider authenProvider()
//    {
//        DaoAuthenticationProvider authProvider= new DaoAuthenticationProvider();
//        authProvider.setPasswordEncoder(passwordEncoder());
//        authProvider.setUserDetailsService(userDetailsService());
//        return authProvider;
//    }


//    @Override
//    public void configure(WebSecurity web) throws Exception {
//        super.configure(web);
//    }
    @Override
    protected void configure(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
        authenticationManagerBuilder.authenticationProvider(authenticationProvider());
    }


    //    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.inMemoryAuthentication().withUser("john").password(passwordEncoder().encode("jerry")).roles("user");
//
//    }


    @Bean
    public UserDetailsService userDetailsService(){

        return new CustomUserDetailsService();
    }


//



//

    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable().
                authorizeRequests()


//                .antMatchers("/userRegister").permitAll()
                .antMatchers("/welcome").authenticated()

                .anyRequest().permitAll().

                and().formLogin()
                .loginPage("/hey")



                .usernameParameter("email")
                .defaultSuccessUrl("/welcome").permitAll()
                .and()
                .logout().logoutSuccessUrl("/").permitAll();
//                .logoutSuccessUrl("/welcome").invalidateHttpSession(true)
//                .clearAuthentication(true)
//                .logoutRequestMatcher(new AntPathRequestMatcher(
//                        "/logout"
//                ))
//                .logoutSuccessUrl("/logout-success").permitAll();

    }





}
