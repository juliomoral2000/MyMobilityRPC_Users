package com.consisint.acsele.interseguro.interfaces.mobilityRPC.services.beans;

/**
 * La clase <code>PlanFinanciamientoRPC</code> representa el wrapper del ConfiguratedFinancialPlan
 * de Acsele para los servicios del MobilityRPC. (para Interseguro es el PERIODO DE PAGO)
 */
public class PlanFinanciamientoRPC {
    long id;
    long idProducto;
    String desc;
    int period; // periodo
    private String unitPeriodo; //unidad del Periodo
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

    @Override
    public String toString() {
        return new StringBuilder("PlanFinanciamientoRPC{").append("id=").append( id).append(", idProducto=").append( idProducto).append(", desc='").append( desc).append( '\'').append(", period=").append( period).append(", unitPeriodo='").append( unitPeriodo).append( '\'').append('}').toString();
    }
}
