package com.assignment.ecom.service;

import com.assignment.ecom.model.User;

public interface UserService {
    void save(User user);

    User findByUsername(String username);
}
