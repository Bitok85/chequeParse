package ru.chequeparse.chequeService.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NamedEntityGraph(name = "BuyerGraph", attributeNodes = {
        @NamedAttributeNode("chequeUrls"), @NamedAttributeNode("products")
})
public class Buyer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private int id;

    @Column(name = "tg_name")
    private String tgName;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "buyer_id")
    private Set<ChequeUrl> chequeUrls;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "buyer_id")
    private Set<Product> products;

}
