package com.banquito.core.banking.creditos.dao;

import org.springframework.data.repository.CrudRepository;

import com.banquito.core.banking.creditos.domain.CreditoInterviniente;
import com.banquito.core.banking.creditos.domain.CreditoIntervinientePK;

import java.util.List;

public interface CreditoIntervinienteRepository extends CrudRepository<CreditoInterviniente, CreditoIntervinientePK> {
    List<CreditoInterviniente> findByIntervinientePKCodCredito(Long codCredito);

    List<CreditoInterviniente> findByIntervinientePKCodCliente(Long codCliente);

    List<CreditoInterviniente> findByTipoAndIntervinientePKCodCredito(String tipo, Long codCredito);

    void deleteByIntervinientePKCodCredito(Long codCredito);

    void deleteByIntervinientePKCodCliente(Long codCliente);
}
