package com.banquito.core.banking.creditos.service;

import org.springframework.stereotype.Service;

import com.banquito.core.banking.creditos.dao.TipoCreditoRepository;
import com.banquito.core.banking.creditos.domain.TipoCredito;
import com.banquito.core.banking.creditos.utils.EncontrarException;
import com.banquito.core.banking.creditos.utils.TransaccionException;
import com.banquito.core.banking.creditos.utils.ValidacionException;

import jakarta.transaction.Transactional;

@Service
public class TipoCreditoService {
    private final TipoCreditoRepository tipoCreditoRepository;

    public TipoCreditoService(TipoCreditoRepository tipoCreditoRepository) {
        this.tipoCreditoRepository = tipoCreditoRepository;
    }

    @Transactional
    public TipoCredito crearTipoCredito(TipoCredito tipoCredito) {
        try {
            validarTipoCredito(tipoCredito);
            return tipoCreditoRepository.save(tipoCredito);
        } catch (Exception e) {
            throw new TransaccionException("Error en creación de tipo de crédito: " + tipoCredito + ", el error es: " + e);
        }
    }

    @Transactional
    public TipoCredito obtenerTipoCreditoPorId(Long id) {
        return tipoCreditoRepository.findById(id)
                .orElseThrow(() -> new EncontrarException("No se pudo encontrar el tipo de crédito con ID: " + id));
    }

    @Transactional
    public TipoCredito actualizarTipoCredito(TipoCredito tipoCredito) {
        try {
            validarTipoCredito(tipoCredito);
            return tipoCreditoRepository.save(tipoCredito);
        } catch (Exception e) {
            throw new TransaccionException("Error en actualización de tipo de crédito: " + tipoCredito + ", el error es: " + e);
        }
    }

    @Transactional
    public void eliminarTipoCreditoPorId(Long id) {
        try {
            tipoCreditoRepository.deleteById(id);
        } catch (Exception e) {
            throw new TransaccionException("Error al eliminar el tipo de crédito con ID: " + id + ", el error es: " + e);
        }
    }

    private void validarTipoCredito(TipoCredito tipoCredito) {
        if (tipoCredito.getNombre() == null || tipoCredito.getNombre().isEmpty()) {
            throw new ValidacionException("El nombre del tipo de crédito es requerido");
        }
    }
}
