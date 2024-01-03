package com.banquito.core.banking.creditos.dao;

import java.sql.Date;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.banquito.core.banking.creditos.domain.CreditoTablaPagos;

public interface CreditoTablaPagosRepository extends CrudRepository<CreditoTablaPagos, Integer> {

    CreditoTablaPagos findbyFechaPlanificadPagoAndEstado(Date fechaPlanificadaPago, String estado);

    List<CreditoTablaPagos> findByCreditoTablaPagosPKCodCredito(Integer codCredito);

    List<CreditoTablaPagos> findByCreditoTablaPagosPKCodCuota(Integer codCuota);

    List<CreditoTablaPagos> findByFechaPlanificadaPagoBetween(Date startDate, Date endDate);

    List<CreditoTablaPagos> findByEstado(String estado);

    List<CreditoTablaPagos> findByMontoCuotaGreaterThan(long montoCuota);

    List<CreditoTablaPagos> findByFechaPagoEfectivoBefore(Date fechaPagoEfectivo);
}
