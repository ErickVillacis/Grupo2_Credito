package com.banquito.core.banking.creditos.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.banquito.core.banking.creditos.domain.Credito;
import com.banquito.core.banking.creditos.domain.TasaInteres;
import com.banquito.core.banking.creditos.domain.TipoCredito;
import com.banquito.core.banking.creditos.service.CreditoService;
import com.banquito.core.banking.creditos.service.TasaInteresService;
import com.banquito.core.banking.creditos.service.TipoCreditoService;

@RestController
@RequestMapping("/creditos")
public class CreditoController {

    private final CreditoService creditoService;
    private final TasaInteresService tasaInteresService;
    private final TipoCreditoService tipoCreditoService;

    public CreditoController(CreditoService creditoService, TasaInteresService tasaInteresService,
            TipoCreditoService tipoCreditoService) {
        this.creditoService = creditoService;
        this.tasaInteresService = tasaInteresService;
        this.tipoCreditoService = tipoCreditoService;
    }

    // Endpoints para CreditoService
    @PostMapping("/crearCredito")
    public ResponseEntity<Credito> crearCredito(@RequestBody Credito credito) {
        return ResponseEntity.ok(creditoService.crearCredito(credito));
    }

    @GetMapping("/obtenerCreditoPorId/{id}")
    public ResponseEntity<Credito> obtenerCreditoPorId(@PathVariable Long id) {
        return ResponseEntity.ok(creditoService.obtenerCreditoPorId(id));
    }

    @PutMapping("/actualizarCredito")
    public ResponseEntity<Credito> actualizarCredito(@RequestBody Credito credito) {
        return ResponseEntity.ok(creditoService.actualizarCredito(credito));
    }

    @DeleteMapping("/eliminarCreditoPorId/{id}")
    public ResponseEntity<String> eliminarCreditoPorId(@PathVariable Long id) {
        creditoService.eliminarCreditoPorId(id);
        return ResponseEntity.ok("Credito eliminado correctamente");
    }

    // Endpoints para TasaInteresService
    @PostMapping("/crearTasaInteres")
    public ResponseEntity<TasaInteres> crearTasaInteres(@RequestBody TasaInteres tasaInteres) {
        return ResponseEntity.ok(tasaInteresService.crearTasaInteres(tasaInteres));
    }

    @GetMapping("/obtenerTasaInteresPorId/{id}")
    public ResponseEntity<TasaInteres> obtenerTasaInteresPorId(@PathVariable String id) {
        return ResponseEntity.ok(tasaInteresService.obtenerTasaInteresPorId(id));
    }

    @PutMapping("/actualizarTasaInteres")
    public ResponseEntity<TasaInteres> actualizarTasaInteres(@RequestBody TasaInteres tasaInteres) {
        return ResponseEntity.ok(tasaInteresService.actualizarTasaInteres(tasaInteres));
    }

    @DeleteMapping("/eliminarTasaInteresPorId/{id}")
    public ResponseEntity<String> eliminarTasaInteresPorId(@PathVariable String id) {
        tasaInteresService.eliminarTasaInteresPorId(id);
        return ResponseEntity.ok("Tasa de Interes eliminada correctamente");
    }

    // Endpoints para TipoCreditoService
    @PostMapping("/crearTipoCredito")
    public ResponseEntity<TipoCredito> crearTipoCredito(@RequestBody TipoCredito tipoCredito) {
        return ResponseEntity.ok(tipoCreditoService.crearTipoCredito(tipoCredito));
    }

    @GetMapping("/obtenerTipoCreditoPorId/{id}")
    public ResponseEntity<TipoCredito> obtenerTipoCreditoPorId(@PathVariable Long id) {
        return ResponseEntity.ok(tipoCreditoService.obtenerTipoCreditoPorId(id));
    }

    @PutMapping("/actualizarTipoCredito")
    public ResponseEntity<TipoCredito> actualizarTipoCredito(@RequestBody TipoCredito tipoCredito) {
        return ResponseEntity.ok(tipoCreditoService.actualizarTipoCredito(tipoCredito));
    }

    @DeleteMapping("/eliminarTipoCreditoPorId/{id}")
    public ResponseEntity<String> eliminarTipoCreditoPorId(@PathVariable Long id) {
        tipoCreditoService.eliminarTipoCreditoPorId(id);
        return ResponseEntity.ok("Tipo de Crédito eliminado correctamente");
    }

}
