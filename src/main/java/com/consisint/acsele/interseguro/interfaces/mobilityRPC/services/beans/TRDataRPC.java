package com.consisint.acsele.interseguro.interfaces.mobilityRPC.services.beans;

/**
 * La clase <code>TRDataRPC</code> representa el wrapper del TransformadorFila
 * de Acsele para los servicios del MobilityRPC.
 */
public class TRDataRPC {
    String input;
    double value;
    String display;

    public TRDataRPC(String input, double value, String display) {
        this.input = input;
        this.value = value;
        this.display = display;
    }

    public String getInput() {
        return input;
    }

    public double getValue() {
        return value;
    }

    public String getDisplay() {
        return display;
    }
}
