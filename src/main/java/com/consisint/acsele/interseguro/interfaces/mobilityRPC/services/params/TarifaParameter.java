package com.consisint.acsele.interseguro.interfaces.mobilityRPC.services.params;

import com.enroquesw.mcs.comm.mobilityRPC.services.parameter.ProcessParameter;

import java.util.Date;


/**
 * La clase <code>TarifaParameter</code> representa el Parametro de entrada Para los Servicios de Tarifas de los Productos.
 * idProducto    filtro del Id del Campo "ProductosVida" de la tabla de Tarifas correspondiente a ese Producto. (Es el unico valor requerido).
 * idPlanVida    filtro del Id del Campo "PlanVida" de la tabla de Tarifas correspondiente a ese Producto. (No requerido)
 * idCobertura   filtro del Id del Campo "CodCobertura" de la tabla de Tarifas correspondiente a ese Producto. (No requerido).
 * fecha         filtro del campo "Fecha" de la tabla de Tarifas correspondiente a ese Producto donde los valores sean mayores o iguales al que se setee.
 *               (No requerido - si no se indica no se filtraran por fecha)
 */
public class TarifaParameter implements ProcessParameter {
    public long idProducto;
    public long idPlanVida;
    public long idCobertura;
    public long fecha;

    /**
     * Constructor de TarifaParameter, los campos filtros:
     * @param idProducto    Id del Campo "ProductosVida" de la tabla de Tarifas correspondiente a ese Producto
     * @param idPlanVida    Id del Campo "PlanVida" de la tabla de Tarifas correspondiente a ese Producto
     * @param idCobertura   Id del Campo "CodCobertura" de la tabla de Tarifas correspondiente a ese Producto
     * @param fecha         Valor de Fecha de referencia para tomar los registros cuyo campo "Fecha" sean mayores o iguales al que se setee.
     */
    public TarifaParameter(long idProducto, long idPlanVida, long idCobertura, Date fecha) {
        this.idProducto = idProducto;
        this.idPlanVida = idPlanVida;
        this.idCobertura = idCobertura;
        this.fecha = fecha.getTime();
    }

    public TarifaParameter(long idProducto, long idPlanVida, long idCobertura) {
        this.idProducto = idProducto;
        this.idPlanVida = idPlanVida;
        this.idCobertura = idCobertura;
    }

    public TarifaParameter(long idProducto, long idPlanVida) {
        this.idProducto = idProducto;
        this.idPlanVida = idPlanVida;
    }

    public TarifaParameter(long idProducto) {
        this.idProducto = idProducto;
    }
}
