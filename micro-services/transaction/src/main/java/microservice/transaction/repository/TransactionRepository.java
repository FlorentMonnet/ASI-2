package microservice.transaction.repository;

import org.springframework.data.repository.CrudRepository;

import microservice.transaction.entity.Transaction;

public interface TransactionRepository extends CrudRepository<Transaction, Integer> {

}
