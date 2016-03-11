package com.consisint.acsele.interseguro.interfaces.mobilityRPC.services.params;

import com.enroquesw.mcs.comm.mobilityRPC.services.parameter.ProcessParameter;

import java.util.Date;

/**
 * La clase <code>TarifaParameter</code> representa el Parametro de entrada Para los Servicios de Tarifas de los Productos.
 * idProducto    filtro del Id del Campo "ProductosVida" de la tabla de Exigencias Medicas correspondiente a ese Producto. (Es el unico valor requerido).
 * fecha         filtro del campo "Fecha" de la tabla de Tarifas correspondiente a ese Producto donde los valores sean mayores o iguales al que se setee.
 *               (No requerido - si no se indica no se filtraran por fecha)
 */
public class ExigenciasMedicaParameter implements ProcessParameter {
    public long idProducto;
    public long fecha;

    public ExigenciasMedicaParameter(long idProducto) {
        this.idProducto = idProducto;
    }

    public ExigenciasMedicaParameter(long idProducto, Date fecha) {
        this.idProducto = idProducto;
        this.fecha = fecha.getTime();
    }
}
