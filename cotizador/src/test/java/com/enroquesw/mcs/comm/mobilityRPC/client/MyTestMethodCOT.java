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
import com.enroquesw.mcs.comm.mobilityRPC.util.FileUtil;
import com.enroquesw.mcs.comm.mobilityRPC.util.testRunner.MyTestRunnerCOT;
import com.enroquesw.mcs.comm.mobilityRPC.util.testRunner.interfaces.TestRunnerJC;
import com.esotericsoftware.minlog.Log;
import com.google.common.base.Stopwatch;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DateFormat;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

import static com.enroquesw.mcs.comm.mobilityRPC.enums.SystemName.ACSELE;

/**
 * Mi Metodo de Prueba
 */
public class MyTestMethodCOT extends TestRunnerJC{
    public static AtomicInteger countExec = new AtomicInteger(0);
    public static final String sep = "***************************************\n";
    public static final DateFormat dateTimeInstance = DateFormat.getDateTimeInstance(DateFormat.SHORT, DateFormat.SHORT, new Locale("es", "es"));

    /*public final static String PATH_TEST_JSON = "D:\\Git_Repo\\ServiciosWebInter\\PruebasJSONs_Cotizaciones";*/
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
        System.out.println("[testMain] Inicia ............................... ");
        Stopwatch stopwatch = Stopwatch.createStarted();
        test_StressTestingGetProduct();
        /*** Pruebas de Cotizacion *************************************************************************/
        /*final ProductRPC p = ServicesResultsObjectCache.getProduct(49184);
        conjuntoPruebasCotizacion(p, new Long(60000 * 3), false);*/
        /****************************************************************************/
        /*for (ProductRPC p : ServicesResultsObjectCache.getListaProductos()) {
            conjuntoPruebasCotizacion(p, new Long(60000 * 3));
        }*/
        stopwatch.stop(); // optional
        stopwatch.elapsed(TimeUnit.MILLISECONDS);
        System.out.println("[testMain] Total time; " + stopwatch);
        System.out.println("[testMain] Termine ............................... ");
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
            System.out.println("[test_GetEdadProducto] " + rpc.toString());
        } catch (ServiceBaseException e) {
            Log.debug("ver ", e);
        }
    }

    private CotizacionRPC test_GetListCotizacionRPC(ProductParameter parameter, String productName) {
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
                //System.out.println("[test_GetListCotizacionRPC] cotizacion Cargada Original: " + cRPC.toString());
                String y1 = "[test_GetListCotizacionRPC] cotizacion Cargada Original: \n" + FileUtil.gson.toJson(cRPC);
                y0.append(y1+"\n");
                System.out.println(y1);
            }
            FileUtil.writeJSONLogByProduct(productName, sep + x0 + "\n" + y0.toString() + x1 + "\n" + sep);
            return !cRPCs.isEmpty() ? cRPCs.get(0): null;
        }catch (Exception e){
            Log.debug("ver ", e);
            String x = "[test_GetListCotizacionRPC] Error " + e.getMessage();
            System.out.println(x);
            FileUtil.writeJSONLogByProduct(productName, x + "\n" + sep);
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

    private void test_StressTestingGetProduct() {
        System.out.println("[test_StressTestingGetProduct] INICIO ********************\n");
        int numThread = 2;   // Hilos por producto
        List<ProductRPC> productRPCList = ServicesResultsObjectCache.getListaProductos();
        Stresstesting.stressTestingGetProduct(numThread, 1, productRPCList);
        System.out.println("[test_StressTestingGetProduct] FINALIZO ********************\n");
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
            t.reset(); t.start(); int i = 0;
            for (ProductRPC product : products) {
                /*test_GetProduct(product, isShowObjectResult);
                test_PlanesFinanciamiento(product, isShowObjectResult);
                test_Planes(product, isShowObjectResult);
                test_Coberturas(product, isShowObjectResult);
                test_PeriodosCoberturas(product, isShowObjectResult);*/
                //test_ExigenciasMedicas(product, isShowObjectResult);
                //if(product.getId()==49183)
                //System.out.println("[test_GetProducts] " + product.getName());
                System.out.println((i++) + "\n" + FileUtil.gson.toJson(product));
                //test_ExigenciasMedicas(product, isShowObjectResult);
                test_Tarifas(product, isShowObjectResult);
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
                    System.out.println("[test_Coberturas] : \n" + FileUtil.gson.toJson(o));
                }
            }
        } catch (ServiceBaseException e) {
            Log.debug("ver ", e);
        }
    }

    private CotizacionRPC test_CalcularCotizacion(boolean isDirecta, long idProducto, double idGrupoFamiliar, long timeOut, String productName) {
        try {
            CotizacionParameter parameter = CreateCotizacion.createParameterFromMap(isDirecta, createMap());
            parameter.setTimeOutMax(timeOut);
            System.out.println("[test_CalcularCotizacion]; parametro de entrada:\n" + parameter.toString());
            Stopwatch t = Stopwatch.createStarted();
            StringBuffer requestIdOut = new StringBuffer();
            CotizacionRPC cotizacionRPC = ServicesResultsObjectCache.calcularCotizacion(isDirecta, timeOut, parameter, requestIdOut);
            t.stop(); // optional
            t.elapsed(TimeUnit.MILLISECONDS);
            System.out.println("***************************************");
            System.out.println("[test_CalcularCotizacion]; resquestId: "+requestIdOut.toString()+"\nCalculo " + (isDirecta ? "Directo" : "Inverso") + " respuesta :\n" + cotizacionRPC.toString());
            System.out.println("[test_CalcularCotizacion]; Total time; " + t);
            System.out.println("***************************************");
            System.out.println("[test_CalcularCotizacion]; Termine ....");
            return cotizacionRPC;
        }catch (Exception e){
            Log.debug("ver ", e);
            return null;
        }
    }

    private CotizacionRPC test_CalcularCotizacion(boolean isDirecta, CotizacionRPC cotizacionRPCIn, long timeOut, String productName) {
        try {
            long idPoliza = cotizacionRPCIn.getIdPoliza();
            String x = "[test_CalcularCotizacion] Inicio Calculo "+(isDirecta ? (idPoliza != 0 ? "RE_COTIZACION" : "DIRECTO") : "inverso") + "*************************************************\n";
            CotizacionParameter parameter = CreateCotizacion.createParameterFromCotizacion(isDirecta, cotizacionRPCIn, timeOut);
            String x0 = "[test_CalcularCotizacion]; parametro de entrada:\n" + FileUtil.gson.toJson(parameter);
            System.out.println(x0);
            Stopwatch t = Stopwatch.createStarted();
            StringBuffer requestIdOut = new StringBuffer();
            CotizacionRPC cotizacionRPC = ServicesResultsObjectCache.calcularCotizacion(isDirecta, timeOut, parameter, requestIdOut);
            t.stop(); // optional
            t.elapsed(TimeUnit.MILLISECONDS);
            System.out.println(sep);
            String x1 = "[test_CalcularCotizacion]; resquestId: "+requestIdOut.toString()+"\nCalculo " + (isDirecta ? (idPoliza != 0 ? "Recotizar" : "Directo") : "Inverso") + " respuesta :\n" + FileUtil.gson.toJson(cotizacionRPC);
            System.out.println(x1);
            String x2 = "[test_CalcularCotizacion]; Total time; " + t;
            System.out.println(x2);
            System.out.println(sep);
            System.out.println("[test_CalcularCotizacion]; Termine ...."+requestIdOut.toString());
            FileUtil.writeJSONLogByProduct(productName, x + sep + x0 + "\n" + sep + x1 + "\n" + x2 + "\n" + "[test_CalcularCotizacion]; Termine ....\n" + sep);
            return cotizacionRPC;
        }catch (Exception e){
            Log.debug("ver ", e);
            FileUtil.writeJSONLogByProduct(productName, "[test_CalcularCotizacion]; Error " + e.getMessage() + "\n" + sep);
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
        if(isShowObjectResult) System.out.println("[test_ExigenciasMedicas]; " + FileUtil.gson.toJson(exigRPC));
    }

    private void test_Tarifas(ProductRPC product, boolean isShowObjectResult) {
        //Calendar instance = Calendar.getInstance();
        //instance.set(1995, Calendar.JANUARY, 1);
        try {
            TarifaParameter parameter = new TarifaParameter(product.getId());
            parameter.setTimeOutMax(4*120000L);
            Stopwatch stopwatch = Stopwatch.createStarted();
            List<TarifaRPC> list = Product_Callers.getTarifas(ACSELE, parameter);
            stopwatch.stop(); // optional
            stopwatch.elapsed(TimeUnit.MILLISECONDS);
            System.out.println("[test_Tarifas]; Total time; " + stopwatch);
            //System.out.println("[test_Tarifas];idProducto: "+product.getId()+"; Producto:"+product.getName()+"; Tarifas size: "+list.size());
            if (isShowObjectResult) {
                for (TarifaRPC t : list) {
                    System.out.println("[test_Planes]; " + FileUtil.gson.toJson(t)/*t.toString()*/);
                    //System.out.println("RenglonesTarifa size: "+t.getRenglonList().size());
                }
            }
        } catch (ServiceBaseException e) {
            Log.debug("[test_Tarifas] ERROR:\n", e);

        }
    }
    private void test_Tarifas_By_Cov_PlanVida(ProductRPC product, boolean isShowObjectResult) {
        List<CoberturaRPC> list_ccv = ServicesResultsObjectCache.getListaCoberturas(product.getId());
        final List<TRDataRPC> planVida = ServicesResultsObjectCache.getCachedPlanesVida(product.getId());
        for (CoberturaRPC coberturaRPC : list_ccv) {
            String msgProdCov = "productoId : "+product.getId()+";productoName: "+product.getName()+"; ccvId : "+coberturaRPC.getId() +"; ccvName : "+coberturaRPC.getName();
            for (TRDataRPC trDataRPC : planVida) {
                System.out.println("[test_Tarifas_By_Cov_PlanVida] Extraer Tarifas para ; "+msgProdCov+"; PlanVida: "+trDataRPC.getInput()+"; planVidaId: "+trDataRPC.getValue());
                test_Tarifas(product.getId(), (long) trDataRPC.getValue(), coberturaRPC.getId(), isShowObjectResult);
            }
        }
    }

    private void test_Tarifas(long productId, long idPlanVida, long ccvId, boolean isShowObjectResult) {
        try {
            TarifaParameter parameter = new TarifaParameter(productId, idPlanVida, ccvId);
            parameter.setTimeOutMax(4*120000L);
            Stopwatch stopwatch = Stopwatch.createStarted();
            List<TarifaRPC> list = Product_Callers.getTarifas(ACSELE, parameter);
            stopwatch.stop(); // optional
            stopwatch.elapsed(TimeUnit.MILLISECONDS);
            System.out.println("[test_Tarifas]; Total time; " + stopwatch);
            System.out.println("[test_Tarifas]; Tarifas size: "+list.size());
            if (isShowObjectResult) {
                for (TarifaRPC t : list) {
                    System.out.println("[test_Planes]; " + FileUtil.gson.toJson(t)/*t.toString()*/);

                }
            }
        } catch (ServiceBaseException e) {
            Log.debug("[test_Tarifas] ERROR:\n", e);
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


    private void conjuntoPruebasCotizacion(ProductRPC productRPC, final Long timeOut, boolean overWriteLog) {
        FileUtil.writeJSONLogByProduct(productRPC.getName(), dateTimeInstance.format(new Date())+"; [conjuntoPruebasCotizacion] INICIO...  producto: "+productRPC.getName()+"\n", overWriteLog);
        try {
            /*********************** CARGAMOS DATOS DE COTIZACION BASE O REFERENCIA ***************************************/
            CotizacionRPC cotRPCBase = cargarCotizacionBase(productRPC);
            if(cotRPCBase == null){ FileUtil.writeJSONLogByProduct(productRPC.getName(), "[conjuntoPruebasCotizacion] cotRPCBase ES NULO \n"); return;}
            /************************** CALCULO aplica_[DIRECTO]/sobreUltimoApp_[]     "1 EVENTO - cotizarvida"  ***********************/
            CotizacionRPC cotRPCDirecto = executeCalculoDirecto(productRPC, timeOut, cotRPCBase);
            if(cotRPCDirecto.getIdPoliza() == 0){ FileUtil.writeJSONLogByProduct(productRPC.getName(), "[conjuntoPruebasCotizacion] cotRPCDirecto ERROR en Calculo Directo \n"); return;}
            /************************** CALCULO aplica_[DIRECTO]/sobreUltimo_[DIRECTO]  "1 EVENTO - ReCotizar" ***********************/
            //CotizacionRPC cRPC_Recalculo = executeReCalculoDirecto(productRPC, timeOut, cotRPCDirecto);
            //cRPC_Recalculo.getIdPoliza();
            /************************** CALCULO aplica_[INVERSO]/sobreUltimo_[DIRECTO]  "1 EVENTO - CotizarInv" ***********************/
            CotizacionRPC cRPC_inverso = executeCalculosInversos(productRPC, timeOut, cotRPCBase);
            if(cRPC_inverso != null) cRPC_inverso.getIdPoliza();
            /************************** CALCULO aplica_[DIRECTO]/sobreUltimo_[INVERSO]   "1 EVENTO - ReCotizar" ***********************/
            /********** RECALCULAR DIRECTO/INVERSO - SOBRE UNA COTIZACION ultima operacion Cotizacion Inversa  ************/
            // FIXME_JULIO: Implementar
            /************************** CALCULO aplica_[INVERSO]/sobreUltimo_[INVERSO]   "1 EVENTO - CotizarInv" ***********************/
            /********** RECALCULAR INVERSO/INVERSO - SOBRE UNA COTIZACION ultima operacion Cotizacion Inversa  ************/
            // FIXME_JULIO: Implementar
        } finally {
            FileUtil.writeJSONLogByProduct(productRPC.getName(), dateTimeInstance.format(new Date())+"; [conjuntoPruebasCotizacion] FINALIZO... producto: "+productRPC.getName()+"\n"+sep+sep+sep+sep);
        }
    }

    private CotizacionRPC executeCalculoDirecto(ProductRPC productRPC, long timeOut, CotizacionRPC cotRPCBase) {
        CotizacionRPC cotRPCDirecto = ServicesResultsObjectCache.cloneCotizacionRPC(cotRPCBase);        // Clonamos el cotBase
        CreateCotizacion.cleanOutFields(cotRPCDirecto, false, true);                                    // Limpiamos El clone
        cotRPCDirecto = test_CalcularCotizacion(true, cotRPCDirecto, timeOut, productRPC.getName());    // Realizamos el calculo directo
        return cotRPCDirecto;
    }

    private CotizacionRPC executeReCalculoDirecto(ProductRPC productRPC, long timeOut, CotizacionRPC cotRPCDirecto) {
        CotizacionRPC cRPC_Recalculo = ServicesResultsObjectCache.cloneCotizacionRPC(cotRPCDirecto);
        CreateCotizacion.cleanOutFields(cRPC_Recalculo, false, false);  // Limpiamos al clon
        cRPC_Recalculo.setMontoTotalPrimaFP(0.0);
        cRPC_Recalculo = test_CalcularCotizacion(true, cRPC_Recalculo, timeOut, productRPC.getName());
        cRPC_Recalculo.getIdPoliza();
        return cRPC_Recalculo;
    }

    private CotizacionRPC executeCalculosInversos(ProductRPC productRPC, long timeOut, CotizacionRPC cotRPCBase ) {
        if(productRPC.getDataDynamic().containsKey("IndCapital") && "CapitalTABLA".equalsIgnoreCase(productRPC.getDataDynamic().get("IndCapital").getInput())){
            FileUtil.writeJSONLogByProduct(productRPC.getName(), "[conjuntoPruebasCotizacion] Para el producto "+productRPC.getName()+" no aplica el evento  'CotizarInverso'\n"); return null;
        }
        CotizacionRPC cotRPCDirectoToInver = ServicesResultsObjectCache.cloneCotizacionRPC(cotRPCBase);     // Clonamos el cotBase
        CreateCotizacion.cleanOutFields(cotRPCDirectoToInver, false, true);                                 // Limpiamos El clone
        cotRPCDirectoToInver = test_CalcularCotizacion(true, cotRPCDirectoToInver, timeOut, productRPC.getName());     // Realizamos el calculo directo
        if(cotRPCDirectoToInver.getIdPoliza() == 0){ FileUtil.writeJSONLogByProduct(productRPC.getName(), "[conjuntoPruebasCotizacion] cotRPCDirectoToInver ERROR en Calculo Directo \n"); return null;}
        double montoTotalPrimaFP_Inicial = cotRPCDirectoToInver.getMontoTotalPrimaFP();     // sacamos la prima inicial de la poliza
        double porcentajeCambio = -25;                                                      // porcentaje de cambio a la prima [ si positivo es el 100 + este, si es negativo se le resta ese porcentaje a la prima original ]
        double nuevaprimaInv = redondearDosDecimales(porcentajeCambio >= 0 ? ((100 + porcentajeCambio) * montoTotalPrimaFP_Inicial) / 100 : (montoTotalPrimaFP_Inicial - ((-1*porcentajeCambio*montoTotalPrimaFP_Inicial)/100)));
        FileUtil.writeJSONLogByProduct(productRPC.getName(), "[executeCalculosInversos] Valor Nuevo Para inversaMontoTotalPrimaFP :"+nuevaprimaInv+"\n");
        CotizacionRPC cRPC_inverso = ServicesResultsObjectCache.cloneCotizacionRPC(cotRPCDirectoToInver);   // Clonamos a la Cotizacion Directa
        CreateCotizacion.cleanOutFields(cRPC_inverso, false, false);    // Limpiamos las salidas FIXME_JULIO: verificar si cambia el motoAsegurado en las coberturas
        cRPC_inverso.setMontoTotalPrimaFP(nuevaprimaInv);               // Seteamos la prima Inversa Deseada
        cRPC_inverso = test_CalcularCotizacion(false, cRPC_inverso, timeOut, productRPC.getName()); // Realizamos el calculo inverso
        cRPC_inverso.getIdPoliza();
        return cRPC_inverso;
    }

    private CotizacionRPC cargarCotizacionBase(ProductRPC productRPC) {
        BaseData baseDataPolicyId = FileUtil.getJSONBaseDataFromFile(productRPC.getName());                     // cargamos los datos de la Poliza Base desde un archivo
        CotizacionRPC cotRPCBase = FileUtil.getJSONFromFileByPolId(baseDataPolicyId, productRPC.getName());     // SI EXISTE EL ARCHIVO --> Cargamos la cotizacion base desde archivo ,
        if(cotRPCBase == null){
            ProductParameter parameter = new ProductParameter(baseDataPolicyId.idProducto);
            parameter.setTimeOutMax(baseDataPolicyId.idPoliza);                         // Lo voy a setear al id de la poliza Base para mis pruebas
            cotRPCBase = test_GetListCotizacionRPC(parameter, productRPC.getName());    // Cargamos la cotizacion desde El Servicio de Acsele
            if(cotRPCBase != null) FileUtil.writeJSONByPolIdToFile(productRPC.getName() , cotRPCBase);
        }
        FileUtil.writeJSONLogByProduct(productRPC.getName(),sep+"[cargarCotizacionBase]; Cotizacion Base:\n" + FileUtil.gson.toJson(cotRPCBase)+sep);
        return cotRPCBase;
    }

    private double redondearDosDecimales(double v) {
        BigDecimal bd = new BigDecimal(v);
        bd = bd.setScale(2, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }















}
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


/******************* Respaldo del main hasta el domingo 28/08/2016
 public void testMain() throws Exception {
 //test_ServicesFactoryProccesor();
 //test_GetProducts();
 //test_boomerang();
 Stopwatch stopwatch = Stopwatch.createStarted();
 //test_Coberturas(ServicesResultsObjectCache.getProduct(77059L), true);
 /*******   Prueba de Tarifas
 for (ProductRPC productRPC : ServicesResultsObjectCache.getListaProductos()) {
 test_Tarifas_By_Cov_PlanVida(productRPC, true);
 }*/
    //test_Otra_Cosa();
    //test_StressTestingCalcularCotizacion();
    /****************************************************************************/
        /* Calcular Cotizacion de Mapa de Datos OJO NO USAR DEPRECADO
        final Long timeOut = new Long(60000 * 3);
        long idProduct = 49183;
        final CotizacionRPC cRPC = test_CalcularCotizacion(true, 49183, 0, timeOut); // desde mapa */
    //test_CalcularTVG(cRPC, timeOut*2);  // probar despues null*/
    //test_GetEdadProducto(49183);
    //test_StressTestingGetProducts();
/*** Pruebas de Cotizacion *************************************************************************/
        /*final ProductRPC p = ServicesResultsObjectCache.getProduct(49184);
        conjuntoPruebasCotizacion(p, new Long(60000 * 3), false);*/
/****************************************************************************/
        /*for (ProductRPC p : ServicesResultsObjectCache.getListaProductos()) {
            conjuntoPruebasCotizacion(p, new Long(60000 * 3));
        }*/
/****************************************************************************/
        /*final ProductRPC p = ServicesResultsObjectCache.getProduct(49183);
        System.out.println(p.toString());*/

//double idGrupoFamiliar = 0;             // Id o valor Grupo Familiar            -- Propiedad "GrupoFamiliar"  [0, 1, 2, 3, 4] [NINGUNO, Titular; Titular y C�nyuge; Titular, C�nyuge e Hijo(s); Titular e Hijo(s)]
/*************************************************************************/
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
/*stopwatch.stop(); // optional
        stopwatch.elapsed(TimeUnit.MILLISECONDS);
        System.out.println("[testMain] Total time; " + stopwatch);
        System.out.println("Termine ............................... ");
        //log.log(Level.INFO, "Parate Aqui");
        }*/
