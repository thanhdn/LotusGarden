package com.lilyle.lotus.service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lilyle.lotus.model.Customers;

@Service
@Transactional(rollbackFor = Exception.class)
public class UserDetailsServiceImpl implements UserDetailsService {
    
    @Autowired
    private CustomerService customerService;
    
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Customers cus = customerService.findById(Long.valueOf(username));
        Set<GrantedAuthority> grantedAuthorities = new HashSet<GrantedAuthority>();
        grantedAuthorities.add(new SimpleGrantedAuthority(cus.getGoldmember() == 1 ? "1" : "0"));
        return new org.springframework.security.core.userdetails.User(String.valueOf(cus.getCustomerId()), cus.getPassword(), grantedAuthorities);
    }

}
