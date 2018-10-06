package pokerstarstournament.tournament.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pokerstarstournament.tournament.model.entity.Player;

@RestController
@RequestMapping("/tournaments")
public class TournamentController {

    @PostMapping
    public ResponseEntity register(@RequestBody Player player) {
        return new ResponseEntity("Registered Successfully", HttpStatus.CREATED);
    }
}
