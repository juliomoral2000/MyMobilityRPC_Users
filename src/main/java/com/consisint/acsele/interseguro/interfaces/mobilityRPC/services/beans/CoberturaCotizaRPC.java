package com.consisint.acsele.interseguro.interfaces.mobilityRPC.services.beans;

/**
 * La clase <code>CoberturaCotizaRPC</code> representa el wrapper de los datos de la Cobertura
 * extraido del Cotizador el cual sera utilizado por los servicios de Cotizacion.
 */
public class CoberturaCotizaRPC {
    long idCobertura;               // Id de Cobertura [ConfiguratedCoverage.id]
    double montoCapitalAsegurado;   // Monto del Capital Asegurado [UR.capitalAsegurado Como entrada || Cov.COVTasaBasicaI Como salida {CalculoInverso}]
    double montoPrima;              // Monto de Prima [Cov.COVPrimaCOT Como entrada {CalculoInverso} || Cov.COVPrima Como salida]

    /**
     *
     * @param idCobertura           Id de Cobertura
     * @param montoCapitalAsegurado Monto del Capital Asegurado
     * @param montoPrima            Monto de Prima
     */
    public CoberturaCotizaRPC(long idCobertura, double montoCapitalAsegurado, double montoPrima) {
        this.idCobertura = idCobertura;
        this.montoCapitalAsegurado = montoCapitalAsegurado;
        this.montoPrima = montoPrima;
    }

    @Override
    public String toString() {
        StringBuilder out = new StringBuilder("CoberturaCotizaRPC{").append("idCobertura=").append(String.valueOf(idCobertura))
                .append(", montoCapitalAsegurado=").append(String.valueOf(montoCapitalAsegurado))
                .append(", montoPrima=").append(String.valueOf(montoPrima));
        out.append("}");
        return out.toString();
    }
}
