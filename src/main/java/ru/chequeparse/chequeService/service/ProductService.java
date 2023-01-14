package ru.chequeparse.chequeService.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.chequeparse.chequeService.repository.ProductRepository;

@Service
@AllArgsConstructor
public class ProductService {

    private ProductRepository store;

}
