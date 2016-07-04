package com.enroquesw.mcs.comm.mobilityRPC.client;

import com.consisint.acsele.interseguro.interfaces.mobilityRPC.services.beans.*;
import com.consisint.acsele.interseguro.interfaces.mobilityRPC.services.client.caller.Product_Callers;
import com.consisint.acsele.interseguro.interfaces.mobilityRPC.services.client.caller.Property_Callers;
import com.consisint.acsele.interseguro.interfaces.mobilityRPC.services.client.caller.Quotation_Callers;
import com.consisint.acsele.interseguro.interfaces.mobilityRPC.services.params.*;
import com.enroquesw.mcs.comm.mobilityRPC.client.cotizacion.CreateCotizacion;
import com.enroquesw.mcs.comm.mobilityRPC.services.exception.ServiceBaseException;
import com.enroquesw.mcs.comm.mobilityRPC.services.factory.CallerRegister;
import com.enroquesw.mcs.comm.mobilityRPC.services.factory.ProcessorRegister;
import com.enroquesw.mcs.comm.mobilityRPC.services.impl.caller.ServicesFactory_Callers;
import com.enroquesw.mcs.comm.mobilityRPC.util.testRunner.MyTestRunnerCOT;
import com.enroquesw.mcs.comm.mobilityRPC.util.testRunner.interfaces.TestRunnerJC;
import com.esotericsoftware.minlog.Log;
import com.google.common.base.Stopwatch;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

import static com.enroquesw.mcs.comm.mobilityRPC.enums.SystemName.ACSELE;

/**
 * Mi Metodo de Prueba
 */
public class MyTestMethodCOT extends TestRunnerJC{
    public static AtomicInteger countExec = new AtomicInteger(0);
    @Override
    public void run() {
        try {
            if(!Log.DEBUG) Log.DEBUG = true;
            testMain();
            MyTestRunnerCOT.finalTest.set(true);
        } catch (Exception e) {
            e.printStackTrace();
            MyTestRunnerCOT.finalTest.set(true);
            this.interrupt();
        }
    }

    public void testMain() throws Exception {
        //test_ServicesFactoryProccesor();
        //test_GetProducts();
        //test_boomerang();
        Stopwatch stopwatch = Stopwatch.createStarted();
        //test_Otra_Cosa();
        //test_StressTestingCalcularCotizacion();
        /****************************************************************************/
        /*final Long timeOut = new Long(60000 * 3);
        long idProduct = 49183;
        final CotizacionRPC cRPC = test_CalcularCotizacion(true, 49183, 0, timeOut);*/
        //test_CalcularTVG(cRPC, timeOut*2);  // probar despues null*/
        //test_GetEdadProducto(49183);
        /****************************************************************************/
        conjuntoPruebasCotizacion();
        /****************************************************************************/
        /*final ProductRPC p = ServicesResultsObjectCache.getProduct(49183);
        System.out.println(p.toString());*/

        //double idGrupoFamiliar = 0;             // Id o valor Grupo Familiar            -- Propiedad "GrupoFamiliar"  [0, 1, 2, 3, 4] [NINGUNO, Titular; Titular y C�nyuge; Titular, C�nyuge e Hijo(s); Titular e Hijo(s)]
        /*************************************************************************/
        // Caso 1.0: Directa , [EducacionGarantizada] - Exitoso
        //test_CalcularCotizacion(true, p.getId(), idGrupoFamiliar);

        // Caso 1.1: Directa , [EducacionGarantizada] - Errores
        // Caso 3.0: Inversa , [EducacionGarantizada] - Exitoso
        // Caso 3.1: Inversa , [EducacionGarantizada] - Errores

        // Caso 2.0.0: Directa , [Vida Protegida] (Titular) - Exitoso
        // Caso 2.0.1: Directa , [Vida Protegida] (Titular/Conyuge) - Exitoso
        // Caso 2.0.2: Directa , [Vida Protegida] (Titular/Hijo) - Exitoso
        // Caso 2.0.3: Directa , [Vida Protegida] (Titular/Conyuge/Hijo) - Exitoso
        // Caso 2.1.0: Directa , [Vida Protegida] (Titular) - Errores
        // Caso 2.1.1: Directa , [Vida Protegida] (Titular/Conyuge) - Errores
        // Caso 2.1.2: Directa , [Vida Protegida] (Titular/Hijo) - Errores
        // Caso 2.1.3: Directa , [Vida Protegida] (Titular/Conyuge/Hijo) - Errores
        // Caso 4.0.0: Inversa , [Vida Protegida] (Titular) - Exitoso
        // Caso 4.0.1: Inversa , [Vida Protegida] (Titular/Conyuge) - Exitoso
        // Caso 4.0.2: Inversa , [Vida Protegida] (Titular/Hijo) - Exitoso
        // Caso 4.0.3: Inversa , [Vida Protegida] (Titular/Conyuge/Hijo) - Exitoso
        // Caso 4.1.0: Inversa , [Vida Protegida] (Titular) - Errores
        // Caso 4.1.1: Inversa , [Vida Protegida] (Titular/Conyuge) - Errores
        // Caso 4.1.2: Inversa , [Vida Protegida] (Titular/Hijo) - Errores
        // Caso 4.1.3: Inversa , [Vida Protegida] (Titular/Conyuge/Hijo) - Errores



        /*************************************************************************/
        //test_ServicesFactoryProccesor();

        //test_StressTestingGetProducts();
        //test_GetProducts(false);
        //int i = 1;
        /*************************************************************************
        test_GetPropertyRPC_Dependencies("CodDepartamento", false, false, "Parent", i++);
        test_GetPropertyRPC_Dependencies("CodDepartamento", true, false, "Parent", i++);
        test_GetPropertyRPC_Dependencies("CodDepartamento", true, true, "Parent", i++);
        *************************************************************************/

        /*test_GetPropertyRPC_Dependencies("CodProvincia", false, false, "Parent", i++);
        test_GetPropertyRPC_Dependencies("CodProvincia", true, false, "Parent", i++);
        test_GetPropertyRPC_Dependencies("CodProvincia", true, true, "Parent", i++);*/
        /*************************************************************************/
        /*test_GetPropertyRPC_Dependencies("CodDistrito", false, false, "Parent", i++);
        test_GetPropertyRPC_Dependencies("CodDistrito", true, false, "Parent", i++);
        test_GetPropertyRPC_Dependencies("CodDistrito", true, true, "Parent", i++);*/
        /*************************************************************************/
        //for(int i = 100000; i > 0 ; --i){
           //test_EdadActuarial();
        //}
        //test_StressTestingGetEdadActuarial();
        /*************************************************************************/
        /*************************************************************************/
        //test_CumulusTercero();
        /*************************************************************************/
        //test_GetPropertyRPC_Dependencies("SexoAseg", false, false, "Parent", 0);
        /*************************************************************************/
        stopwatch.stop(); // optional
        stopwatch.elapsed(TimeUnit.MILLISECONDS);
        System.out.println("[testMain] Total time; " + stopwatch);
        System.out.println("Termine ............................... ");
        //log.log(Level.INFO, "Parate Aqui");
    }

    private void test_Otra_Cosa() throws IOException {
        /*jcifs.Config.setProperty( "jcifs.netbios.wins", "126.26.1.10" ); // ip del server o
        //jcifs.Config.setProperty( "jcifs.smb.client.username", "dinterseguro\\desa.core.vida" ); // Usuario
        //jcifs.Config.setProperty( "jcifs.smb.client.password", "D3s@2016" ); // Password*//*


        NtlmPasswordAuthentication auth = new NtlmPasswordAuthentication("DINTERSEGURO", "desa.core.vida", "D3s@2016");
        final SmbFile smbFile = new SmbFile("smb://interseguro.com.pe\\\\;desa.core.vida:D3s@2016@Aplicaciones/Acsel-e Vida Desarrollo");
        final boolean b1 = smbFile.canRead();
        SmbFileInputStream in = new SmbFileInputStream(new SmbFile("smb://interseguro.com.pe/Aplicaciones/Acsel-e Vida Desarrollo/somefile.txt", auth));
        byte[] b = new byte[8192];
        int n;
        while(( n = in.read( b )) > 0 ) {
            System.out.write( b, 0, n );
        }*/

    }

    private void test_GetEdadProducto(long idProducto) {
        try {
            Stopwatch stopwatch = Stopwatch.createStarted();
            EdadProductoRPC rpc = ServicesResultsObjectCache.getEdadProducto(idProducto);
            stopwatch.stop(); // optional
            stopwatch.elapsed(TimeUnit.MILLISECONDS);
            System.out.println("[test_GetEdadProducto]; Total time; " + stopwatch);
            System.out.println("[test_GetEdadProducto] "+rpc.toString());
        } catch (ServiceBaseException e) {
            Log.debug("ver ", e);
        }
    }

    private CotizacionRPC test_GetListCotizacionRPC(ProductParameter parameter) {
        try {
            Stopwatch t = Stopwatch.createStarted();
            List<CotizacionRPC> cRPCs = ServicesResultsObjectCache.getListaCotizaciones(parameter);
            t.stop(); // optional
            t.elapsed(TimeUnit.MILLISECONDS);
            System.out.println("[test_GetListCotizacionRPC]; Total time; " + t);
            t.reset(); t.start();
            for (CotizacionRPC cRPC : cRPCs) {
                System.out.println("[test_GetListCotizacionRPC] cotizacion Cargada Original: " + cRPC.toString());
            }
            return !cRPCs.isEmpty() ? cRPCs.get(0): null;
        }catch (Exception e){
            Log.debug("ver ", e);
            System.out.println("[test_GetListCotizacionRPC] Error " + e.getMessage());
        }
        return null;
    }

    private void test_GetPropertyRPC_Dependencies(String propertyName, boolean fetchDependence, boolean fetchDependenceChilds, String level, int numeroTest) {
        try {
            PropertyParameter parameter = new PropertyParameter(0, propertyName, fetchDependence);
            Stopwatch stopwatch = Stopwatch.createStarted();
            PropertyValuesRPC rpc = Property_Callers.getPropertyValues(ACSELE, parameter);
            stopwatch.stop(); // optional
            stopwatch.elapsed(TimeUnit.MILLISECONDS);
            System.out.println("[test_GetPropertyRPC_Dependencies_" + numeroTest + "] property :" + rpc.getPropertyId() + "-" + rpc.getPropertyName() + "; CurrentLevel : " + level + ";" + (fetchDependence ? "CON" : "SIN") + " DependenciaDirecta ;" + (fetchDependenceChilds ? "CON" : "SIN") + " DependenciaEnChilds ; Total time; " + stopwatch);
            if(fetchDependence){
                for (TRDataRPC trDataRPC : rpc.getTrsArr()) {
                    TRDataRPC[] trsArrParent = trDataRPC.getTrsArrParent()!=null? trDataRPC.getTrsArrParent(): new TRDataRPC[0];
                    for (TRDataRPC dataRPC : trsArrParent) {
                        System.out.println("CurrentLevel : "+level+";PropChild: ".concat(rpc.getPropertyName()).concat(";TrChild: ").concat(trDataRPC.getInput()).
                                concat(";PropPadre: ").concat(rpc.getParentName()).concat(";TrParent: ").concat(dataRPC.getInput()));
                    }
                }
                String[] childs = rpc.getChilds() == null? new String[0] : rpc.getChilds();
                for (String propChilds : childs) {
                    test_GetPropertyRPC_Dependencies(propChilds, fetchDependenceChilds, false, "Child", numeroTest);
                }
            }
        } catch (ServiceBaseException e) {
            Log.debug("ver ", e);
        } catch (Exception e) {
            Log.debug("ver ", e);
        }

    }

    private void test_StressTestingGetProducts() {
        int numThread = 1;   // llamadas concurrentes
        //Stresstesting.stressTestingGetProducts(numThread);
        for(int i = 0; i < 100; i++ ) {
            Stresstesting.stressTestingGetProducts_2(numThread, i);
        }

    }

    private void test_GetProducts(boolean isShowObjectResult) throws Exception {
        try {
            Stopwatch t = Stopwatch.createStarted();
            List<ProductRPC> products = Product_Callers.getProducts(ACSELE);
            t.stop(); // optional
            t.elapsed(TimeUnit.MILLISECONDS);
            System.out.println("[test_GetProducts]; Total time; " + t);
            t.reset(); t.start();
            for (ProductRPC product : products) {
                test_GetProduct(product, isShowObjectResult);
                test_PlanesFinanciamiento(product, isShowObjectResult);
                test_Planes(product, isShowObjectResult);
                test_Coberturas(product, isShowObjectResult);
                test_PeriodosCoberturas(product, isShowObjectResult);
                test_Tarifas(product, isShowObjectResult);
                test_ExigenciasMedicas(product, isShowObjectResult);
                //if(product.getId()==49183)
                //System.out.println("[test_GetProducts] " + product.getName());
            }
            t.stop(); // optional
            t.elapsed(TimeUnit.MILLISECONDS);
            System.out.println("[test_GetProducts]; Total time; " + t);
        }catch (Exception e){
            Log.debug("ver ", e);
            System.out.println("[test_GetProducts] Error " + e.getMessage());
        }
    }

    private void test_GetProduct(ProductRPC product, boolean isShowObjectResult) {
        try {
            Stopwatch stopwatch = Stopwatch.createStarted();
            ProductRPC rpc = ServicesResultsObjectCache.getProduct(product.getId());
            stopwatch.stop(); // optional
            stopwatch.elapsed(TimeUnit.MILLISECONDS);
            System.out.println("[test_GetProduct]; Total time; " + stopwatch);
            if(isShowObjectResult) System.out.println("[test_GetProduct] "+rpc.toString());
        } catch (ServiceBaseException e) {
            Log.debug("ver ", e);
        }
    }

    private void test_Planes(ProductRPC product, boolean isShowObjectResult) {
        try {
            Stopwatch stopwatch = Stopwatch.createStarted();
            List<PlanRPC> list = ServicesResultsObjectCache.getPlanRPC(product.getId());
            stopwatch.stop(); // optional
            stopwatch.elapsed(TimeUnit.MILLISECONDS);
            System.out.println("[MyTestMethodCOT.test_Planes]; Total time; " + stopwatch);
            System.out.println("[MyTestMethodCOT.test_Planes]; list.size; " + list.size());
            if(isShowObjectResult) for (PlanRPC planRPC : list) System.out.println("[MyTestMethodCOT.test_Planes];"+planRPC.toString());
        } catch (ServiceBaseException e) {
            Log.debug("ver ", e);
        }

    }

    public static List<PlanFinanciamientoRPC> getPlanesFinanciamiento(long idProducto) {
        ProductParameter productParameter = new ProductParameter(idProducto);
        return Product_Callers.getPlanesFinanciamiento(ACSELE, productParameter);
    }

    private void test_PlanesFinanciamiento(ProductRPC product, boolean isShowObjectResult) {
        try {
            Stopwatch stopwatch = Stopwatch.createStarted();
            List<PlanFinanciamientoRPC> list = getPlanesFinanciamiento(product.getId());
            stopwatch.stop(); // optional
            stopwatch.elapsed(TimeUnit.MILLISECONDS);
            System.out.println("[test_PlanesFinanciamiento]; Total time; " + stopwatch);
            System.out.println("[test_PlanesFinanciamiento] " + list.size());
            if (isShowObjectResult) {
                for (PlanFinanciamientoRPC o : list) {
                    System.out.println("[test_PlanesFinanciamiento] " + o.toString());
                }
            }
        } catch (ServiceBaseException e) {
            Log.debug("ver ", e);
        }

    }

    private void test_Coberturas(ProductRPC product, boolean isShowObjectResult) {
        try {
            Stopwatch stopwatch = Stopwatch.createStarted();
            List<CoberturaRPC> list_ccv = ServicesResultsObjectCache.getListaCoberturas(product.getId());
            stopwatch.stop(); // optional
            stopwatch.elapsed(TimeUnit.MILLISECONDS);
            System.out.println("[test_Coberturas]; Total time; " + stopwatch);
            System.out.println("[test_Coberturas] list_ccv.size: " + list_ccv.size());
            if (isShowObjectResult) {
                for (CoberturaRPC o : list_ccv) {
                    System.out.println("[test_Coberturas] : " + o.toString());
                }
            }
        } catch (ServiceBaseException e) {
            Log.debug("ver ", e);
        }
    }

    private CotizacionRPC test_CalcularCotizacion(boolean isDirecta, long idProducto, double idGrupoFamiliar, long timeOut) {
        try {
            CotizacionParameter parameter = CreateCotizacion.createParameterFromMap(isDirecta, createMap());
            parameter.setTimeOutMax(timeOut);
            System.out.println("[test_CalcularCotizacion]; parametro de entrada:\n" + parameter.toString());
            Stopwatch t = Stopwatch.createStarted();
            CotizacionRPC cotizacionRPC = ServicesResultsObjectCache.calcularCotizacion(isDirecta, timeOut, parameter);
            t.stop(); // optional
            t.elapsed(TimeUnit.MILLISECONDS);
            System.out.println("***************************************");
            System.out.println("[test_CalcularCotizacion]; Calculo " + (isDirecta ? "Directo" : "Inverso") + " respuesta :\n" + cotizacionRPC.toString());
            System.out.println("[test_CalcularCotizacion]; Total time; " + t);
            System.out.println("***************************************");
            System.out.println("[test_CalcularCotizacion]; Termine ....");
            return cotizacionRPC;
        }catch (Exception e){
            Log.debug("ver ", e);
            return null;
        }
    }

    private CotizacionRPC test_CalcularCotizacion(boolean isDirecta, CotizacionRPC cotizacionRPCIn, long timeOut) {
        try {
            CotizacionParameter parameter = CreateCotizacion.createParameterFromCotizacion(isDirecta, cotizacionRPCIn, timeOut);
            System.out.println("[test_CalcularCotizacion]; parametro de entrada:\n" + parameter.toString());
            Stopwatch t = Stopwatch.createStarted();
            CotizacionRPC cotizacionRPC = ServicesResultsObjectCache.calcularCotizacion(isDirecta, timeOut, parameter);
            t.stop(); // optional
            t.elapsed(TimeUnit.MILLISECONDS);
            System.out.println("***************************************");
            System.out.println("[test_CalcularCotizacion]; Calculo " + (isDirecta ? "Directo" : "Inverso") + " respuesta :\n" + cotizacionRPC.toString());
            System.out.println("[test_CalcularCotizacion]; Total time; " + t);
            System.out.println("***************************************");
            System.out.println("[test_CalcularCotizacion]; Termine ....");
            return cotizacionRPC;
        }catch (Exception e){
            Log.debug("ver ", e);
            return null;
        }
    }

    private void test_CalcularTVG(CotizacionRPC cRPC, Long timeOut) {
        try {
            TVGParameter parameter = new TVGParameter(cRPC.getIdPoliza(), cRPC.getIdOperation(), timeOut);
            System.out.println("[test_CalcularTVG]; parametro de entrada:\n" + parameter.toString());
            Stopwatch t = Stopwatch.createStarted();
            final TablaValorGarantizadoRPC tvg = Quotation_Callers.calcularTVG(ACSELE, parameter);
            t.stop(); // optional
            t.elapsed(TimeUnit.MILLISECONDS);
            System.out.println("***************************************");
            System.out.println("[test_CalcularTVG]; Calculo respuesta :\n" + tvg.toString());
            System.out.println("[test_CalcularTVG]; Total time; " + t);
            System.out.println("***************************************");
            System.out.println("[test_CalcularTVG]; Termine ....");
        }catch (Exception e){
            Log.debug("ver ", e);
        }
    }

    public static Map<String, String> createMap() {
        Map<String, String> mapa = new HashMap<String, String>();
        /*long idProducto = */
        mapa.put("idProducto", "49183");
        mapa.put("idUnidadRiesgoType", "49838668");
        mapa.put("idPlan", "48161");             // Id de Plan
        mapa.put("idPlanVida", "602");   // Id de PlanVida
        mapa.put("idTipoDescuento", "0");             // Id o valor Tipo de Descuento
        mapa.put("idPeriodoCobertura", "168"); // Id o valor Periodo de Cobertura   ESTA expresado en meses
        mapa.put("idPeriodoDePago", "47341");   // valor del Periodo de Pago
        mapa.put("idMoneda", "2123");           // Id de la Moneda de ese Cotizacion
        mapa.put("idPeriodoPagoPrima", "10"); // Id o valor periodo Pago Prima [Esta expresada en a#os]
        mapa.put("idPeriodoPagoBeneficio", "1");    // Id o valor periodo Pago Beneficio
        mapa.put("idGrupoFamiliar", "0");
        mapa.put("ano","2016");
        mapa.put("mes","7");
        mapa.put("dia","01");
        return mapa;

    }

    public static Map<String, String> createMapFromJSON(String filePath) {
        Map<String, String> mapa = new HashMap<String, String>();
        /*long idProducto = */
        mapa.put("idProducto", "49183");
        mapa.put("idPlan", "48161");             // Id de Plan
        mapa.put("idPlanVida", "602");   // Id de PlanVida
        mapa.put("idTipoDescuento", "0");             // Id o valor Tipo de Descuento
        mapa.put("idPeriodoCobertura", "168"); // Id o valor Periodo de Cobertura   ESTA expresado en meses
        mapa.put("idPeriodoDePago", "47341");   // valor del Periodo de Pago
        mapa.put("idMoneda", "2123");           // Id de la Moneda de ese Cotizacion
        mapa.put("idPeriodoPagoPrima", "10"); // Id o valor periodo Pago Prima [Esta expresada en a#os]
        mapa.put("idPeriodoPagoBeneficio", "1");    // Id o valor periodo Pago Beneficio
        mapa.put("idGrupoFamiliar", "0");
        mapa.put("ano","2016");
        mapa.put("mes","6");
        mapa.put("dia","13");
        return mapa;

    }

    private void test_CumulusTercero() {
        try {
            long[] lista = new long[]{5811041,5802969,5803002,5803007,5803025,5803034,5802966,5802970,5802985,5802988,5802992,5802994,5803001,5803003,5803005,5803016,5803023,5802964,5802981,5803017,5803027,5803039,5803040,5803041,5803043,5197426,5871655,5839325,5867610,5843375,5855698,5871651,5855696,5855694,5871657,5855484,5843371,5871652,5883762,5827203,5843367,5871650,5843364,5839324,5871843,5839323,5843373,5847404,5855685,5859524,5855687,5843361,5843377,5867614,5855683,5855684,5823364,5843379,5871656};
            Stopwatch t = Stopwatch.createStarted();
            //long idTercero = 0; /*long idProducto = 0; long idMoneda=0;*/
            for (long idTercero : lista) {
                CumulusTerceroRPC ctRPC = Quotation_Callers.getCumulusTercero(ACSELE, new CumulusTerceroParameter(idTercero));
                t.stop(); // optional
                t.elapsed(TimeUnit.MILLISECONDS);
                System.out.println("***************************************");
                System.out.println("[test_CumulusTercero]; " + ctRPC.toString());
                System.out.println("[test_CumulusTercero]; Total time; " + t);
                System.out.println("***************************************");
                t.reset(); t.start();
            }
            System.out.println("Termine ....");
        }catch (Exception e){
            Log.debug("ver ", e);
        }
    }

    private void test_EdadActuarial() {
        try {
            final Random randomGenerator = new Random();
            int anInt_ano = randomGenerator.nextInt(100);
            int anInt_mes = randomGenerator.nextInt(12);
            Calendar birthDate = Calendar.getInstance();
            birthDate.set(1900+anInt_ano, anInt_mes/*Calendar.JANUARY*/, 01);
            final ActuarialAgeParameter parameter = new ActuarialAgeParameter(Calendar.getInstance().getTime(), birthDate.getTime());
            System.out.println("[test_EdadActuarial]; parametro enviado; " + parameter);
            Stopwatch t = Stopwatch.createStarted();
            int edad = ServicesResultsObjectCache.getEdadActuarial(parameter);
            t.stop(); // optional
            t.elapsed(TimeUnit.MILLISECONDS);
            System.out.println("[test_EdadActuarial]; edad; " + edad);
            System.out.println("[test_EdadActuarial]; Total time; " + t);
            t.reset(); t.start();
        }catch (Exception e){
            Log.debug("ver ", e);
        }
    }

    private void test_ExigenciasMedicas(ProductRPC product, boolean isShowObjectResult) {
        Calendar instance = Calendar.getInstance();
        instance.set(1990, Calendar.JANUARY, 1);
        ExigenciasMedicaParameter exiParameter = new ExigenciasMedicaParameter(product.getId(), instance.getTime());
        Stopwatch stopwatch = Stopwatch.createStarted();
        ExigenciasMedicaRPC exigRPC = Product_Callers.getExigenciasMedicas(ACSELE, exiParameter);
        stopwatch.stop(); // optional
        stopwatch.elapsed(TimeUnit.MILLISECONDS);
        System.out.println("[test_ExigenciasMedicas]; Total time; " + stopwatch);
        System.out.println("[test_ExigenciasMedicas]; exigRPC.getRenglonList().size(); " + exigRPC.getRenglonList().size());
        //System.out.println("idProducto: "+product.getId()+"; Producto:"+product.getName()+"; Exigencias size: "+exigRPC.getRenglonList().size());
        if(isShowObjectResult) System.out.println("[test_ExigenciasMedicas]; " + exigRPC.toString());
    }

    private void test_Tarifas(ProductRPC product, boolean isShowObjectResult) {
        Calendar instance = Calendar.getInstance();
        instance.set(1995, Calendar.JANUARY, 1);
        TarifaParameter tarifaParameter = new TarifaParameter(product.getId());
        Stopwatch stopwatch = Stopwatch.createStarted();
        List<TarifaRPC> list = Product_Callers.getTarifas(ACSELE, tarifaParameter);
        stopwatch.stop(); // optional
        stopwatch.elapsed(TimeUnit.MILLISECONDS);
        System.out.println("[test_Tarifas]; Total time; " + stopwatch);
        System.out.println("[test_Tarifas];idProducto: "+product.getId()+"; Producto:"+product.getName()+"; Tarifas size: "+list.size());
        if (isShowObjectResult) {
            for (TarifaRPC t : list) {
                System.out.println("[test_Planes]; " + t.toString());
                //System.out.println("RenglonesTarifa size: "+t.getRenglonList().size());
            }
        }
    }

    private void test_PeriodosCoberturas(ProductRPC product, boolean isShowObjectResult) {
        ProductParameter productParameter = new ProductParameter(product.getId());
        Stopwatch stopwatch = Stopwatch.createStarted();
        List<VigenciaRPC> list = Product_Callers.getPeriodosCoberturas(ACSELE, productParameter);
        stopwatch.stop(); // optional
        stopwatch.elapsed(TimeUnit.MILLISECONDS);
        System.out.println("[test_PeriodosCoberturas]; Total time; " + stopwatch);
        System.out.println("[test_PeriodosCoberturas] "+list.size());
        if (isShowObjectResult) {
            for (VigenciaRPC o : list) {
                System.out.println("[test_Planes] :" + o.toString());
            }
        }
    }

    private void test_ServicesFactoryProccesor() throws Exception {
        try {
            for (CallerRegister register : ServicesFactory_Callers.fetchCallerRegistersFromServer(ACSELE)) {
                Log.debug("******** CallerRegister :    ****************\n".concat(register.toString()));
            }
            for (ProcessorRegister register : ServicesFactory_Callers.fetchProcessorRegistersFromServer(ACSELE)) {
                Log.debug("******** ProcessorRegister : ****************\n".concat(register.toString()));
            }
        } catch (Exception e) {
            System.out.println("Error : " + e.getMessage());
        }
    }

    private void test_StressTestingCalcularCotizacion() {
        int numThread = 10;   // llamadas concurrentes
        for(int i = 0; i < 1; i++ ) {
            Stresstesting.stressTestingCalcularCotizacion(numThread, i);
        }
    }
    private void test_StressTestingGetEdadActuarial() {
        int numThread = 50;   // llamadas concurrentes x prueba
        int numeroPruebasConcurrentes = 1;  // Pruebas serializadas de Concurrentes
        for(int i = 0; i < numeroPruebasConcurrentes; i++ ) {
            Stresstesting.stressTestingGetEdadActuarial(numThread, i);
        }
    }


    private void conjuntoPruebasCotizacion() {
        final Long timeOut = new Long(60000 * 3);
        long idProducto = 81099;    // Temporal
        final ProductParameter parameter = new ProductParameter(idProducto);
        parameter.setTimeOutMax(13389493L);  // Lo voy a setear al id de la poliza Base para mis pruebas
        CotizacionRPC cotizacionRPC = test_GetListCotizacionRPC(parameter);
        CreateCotizacion.cleanOutFields(cotizacionRPC, false);  // Limpiamos la original
        // Realizamos el calculo directo
        CotizacionRPC cRPC_directo = test_CalcularCotizacion(true, cotizacionRPC, timeOut);
        double montoTotalPrimaFP_Inicial = cRPC_directo.getMontoTotalPrimaFP();    // sacamos la prima inicial de la poliza
        double porcentajeCambio = -25; // porcentaje de cambio a la prima [ si positivo es el 100 + este, si es negativo se le resta ese porcentaje a la prima original ]
        double nuevaprimaInv = redondearDosDecimales(porcentajeCambio >= 0 ? ((100+porcentajeCambio)*montoTotalPrimaFP_Inicial)/100 : (montoTotalPrimaFP_Inicial - ((-1*porcentajeCambio*montoTotalPrimaFP_Inicial)/100)));
        CreateCotizacion.cleanOutFields(cRPC_directo, false); // Limpiamos las salidas
        cRPC_directo.setMontoTotalPrimaFP(nuevaprimaInv);   // Seteamos la prima Inversa Deseada
        // Realizamos el calculo inverso
        CotizacionRPC cRPC_inverso = test_CalcularCotizacion(false, cRPC_directo, timeOut);
        final List<ObjetoAsegCotizaRPC> iosCot = cRPC_inverso.getIosCot();
        // Faltaria probar el recalculo OJOOOOOOOOO


    }

    private double redondearDosDecimales(double v) {
        BigDecimal bd = new BigDecimal(v);
        bd = bd.setScale(2, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }

}
