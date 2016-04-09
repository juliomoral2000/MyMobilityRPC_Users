package com.consisint.acsele.interseguro.interfaces.mobilityRPC.services.params;

import com.enroquesw.mcs.comm.mobilityRPC.services.parameter.ProcessParameter;

/**
 * La clase <code>CumulusTerceroParameter</code> representa el Parametro de entrada Para el obtener el cumulus del Tercero segun funciones de Acsele.
 * idTercero          Id del Tercero. (Requerido).
 */
public class CumulusTerceroParameter implements ProcessParameter {
    public long idTercero;

    /**
     * Constructor
     * @param idTercero Id del Tercero. (Requerido).
     */
    public CumulusTerceroParameter(long idTercero) {
        this.idTercero = idTercero;
    }
}
