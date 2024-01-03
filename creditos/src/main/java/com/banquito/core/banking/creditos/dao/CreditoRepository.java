package com.banquito.core.banking.creditos.dao;

import java.sql.Date;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.banquito.core.banking.creditos.domain.Credito;

public interface CreditoRepository extends CrudRepository<Credito, Long> {

    Credito findByNumeroOperacion(String numeroOperacion);

    List<Credito> findByCodigoTipoCreditoAndCodigoCliente(Integer codigoTipoCredito, Integer codigoCliente);

    List<Credito> findByFechaCreacionBetween(Date startDate, Date endDate);

    List<Credito> findByFechaDesembolsoBefore(Date fechaDesembolso);

    List<Credito> findByEstadoAndMontoGreaterThan(String estado, long monto);

    List<Credito> findByCapitalPendienteLessThan(long capitalPendiente);

}
