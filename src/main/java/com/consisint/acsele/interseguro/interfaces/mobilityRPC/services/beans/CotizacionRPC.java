package com.consisint.acsele.interseguro.interfaces.mobilityRPC.services.beans;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * La clase <code>CotizacionRPC</code> representa el wrapper de los datos de la Cotizacion
 * extraido del Cotizador el cual sera utilizado por los servicios de Cotizacion.
 */
public class CotizacionRPC {
    long idProducto;                // Id de Producto [AgregatedPoliza.productId]
    long idUnidadRiesgoType;        // Id de Unidad de Riesgo Configurada
    long idPlan;                    // Id del Plan Acsele (este agrupa los Objetos Asegurados en Acsele) - por ahora solo existe uno x producto
    double idPlanVida;              // Id de PlanVida                       -- [Poliza.PlanVida] --> [TarifaRPC.idPlanVida]
    double idTipoDescuento;         // Id o valor Tipo de Descuento [VERIFICAR ESTO -- Pol.TipoDescuento] -- Campo "TipoDescuento" solo usada en una tabla "TDDescuentoVida" no esta en ninguna configuracion de Polizas ????? XQ????
    double idPeriodoCobertura;      // Id o valor Periodo de Cobertura      -- [AgregatedPolicy.validity] o lo mismo [STPT_PRODUCTVALIDITY.PVT_VALIDITY] -->  [VigenciaRPC.valor]
    long idPeriodoDePago;           // Id del Periodo de Pago               -- [ConfiguratedFinancialPlan.CONFIGURATEDFINANCIALPLANID]  -->  [PlanFinanciamientoRPC.id]
    long idMoneda;                  // Id de la Moneda de ese Cotizacion    -- [STPS_FINANCIALPLANCURRENCY.CCY_ID]  -->  [Monedas que correspondan con PlanFinanciamientoRPC.idMonedas]
    double idPeriodoPagoPrima;      // Id o valor periodo Pago Prima        -- [UR.periodoPagoPrima]        --> [TarifaRPC.map<"periodoPagoPrimaTD">]
    double idPeriodoPagoBeneficio;  // Id o valor periodo Pago Beneficio    -- [Poliza.NumeroAnualidades]   --> [PropertyValuesRPC.get("NumeroAnualidades")]
    double idGrupoFamiliar;         // Id o valor Grupo Familiar            -- [Poliza.GrupoFamiliar]       -->  [PropertyValuesRPC.get("GrupoFamiliar")]
    long fechaCotizacion = 0;       // Fecha Cotizacion                     -- [Poliza.FechaInicial]
    boolean isIGV = false;          // Este flag indica si el CONTRATANTE es Natural o Juridico
    /*** Totalizaciones o Respuestas Calculadas  */
    double montoPrimaBruta;         //  Monto Prima Bruta                       -- [cov.COVPorcPartCoaCed]
    double montoPrimaVoluntaria;    //  Monto Prima Voluntaria                  -- [?????] Segunda Fase
    double montoPrimaPrograma;      //  Monto Prima Programada                  -- [cov.COVPorcPartCoaCed] Por Ahora (No hay productos Flex - cov.COVPorcPartCoaCed+"CampoPrimaVoluntariaRegular")
    double montoPrimaFP;            //  Monto Prima por Forma de Pago           -- [cov.COVPrimaNeta]
    double derechoEmision;          //  Derecho de Emision                      -- [COVMontoDE]
    double igv;                     //  Monto IGV                               -- [COVMontoIGV]
    double montoTotalPrimaFP;       //  Monto Total Prima por Forma de Pago     -- [COVPrima]

    List<ObjetoAsegCotizaRPC> iosCot = new ArrayList<ObjetoAsegCotizaRPC>();     // Lista de Objetos Asegurado (Info de Asegurados e Coberturas)
    List<ValidacionRPC> validaciones = new ArrayList<ValidacionRPC>();  // Salida de Lista de Errores en las validaciones realizadas al calcular la poliza


    /**
     * Constructor
     * @param idProducto                Id de Producto
     * @param idPlan                    Id del Plan Acsele (este agrupa los Objetos Asegurados en Acsele)
     * @param idUnidadRiesgoType        Id de Unidad de Riesgo Configurada
     * @param idPlanVida                Id de PlanVida
     * @param idTipoDescuento           Id o valor Tipo de Descuento
     * @param idPeriodoCobertura        Id o valor Periodo de Cobertura
     * @param idPeriodoDePago           Id del Periodo de Pago
	 * @param idMoneda                  Id de la Moneda
     * @param idPeriodoPagoPrima        Id o valor periodo Pago Prima
     * @param idPeriodoPagoBeneficio    Id o valor periodo Pago Beneficio
     * @param idGrupoFamiliar           Id o valor Grupo Familiar
     * @param fechaCotizacion           Fecha Cotizacion o Fecha inicial de la Poliza
     * @param isIGV                     Este flag indica si el CONTRATANTE es Natural o Juridico
     * @param iosCot                    Lista de Objetos Asegurado (Info de Asegurados e Coberturas)
     */
    public CotizacionRPC(long idProducto, long idUnidadRiesgoType, long idPlan, double idPlanVida, double idTipoDescuento, double idPeriodoCobertura, long idPeriodoDePago, long idMoneda, double idPeriodoPagoPrima, double idPeriodoPagoBeneficio, double idGrupoFamiliar, long fechaCotizacion, boolean isIGV, List<ObjetoAsegCotizaRPC> iosCot) {
        this.idProducto = idProducto;
        this.idPlan = idPlan;
        this.idUnidadRiesgoType = idUnidadRiesgoType;
        this.idPlanVida = idPlanVida;
        this.idTipoDescuento = idTipoDescuento;
        this.idPeriodoCobertura = idPeriodoCobertura;
        this.idPeriodoDePago = idPeriodoDePago;
        this.idMoneda = idMoneda;
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

    public long getIdUnidadRiesgoType() {
        return idUnidadRiesgoType;
    }

    public long getIdPlan() {
        return idPlan;
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

    public long getIdPeriodoDePago() {
        return idPeriodoDePago;
    }

    public long getIdMoneda() {
        return idMoneda;
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

    public List<ObjetoAsegCotizaRPC> getIosCot() {
        return iosCot;
    }

    public List<ValidacionRPC> getValidaciones() {
        return validaciones;
    }

    public void setValidaciones(List<ValidacionRPC> validaciones) {
        this.validaciones = validaciones;
    }

    @Override
    public String toString() {
        StringBuilder out = new StringBuilder("CotizacionRPC{")
                .append("idProducto=").append(String.valueOf(idProducto))
                .append(", idUnidadRiesgoType=").append(String.valueOf(idUnidadRiesgoType))
                .append(", idPlan=").append(String.valueOf(idPlan))
                .append(", idPlanVida=").append(String.valueOf(idPlanVida))
                .append(", idTipoDescuento=").append(String.valueOf(idTipoDescuento))
                .append(", idPeriodoCobertura=").append(String.valueOf(idPeriodoCobertura))
                .append(", idPeriodoDePago=").append(String.valueOf(idPeriodoDePago))
                .append(", idMoneda=").append(String.valueOf(idMoneda))
                .append(", idPeriodoPagoPrima=").append(String.valueOf(idPeriodoPagoPrima))
                .append(", idPeriodoPagoBeneficio=").append(String.valueOf(idPeriodoPagoBeneficio))
                .append(", idGrupoFamiliar=").append(String.valueOf(idGrupoFamiliar))
                .append(", fechaCotizacion=").append(new Date(fechaCotizacion).toString())
                .append(", isIGV=").append(String.valueOf(isIGV))
                .append(", montoPrimaBruta=").append(String.valueOf(montoPrimaBruta))
                .append(", montoPrimaVoluntaria=").append(String.valueOf(montoPrimaVoluntaria))
                .append(", montoPrimaPrograma=").append(String.valueOf(montoPrimaPrograma))
                .append(", montoPrimaFP=").append(String.valueOf(montoPrimaFP))
                .append(", derechoEmision=").append(String.valueOf(derechoEmision))
                .append(", igv=").append(String.valueOf(igv))
                .append(", montoTotalPrimaFP=").append(String.valueOf(montoTotalPrimaFP))
                ;
        if(!iosCot.isEmpty()){
            out.append(", iosCotList:\n{");
            for (ObjetoAsegCotizaRPC j : iosCot) out.append(j.toString()).append("\n");
            out.append("}\n");
        }
        if(!validaciones.isEmpty()){
            out.append(", validacionesList:\n{");
            for (ValidacionRPC z : validaciones) out.append(z.toString()).append("\n");
            out.append("}\n");
        }
        out.append("}");
        return out.toString();
    }

}
