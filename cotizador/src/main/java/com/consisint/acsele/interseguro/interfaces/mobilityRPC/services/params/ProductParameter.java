package com.consisint.acsele.interseguro.interfaces.mobilityRPC.services.params;

import com.enroquesw.mcs.comm.mobilityRPC.services.parameter.ProcessParameterBase;

import java.util.Date;

/**
 * La clase <code>ProductParameter</code> representa el Parametro de entrada Para los Servicios de Producto
 */
public class ProductParameter extends ProcessParameterBase {
    public long idProducto;     //Id del Producto
    public long fecha;          // valor campo "Fecha" de la tabla Dinamica
    private Long timeOutMax;

    /**
     * Constructor
     * @param idProducto Id del Producto
     */
    public ProductParameter(long idProducto) {
        this.idProducto = idProducto;
    }

    /**
     * Constructor
     * @param idProducto    Id del Producto
     * @param fecha         valor campo "Fecha" de la tabla Dinamica
     */
    public ProductParameter(long idProducto, Date fecha) {
        this.idProducto = idProducto;
        this.fecha = fecha.getTime();
    }

    @Override
    public String toString() {
        StringBuilder out = new StringBuilder("ProductParameter{").append("idProducto=").append( String.valueOf(idProducto)).append(", fecha=").append( new Date(fecha).toString()).append("}\n");
        return out.toString();
    }

    public void setTimeOutMax(Long timeOutMax) { this.timeOutMax = timeOutMax; }

    @Override
    public Long getTimeOutMax() { return timeOutMax; }
}
