package com.enroquesw.mcs.comm.mobilityRPC.client.cotizacion;

import com.consisint.acsele.interseguro.interfaces.mobilityRPC.services.beans.*;
import com.consisint.acsele.interseguro.interfaces.mobilityRPC.services.params.CotizacionParameter;
import com.enroquesw.mcs.comm.mobilityRPC.client.MyTestMethodCOT;
import com.enroquesw.mcs.comm.mobilityRPC.client.ServicesResultsObjectCache;
import com.enroquesw.mcs.comm.mobilityRPC.util.DateUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * La clase <code>CreateCotizacion</code> es una clase utilitaria de funciones de creacion de objetos de cotizacion
 */
public class CreateCotizacion {

    public static CotizacionParameter createParameterFromCotizacion(boolean isDirecta, CotizacionRPC cotizacionRPC, long timeOut) {
        final CotizacionParameter cotizacionParameter = new CotizacionParameter(cotizacionRPC, !isDirecta);
        cotizacionParameter.setTimeOutMax(timeOut);
        return cotizacionParameter;
    }
    public static CotizacionParameter createParameterFromMap(boolean isDirecta, Map<String, String> mapa) {
        CreateCotizacion createCotizacion = new CreateCotizacion();
        long idProducto = Long.parseLong(mapa.get("idProducto"));
        long idGrupoFamiliar = Long.parseLong(mapa.get("idGrupoFamiliar"));
        long idPeriodoDePago =  Long.parseLong(mapa.get("idPeriodoDePago"));   // valor del Periodo de Pago
        long idMoneda = Long.parseLong(mapa.get("idMoneda"));           // Id de la Moneda de ese Cotizacion
        return new CotizacionParameter(createCotizacion.createCotizacionFromMap(idProducto, isDirecta, idGrupoFamiliar, idPeriodoDePago, idMoneda, false, mapa), !isDirecta);
    }
    private CotizacionRPC createCotizacionFromMap(long idProducto, boolean isDirecta, double idGrupoFamiliar, long idPeriodoDePago, long idMoneda, boolean isLegal, Map<String, String> mapa) {
        long idUnidadRiesgoType = Long.parseLong(mapa.get("idUnidadRiesgoType"));             // Id de UR
        long idPlan = Long.parseLong(mapa.get("idPlan"));             // Id de Plan
        double idPlanVida = Double.parseDouble(mapa.get("idPlanVida"));   // Id de PlanVida
        double idTipoDescuento = Double.parseDouble(mapa.get("idTipoDescuento"));             // Id o valor Tipo de Descuento
        double idPeriodoCobertura = Double.parseDouble(mapa.get("idPeriodoCobertura")); // Id o valor Periodo de Cobertura   ESTA expresado en meses
        double idPeriodoPagoPrima = Double.parseDouble(mapa.get("idPeriodoPagoPrima")); // Id o valor periodo Pago Prima [Esta expresada en a#os]
        double idPeriodoPagoBeneficio = Double.parseDouble(mapa.get("idPeriodoPagoBeneficio"));    // Id o valor periodo Pago Beneficio
        long fechaCotizacion = DateUtil.getTime(Integer.parseInt(mapa.get("ano")), Integer.parseInt(mapa.get("mes")), Integer.parseInt(mapa.get("dia"))); // Fecha Cotizacion                     -- [Poliza.FechaInicial]
        List<CoberturaRPC> list_ccv = ServicesResultsObjectCache.getListaCoberturas(idProducto);
        List<ObjetoAsegCotizaRPC> iosCot = createListaObjetoAsegCotizaRPCFromMap(isDirecta, idProducto, (int) idGrupoFamiliar, list_ccv, mapa);     // Lista de Objetos Asegurado (Info de Asegurados e Coberturas)
        return new CotizacionRPC(idProducto, list_ccv.get(0).getIdUnidadRiesgoType(), idPlan,  idPlanVida,  idTipoDescuento,  idPeriodoCobertura,  idPeriodoDePago, idMoneda,  idPeriodoPagoPrima,  idPeriodoPagoBeneficio,  idGrupoFamiliar,  fechaCotizacion,  isLegal,  iosCot);
        //return cotizacionRPC;
    }
    private List<ObjetoAsegCotizaRPC> createListaObjetoAsegCotizaRPCFromMap(boolean isDirecta, long idProducto, int idGrupoFamiliar, List<CoberturaRPC> list_ccv, Map<String, String> mapa) {
        //idGrupoFamiliar --> [1,2,3,4] [Titular; Titular y Cónyuge; Titular, Cónyuge e Hijo(s); Titular e Hijo(s)]
        int numeroAsegurados = 0;
        if(idGrupoFamiliar == 0) numeroAsegurados = 1; // Titular
        if(idGrupoFamiliar == 1) numeroAsegurados = 1; // Titular
        if(idGrupoFamiliar == 2) numeroAsegurados = 2; // Titular y Cónyuge
        if(idGrupoFamiliar == 3) numeroAsegurados = 3; // Titular, Cónyuge e Hijo(s)
        if(idGrupoFamiliar == 4) numeroAsegurados = 2; // Titular e Hijo(s)
        List<ObjetoAsegCotizaRPC> iosCot = new ArrayList<ObjetoAsegCotizaRPC>(numeroAsegurados);
        for(int i = 0; i < numeroAsegurados; ++i){
            iosCot.add(createObjetoAsegCotizaRPC(isDirecta, idProducto, idGrupoFamiliar, i+1, list_ccv));
        }
        return iosCot;
    }

    public static CotizacionParameter createParameter(boolean isDirecta, long idProducto, double idGrupoFamiliar) {
        CreateCotizacion createCotizacion = new CreateCotizacion();
        PlanFinanciamientoRPC planF = MyTestMethodCOT.getPlanesFinanciamiento(idProducto).get(0);
        long idPeriodoDePago =  planF.getId();              // valor del Periodo de Pago            -- tabla CONFIGURATEDFINANCIALPLAN [PERIOD]
        long idMoneda = planF.getIdMonedas().get(0);        // Id de la Moneda de ese Cotizacion    -- [STPS_FINANCIALPLANCURRENCY.CCY_ID]  -->  [Monedas que correspondan con PlanFinanciamientoRPC.idMonedas]
        return new CotizacionParameter(createCotizacion.createCotizacion(idProducto, isDirecta, idGrupoFamiliar, idPeriodoDePago, idMoneda, false), !isDirecta);
    }

    private CotizacionRPC createCotizacion(long idProducto, boolean isDirecta, double idGrupoFamiliar, long idPeriodoDePago, long idMoneda, boolean isLegal ) {
        long idPlan = ServicesResultsObjectCache.getPlanRPC(idProducto).get(0).getId();      // Id de PlanVida       -- Tabla PLAN [PLANID]
        double idPlanVida = ServicesResultsObjectCache.getPlanVida(idProducto).get(1).getValue();              // Id de PlanVida       -- Tabla Tarifas [PLANVIDAVALUE]
        double idTipoDescuento = 0;             // Id o valor Tipo de Descuento [VERIFICAR ESTO -- Pol.TipoDescuento] -- Campo "TipoDescuento" solo usada en una tabla "TDDescuentoVida" no esta en ninguna configuracion de Polizas ????? XQ????
        // ServicesResultsObjectCache.getPeriodoCobertura(idProducto)
        double idPeriodoCobertura = 5*12;//ServicesResultsObjectCache.getPeriodosCoberturas(idProducto).get(0).getValor();          // Id o valor Periodo de Cobertura   ESTA expresado en meses   -- Tabla STPT_PRODUCTVALIDITY [PVT_VALIDITY]
        // ServicesResultsObjectCache.getPeriodoPagoPrima(idProducto)
        double idPeriodoPagoPrima = Double.parseDouble(String.format("%.2g%n", idPeriodoCobertura/12));       // Id o valor periodo Pago Prima [Esta expresada en a#os] asignacion a VigenciaEG       -- Tabla Tarifas [PERIODOPAGOPRIMATDVALUE]
        // ServicesResultsObjectCache.getPeriodoPagoBeneficio(idProducto)
        double idPeriodoPagoBeneficio = 1.0;    // Id o valor periodo Pago Beneficio    -- Propiedad "NumeroAnualidades" [Poliza.NumeroAnualidades] --> [PropertyValuesRPC.get("NumeroAnualidades")]
        long fechaCotizacion = DateUtil.getTime(2016, 5, 1); // Fecha Cotizacion                     -- [Poliza.FechaInicial]
        List<CoberturaRPC> list_ccv = ServicesResultsObjectCache.getListaCoberturas(idProducto);
        List<ObjetoAsegCotizaRPC> iosCot = createListaObjetoAsegCotizaRPC(isDirecta, idProducto, (int) idGrupoFamiliar, list_ccv);     // Lista de Objetos Asegurado (Info de Asegurados e Coberturas)
        return new CotizacionRPC(idProducto, list_ccv.get(0).getIdUnidadRiesgoType(), idPlan,  idPlanVida,  idTipoDescuento,  idPeriodoCobertura,  idPeriodoDePago, idMoneda,  idPeriodoPagoPrima,  idPeriodoPagoBeneficio,  idGrupoFamiliar,  fechaCotizacion,  isLegal,  iosCot);
        //return cotizacionRPC;
    }

    private List<ObjetoAsegCotizaRPC> createListaObjetoAsegCotizaRPC(boolean isDirecta, long idProducto, int idGrupoFamiliar, List<CoberturaRPC> list_ccv) {
        //idGrupoFamiliar --> [1,2,3,4] [Titular; Titular y Cónyuge; Titular, Cónyuge e Hijo(s); Titular e Hijo(s)]
        int numeroAsegurados = 0;
        if(idGrupoFamiliar == 0) numeroAsegurados = 1; // Titular
        if(idGrupoFamiliar == 1) numeroAsegurados = 1; // Titular
        if(idGrupoFamiliar == 2) numeroAsegurados = 2; // Titular y Cónyuge
        if(idGrupoFamiliar == 3) numeroAsegurados = 3; // Titular, Cónyuge e Hijo(s)
        if(idGrupoFamiliar == 4) numeroAsegurados = 2; // Titular e Hijo(s)
        List<ObjetoAsegCotizaRPC> iosCot = new ArrayList<ObjetoAsegCotizaRPC>(numeroAsegurados);
        for(int i = 0; i < numeroAsegurados; ++i){
            iosCot.add(createObjetoAsegCotizaRPC(isDirecta, idProducto, idGrupoFamiliar, i+1, list_ccv));
        }
        return iosCot;
    }

    private ObjetoAsegCotizaRPC createObjetoAsegCotizaRPC(boolean isDirecta, long idProducto, int idGrupoFamiliar, int numeroAsegurado, List<CoberturaRPC> list_ccv) {
        return new ObjetoAsegCotizaRPC(numeroAsegurado, list_ccv.get(0).getIdInsuranceObjectType(), createAsegurado(idGrupoFamiliar, numeroAsegurado), createListaCoberturas(isDirecta, list_ccv));
    }

    private List<CoberturaCotizaRPC> createListaCoberturas(boolean isDirecta, List<CoberturaRPC> listCov) {
        List<CoberturaCotizaRPC> list = new ArrayList<CoberturaCotizaRPC>();
        for (CoberturaRPC o : listCov) {
            if(o.isMandatory()) list.add(new CoberturaCotizaRPC(o.getId(), o.isMandatory(), o.isLeading(), isDirecta? 10000.0 : 0));
        }
        return list;
    }

    private AseguradoRPC createAsegurado(int idGrupoFamiliar, int numeroAsegurado) {
        long idTercero = 0;             // Id del Tercero [si en dado caso lo poseen]
        long fechaNacimiento = 0;       // Fecha de Nacimiento [IO.fechaNacimientoCOT]
        double idSexo = 0;              // Id o valor de Sexo -- propiedad "SexoAseg" [0,1,2] [Desconocido, Femenino, Masculino]
        double idFumador = -1;          // Id o valor de Fumador -- propiedad "CondicionFumador" [0, 10] [No Fuma, Si Fuma]
        double idProfesion = 0;         // Id o valor de Profesion -- propiedad "ProfesionActividad" [1 al 112]
        double idClaseAccPers = 0;      // Id o valor de Clase -- propiedad "ClaseAccPers" [1, 2, 3] [Clase I, Clase II, Clase III]
        double idTipoAsegurado = 0; // Id o valor de Tipo de Asegurado -- propiedad "TipoAseguradoAcc" [1, 2, 3] [TITULAR, CONYUGE, HIJO]
        switch (numeroAsegurado){
            case 1: //Titular
                fechaNacimiento = DateUtil.getTime(1970, 5, 1);
                idSexo = 2;              // Id o valor de Sexo -- propiedad "SexoAseg" [0,1,2] [Desconocido, Femenino, Masculino]
                idFumador = 10;          // Id o valor de Fumador -- propiedad "CondicionFumador" [0, 10] [No Fuma, Si Fuma]
                idProfesion = 2;         // Id o valor de Profesion -- propiedad "ProfesionActividad" [1 al 112]
                idClaseAccPers = 1;      // Id o valor de Clase -- propiedad "ClaseAccPers" [1, 2, 3] [Clase I, Clase II, Clase III]
                idTipoAsegurado = idGrupoFamiliar == 0? 0 : 1; // Id o valor de Tipo de Asegurado -- propiedad "TipoAseguradoAcc" [1, 2, 3] [TITULAR, CONYUGE, HIJO]
                break;
            case 2: // Cónyuge o Hijo
                if(idGrupoFamiliar == 2 || idGrupoFamiliar == 0){   //Cónyuge
                    fechaNacimiento = DateUtil.getTime(1950, 12, 1);
                    idSexo = 1;              // Id o valor de Sexo -- propiedad "SexoAseg" [0,1,2] [Desconocido, Femenino, Masculino]
                    idProfesion = 4;         // Id o valor de Profesion -- propiedad "ProfesionActividad" [1 al 112]
                    idTipoAsegurado = idGrupoFamiliar == 0? 0 : 2; // Id o valor de Tipo de Asegurado -- propiedad "TipoAseguradoAcc" [1, 2, 3] [TITULAR, CONYUGE, HIJO]
                } else {    //Hijo
                    fechaNacimiento = DateUtil.getTime(1980, 6, 1);
                    idSexo = 2;              // Id o valor de Sexo -- propiedad "SexoAseg" [0,1,2] [Desconocido, Femenino, Masculino]
                    idProfesion = 44;          // Id o valor de Profesion -- propiedad "ProfesionActividad" [1 al 112]
                    idTipoAsegurado = 3; // Id o valor de Tipo de Asegurado -- propiedad "TipoAseguradoAcc" [1, 2, 3] [TITULAR, CONYUGE, HIJO]
                }
                idFumador = 0;          // Id o valor de Fumador -- propiedad "CondicionFumador" [0, 10] [No Fuma, Si Fuma]
                idClaseAccPers = 1;      // Id o valor de Clase -- propiedad "ClaseAccPers" [1, 2, 3] [Clase I, Clase II, Clase III]
                break;
            case 3: // Hijo
                fechaNacimiento = DateUtil.getTime(1980, 6, 1);
                idSexo = 2;              // Id o valor de Sexo -- propiedad "SexoAseg" [0,1,2] [Desconocido, Femenino, Masculino]
                idProfesion = 44;         // Id o valor de Profesion -- propiedad "ProfesionActividad" [1 al 112]
                idTipoAsegurado = idGrupoFamiliar == 0? 0 : 3; // Id o valor de Tipo de Asegurado -- propiedad "TipoAseguradoAcc" [1, 2, 3] [TITULAR, CONYUGE, HIJO]
                idFumador = 0;          // Id o valor de Fumador -- propiedad "CondicionFumador" [0, 10] [No Fuma, Si Fuma]
                idClaseAccPers = 1;      // Id o valor de Clase -- propiedad "ClaseAccPers" [1, 2, 3] [Clase I, Clase II, Clase III]
                break;
        }
        return new AseguradoRPC( fechaNacimiento,  idSexo,  idFumador,  idProfesion,  idClaseAccPers,  idTipoAsegurado);
    }

    public static void cleanOutFields(CotizacionRPC cRPC, boolean isCleanAmount) {
        cRPC.setMontoPrimaBruta(0.0);
        cRPC.setMontoPrimaVoluntaria(0.0);
        cRPC.setMontoPrimaPrograma(0.0);
        cRPC.setMontoPrimaFP(0.0);
        cRPC.setDerechoEmision(0.0);
        cRPC.setIgv(0.0);
        cRPC.setMontoTotalPrimaFP(0.0);
        cRPC.setTasaCostoEfectivoAnual(0.0);

        cRPC.setFechaaUno(0);                 //  Fecha de la primera anualidad
        cRPC.setFechaaDos(0);                 //  Fecha de la primera anualidad
        cRPC.setFechaaTres(0);                //  Fecha de la segunda anualidad
        cRPC.setFechaaCuatro(0);              //  Fecha de la tercera anualidad
        cRPC.setFechaaCinco(0);               //  Fecha de la cuarta  anualidad
        cRPC.setFechaaSeis(0);                //  Fecha de la sexta   anualidad
        cRPC.setFechaaSiete(0);               //  Fecha de la septima anualidad
        cRPC.setFechaaOcho(0);                //  Fecha de la octava  anualidad
        cRPC.setFechaaNueve(0);               //  Fecha de la novena  anualidad
        cRPC.setFechaaDiez(0);                //  Fecha de la decima  anualidad
        cRPC.setFondoUniversitario(0.0);      //  Monto del Fondo Universitario

        for (ObjetoAsegCotizaRPC oi : cRPC.getIosCot()) {
            for (CoberturaCotizaRPC cov : oi.getCovsCot()) {
                if(isCleanAmount) cov.setMontoCapitalAsegurado(0);
                cov.setMontoPrima(0.0);              // Salida del Monto de Prima                [Cov.COVPrima]
                cov.setMontoTarifa(0.0);             // Salida del Monto de la Tarifa Calculada  [Cov.COVMonComisIII]
                cov.setMontoAjuste(0.0);             // Salida del Monto del Ajuste Calculada    [Cov.COVMonComisII]
                cov.setMontoDescuento(0.0);          // Salida del Monto del Descuento Calculada [Cov.COVMonComisIV]
                cov.setMontoRecargo(0.0);            // Salida del Monto del Recargo presente    [Cov.COVMonComisV]
            }
        }
    }
}
/*double idGrupoFamiliar = 1;             // Id o valor Grupo Familiar            -- Propiedad "GrupoFamiliar"  [1,2,3,4] [Titular; Titular y Cónyuge; Titular, Cónyuge e Hijo(s); Titular e Hijo(s)]*/
        /*boolean isIGV = isLegal;                 // Este flag indica si el CONTRATANTE es Natural o Juridico*/
/*** Totalizaciones o Respuestas Calculadas
 double montoPrimaBruta;         //  Monto Prima Bruta                       -- [?????]
 double montoPrimaVoluntaria;    //  Monto Prima Voluntaria                  -- [?????]
 double montoPrimaPrograma;      //  Monto Prima Programada                  -- [?????]
 double montoPrimaFP;            //  Monto Prima por Forma de Pago           -- [Segun Rosa : ThirdPartyMovement.concepto = 'PrimaNeta']
 double derechoEmision;          //  Derecho de Emision                      -- [?????]
 double igv;                     //  Monto IGV                               -- [Segun Rosa : ThirdPartyMovement.concepto = 'IGV']
 double montoTotalPrimaFP;       //  Monto Total Prima por Forma de Pago     -- [Segun Rosa : ThirdPartyMovement.concepto = 'PrimaTotal']*/
