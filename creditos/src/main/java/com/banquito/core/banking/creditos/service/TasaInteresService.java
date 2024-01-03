package com.banquito.core.banking.creditos.service;

import org.springframework.stereotype.Service;

import com.banquito.core.banking.creditos.dao.TasaInteresRepository;
import com.banquito.core.banking.creditos.domain.TasaInteres;
import com.banquito.core.banking.creditos.utils.EncontrarException;
import com.banquito.core.banking.creditos.utils.TransaccionException;
import com.banquito.core.banking.creditos.utils.ValidacionException;

import jakarta.transaction.Transactional;

@Service
public class TasaInteresService {
    private final TasaInteresRepository tasaInteresRepository;

    public TasaInteresService(TasaInteresRepository tasaInteresRepository) {
        this.tasaInteresRepository = tasaInteresRepository;
    }

    @Transactional
    public TasaInteres crearTasaInteres(TasaInteres tasaInteres) {
        try {
            validarTasaInteres(tasaInteres);
            return tasaInteresRepository.save(tasaInteres);
        } catch (Exception e) {
            throw new TransaccionException("Error en creación de tasa de interés: " + tasaInteres + ", el error es: " + e);
        }
    }

    @Transactional
    public TasaInteres obtenerTasaInteresPorId(String id) {
        return tasaInteresRepository.findById(id)
                .orElseThrow(() -> new EncontrarException("No se pudo encontrar la tasa de interés con el ID: " + id));
    }

    @Transactional
    public TasaInteres actualizarTasaInteres(TasaInteres tasaInteres) {
        try {
            validarTasaInteres(tasaInteres);
            return tasaInteresRepository.save(tasaInteres);
        } catch (Exception e) {
            throw new TransaccionException("Error en actualización de tasa de interés: " + tasaInteres + ", el error es: " + e);
        }
    }

    @Transactional
    public void eliminarTasaInteresPorId(String id) {
        try {
            tasaInteresRepository.deleteById(id);
        } catch (Exception e) {
            throw new TransaccionException("Error al eliminar la tasa de interés con ID: " + id + ", el error es: " + e);
        }
    }

    private void validarTasaInteres(TasaInteres tasaInteres) {
        if (tasaInteres.getCodigo() == null || tasaInteres.getCodigo().isEmpty()) {
            throw new ValidacionException("El código de tasa de interés es requerido");
        }
    }
}
