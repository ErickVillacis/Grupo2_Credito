package com.banquito.core.banking.creditos.domain;

import java.io.Serializable;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

@Getter
@Setter
@NoArgsConstructor
@Embeddable

public class CreditoIntervinientePK implements Serializable {

    @Column(name = "COD_CREDITO", nullable = false)
    private Long codCredito;

    @Column(name = "COD_CLIENTE", nullable = false)
    private Long codCliente;

    public CreditoIntervinientePK(Long codCredito, Long codCliente) {
        this.codCredito = codCredito;
        this.codCliente = codCliente;
    }

}
