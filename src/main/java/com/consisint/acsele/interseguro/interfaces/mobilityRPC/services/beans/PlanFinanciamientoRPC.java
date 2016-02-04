package com.consisint.acsele.interseguro.interfaces.mobilityRPC.services.beans;

import java.util.Hashtable;
import java.util.Map;

/**
 * Los Planes de Financiamiento (para Interseguro es el PERIODO DE PAGO)
 */
public class PlanFinanciamientoRPC {
    long id;
    String desc;
    int period; // periodo
    private String unitPeriodo; //unidad del Periodo
    long idProducto;
    //Map<String, DynamicDataRPC> dataDynamic = new Hashtable<String, DynamicDataRPC>(); // propiedadNombre, <nombre, input, value>

    public PlanFinanciamientoRPC(long id, String desc, int period, String unitPeriodo, long idProducto/*, Map<String, DynamicDataRPC> dataDynamic*/) {
        this.id = id;
        this.desc = desc;
        this.period = period;
        this.unitPeriodo = unitPeriodo;
        this.idProducto = idProducto;
        //this.dataDynamic = dataDynamic;
    }

    public long getId() {
        return id;
    }

    public String getDesc() {
        return desc;
    }

    public int getPeriod() {
        return period;
    }

    public String getUnitPeriodo() {
        return unitPeriodo;
    }

    public long getIdProducto() {
        return idProducto;
    }

    /*public Map<String, DynamicDataRPC> getDataDynamic() {
        return dataDynamic;
    }*/
}
