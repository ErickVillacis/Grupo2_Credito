package com.banquito.core.banking.creditos.dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.banquito.core.banking.creditos.domain.TipoCredito;

public interface TipoCreditoRepository extends CrudRepository<TipoCredito, Long> {

    TipoCredito findByCodigo(Long codigo);

    List<TipoCredito> findByNombre(String nombre);

    List<TipoCredito> findByTipoClienteAndUnidadPlazo(String tipoCliente, String unidadPlazo);

    List<TipoCredito> findByPlazoMinimoGreaterThanEqualAndPlazoMaximoLessThanEqual(Long plazoMinimo, Long plazoMaximo);

    List<TipoCredito> findByMontoMinimoGreaterThanEqualAndMontoMaximoLessThanEqual(Double montoMinimo,
            Double montoMaximo);

    List<TipoCredito> findByEstadoAndFechaCreacionBetween(String estado, Date startDate, Date endDate);

}