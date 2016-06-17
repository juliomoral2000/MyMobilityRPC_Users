package com.consisint.acsele.interseguro.interfaces.mobilityRPC.services.params;

import com.enroquesw.mcs.comm.mobilityRPC.services.parameter.ProcessParameter;

/**
 * La clase <code>TVGParameter</code> representa el Parametro de entrada Para el calculo de la Tabla de Valores Garantizados de Acsele.
 * idPoliza          Id de la Poliza (Cotizacion). (Requerido).
 *
 */
public class TVGParameter implements ProcessParameter {
    public long idPoliza;
    public long idOperation;
    private Long timeOutMax;

    public TVGParameter(long idPoliza, long idOperation) { this.idPoliza = idPoliza; this.idOperation=idOperation;}

    public TVGParameter(long idPoliza, long idOperation, Long timeOutMax) {
        this(idPoliza, idOperation);
        this.timeOutMax = timeOutMax;
    }

    public void setTimeOutMax(Long timeOutMax) { this.timeOutMax = timeOutMax; }

    @Override
    public Long getTimeOutMax() { return timeOutMax; }

    @Override
    public String toString() {
        return "TVGParameter{" + "idPoliza=" + idPoliza + ", idOperation=" + idOperation +'}';
    }
}
