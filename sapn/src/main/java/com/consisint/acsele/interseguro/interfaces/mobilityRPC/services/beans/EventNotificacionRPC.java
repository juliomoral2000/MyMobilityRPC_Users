package com.consisint.acsele.interseguro.interfaces.mobilityRPC.services.beans;

import com.enroquesw.mcs.comm.mobilityRPC.services.parameter.ProcessParameter;

import java.util.Date;

/**
 * La clase <code>EventNotificacionRPC</code> representa el wrapper de las Notificaciones
 * de Acsele para los servicios del MobilityRPC para
 * el Sistema Administrador de Plazos – Notificaciones [SAPN].
 */
public class EventNotificacionRPC implements ProcessParameter {
    public long idProducto;
    public String nombreProducto;
    public long idPoliza;
    public String numPoliza;
    public long idOperacion;
    public String numPropuesta;
    public String numCotizacion;
    public String numOportunidad;
    public String numEndoso;
    public String estadoPoliza;
    public String evento;
    public String motivoEvento;
    public long fechaEvento;
    public String comunicacion;
    public String correoEP;
    public String comunicacionEndoso;
    public String correoEE;
    public String codAgenteVI;
    public String codAgenteVM;
    public String tipoDocumento;
    public String numDocumento;
    public String primerNombre;
    public String segundoNombre;
    public String primerApellido;
    public String segundoApellido;
    public String codigoLaboratorio;
    public String nombreLaboratorio;
    public String origenPoliza;
    private Long timeOutMax;

    public EventNotificacionRPC(long idProducto, String nombreProducto, long idPoliza, String numPoliza, long idOperacion, String numPropuesta, String numCotizacion, String numOportunidad, String numEndoso, String estadoPoliza, String evento, String motivoEvento, long fechaEvento, String comunicacion, String correoEP, String comunicacionEndoso, String correoEE, String codAgenteVI, String codAgenteVM, String tipoDocumento, String numDocumento, String primerNombre, String segundoNombre, String primerApellido, String segundoApellido, String codigoLaboratorio, String nombreLaboratorio, String origenPoliza) {
        this.idProducto = idProducto;
        this.nombreProducto = nombreProducto;
        this.idPoliza = idPoliza;
        this.numPoliza = numPoliza;
        this.idOperacion = idOperacion;
        this.numPropuesta = numPropuesta;
        this.numCotizacion = numCotizacion;
        this.numOportunidad = numOportunidad;
        this.numEndoso = numEndoso;
        this.estadoPoliza = estadoPoliza;
        this.evento = evento;
        this.motivoEvento = motivoEvento;
        this.fechaEvento = fechaEvento;
        this.comunicacion = comunicacion;
        this.correoEP = correoEP;
        this.comunicacionEndoso = comunicacionEndoso;
        this.correoEE = correoEE;
        this.codAgenteVI = codAgenteVI;
        this.codAgenteVM = codAgenteVM;
        this.tipoDocumento = tipoDocumento;
        this.numDocumento = numDocumento;
        this.primerNombre = primerNombre;
        this.segundoNombre = segundoNombre;
        this.primerApellido = primerApellido;
        this.segundoApellido = segundoApellido;
        this.codigoLaboratorio = codigoLaboratorio;
        this.nombreLaboratorio = nombreLaboratorio;
        this.origenPoliza = origenPoliza;
    }

    public long getIdProducto() { return idProducto; }

    public String getNombreProducto() { return nombreProducto; }

    public long getIdPoliza() { return idPoliza; }

    public String getNumPoliza() { return numPoliza; }

    public long getIdOperacion() { return idOperacion; }

    public String getNumPropuesta() { return numPropuesta; }

    public String getNumCotizacion() { return numCotizacion; }

    public String getNumOportunidad() { return numOportunidad; }

    public String getNumEndoso() { return numEndoso; }

    public String getEstadoPoliza() { return estadoPoliza; }

    public String getEvento() { return evento; }

    public String getMotivoEvento() { return motivoEvento; }

    public Date getFechaEvento() { return new Date(fechaEvento); }

    public String getComunicacion() { return comunicacion; }

    public String getCorreoEP() { return correoEP; }

    public String getCorreoEE() { return correoEE; }

    public String getCodAgenteVI() { return codAgenteVI; }

    public String getCodAgenteVM() { return codAgenteVM; }

    public String getTipoDocumento() { return tipoDocumento; }

    public String getNumDocumento() { return numDocumento; }

    public String getPrimerNombre() { return primerNombre; }

    public String getSegundoNombre() { return segundoNombre; }

    public String getPrimerApellido() { return primerApellido; }

    public String getSegundoApellido() { return segundoApellido; }

    public String getCodigoLaboratorio() { return codigoLaboratorio; }

    public String getNombreLaboratorio() { return nombreLaboratorio; }

    public String getOrigenPoliza() { return origenPoliza; }

    public String getComunicacionEndoso() { return comunicacionEndoso; }

    @Override
    public String toString() {
        return "EventNotificacionRPC{" +
                "idProducto=" + idProducto +
                ", nombreProducto='" + nombreProducto + '\'' +
                ", idPoliza=" + idPoliza +
                ", numPoliza='" + numPoliza + '\'' +
                ", idOperacion=" + idOperacion +
                ", numPropuesta='" + numPropuesta + '\'' +
                ", numCotizacion='" + numCotizacion + '\'' +
                ", numOportunidad='" + numOportunidad + '\'' +
                ", numEndoso='" + numEndoso + '\'' +
                ", estadoPoliza='" + estadoPoliza + '\'' +
                ", evento='" + evento + '\'' +
                ", motivoEvento='" + motivoEvento + '\'' +
                ", fechaEvento=" + fechaEvento +
                ", comunicacion='" + comunicacion + '\'' +
                ", correoEP='" + correoEP + '\'' +
                ", correoEE='" + correoEE + '\'' +
                ", codAgenteVI='" + codAgenteVI + '\'' +
                ", codAgenteVM='" + codAgenteVM + '\'' +
                ", tipoDocumento='" + tipoDocumento + '\'' +
                ", numDocumento='" + numDocumento + '\'' +
                ", primerNombre='" + primerNombre + '\'' +
                ", segundoNombre='" + segundoNombre + '\'' +
                ", primerApellido='" + primerApellido + '\'' +
                ", segundoApellido='" + segundoApellido + '\'' +
                ", codigoLaboratorio='" + codigoLaboratorio + '\'' +
                ", nombreLaboratorio='" + nombreLaboratorio + '\'' +
                ", origenPoliza='" + origenPoliza + '\'' +
                '}';
    }

    public void setTimeOutMax(Long timeOutMax) { this.timeOutMax = timeOutMax; }

    @Override
    public Long getTimeOutMax() { return timeOutMax; }
}
