package microservice.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import microservice.user.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {
}
