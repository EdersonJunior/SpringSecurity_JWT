package pokerstarstournament.tournament.security.service;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import pokerstarstournament.tournament.model.entity.UserLogin;
import pokerstarstournament.tournament.repository.UserLoginRepository;

import static java.util.Collections.emptyList;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    private UserLoginRepository repository;

    public UserDetailsServiceImpl(UserLoginRepository repository) {
        this.repository = repository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserLogin userLogin = repository.findByUserName(username);
        if (userLogin == null) {
            throw new UsernameNotFoundException(username);
        }
        return new User(userLogin.getUserName(), userLogin.getPassword(), emptyList());
    }
}