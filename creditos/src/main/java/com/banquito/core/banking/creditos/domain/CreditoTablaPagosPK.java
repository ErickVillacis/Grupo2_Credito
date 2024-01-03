package com.banquito.core.banking.creditos.domain;

import java.io.Serializable;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Embeddable
public class CreditoTablaPagosPK implements Serializable {

    @Column(name = "COD_CREDITO", nullable = false)
    private Integer codCredito;

    @Column(name = "COD_CUOTA", nullable = false, length = 3)
    private Integer codCuota;

    public CreditoTablaPagosPK(Integer codCredito, Integer codCuota) {
        this.codCredito = codCredito;
        this.codCuota = codCuota;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((codCredito == null) ? 0 : codCredito.hashCode());
        result = prime * result + ((codCuota == null) ? 0 : codCuota.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        CreditoTablaPagosPK other = (CreditoTablaPagosPK) obj;
        if (codCredito == null) {
            if (other.codCredito != null)
                return false;
        } else if (!codCredito.equals(other.codCredito))
            return false;
        if (codCuota == null) {
            if (other.codCuota != null)
                return false;
        } else if (!codCuota.equals(other.codCuota))
            return false;
        return true;
    }

}
