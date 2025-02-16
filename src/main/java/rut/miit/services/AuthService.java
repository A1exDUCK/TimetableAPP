package rut.miit.services;

import rut.miit.dto.UserRegistrationDto;
import rut.miit.models.entities.User;


public interface AuthService {

    void register(UserRegistrationDto registrationDTO);

    User getUser(String username);
}
