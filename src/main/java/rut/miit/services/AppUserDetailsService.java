package rut.miit.services;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import rut.miit.repositories.UserRepository;

import java.util.stream.Collectors;

public interface AppUserDetailsService{

    UserDetails loadUserByUsername(String username) throws UsernameNotFoundException;
}
