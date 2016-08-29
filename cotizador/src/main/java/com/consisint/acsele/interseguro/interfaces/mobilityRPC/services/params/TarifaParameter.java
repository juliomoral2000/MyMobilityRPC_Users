package com.consisint.acsele.interseguro.interfaces.mobilityRPC.services.params;

import com.enroquesw.mcs.comm.mobilityRPC.services.parameter.ProcessParameterBase;

import java.util.Date;


/**
 * La clase <code>TarifaParameter</code> representa el Parametro de entrada Para los Servicios de Tarifas de los Productos.
 * <p>
 * <ul>
 *     <li>idProducto    filtro del Id del Campo "ProductosVida" de la tabla de Tarifas correspondiente a ese Producto. <b>(Es el unico valor requerido)</b>.</li>
 *     <li>idPlanVida    filtro del Id del Campo "PlanVida" de la tabla de Tarifas correspondiente a ese Producto. <b>(No requerido)</b></li>
 *     <li>idCobertura   filtro del Id del Campo "CodCobertura" de la tabla de Tarifas correspondiente a ese Producto. <b>(No requerido)</b></li>
 *     <li>fecha         filtro del campo "Fecha" de la tabla de Tarifas correspondiente a ese Producto donde los valores sean mayores o iguales al que se setee.
 *               <b>(No requerido - si no se indica no se filtraran por fecha)</b></li>
 * </ul>
 * </p>
 */
public class TarifaParameter extends ProcessParameterBase {
    public long idProducto;     // Id del Producto de la tabla de Tarifas
    public long idPlanVida;     // Id del PlanVida de la tabla de Tarifas
    public long idCobertura;    // Id del Cobertura de la tabla de Tarifas
    public long fecha;          // valor campo "Fecha" de la tabla de Tarifas
    private Long timeOutMax;

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

    /**
     * Constructor de TarifaParameter, los campos filtros:
     * @param idProducto    Id del Campo "ProductosVida" de la tabla de Tarifas correspondiente a ese Producto
     * @param idPlanVida    Id del Campo "PlanVida" de la tabla de Tarifas correspondiente a ese Producto
     * @param idCobertura   Id del Campo "CodCobertura" de la tabla de Tarifas correspondiente a ese Producto
     */
    public TarifaParameter(long idProducto, long idPlanVida, long idCobertura) {
        this.idProducto = idProducto;
        this.idPlanVida = idPlanVida;
        this.idCobertura = idCobertura;
    }

    /**
     * Constructor de TarifaParameter, los campos filtros:
     * @param idProducto    Id del Campo "ProductosVida" de la tabla de Tarifas correspondiente a ese Producto
     * @param idPlanVida    Id del Campo "PlanVida" de la tabla de Tarifas correspondiente a ese Producto
     */
    public TarifaParameter(long idProducto, long idPlanVida) {
        this.idProducto = idProducto;
        this.idPlanVida = idPlanVida;
    }

    /**
     * Constructor de TarifaParameter, los campos filtros:
     * @param idProducto    Id del Campo "ProductosVida" de la tabla de Tarifas correspondiente a ese Producto
     */
    public TarifaParameter(long idProducto) {
        this.idProducto = idProducto;
    }

    @Override
    public String toString() {
        StringBuilder out = new StringBuilder("TarifaParameter{")
                .append("idProducto=").append(String.valueOf(idProducto))
                .append(", idPlanVida=").append(String.valueOf(idPlanVida))
                .append(", idCobertura=").append(String.valueOf(idCobertura))
                .append(", fecha=").append( new Date(fecha).toString())
                .append("}\n");
        return out.toString();
    }

    public void setTimeOutMax(Long timeOutMax) { this.timeOutMax = timeOutMax; }

    @Override
    public Long getTimeOutMax() { return timeOutMax; }
}
