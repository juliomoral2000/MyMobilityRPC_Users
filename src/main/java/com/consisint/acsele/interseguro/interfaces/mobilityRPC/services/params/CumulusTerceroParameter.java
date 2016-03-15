package com.consisint.acsele.interseguro.interfaces.mobilityRPC.services.params;

import com.enroquesw.mcs.comm.mobilityRPC.services.parameter.ProcessParameter;

/**
 * Created by Julio on 14/03/2016.
 */
public class CumulusTerceroParameter implements ProcessParameter {
    public long idTercero;
    public long idProducto;
    public long idMoneda;

    public CumulusTerceroParameter(long idTercero, long idProducto, long idMoneda) {
        this.idTercero = idTercero;
        this.idProducto = idProducto;
        this.idMoneda = idMoneda;
    }
}
