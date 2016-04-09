package com.consisint.acsele.interseguro.interfaces.mobilityRPC.services.beans;

import java.util.ArrayList;
import java.util.List;

/**
 * La clase <code>CotizacionRPC</code> representa el wrapper de los datos de la Cotizacion
 * extraido del Cotizador el cual sera utilizado por los servicios de Cotizacion.
 */
public class CotizacionRPC {
    long idProducto;                // Id de Producto [AgregatedPoliza.productId]
    double idPlanVida;              // Id de PlanVida [Poliza.PlanVida] --> [TarifaRPC.idPlanVida]
    double idTipoDescuento;         // Id o valor Tipo de Descuento [VERIFICAR ESTO -- Pol.TipoDescuento] -- Campo "TipoDescuento" solo usada en una tabla "TDDescuentoVida" no esta en ninguna configuracion de Polizas ????? XQ????
    double idPeriodoCobertura;      // Id o valor Periodo de Cobertura      -- [AgregatedPolicy.validity] o lo mismo [Product.validity] -->  [VigenciaRPC.valor]
    String periodoDePago;           // Nombre o Entrada del Periodo de Pago -- [ConfiguratedFinancialPlan.desc]  -->  [PlanFinanciamientoRPC.desc]
    double idPeriodoPagoPrima;      // Id o valor periodo Pago Prima        -- [UR.periodoPagoPrima] --> [TarifaRPC.map<"periodoPagoPrimaTD">]
    double idPeriodoPagoBeneficio;  // Id o valor periodo Pago Beneficio    -- [Poliza.NumeroAnualidades] --> [PropertyValuesRPC.get("NumeroAnualidades")]
    double idGrupoFamiliar;         // Id o valor Grupo Familiar            -- [Poliza.GrupoFamiliar] -->  [PropertyValuesRPC.get("GrupoFamiliar")]
    long fechaCotizacion = 0;       // Fecha Cotizacion                     -- [Poliza.FechaInicial]
    boolean isIGV = false;          // Este flag indica si el CONTRATANTE es Natural o Juridico
    /*** Totalizaciones o Respuestas Calculadas  */
    double montoPrimaBruta;         //  Monto Prima Bruta                       -- [?????]
    double montoPrimaVoluntaria;    //  Monto Prima Voluntaria                  -- [?????]
    double montoPrimaPrograma;      //  Monto Prima Programada                  -- [?????]
    double montoPrimaFP;            //  Monto Prima por Forma de Pago           -- [Segun Rosa : ThirdPartyMovement.concepto = 'PrimaNeta']
    double derechoEmision;          //  Derecho de Emision                      -- [?????]
    double igv;                     //  Monto IGV                               -- [Segun Rosa : ThirdPartyMovement.concepto = 'IGV']
    double montoTotalPrimaFP;       //  Monto Total Prima por Forma de Pago     -- [Segun Rosa : ThirdPartyMovement.concepto = 'PrimaTotal']

    List<ObjetoAsegCotizaRPC> iosCot = new ArrayList();     // Lista de Objetos Asegurado (Info de Asegurados e Coberturas)
    List<ValidacionRPC> validaciones = new ArrayList<ValidacionRPC>();  // Salida de Lista de Errores en las validaciones realizadas al calcular la poliza


    /**
     * Constructor
     * @param idProducto
     * @param idPlanVida
     * @param idTipoDescuento
     * @param idPeriodoCobertura
     * @param periodoDePago
     * @param idPeriodoPagoPrima
     * @param idPeriodoPagoBeneficio
     * @param idGrupoFamiliar
     * @param fechaCotizacion
     * @param isIGV
     * @param iosCot
     */
    public CotizacionRPC(long idProducto, double idPlanVida, double idTipoDescuento, double idPeriodoCobertura, String periodoDePago, double idPeriodoPagoPrima, double idPeriodoPagoBeneficio, double idGrupoFamiliar, long fechaCotizacion, boolean isIGV, List<ObjetoAsegCotizaRPC> iosCot) {
        this.idProducto = idProducto;
        this.idPlanVida = idPlanVida;
        this.idTipoDescuento = idTipoDescuento;
        this.idPeriodoCobertura = idPeriodoCobertura;
        this.periodoDePago = periodoDePago;
        this.idPeriodoPagoPrima = idPeriodoPagoPrima;
        this.idPeriodoPagoBeneficio = idPeriodoPagoBeneficio;
        this.idGrupoFamiliar = idGrupoFamiliar;
        this.fechaCotizacion = fechaCotizacion;
        this.isIGV = isIGV;
        this.iosCot = iosCot;
    }

    public long getIdProducto() {
        return idProducto;
    }

    public double getIdPlanVida() {
        return idPlanVida;
    }

    public double getIdTipoDescuento() {
        return idTipoDescuento;
    }

    public double getIdPeriodoCobertura() {
        return idPeriodoCobertura;
    }

    public String getPeriodoDePago() {
        return periodoDePago;
    }

    public double getIdPeriodoPagoPrima() {
        return idPeriodoPagoPrima;
    }

    public double getIdPeriodoPagoBeneficio() {
        return idPeriodoPagoBeneficio;
    }

    public double getIdGrupoFamiliar() {
        return idGrupoFamiliar;
    }

    public long getFechaCotizacion() {
        return fechaCotizacion;
    }

    public boolean isIGV() {
        return isIGV;
    }

    public double getMontoPrimaBruta() {
        return montoPrimaBruta;
    }

    public double getMontoPrimaVoluntaria() {
        return montoPrimaVoluntaria;
    }

    public double getMontoPrimaPrograma() {
        return montoPrimaPrograma;
    }

    public double getMontoPrimaFP() {
        return montoPrimaFP;
    }

    public double getDerechoEmision() {
        return derechoEmision;
    }

    public double getIgv() {
        return igv;
    }

    public double getMontoTotalPrimaFP() {
        return montoTotalPrimaFP;
    }

    public List<ValidacionRPC> getValidaciones() {
        return validaciones;
    }

    public void setValidaciones(List<ValidacionRPC> validaciones) {
        this.validaciones = validaciones;
    }
}
