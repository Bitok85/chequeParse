package ru.chequeparse.chequeService.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.chequeparse.chequeService.model.Buyer;
import ru.chequeparse.chequeService.repository.BuyerRepository;

import java.util.Optional;

@Service
@AllArgsConstructor
public class BuyerService {

    private BuyerRepository store;

    public Optional<Buyer> findByTgName(String tgName) {
        return store.findByTgName(tgName);
    }
}
