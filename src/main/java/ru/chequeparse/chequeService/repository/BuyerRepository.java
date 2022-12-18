package ru.chequeparse.chequeService.repository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.chequeparse.chequeService.model.Buyer;

import java.util.Optional;

@Repository
public interface BuyerRepository extends CrudRepository<Buyer, Integer> {

    Optional<Buyer> findByTgName(String tgName);
}
