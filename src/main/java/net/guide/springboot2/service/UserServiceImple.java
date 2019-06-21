package net.guide.springboot2.service;

import net.guide.springboot2.model.User;
import net.guide.springboot2.repository.RoleRepository;
import net.guide.springboot2.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.HashSet;

public class UserServiceImple implements  UserService{

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;


    @Override
    public void save(User user) {
       user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
       user.setRoles(new HashSet<>(roleRepository.findAll()));
       userRepository.save(user);
    }

    @Override
    public User findByUserName(String userName) {
        return userRepository.findByUsername(userName);
    }
}
