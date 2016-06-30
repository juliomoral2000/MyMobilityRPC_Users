package com.consisint.acsele.interseguro.interfaces.mobilityRPC.services.beans;

import java.util.Hashtable;
import java.util.Map;

/**
 * La clase <code>CoberturaRPC</code> representa el wrapper de la Cobertura Configurada
 * de Acsele para los servicios del MobilityRPC.
 */
public class CoberturaRPC {
    long id;                            // Id de Cobertura Configurada
    long idProduct;                     // Id de Producto asociado a esta cobertura
    long idUnidadRiesgoType;            // Id de Unidad de Riesgo Configurada asociado a esta cobertura
    long idPlan;                        // Id de Plan asociado a esta cobertura
    long idInsuranceObjectType;         // Id de Objeto Asegurado Configurado asociado a esta cobertura
    String name;                        // Nombre de la Cobertura
    boolean isMandatory;                // Es Obligatoria/mandatorio?                   [ConfiguratedCoverage.mandatory]
    boolean isLeading;                  // Es Principal?                                [ConfiguratedCoverage.template."COVTipoCobertura".value = 1]
    boolean isCcvBenef;                 // Es una Cobertura para pagar beneficios?      [Product.template."CoberturaBeneficio".exist && contiene a this.cvv
    Map<String, DynamicDataRPC> dataDynamic = new Hashtable<String, DynamicDataRPC>(); // propiedadNombre, <nombre, input, value>
    //public static final transient String[] PROPERTIESTOTAKE = {/*"Ramo", "SubRamo", "RamoSBS", "EdadLimiteIngreso", "EdadMinima"*/};  TODO: posible uso futuro

    /**
     * Constructor
     * @param id                Id de Cobertura Configurada
     * @param idProduct         Id de Producto asociado a esta cobertura
     * @param idPlan            Id de Plan asociado a esta cobertura
     * @param name              Nombre de la Cobertura
     * @param isMandatory       Es mandatorio?
     * @param isLeading         Es principal?
     */
    public CoberturaRPC(long id, long idProduct, long idUnidadRiesgoType, long idPlan, long idInsuranceObjectType, String name, boolean isMandatory, boolean isLeading, boolean isCcvBenef) {
        this.id = id;
        this.idProduct = idProduct;
        this.idUnidadRiesgoType = idUnidadRiesgoType;
        this.idPlan = idPlan;
        this.idInsuranceObjectType = idInsuranceObjectType;
        this.name = name;
        this.isMandatory = isMandatory;
        this.isLeading = isLeading;
        this.isCcvBenef = isCcvBenef;
        /*this.dataDynamic = dataDynamic;*/
    }

    public long getId() { return id; }

    public long getIdProduct() { return idProduct; }

    public long getIdUnidadRiesgoType() { return idUnidadRiesgoType; }

    public long getIdPlan() { return idPlan; }

    public long getIdInsuranceObjectType() { return idInsuranceObjectType; }

    public String getName() { return name; }

    public boolean isMandatory() { return isMandatory; }

    public boolean isLeading() { return isLeading; }

    public boolean isCcvBenef() { return isCcvBenef; }

    @Override
    public String toString() {
        StringBuilder out = new StringBuilder("CoberturaRPC{\n").append("id=").append(id).append(", idProduct=").append(idProduct).append(", idUnidadRiesgoType=").append(idUnidadRiesgoType).append(", idPlan=").append(idPlan).append(", idInsuranceObjectType=").append(idInsuranceObjectType).append(", name='").append(name).append( '\'').append(", isMandatory=").append(isMandatory).append(", isLeading=").append(isLeading).append(", isCcvBenef=").append(isCcvBenef);
        if(!dataDynamic.isEmpty()){
            out.append(", dataDynamic:\n{");
            for (Map.Entry<String, DynamicDataRPC> i: dataDynamic.entrySet()) out.append(i.getValue().toString()).append("\n");
            out.append("}");
        }
        out.append("\n}");
        return out.toString();
    }
}
