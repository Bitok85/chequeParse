package ru.chequeparse.chequeService.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;
import ru.chequeparse.chequeService.model.ChequeUrl;

import java.util.Optional;

@Repository
public interface ChequeUrlRepository extends CrudRepository<ChequeUrl, Integer> {

    Optional<ChequeUrl> findBycUrl(String cUrl);
}
