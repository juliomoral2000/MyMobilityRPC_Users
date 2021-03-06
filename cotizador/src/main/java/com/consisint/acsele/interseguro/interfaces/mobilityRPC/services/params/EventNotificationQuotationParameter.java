package com.consisint.acsele.interseguro.interfaces.mobilityRPC.services.params;

import com.enroquesw.mcs.comm.mobilityRPC.services.parameter.ProcessParameter;
import com.enroquesw.mcs.comm.mobilityRPC.services.parameter.ProcessParameterBase;

import java.util.Date;

/**
 * La clase <code>EventNotificationQuotationParameter</code> representa el Parametro de entrada para
 * el servicio de recepcion de Notificaciones de Recargo del Sistema Cotizador.
 *
 */
public class EventNotificationQuotationParameter extends ProcessParameterBase {
    public long   idPoliza;              // Id de Poliza [Propuesta] Acsel-e
    public String numeroPropuesta;       // Numero de Propuesta      -- TODO: Ideal seria el Id (si lo almacenara Acsele)
    public String numeroCotizacion;      // Numero de Cotizacion     -- TODO: Ideal seria el Id (si lo almacenara Acsele)
    public long   idCobertura;           // Id de Cobertura (Es la cobertura a la cual aplica este recargo).
    public long   idTercero;             // Id del Tercero del Asegurado que aplica este recargo.
    public String primerNombre;          // Primer Nombre del Asegurado [Esto para no tener que crear un servicio de consulta de Tercero]
    public String primerApellido;        // Primer Apellido del Asegurado [Esto para no tener que crear un servicio de consulta de Tercero]
    public long   fechaNacimiento;       // Fecha Nacimiento del Asegurado [Esto para no tener que crear un servicio de consulta de Tercero]
    public double montoRecargo;          // monto del Recargo -- TODO: Segun lo conversado esto debe ser un campo a nivel de cobertura que contenga este valor[en desarrollo tengo entendido que el monto general del recargo esta a nivel de Objeto Asegurado por lo tanto es x asegurado y en escencia esto debera distribuirse a las coberturas que aplique el recargo].
    protected Long timeOutMax;

    /**
     * Constructor
     * @param idPoliza          Id de Poliza [Propuesta] Acsel-e
     * @param numeroPropuesta   Numero de Propuesta
     * @param numeroCotizacion  Numero de Cotizacion
     * @param idCobertura       Id de Cobertura (Es la cobertura a la cual aplica este recargo).
     * @param idTercero         Id del Tercero del Asegurado que aplica este recargo.
     * @param primerNombre      Primer Nombre del Asegurado
     * @param primerApellido    Primer Apellido del Asegurado
     * @param montoRecargo      monto del Recargo
     */
    public EventNotificationQuotationParameter(long idPoliza, String numeroPropuesta, String numeroCotizacion, long idCobertura, long idTercero, String primerNombre, String primerApellido, long fechaNacimiento, double montoRecargo) {
        this.idPoliza = idPoliza;
        this.numeroPropuesta = numeroPropuesta;
        this.numeroCotizacion = numeroCotizacion;
        this.idCobertura = idCobertura;
        this.idTercero = idTercero;
        this.primerNombre = primerNombre;
        this.primerApellido = primerApellido;
        this.fechaNacimiento = fechaNacimiento;
        this.montoRecargo = montoRecargo;
    }

    @Override
    public String toString() {
        StringBuilder out = new StringBuilder("EventNotificationQuotationParameter{")
                .append("idPoliza=").append(String.valueOf(idPoliza))
                .append(", numeroPropuesta=").append(numeroPropuesta)
                .append(", numeroCotizacion=").append(numeroCotizacion)
                .append(", idCobertura=").append(String.valueOf(idCobertura))
                .append(", idTercero=").append(String.valueOf(idTercero))
                .append(", primerNombre=").append(primerNombre)
                .append(", primerApellido=").append(primerApellido)
                .append(", fechaNacimiento=").append(new Date(fechaNacimiento).toString())
                .append(", montoRecargo=").append(String.valueOf(montoRecargo)).append("}");
        return out.toString();
    }

    public void setTimeOutMax(Long timeOutMax) { this.timeOutMax = timeOutMax; }

    @Override
    public Long getTimeOutMax() { return timeOutMax; }
}
