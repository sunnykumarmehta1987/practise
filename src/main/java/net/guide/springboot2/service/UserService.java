package net.guide.springboot2.service;

import net.guide.springboot2.model.User;

public interface UserService {
    void save(User user);

    User findByUserName(String userName);

}
