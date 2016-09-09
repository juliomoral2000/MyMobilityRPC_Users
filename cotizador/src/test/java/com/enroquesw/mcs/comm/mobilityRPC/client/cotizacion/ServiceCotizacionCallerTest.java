package com.enroquesw.mcs.comm.mobilityRPC.client.cotizacion;

import com.consisint.acsele.interseguro.interfaces.mobilityRPC.services.beans.CotizacionRPC;
import com.consisint.acsele.interseguro.interfaces.mobilityRPC.services.beans.ProductRPC;
import com.consisint.acsele.interseguro.interfaces.mobilityRPC.services.beans.TablaValorGarantizadoRPC;
import com.consisint.acsele.interseguro.interfaces.mobilityRPC.services.client.caller.Quotation_Callers;
import com.consisint.acsele.interseguro.interfaces.mobilityRPC.services.params.CotizacionParameter;
import com.consisint.acsele.interseguro.interfaces.mobilityRPC.services.params.ProductParameter;
import com.consisint.acsele.interseguro.interfaces.mobilityRPC.services.params.TVGParameter;
import com.enroquesw.mcs.comm.mobilityRPC.client.BaseData;
import com.enroquesw.mcs.comm.mobilityRPC.client.ServicesResultsObjectCache;
import com.enroquesw.mcs.comm.mobilityRPC.util.FileUtil;
import com.esotericsoftware.minlog.Log;
import com.google.common.base.Stopwatch;

import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

import static com.enroquesw.mcs.comm.mobilityRPC.enums.SystemName.ACSELE;
import static com.enroquesw.mcs.comm.mobilityRPC.util.DateUtil.DATE_FORMAT_DEF;
import static com.enroquesw.mcs.comm.mobilityRPC.util.LogUtil.SEP;
import static com.enroquesw.mcs.comm.mobilityRPC.util.NumberUtil.redondearDosDecimales;

/**
 * Created by Julio on 29/08/2016.
 */
public class ServiceCotizacionCallerTest {
    /***************** Metodos Principales o Bases o utilitarios o Atomicos *******************************************/
    public static CotizacionRPC test_GetListCotizacionRPC(ProductParameter parameter, String productName) {
        try {
            String x0 = "[test_GetListCotizacionRPC] Inicio ********************\n";
            Stopwatch t = Stopwatch.createStarted();
            List<CotizacionRPC> cRPCs = ServicesResultsObjectCache.getListaCotizaciones(parameter);
            t.stop(); // optional
            t.elapsed(TimeUnit.MILLISECONDS);
            String x1 = "[test_GetListCotizacionRPC]; Total time; " + t;
            System.out.println(x1);
            t.reset(); t.start();
            StringBuffer y0 = new StringBuffer();
            for (CotizacionRPC cRPC : cRPCs) {
                String y1 = "[test_GetListCotizacionRPC] Poliza/Cotizacion Cargada : \n" + FileUtil.gson.toJson(cRPC);
                y0.append(y1+"\n");
                System.out.println(y1);
            }
            FileUtil.writeJSONLogByProduct(productName, SEP + x0 + "\n" + y0.toString() + x1 + "\n" + SEP);
            return !cRPCs.isEmpty() ? cRPCs.get(0): null;
        }catch (Exception e){
            Log.debug("ver ", e);
            String x = "[test_GetListCotizacionRPC] Error " + e.getMessage();
            System.out.println(x);
            FileUtil.writeJSONLogByProduct(productName, x + "\n" + SEP);
        }
        return null;
    }

    public static CotizacionRPC test_CalcularCotizacion(boolean isDirecta, CotizacionRPC cotizacionRPCIn, long timeOut, String productName) {
        try {
            long idPoliza = cotizacionRPCIn.getIdPoliza();
            String x = "[test_CalcularCotizacion] Inicio Calculo "+(isDirecta ? (idPoliza != 0 ? "RE_COTIZACION" : "DIRECTO") : "INVERSO") + SEP;
            CotizacionParameter parameter = CreateCotizacion.createParameterFromCotizacion(isDirecta, cotizacionRPCIn, timeOut);
            String x0 = "[test_CalcularCotizacion]; parametro de entrada:\n" + FileUtil.gson.toJson(parameter);
            System.out.println(x0);
            Stopwatch t = Stopwatch.createStarted();
            StringBuffer requestIdOut = new StringBuffer();
            CotizacionRPC cotizacionRPC = ServicesResultsObjectCache.calcularCotizacion(isDirecta, timeOut, parameter, requestIdOut);
            t.stop(); // optional
            t.elapsed(TimeUnit.MILLISECONDS);
            System.out.println(SEP);
            String x1 = new StringBuilder("[test_CalcularCotizacion];").append(" req_Id: ").append(UUID.fromString(requestIdOut.toString()).hashCode()).append("; requestIdOut: ").append(requestIdOut).append("\nCalculo ").append((isDirecta ? (idPoliza != 0 ? "Recotizar" : "Directo") : "Inverso") + " respuesta :\n").append(FileUtil.gson.toJson(cotizacionRPC)).toString();
            System.out.println(x1);
            String x2 = "[test_CalcularCotizacion]; Total time; " + t;
            System.out.println(SEP + x2);
            String x3 = new StringBuilder("[test_CalcularCotizacion]; Termine ....;").append(" req_Id: ").append(UUID.fromString(requestIdOut.toString()).hashCode()).append("; requestIdOut: ").append(requestIdOut).toString();
            System.out.println(x3+ SEP + SEP);
            FileUtil.writeJSONLogByProduct(productName, x + SEP + x0 + "\n" + SEP + x1 + "\n" + x2 + "\n" + x3 + "\n" + SEP);
            return cotizacionRPC;
        }catch (Exception e){
            Log.debug("ver ", e);
            FileUtil.writeJSONLogByProduct(productName, "[test_CalcularCotizacion]; Error " + e.getMessage() + "\n" + SEP);
            return null;
        }
    }

    /***************** Metodos Agrupadores de funcionalidad  **********************************************************/
    public static  CotizacionRPC cargarCotizacionBase(ProductRPC productRPC) {
        BaseData baseDataPolicyId = FileUtil.getJSONBaseDataFromFile(productRPC.getName());                     // cargamos los datos de la Poliza Base desde un archivo
        CotizacionRPC cotRPCBase = FileUtil.getJSONFromFileByPolId(baseDataPolicyId, productRPC.getName());     // SI EXISTE EL ARCHIVO --> Cargamos la cotizacion base desde archivo ,
        if(cotRPCBase == null){
            ProductParameter parameter = new ProductParameter(baseDataPolicyId.getIdProducto());
            parameter.setTimeOutMax(baseDataPolicyId.getIdPoliza());                         // Lo voy a setear al id de la poliza Base para mis pruebas
            cotRPCBase = test_GetListCotizacionRPC(parameter, productRPC.getName());    // Cargamos la cotizacion desde El Servicio de Acsele
            if(cotRPCBase != null) FileUtil.writeJSONByPolIdToFile(productRPC.getName() , cotRPCBase);
        }
        FileUtil.writeJSONLogByProduct(productRPC.getName(), SEP +"[cargarCotizacionBase]; Cotizacion Base:\n" + FileUtil.gson.toJson(cotRPCBase)+ SEP);
        return cotRPCBase;
    }

    public static CotizacionRPC executeCalculoDirecto(ProductRPC productRPC, long timeOut, CotizacionRPC cotRPCBase) {
        FileUtil.writeJSONLogByProduct(productRPC.getName(), "[executeCalculoDirecto] INICIO ......  " + SEP);
        CotizacionRPC cotRPCDirecto = ServicesResultsObjectCache.cloneCotizacionRPC(cotRPCBase);        // Clonamos el cotBase
        CreateCotizacion.cleanOutFields(cotRPCDirecto, false, true);                                    // Limpiamos El clone
        cotRPCDirecto = test_CalcularCotizacion(true, cotRPCDirecto, timeOut, productRPC.getName());    // Realizamos el calculo directo
        FileUtil.writeJSONLogByProduct(productRPC.getName(), "[executeCalculoDirecto] FINALIZO ......  "+ SEP);
        return cotRPCDirecto;
    }

    public static CotizacionRPC executeReCalculoDirecto(ProductRPC productRPC, long timeOut, CotizacionRPC cotRPCDirecto) {
        FileUtil.writeJSONLogByProduct(productRPC.getName(), "[executeReCalculoDirecto] INICIO ......  " + SEP);
        CotizacionRPC cRPC_Recalculo = ServicesResultsObjectCache.cloneCotizacionRPC(cotRPCDirecto);
        CreateCotizacion.cleanOutFields(cRPC_Recalculo, false, false);  // Limpiamos al clon
        cRPC_Recalculo.setMontoTotalPrimaFP(0.0);
        cRPC_Recalculo = test_CalcularCotizacion(true, cRPC_Recalculo, timeOut, productRPC.getName());
        FileUtil.writeJSONLogByProduct(productRPC.getName(), "[executeReCalculoDirecto] FINALIZO ......  " + SEP);
        return cRPC_Recalculo;
    }

    public static CotizacionRPC executeCalculosInversos(ProductRPC productRPC, long timeOut, CotizacionRPC cotRPCBase ) {
        FileUtil.writeJSONLogByProduct(productRPC.getName(), "[executeCalculosInversos] INICIO ......  "+ SEP);
        if(productRPC.getDataDynamic().containsKey("IndCapital") && "CapitalTABLA".equalsIgnoreCase(productRPC.getDataDynamic().get("IndCapital").getInput())){
            FileUtil.writeJSONLogByProduct(productRPC.getName(), "[executeCalculosInversos] Para el producto "+productRPC.getName()+" no aplica el evento  'CotizarInverso'\n"+ SEP); return null;
        }
        CotizacionRPC cotRPCDirectoToInver = ServicesResultsObjectCache.cloneCotizacionRPC(cotRPCBase);     // Clonamos el cotBase
        CreateCotizacion.cleanOutFields(cotRPCDirectoToInver, false, true);                                 // Limpiamos El clone
        cotRPCDirectoToInver = test_CalcularCotizacion(true, cotRPCDirectoToInver, timeOut, productRPC.getName());     // Realizamos el calculo directo
        if(cotRPCDirectoToInver.getIdPoliza() == 0){ FileUtil.writeJSONLogByProduct(productRPC.getName(), "[executeCalculosInversos] cotRPCDirectoToInver ERROR en Calculo Directo \n"); return null;}
        double montoTotalPrimaFP_Inicial = cotRPCDirectoToInver.getMontoTotalPrimaFP();     // sacamos la prima inicial de la poliza
        double porcentajeCambio = -25;                                                      // porcentaje de cambio a la prima [ si positivo es el 100 + este, si es negativo se le resta ese porcentaje a la prima original ]
        double nuevaprimaInv = redondearDosDecimales(porcentajeCambio >= 0 ? ((100 + porcentajeCambio) * montoTotalPrimaFP_Inicial) / 100 : (montoTotalPrimaFP_Inicial - ((-1 * porcentajeCambio * montoTotalPrimaFP_Inicial) / 100)));
        System.out.println(SEP +"[executeCalculosInversos] Valor Para inversaMontoTotalPrimaFP :"+nuevaprimaInv+"\n"+ SEP);
        FileUtil.writeJSONLogByProduct(productRPC.getName(), SEP + "[executeCalculosInversos] Valor Para inversaMontoTotalPrimaFP :" + nuevaprimaInv + "\n" + SEP);
        CotizacionRPC cRPC_inverso = ServicesResultsObjectCache.cloneCotizacionRPC(cotRPCDirectoToInver);   // Clonamos a la Cotizacion Directa
        CreateCotizacion.cleanOutFields(cRPC_inverso, false, false);    // Limpiamos las salidas FIXME_JULIO: verificar si se debe cambiar/limpiar el motoAsegurado en las coberturas
        cRPC_inverso.setMontoTotalPrimaFP(nuevaprimaInv);               // Seteamos la prima Inversa Deseada
        cRPC_inverso = test_CalcularCotizacion(false, cRPC_inverso, timeOut, productRPC.getName()); // Realizamos el calculo inverso
        FileUtil.writeJSONLogByProduct(productRPC.getName(), "[executeCalculosInversos] FINALIZO ......  " + SEP);
        return cRPC_inverso;
    }

    public static TablaValorGarantizadoRPC executeCalculoTVG(StringBuffer requestIdOut, TVGParameter parameter) {
        final TablaValorGarantizadoRPC tablaTVGRPC = Quotation_Callers.calcularTVG(ACSELE, parameter, requestIdOut);
        return tablaTVGRPC;
    }

    /*********************** METODO INVOCADO POR EL principal *********************************************************/
    public static void conjuntoPruebasCotizacion(ProductRPC productRPC, final Long timeOut, boolean overWriteLog) {
        FileUtil.writeJSONLogByProduct(productRPC.getName(), DATE_FORMAT_DEF.format(new Date())+"; [conjuntoPruebasCotizacion] INICIO...  producto: "+productRPC.getName()+"\n", overWriteLog);
        try {
            /*********************** CARGAMOS DATOS DE COTIZACION BASE O REFERENCIA ***************************************/
            CotizacionRPC cotRPCBase = cargarCotizacionBase(productRPC);
            if(cotRPCBase == null){ FileUtil.writeJSONLogByProduct(productRPC.getName(), "[conjuntoPruebasCotizacion] cotRPCBase ES NULO \n"); return;}
            /************************** CALCULO aplica_[DIRECTO]/sobreUltimoApp_[]     "1 EVENTO - cotizarvida"  ***********************/
            /*CotizacionRPC cotRPCDirecto = executeCalculoDirecto(productRPC, timeOut, cotRPCBase);
            if(cotRPCDirecto.getIdPoliza() == 0){ FileUtil.writeJSONLogByProduct(productRPC.getName(), "[conjuntoPruebasCotizacion] cotRPCDirecto ERROR en Calculo Directo \n"+ SEP); return;}*/
            /************************** CALCULO aplica_[DIRECTO]/sobreUltimo_[DIRECTO]  "1 EVENTO - ReCotizar" ***********************/
            /*CotizacionRPC cRPC_Recalculo = executeReCalculoDirecto(productRPC, timeOut, cotRPCDirecto);
            if(!cRPC_Recalculo.getValidaciones().isEmpty()){ FileUtil.writeJSONLogByProduct(productRPC.getName(), "[conjuntoPruebasCotizacion] cRPC_Recalculo ERROR en Re-Calculo Directo \n"+ SEP); return;}*/
            /************************** CALCULO aplica_[INVERSO]/sobreUltimo_[DIRECTO]  "1 EVENTO - CotizarInv" ***********************/
            CotizacionRPC cRPC_inverso = executeCalculosInversos(productRPC, timeOut, cotRPCBase);
            if(cRPC_inverso != null && !cRPC_inverso.getValidaciones().isEmpty()){ FileUtil.writeJSONLogByProduct(productRPC.getName(), "[conjuntoPruebasCotizacion] cRPC_inverso ERROR en Re-Calculo Inverso \n"+ SEP); return;}
            /************************** CALCULO aplica_[DIRECTO]/sobreUltimo_[INVERSO]   "1 EVENTO - ReCotizar" ***********************/
            /********** RECALCULAR DIRECTO/INVERSO - SOBRE UNA COTIZACION ultima operacion Cotizacion Inversa  ************/
            // FIXME_JULIO: Implementar
            /************************** CALCULO aplica_[INVERSO]/sobreUltimo_[INVERSO]   "1 EVENTO - CotizarInv" ***********************/
            /********** RECALCULAR INVERSO/INVERSO - SOBRE UNA COTIZACION ultima operacion Cotizacion Inversa  ************/
            // FIXME_JULIO: Implementar
        } finally {
            FileUtil.writeJSONLogByProduct(productRPC.getName(), DATE_FORMAT_DEF.format(new Date()) + "; [conjuntoPruebasCotizacion] FINALIZO... producto: " + productRPC.getName() + "\n" + SEP + SEP + SEP + SEP);
        }
    }

    public static void test_CalcularTVG(String productName, CotizacionRPC cRPC, Long timeOut) {
        try {
            String x = "[executeCalculoTVG] Inicio Calculo "+productName + SEP;
            //FileUtil.writeJSONLogByProduct(productName, x);
            TVGParameter parameter = new TVGParameter(cRPC.getIdPoliza(), cRPC.getIdOperation(), timeOut);
            String x0 = "[executeCalculoTVG]; parametro de entrada:\n" + FileUtil.gson.toJson(parameter);
            System.out.println(x0);
            Stopwatch t = Stopwatch.createStarted();
            StringBuffer requestIdOut = new StringBuffer();
            final TablaValorGarantizadoRPC tvg = executeCalculoTVG(requestIdOut, parameter);
            String x1 = new StringBuilder("[executeCalculoTVG];").append(" req_Id: ").append(UUID.fromString(requestIdOut.toString()).hashCode()).append("; requestIdOut: ").append(requestIdOut).append("\nCalculo ").append(FileUtil.gson.toJson(tvg)).toString();
            System.out.println(x1);
            String x2 = "[executeCalculoTVG]; Total time; " + t;
            System.out.println(SEP + x2);
            String x3 = new StringBuilder("[executeCalculoTVG]; Termine ....;").append(" req_Id: ").append(UUID.fromString(requestIdOut.toString()).hashCode()).append("; requestIdOut: ").append(requestIdOut).toString();
            System.out.println(x3+ SEP + SEP);
            t.stop(); // optional
            t.elapsed(TimeUnit.MILLISECONDS);
            System.out.println("***************************************");
            System.out.println("[test_CalcularTVG]; Calculo respuesta :\n" + tvg.toString());
            System.out.println("[test_CalcularTVG]; Total time; " + t);
            System.out.println("***************************************");
            System.out.println("[test_CalcularTVG]; Termine ....");
            FileUtil.writeJSONLogByProduct(productName, x + SEP + x0 + "\n" + SEP + x1 + "\n" + x2 + "\n" + x3 + "\n" + SEP+"[executeCalculoTVG] FINALIZO ......  " + SEP);
        }catch (Exception e){
            Log.debug("ver ", e);
        }
    }
}

