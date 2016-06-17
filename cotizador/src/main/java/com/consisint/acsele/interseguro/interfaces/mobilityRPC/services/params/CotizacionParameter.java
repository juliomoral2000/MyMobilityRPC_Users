package com.consisint.acsele.interseguro.interfaces.mobilityRPC.services.params;

import com.consisint.acsele.interseguro.interfaces.mobilityRPC.services.beans.CotizacionRPC;
import com.enroquesw.mcs.comm.mobilityRPC.services.parameter.ProcessParameter;

/**
 * La clase <code>CotizacionParameter</code> representa el Parametro de entrada Para los Servicios de Cotizacion.
 */
public class CotizacionParameter implements ProcessParameter {
    public CotizacionRPC cotizacionRPC;     // Objeto Cotizacion [contiene la data capturada por el Sistema Cotizador]
    public boolean isInverso = false;       // El calculo de la Catizacion es Inverso? true: Inverso [CotInverso] ; false: Directo [CotDirecto]. POL.TipoActivacion [PropManual, PropRapida, PropCanc, PropDesis, CotDirecto, CotInverso]
    private Long timeOutMax;

    /**
     * Constructor
     * @param cotizacionRPC Objeto Cotizacion [contiene la data capturada por el Sistema Cotizador]
     * @param isInverso     El calculo de la Catizacion es Inverso? true: Inverso ; false: Directo.
     */
    public CotizacionParameter(CotizacionRPC cotizacionRPC, boolean isInverso) {
        this.cotizacionRPC = cotizacionRPC;
        this.isInverso = isInverso;
    }

    @Override
    public String toString() {
        StringBuilder out = new StringBuilder("CotizacionParameter{").append("cotizacionRPC={").append(cotizacionRPC.toString()).append("}\n, isInverso=").append(String.valueOf(isInverso)).append("}");
        return out.toString();
    }

    public void setTimeOutMax(Long timeOutMax) { this.timeOutMax = timeOutMax; }

    @Override
    public Long getTimeOutMax() { return timeOutMax; }
}
