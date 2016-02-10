package com.consisint.acsele.interseguro.interfaces.mobilityRPC.services.params;

import com.enroquesw.mcs.comm.mobilityRPC.services.parameter.ProcessParameter;

/**
 * La clase <code>ProductParameter</code> representa el Parametro de entrada Para los Servicios de Producto
 */
public class ProductParameter implements ProcessParameter {
    public long idProducto;

    public ProductParameter(long idProducto) {
        this.idProducto = idProducto;
    }
}
