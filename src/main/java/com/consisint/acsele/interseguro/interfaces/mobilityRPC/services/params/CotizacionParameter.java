package com.consisint.acsele.interseguro.interfaces.mobilityRPC.services.params;

import com.consisint.acsele.interseguro.interfaces.mobilityRPC.services.beans.CotizacionRPC;

/**
 * La clase <code>CotizacionParameter</code> representa el Parametro de entrada Para los Servicios de Cotizacion.
 */
public class CotizacionParameter {
    public CotizacionRPC cotizacionRPC;     // Objeto Cotizacion [contiene la data capturada por el Sistema Cotizador]
    public boolean isInverso = false;       // El calculo de la Catizacion es Inverso? true: Inverso [CotInverso] ; false: Directo [CotDirecto]. POL.TipoActivacion [PropManual, PropRapida, PropCanc, PropDesis, CotDirecto, CotInverso]

    /**
     * Constructor
     * @param cotizacionRPC Objeto Cotizacion [contiene la data capturada por el Sistema Cotizador]
     * @param isInverso     El calculo de la Catizacion es Inverso? true: Inverso ; false: Directo.
     */
    public CotizacionParameter(CotizacionRPC cotizacionRPC, boolean isInverso) {
        this.cotizacionRPC = cotizacionRPC;
        this.isInverso = isInverso;
    }
}
