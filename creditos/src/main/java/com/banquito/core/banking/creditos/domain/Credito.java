package com.banquito.core.banking.creditos.domain;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.persistence.Version;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "CREDITO")
public class Credito {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "COD_CREDITO", nullable = false)
    private Long codigo;

    @ManyToOne()
    @JoinColumn(name = "COD_TIPO_CREDITO")
    private TipoCredito tipoCredito;

    @Column(name = "COD_TIPO_CREDITO", nullable = false)
    private Integer codigoTipoCredito;

    @Column(name = "COD_CLIENTE", nullable = false)
    private Integer codigoCliente;

    @Column(name = "NUMERO_OPERACION", nullable = false, length = 8)
    private String numeroOperacion;

    @Column(name = "FECHA_CREACION", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCreación;

    @Column(name = "MONTO", nullable = false, length = 18, scale = 2)
    private long monto;

    @Column(name = "PLAZO", nullable = false, length = 3)
    private long plazo;

    @Column(name = "TASA_INTERES", nullable = false, length = 5, scale = 2)
    private long tazaInteres;

    @Column(name = "ESTADO", nullable = false, length = 3)
    private String estado;

    @Column(name = "FECHA_DESEMBOLSO", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaDesembolso;

    @Column(name = "FECHA_ULTIMO_PAGO", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fechaUltimoPago;

    @Column(name = "CAPITAL_PENDIENTE", nullable = false, length = 18, scale = 2)
    private long capitalPendiente;

    @Column(name = "FECHA_ULTIMO_CAMBIO", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaUltimoCambio;

    public Credito(Long codigo) {
        this.codigo = codigo;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
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
        Credito other = (Credito) obj;
        if (codigo == null) {
            if (other.codigo != null)
                return false;
        } else if (!codigo.equals(other.codigo))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Credito [codigo=" + codigo + ", TipoCredito=" + tipoCredito
                + ", codigoTipoCredito=" + codigoTipoCredito + ", codigoCliente=" + codigoCliente + ", numeroOperacion="
                + numeroOperacion + ", fechaCreación=" + fechaCreación + ", monto=" + monto + ", plazo=" + plazo
                + ", tazaInteres=" + tazaInteres + ", estado=" + estado + ", fechaDesembolso=" + fechaDesembolso
                + ", fechaUltimoPago=" + fechaUltimoPago + ", capitalPendiente=" + capitalPendiente
                + ", fechaUltimoCambio=" + fechaUltimoCambio + "]";
    }

    @Version
    long version;

}
