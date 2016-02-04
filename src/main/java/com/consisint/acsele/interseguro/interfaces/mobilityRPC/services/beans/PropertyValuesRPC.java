package com.consisint.acsele.interseguro.interfaces.mobilityRPC.services.beans;

/**
 * La clase <code>PropertyValuesRPC</code> representa el wrapper del Property
 * de Acsele para los servicios del MobilityRPC.
 */
public class PropertyValuesRPC {
    long propertyId;
    String propertyName;
    TRDataRPC[] filas;

    public PropertyValuesRPC(long propertyId, String propertyName, TRDataRPC[] filas) {
        this.propertyId = propertyId;
        this.propertyName = propertyName;
        this.filas = filas;
    }

    public long getPropertyId() {
        return propertyId;
    }

    public String getPropertyName() {
        return propertyName;
    }

    public TRDataRPC[] getFilas() {
        return filas;
    }
}
