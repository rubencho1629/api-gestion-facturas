package com.api.gestion.security;

import com.api.gestion.dao.UserDao;
import com.api.gestion.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class CustomerDetailsService implements UserDetailsService {

    @Autowired
    private UserDao userDao;

    private User userdetail;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        userdetail = userDao.findByEmail(email);
        if (userdetail == null) {
            throw new UsernameNotFoundException("User not found with email: " + email);
        }
        return new org.springframework.security.core.userdetails.User(userdetail.getEmail(), userdetail.getPassword(), new ArrayList<>());
    }

    public User getUserdetail() {
        return userdetail;
    }
}
