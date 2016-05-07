package com.consisint.acsele.interseguro.interfaces.mobilityRPC.services.beans;

/**
 * Created by Julio on 04/05/2016.
 */
public class ValorGarantizadoRenglonRPC {
    public int finAnoVig;          //  Fin A#o vigencia de la Poliza (Altura poliza)           - GVTD_YEAR              - GenerateGVTDetailPK.year
    public double valorRescate;    //  Monto a rescatar                                        - GVTD_TOTALSURRENDER    - totalSurrender
    public double seguroSaldado;   //  Monto a Saldar (Saldado)                                - GVTD_REDUCEDPAID       - reducedPaid
    public int anosCobertura;      //  Numero de A#os a prorrogar                              - GVTD_EXTENDEDYEARS     - extendedYears
    public int mesesCobertura;     //  Mes poliza o Numero de dias a prorrogar(Ver si es entre 30 dias ???? ) - GVTD_MONTH o GVTD_EXTENDEDDAYS      - month o extendedDays
    public double valorProrrogado; //  Monto a Prorrogar (Prorrogado)                          - GVTD_EXTENDEDTERM      - extendedTerm

    public ValorGarantizadoRenglonRPC(int finAnoVig, double valorRescate, double seguroSaldado, int anosCobertura, int mesesCobertura, double valorProrrogado) {
        this.finAnoVig = finAnoVig;
        this.valorRescate = valorRescate;
        this.seguroSaldado = seguroSaldado;
        this.anosCobertura = anosCobertura;
        this.mesesCobertura = mesesCobertura;
        this.valorProrrogado = valorProrrogado;
    }

    @Override
    public String toString() {
        return "ValorGarantizadoRenglonRPC{" + "finAnoVig=" + finAnoVig + ", valorRescate=" + valorRescate + ", seguroSaldado=" + seguroSaldado + ", anosCobertura=" + anosCobertura + ", mesesCobertura=" + mesesCobertura + ", valorProrrogado=" + valorProrrogado + '}';
    }
}
