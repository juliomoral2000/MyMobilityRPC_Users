package com.consisint.acsele.interseguro.interfaces.mobilityRPC.services.beans;

import java.util.Hashtable;
import java.util.Map;

/**
 * La clase <code>ProductRPC</code> representa el wrapper del Product
 * de Acsele para los servicios del MobilityRPC.
 */
public class ProductRPC {
    long id;
    String name;
    Map<String, DynamicDataRPC> dataDynamic = new Hashtable<String, DynamicDataRPC>(); // propiedadNombre, <nombre, input, value>
    /*List<PlanFinanciamientoRPC> plans = new ArrayList<PlanFinanciamientoRPC>();*/
    public static final transient String[] PROPERTIESTOTAKE = {"Ramo", "SubRamo", "RamoSBS", "EdadLimiteIngreso", "EdadMinima"};

    public ProductRPC(long id, String name, Map<String, DynamicDataRPC> dataDynamic/*, List<PlanFinanciamientoRPC> plans*/) {
        this.id = id;
        this.name = name;
        this.dataDynamic = dataDynamic;
        /*this.plans = plans;*/
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /*public List<PlanFinanciamientoRPC> getPlans() {
        return plans;
    }*/

    public Map<String, DynamicDataRPC> getDataDynamic() {
        return dataDynamic;
    }

    @Override
    public String toString() {
        StringBuilder out = new StringBuilder("ProductRPC{").append("id=").append( id).append(", name='").append( name).append( '\'').append(", dataDynamic:\n{");
        for (Map.Entry<String, DynamicDataRPC> i: dataDynamic.entrySet()) out.append(i.getValue().toString());
        out.append("}\n}");
        return out.toString();
    }
}
