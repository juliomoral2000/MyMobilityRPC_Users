package com.consisint.acsele.interseguro.interfaces.mobilityRPC.services.beans;

/**
 * Created by Julio on 02/02/2016.
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
