package com.consisint.acsele.interseguro.interfaces.mobilityRPC.services.beans;

/**
 * La clase <code>DynamicDataRPC</code> representa el wrapper del valor de una instancia de una propiedad de algun DCO
 * de Acsele para los servicios del MobilityRPC.
 */
public class DynamicDataRPC {
    String propertyName;
    String input;
    double value;

    public DynamicDataRPC(String propertyName, String input, double value) {
        this.propertyName = propertyName;
        this.input = input;
        this.value = value;
    }

    public String getPropertyName() {
        return propertyName;
    }

    public String getInput() {
        return input;
    }

    public double getValue() {
        return value;
    }
}
