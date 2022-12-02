package microservice.card.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import microservice.card.entity.CardReference;

public interface CardReferenceRepository extends JpaRepository<CardReference, Integer> {
}
