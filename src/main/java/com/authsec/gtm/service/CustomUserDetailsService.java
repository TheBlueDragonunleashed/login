package com.authsec.gtm.service;


import com.authsec.gtm.entity.User;
import com.authsec.gtm.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

//yo xutera naako thiyo ra
@Service
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    UserRepository userRepository;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User u=userRepository.findUserByEmail(username);
       if(u==null) {
           System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@youser not found ");


           throw new UsernameNotFoundException("usernotfound");
       }
System.out.println(userRepository.findUserByEmail(username));
        System.out.println(username);
        return new CustomerUserDetails(u);

    }


}
