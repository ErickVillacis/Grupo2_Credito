package com.banquito.core.banking.creditos.domain;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.persistence.Version;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "CREDITO_TABLA_PAGOS")
public class CreditoTablaPagos {

    @EmbeddedId
    private CreditoTablaPagosPK creditoTablaPagosPK;

    @Id
    @Column(name = "COD_CUOTA", nullable = false, length = 3)
    private Integer codigoCuota;

    @Column(name = "CAPITAL", nullable = false, length = 18, scale = 2)
    private long capital;

    @Column(name = "INTERES", nullable = false, length = 18, scale = 2)
    private long interes;

    @Column(name = "MONTO_CUOTA", nullable = false, length = 18, scale = 2)
    private long montoCuota;

    @Column(name = "CAPITAL_RESTANTE", nullable = false, length = 18, scale = 2)
    private long capitalRestante;

    @Column(name = "FECHA_PLANIFICADA_PAGO", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fechaPlanificadaPago;

    @Column(name = "ESTADO", nullable = false, length = 3)
    private String estado;

    @Column(name = "FECHA_PAGO_EFECTIVO", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaPagoEfectivo;

    @Column(name = "TRANSACCION_PAGO", nullable = false, length = 64)
    private String transaccionPago;

    @Version
    private Version version;

    public CreditoTablaPagos(CreditoTablaPagosPK creditoTablaPagosPK) {
        this.creditoTablaPagosPK = creditoTablaPagosPK;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((creditoTablaPagosPK == null) ? 0 : creditoTablaPagosPK.hashCode());
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
        CreditoTablaPagos other = (CreditoTablaPagos) obj;
        if (creditoTablaPagosPK == null) {
            if (other.creditoTablaPagosPK != null)
                return false;
        } else if (!creditoTablaPagosPK.equals(other.creditoTablaPagosPK))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "CreditoTablaPagos [creditoTablaPagosPK=" + creditoTablaPagosPK + ", codigoCuota=" + codigoCuota
                + ", capital=" + capital + ", interes=" + interes + ", montoCuota=" + montoCuota + ", capitalRestante="
                + capitalRestante + ", fechaPlanificadaPago=" + fechaPlanificadaPago + ", estado=" + estado
                + ", fechaPagoEfectivo=" + fechaPagoEfectivo + ", transaccionPago=" + transaccionPago + ", version="
                + version + "]";
    }

}
