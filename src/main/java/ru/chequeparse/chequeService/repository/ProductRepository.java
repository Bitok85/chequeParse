package ru.chequeparse.chequeService.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.chequeparse.chequeService.model.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product, Integer> {

}
