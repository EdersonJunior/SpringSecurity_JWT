package pokerstarstournament.tournament.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pokerstarstournament.tournament.model.entity.UserLogin;

public interface UserLoginRepository extends JpaRepository<UserLogin, Long> {

    UserLogin findByUserName(String userName);
}
