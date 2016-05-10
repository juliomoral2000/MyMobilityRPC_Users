package com.consisint.acsele.interseguro.interfaces.mobilityRPC.services.beans;

import java.util.Hashtable;
import java.util.Map;

/**
 * La clase <code>DynamicDCORPC</code> representa el wrapper de un DCO
 * de Acsele para los servicios del MobilityRPC.
 */
public class DynamicDCORPC {
    long id; //id del DCO
    Map<String, DynamicDataRPC> mapDynamicData = new Hashtable<String, DynamicDataRPC>();   //mapa de los valores de las instancias de las propiedades de un DCO

    public DynamicDCORPC(long id, Map<String, DynamicDataRPC> mapDynamicData) {
        this.id = id;
        this.mapDynamicData = mapDynamicData;
    }

    public long getId() {
        return id;
    }

    public Map<String, DynamicDataRPC> getMapDynamicData() {
        return mapDynamicData;
    }

    public DynamicDataRPC pullDynamicDataRCP(String propertyName) {
        return mapDynamicData.get(propertyName);
    }

    @Override
    public String toString() {
        StringBuilder out = new StringBuilder("DynamicDCORPC{").append("id=").append( id).append(", mapDynamicData:\n{");
        for (Map.Entry<String, DynamicDataRPC> i: mapDynamicData.entrySet()) out.append(i.getValue().toString());
        out.append("}\n}");
        return out.toString();
    }
}
