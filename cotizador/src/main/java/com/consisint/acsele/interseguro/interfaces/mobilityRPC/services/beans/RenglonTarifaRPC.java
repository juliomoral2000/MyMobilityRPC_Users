package com.consisint.acsele.interseguro.interfaces.mobilityRPC.services.beans;

import java.util.Map;

/**
 * La clase <code>RenglonTarifaRPC</code> representa el wrapper de los registros de las Tablas de Tarifas [tablas dinamicas] de los productos de Vida
 * de Acsele para los servicios del MobilityRPC.
 */
public class RenglonTarifaRPC extends DynamicDCORPC {

    public RenglonTarifaRPC(long id, Map<String, DynamicDataRPC> dataRPCMap) {
        super(id, dataRPCMap);
    }
}
