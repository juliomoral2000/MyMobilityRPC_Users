package com.consisint.acsele.interseguro.interfaces.mobilityRPC.services.beans;

/**
 * La clase <code>CoberturaCotizaRPC</code> representa el wrapper de los datos de la Cobertura
 * extraido del Cotizador el cual sera utilizado por los servicios de Cotizacion.
 */
public class CoberturaCotizaRPC {
    long idCobertura;               // Id de Cobertura [ConfiguratedCoverage.id]
    boolean isMandatory;            // Es Obligatoria/mandatorio
    boolean isLeading;              // Es Principal
    double montoCapitalAsegurado;   // Monto del Capital Asegurado [UR.capitalAsegurado Como entrada || Cov.COVTasaBasicaI Como salida {CalculoInverso}]
    double montoPrima;              // Monto de Prima [Cov.COVPrimaCOT Como entrada {CalculoInverso} || Cov.COVPrima Como salida]

    /**
     * Contructor
     * @param idCobertura           Id de Cobertura
     * @param montoCapitalAsegurado Monto del Capital Asegurado
     * @param montoPrima            Monto de Prima
     * */
    public CoberturaCotizaRPC(long idCobertura, double montoCapitalAsegurado, double montoPrima) {
        this.idCobertura = idCobertura;
        this.montoCapitalAsegurado = montoCapitalAsegurado;
        this.montoPrima = montoPrima;
    }

    /**
     * Constructor
     * @param idCobertura           Id de Cobertura
     * @param isMandatory           Es Obligatoria/Mandatoria
     * @param isLeading             Es Principal
     * @param montoCapitalAsegurado Monto del Capital Asegurado
     * @param montoPrima            Monto de Prima
     */
    public CoberturaCotizaRPC(long idCobertura, boolean isMandatory, boolean isLeading, double montoCapitalAsegurado, double montoPrima) {
        this.idCobertura = idCobertura;
        this.isMandatory = isMandatory;
        this.isLeading = isLeading;
        this.montoCapitalAsegurado = montoCapitalAsegurado;
        this.montoPrima = montoPrima;
    }

    public long getIdCobertura() {
        return idCobertura;
    }

    public boolean isMandatory() {
        return isMandatory;
    }

    public boolean isLeading() {
        return isLeading;
    }

    public double getMontoCapitalAsegurado() {
        return montoCapitalAsegurado;
    }

    public double getMontoPrima() {
        return montoPrima;
    }

    public void setMontoCapitalAsegurado(double montoCapitalAsegurado) {
        this.montoCapitalAsegurado = montoCapitalAsegurado;
    }

    public void setMontoPrima(double montoPrima) {
        this.montoPrima = montoPrima;
    }

    @Override
    public String toString() {
        StringBuilder out = new StringBuilder("CoberturaCotizaRPC{").append("idCobertura=").append(String.valueOf(idCobertura))
                .append(", isMandatory=").append(String.valueOf(String.valueOf(isMandatory)))
                .append(", isLeading=").append(String.valueOf(String.valueOf(isLeading)))
                .append(", montoCapitalAsegurado=").append(String.valueOf(montoCapitalAsegurado))
                .append(", montoPrima=").append(String.valueOf(montoPrima));
        out.append("}");
        return out.toString();
    }
}
