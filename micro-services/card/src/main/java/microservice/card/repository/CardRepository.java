package microservice.card.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import microservice.card.entity.Card;

public interface CardRepository extends JpaRepository<Card, Integer> {
}