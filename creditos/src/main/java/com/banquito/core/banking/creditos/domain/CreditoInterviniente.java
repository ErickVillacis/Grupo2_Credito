package com.banquito.core.banking.creditos.domain;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Version;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "CREDITO_INTERVINIENTE")
public class CreditoInterviniente {

    @EmbeddedId
    private CreditoIntervinientePK intervinientePK;

    @Column(name = "TIPO", nullable = false, length = 3)
    private String tipo;

    @ManyToOne()
    @JoinColumn(name = "COD_CREDITO")
    private Credito credito;

    public CreditoInterviniente(CreditoIntervinientePK intervinientePK) {
        this.intervinientePK = intervinientePK;
    }

    @Version
    long version;
}
