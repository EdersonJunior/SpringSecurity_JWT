package pokerstarstournament.tournament.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pokerstarstournament.tournament.model.entity.UserLogin;
import pokerstarstournament.tournament.repository.UserLoginRepository;

@RestController
@RequestMapping("/users")
public class UserLoginController {

    @Autowired
    private UserLoginRepository repository;

    @Autowired
    private BCryptPasswordEncoder encoder;

    public UserLoginController(UserLoginRepository repository, BCryptPasswordEncoder encoder) {
        this.repository = repository;
        this.encoder = encoder;
    }

    @PostMapping("/sign-up")
    public ResponseEntity signUp(@RequestBody UserLogin user) {
        user.setPassword(encoder.encode(user.getPassword()));
        repository.save(user);
        return new ResponseEntity("User Registered Successfully", HttpStatus.CREATED);
    }
}
