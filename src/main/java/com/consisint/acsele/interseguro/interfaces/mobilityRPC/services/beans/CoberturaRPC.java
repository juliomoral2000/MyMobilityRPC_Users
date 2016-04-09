package com.consisint.acsele.interseguro.interfaces.mobilityRPC.services.beans;

import java.util.Hashtable;
import java.util.Map;

/**
 * La clase <code>CoberturaRPC</code> representa el wrapper de la Cobertura Configurada
 * de Acsele para los servicios del MobilityRPC.
 */
public class CoberturaRPC {
    long id;        // Id de Cobertura Configurada
    long idProduct; // Id de Producto asociado a esta cobertura
    long idPlan;    // Id de Plan asociado a esta cobertura
    String name;    // Nombre de la Cobertura
    boolean isMandatory;    // Es mandatorio?
    boolean isLeading;      // Es principal?
    Map<String, DynamicDataRPC> dataDynamic = new Hashtable<String, DynamicDataRPC>(); // propiedadNombre, <nombre, input, value>
    //public static final transient String[] PROPERTIESTOTAKE = {/*"Ramo", "SubRamo", "RamoSBS", "EdadLimiteIngreso", "EdadMinima"*/};  TODO: posible uso futuro

    /**
     *
     * @param id                Id de Cobertura Configurada
     * @param idProduct         Id de Producto asociado a esta cobertura
     * @param idPlan            Id de Plan asociado a esta cobertura
     * @param name              Nombre de la Cobertura
     * @param isMandatory       Es mandatorio?
     * @param isLeading         Es principal?
     */
    public CoberturaRPC(long id, long idProduct, long idPlan, String name, boolean isMandatory, boolean isLeading) {
        this.id = id;
        this.idProduct = idProduct;
        this.idPlan = idPlan;
        this.name = name;
        this.isMandatory = isMandatory;
        this.isLeading = isLeading;
        /*this.dataDynamic = dataDynamic;*/
    }

    public long getId() {
        return id;
    }

    public long getIdProduct() {
        return idProduct;
    }

    public long getIdPlan() {
        return idPlan;
    }

    public String getName() {
        return name;
    }

    public boolean isMandatory() {
        return isMandatory;
    }

    public boolean isLeading() {
        return isLeading;
    }

    @Override
    public String toString() {
        StringBuilder out = new StringBuilder("CoberturaRPC{").append("id=").append( id).append(", idProduct=").append( idProduct).append(", idPlan=").append( idPlan).append(", name='").append( name).append( '\'').append(", isMandatory=").append( isMandatory).append(", isLeading=").append( isLeading).append(", dataDynamic:\n{");
        for (Map.Entry<String, DynamicDataRPC> i: dataDynamic.entrySet()) out.append(i.getValue().toString());
        out.append("}\n}");
        return out.toString();
    }
}
