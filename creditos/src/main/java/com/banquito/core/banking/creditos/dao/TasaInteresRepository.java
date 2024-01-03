package com.banquito.core.banking.creditos.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import com.banquito.core.banking.creditos.domain.TasaInteres;

public interface TasaInteresRepository extends CrudRepository<TasaInteres, String> {
    TasaInteres findbyTipoTasaInteres(String tipo);

    TasaInteres findByCodigo(String codigo);

    List<TasaInteres> findByTipo(String tipo);

    List<TasaInteres> findByNombreContaining(String nombre);

    List<TasaInteres> findByTasaMinimaGreaterThanEqualAndTasaMaximaLessThanEqual(double tasaMinima, double tasaMaxima);
}
