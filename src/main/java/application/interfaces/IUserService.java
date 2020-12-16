package application.interfaces;

import application.DTOOjbects.UserRegisterDTO;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface IUserService extends UserDetailsService {
    long save(UserRegisterDTO user);
}
