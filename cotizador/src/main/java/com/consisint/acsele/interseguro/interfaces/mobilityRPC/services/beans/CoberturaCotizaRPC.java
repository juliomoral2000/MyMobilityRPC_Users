package com.consisint.acsele.interseguro.interfaces.mobilityRPC.services.beans;

/**
 * La clase <code>CoberturaCotizaRPC</code> representa el wrapper de los datos de la Cobertura
 * extraido del Cotizador el cual sera utilizado por los servicios de Cotizacion.
 */
public class CoberturaCotizaRPC {
    long idCobertura;               // Id de Cobertura                          [ConfiguratedCoverage.id]
    boolean isMandatory;            // Es Obligatoria/mandatorio
    boolean isLeading;              // Es Principal
    double montoCapitalAsegurado;   // Entrada : [UR.CapitalAsegurado]{Cov Principal} y [Cov.COVBeneficioMaximo]{Todas} Salida: ?????[COVSumaAsegurada] o [Cov.COVTasaBasicaI]?????
    double montoPrima;              // Salida del Monto de Prima                [Cov.COVPrima]
    double montoTarifa;             // Salida del Monto de la Tarifa Calculada  [Cov.COVMonComisIII]
    double montoAjuste;             // Salida del Monto del Ajuste Calculada    [Cov.COVMonComisII]
    double montoDescuento;          // Salida del Monto del Descuento Calculada [Cov.COVMonComisIV]
    double montoRecargo;            // FIXME_JULIO: Monto de Recargo si se llega a definir si realmente se envia al calcular Cotizacion

    /**
     * Constructor caso Calculo Inverso [La prima se ingresa a nivel de CotizacionRPC]
     * @param idCobertura           Id de Cobertura
     * @param isMandatory           Es Obligatoria/Mandatoria
     * @param isLeading             Es Principal
     */
    public CoberturaCotizaRPC(long idCobertura, boolean isMandatory, boolean isLeading) {
        this.idCobertura = idCobertura;
        this.isMandatory = isMandatory;
        this.isLeading = isLeading;
    }

    /**
     * Contructor para caso Calculo Directo
     * @param idCobertura           Id de Cobertura
     * @param isMandatory           Es Obligatoria/Mandatoria
     * @param isLeading             Es Principal
     * @param montoCapitalAsegurado Monto del Capital Asegurado
     * */
    public CoberturaCotizaRPC(long idCobertura, boolean isMandatory, boolean isLeading, double montoCapitalAsegurado) {
        this(idCobertura, isMandatory, isLeading);
        this.montoCapitalAsegurado = montoCapitalAsegurado;
    }

    public long getIdCobertura() { return idCobertura; }

    public boolean isMandatory() { return isMandatory; }

    public boolean isLeading() { return isLeading; }

    public double getMontoCapitalAsegurado() { return montoCapitalAsegurado; }

    public double getMontoPrima() { return montoPrima; }

    public void setMontoCapitalAsegurado(double montoCapitalAsegurado) { this.montoCapitalAsegurado = montoCapitalAsegurado; }

    public void setMontoPrima(double montoPrima) { this.montoPrima = montoPrima; }

    public double getMontoTarifa() { return montoTarifa; }

    public void setMontoTarifa(double montoTarifa) { this.montoTarifa = montoTarifa; }

    public double getMontoAjuste() { return montoAjuste; }

    public void setMontoAjuste(double montoAjuste) { this.montoAjuste = montoAjuste; }

    public double getMontoDescuento() { return montoDescuento; }

    public void setMontoDescuento(double montoDescuento) { this.montoDescuento = montoDescuento; }

    public double getMontoRecargo() { return montoRecargo; }

    public void setMontoRecargo(double montoRecargo) { this.montoRecargo = montoRecargo; }

    @Override
    public String toString() {
        StringBuilder out = new StringBuilder("CoberturaCotizaRPC{").append("idCobertura=").append(String.valueOf(idCobertura))
                .append(", isMandatory=").append(String.valueOf(String.valueOf(isMandatory)))
                .append(", isLeading=").append(String.valueOf(String.valueOf(isLeading)))
                .append(", montoCapitalAsegurado=").append(String.valueOf(montoCapitalAsegurado))
                .append(", montoPrima=").append(String.valueOf(montoPrima))
                .append(", montoTarifa=").append(String.valueOf(montoTarifa))
                .append(", montoAjuste=").append(String.valueOf(montoAjuste))
                .append(", montoDescuento=").append(String.valueOf(montoDescuento));
        out.append("}");
        return out.toString();
    }
}
