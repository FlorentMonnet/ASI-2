package microservice.user.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import microservice.user.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	Optional<User> findByMail(String mail);
}
