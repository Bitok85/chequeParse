package ru.chequeparse.chequeService.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.chequeparse.chequeService.model.ChequeUrl;
import ru.chequeparse.chequeService.repository.ChequeUrlRepository;

import java.util.Optional;

@Service
@AllArgsConstructor
public class ChequeUrlService {

    private ChequeUrlRepository store;

    public Optional<ChequeUrl> findChequeUrlByCUrl(String chequeUrl) {
        return store.findChequeUrlByCUrl(chequeUrl);
    }
}
