package com.consisint.acsele.interseguro.interfaces.mobilityRPC.services.beans;

import java.util.Hashtable;
import java.util.Map;

/**
 * La clase <code>PlanRPC</code> representa el wrapper del Plan
 * de Acsele para los servicios del MobilityRPC. (para Interseguro es el PERIODO DE PAGO)
 */
public class PlanRPC {
    long id;
    long idProducto;
    String name;
    Map<String, DynamicDataRPC> dataDynamic = new Hashtable<String, DynamicDataRPC>(); // propiedadNombre, <nombre, input, value>
    //List<InsureObjectTypeRPC> plans = new ArrayList<InsureObjectTypeRPC>();
    //List<RequisiteTypeRPC> plans = new ArrayList<RequisiteTypeRPC>();
    //List<ClausulaRPC> plans = new ArrayList<ClausulaRPC>();
    public static final transient String[] PROPERTIESTOTAKE = {/*"Ramo", "SubRamo", "RamoSBS", "EdadLimiteIngreso", "EdadMinima"*/};

    public PlanRPC(long id, long idProducto, String name, Map<String, DynamicDataRPC> dataDynamic) {
        this.id = id;
        this.idProducto = idProducto;
        this.name = name;
        this.dataDynamic = dataDynamic;
    }

    public long getId() {
        return id;
    }

    public long getIdProducto() {
        return idProducto;
    }

    public String getName() {
        return name;
    }

    public Map<String, DynamicDataRPC> getDataDynamic() {
        return dataDynamic;
    }
}
