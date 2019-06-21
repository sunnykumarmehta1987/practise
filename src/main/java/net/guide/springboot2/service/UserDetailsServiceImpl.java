package net.guide.springboot2.service;

import net.guide.springboot2.model.User;
import net.guide.springboot2.model.Role;
import net.guide.springboot2.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
      User user = userRepository.findByUsername(userName);
      if(user==null){
          throw new UsernameNotFoundException(userName);
      }
      Set<GrantedAuthority> grantedAuthorities = new HashSet<GrantedAuthority>();
      for(Role role:user.getRoles()){
          grantedAuthorities.add(new SimpleGrantedAuthority(role.getRoleName()));
      }
      return new org.springframework.security.core.userdetails.User(user.getUsername(),user.getPassword(),grantedAuthorities);
    }
}
