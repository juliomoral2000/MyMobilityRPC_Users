package com.consisint.acsele.interseguro.interfaces.mobilityRPC.services.beans;

import java.util.Date;

/**
 * La clase <code>RenglonExigenciasMedicaRPC</code> representa el wrapper de los registros de las Tablas de Requisitos de Asegurabilidad [tablas dinamicas] de los productos de Vida
 * de Acsele para los servicios del MobilityRPC.
 */
public class RenglonExigenciasMedicaRPC  {
    long id; //id del DCO
    String codReq;
    String descReq;
    int edadMin;
    int edadMax;
    double capitalMin;
    double capitalMax;
    long idMoneda;
    String evento;
    boolean isVisible;
    long date;

    public RenglonExigenciasMedicaRPC(long id, String codReq, String descReq, int edadMin, int edadMax, double capitalMin, double capitalMax, long moneda, String evento, boolean isVisible, long date) {
        this.id = id;
        this.codReq = codReq;
        this.descReq = descReq;
        this.edadMin = edadMin;
        this.edadMax = edadMax;
        this.capitalMin = capitalMin;
        this.capitalMax = capitalMax;
        this.idMoneda = moneda;
        this.evento = evento;
        this.isVisible = isVisible;
        this.date = date;
    }

    public long getId() {
        return id;
    }

    public String getCodReq() {
        return codReq;
    }

    public String getDescReq() {
        return descReq;
    }

    public int getEdadMin() {
        return edadMin;
    }

    public int getEdadMax() {
        return edadMax;
    }

    public double getCapitalMin() {
        return capitalMin;
    }

    public double getCapitalMax() {
        return capitalMax;
    }

    public long getIdMoneda() {
        return idMoneda;
    }

    public String getEvento() {
        return evento;
    }

    public boolean isVisible() {
        return isVisible;
    }

    public long getDate() {
        return date;
    }

    @Override
    public String toString() {
        return "RenglonExigenciasMedicaRPC{" +
                "id=" + id + ", codReq='" + codReq + '\'' +", descReq='" + descReq + '\'' +", edadMin=" + edadMin +", edadMax=" + edadMax +", capitalMin=" + capitalMin +
                ", capitalMax=" + capitalMax +", idMoneda='" + idMoneda + '\'' +", evento='" + evento + '\'' +", isVisible=" + isVisible +", date=" + new Date(date).toString() +'}';
    }
}
