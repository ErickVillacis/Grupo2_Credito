package com.banquito.core.banking.creditos.service;

import org.springframework.stereotype.Service;

import com.banquito.core.banking.creditos.dao.CreditoRepository;
import com.banquito.core.banking.creditos.domain.Credito;
import com.banquito.core.banking.creditos.utils.EncontrarException;
import com.banquito.core.banking.creditos.utils.TransaccionException;
import com.banquito.core.banking.creditos.utils.ValidacionException;

import jakarta.transaction.Transactional;



@Service
public class CreditoService {
    private final CreditoRepository creditoRepository;

    public CreditoService(CreditoRepository creditoRepository) {
        this.creditoRepository = creditoRepository;
    }

    @Transactional
    public Credito crearCredito(Credito credito) {
        try {
            validarCredito(credito);
            return creditoRepository.save(credito);
        } catch (Exception e) {
            throw new TransaccionException("Error en creación de crédito: " + credito + ", el error es: " + e);
        }
    }

    @Transactional
    public Credito obtenerCreditoPorId(Long id) {
        return creditoRepository.findById(id)
                .orElseThrow(() -> new EncontrarException("No se pudo encontrar el crédito con el ID: " + id));
    }

    @Transactional
    public Credito actualizarCredito(Credito credito) {
        try {
            validarCredito(credito);
            return creditoRepository.save(credito);
        } catch (Exception e) {
            throw new TransaccionException("Error en actualización de crédito: " + credito + ", el error es: " + e);
        }
    }

    @Transactional
    public void eliminarCreditoPorId(Long id) {
        try {
            creditoRepository.deleteById(id);
        } catch (Exception e) {
            throw new TransaccionException("Error al eliminar el crédito con ID: " + id + ", el error es: " + e);
        }
    }

    private void validarCredito(Credito credito) {
        if (credito.getNumeroOperacion() == null || credito.getNumeroOperacion().isEmpty()) {
            throw new ValidacionException("El número de operación es requerido");
        }
    }
}