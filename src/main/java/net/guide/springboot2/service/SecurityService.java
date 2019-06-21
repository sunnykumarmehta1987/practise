package net.guide.springboot2.service;

//To Provide currentLoggedInUser
public interface SecurityService {

    String findLoggedInUser();

    void autoLogin(String user,String password);
}
