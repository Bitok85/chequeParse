package ru.chequeparse;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;
import ru.chequeparse.chequeService.repository.BuyerRepository;
import ru.chequeparse.chequeService.repository.ChequeUrlRepository;
import ru.chequeparse.chequeService.repository.ProductRepository;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest(classes = ChequeParseApplication.class)
@ActiveProfiles("test")
@TestPropertySource("classpath:application.properties")
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_CLASS)

public class RepositoryTests {

    @Autowired
    private BuyerRepository buyerRepository;

    @Autowired
    private ChequeUrlRepository chequeUrlRepository;

    @Autowired
    private ProductRepository productRepository;

    @Test
    public void whenFindAllBuyers() {
        assertThat(buyerRepository.findAll()).hasSize(2);
    }
}
