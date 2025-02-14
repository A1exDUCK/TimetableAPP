package rut.miit.services;

import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import rut.miit.dto.UserRegistrationDto;
import rut.miit.models.entities.User;
import rut.miit.models.enums.UserRoles;
import rut.miit.repositories.UserRepository;
import rut.miit.repositories.UserRoleRepository;

import java.util.List;
import java.util.Optional;


public interface AuthService {

    void register(UserRegistrationDto registrationDTO);

    User getUser(String username);
}
