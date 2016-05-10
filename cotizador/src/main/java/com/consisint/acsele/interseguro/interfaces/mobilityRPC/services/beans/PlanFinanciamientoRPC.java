package com.consisint.acsele.interseguro.interfaces.mobilityRPC.services.beans;

import java.util.ArrayList;
import java.util.List;

/**
 * La clase <code>PlanFinanciamientoRPC</code> representa el wrapper del ConfiguratedFinancialPlan
 * de Acsele para los servicios del MobilityRPC. (para Interseguro es el PERIODO DE PAGO)
 */
public class PlanFinanciamientoRPC {
    long id;            // Id del Plan de Financiamiento
    long idProducto;    // Id de Producto
    String desc;        // Nombre/Descripcion del Plan de Financiamiento
    int period;         // periodo
    private String unitPeriodo; //unidad del Periodo
    List<Long> idMonedas = new ArrayList<Long>();   // Lista de Id de Monedas configuradas para este plan de Financiamiento
    //Map<String, DynamicDataRPC> dataDynamic = new Hashtable<String, DynamicDataRPC>(); // propiedadNombre, <nombre, input, value>

    /**
     * Contructor
     * @param id            Id del Plan de Financiamiento
     * @param desc          Nombre/Descripcion del Plan de Financiamiento
     * @param period        periodo
     * @param unitPeriodo   unidad del Periodo
     * @param idProducto    Id de Producto
     * @param idMonedas     Las Monedas permitidas en el Plan de Financiamiento
     */
    public PlanFinanciamientoRPC(long id, String desc, int period, String unitPeriodo, long idProducto/*, Map<String, DynamicDataRPC> dataDynamic*/, List<Long> idMonedas) {
        this.id = id;
        this.desc = desc;
        this.period = period;
        this.unitPeriodo = unitPeriodo;
        this.idProducto = idProducto;
        this.idMonedas = idMonedas;
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

    public List<Long> getIdMonedas() {
        return idMonedas;
    }

    /*public Map<String, DynamicDataRPC> getDataDynamic() {
        return dataDynamic;
    }*/

    @Override
    public String toString() {
        StringBuilder out = new StringBuilder("PlanFinanciamientoRPC{").append("id=").append(id).append(", idProducto=").append(idProducto).append(", desc='").append(desc).append('\'').append(", period=").append(period).append(", unitPeriodo='").append(unitPeriodo).append('\'');
        if(!idMonedas.isEmpty()){
            out.append(", IdMonedas:\n{");
            for (Long z : idMonedas) out.append("idMoneda:").append(z.toString()).append(",\n");
            out.append("}\n");
        }
        out.append('}');
        return out.toString();
    }
}
