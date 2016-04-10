package com.consisint.acsele.interseguro.interfaces.mobilityRPC.services.params;

import com.enroquesw.mcs.comm.mobilityRPC.services.parameter.ProcessParameter;

/**
 * La clase <code>ProductParameter</code> representa el Parametro de entrada Para los Servicios de Producto
 */
public class ProductParameter implements ProcessParameter {
    public long idProducto; //Id del Producto

    /**
     * Constructor
     * @param idProducto Id del Producto
     */
    public ProductParameter(long idProducto) {
        this.idProducto = idProducto;
    }

    @Override
    public String toString() {
        StringBuilder out = new StringBuilder("ProductParameter{").append("idProducto=").append(String.valueOf(idProducto)).append("}");
        return out.toString();
    }
}
