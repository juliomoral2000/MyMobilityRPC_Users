package com.enroquesw.mcs.comm.mobilityRPC.client;

import com.consisint.acsele.interseguro.interfaces.mobilityRPC.services.beans.*;
import com.consisint.acsele.interseguro.interfaces.mobilityRPC.services.client.caller.Product_Callers;
import com.consisint.acsele.interseguro.interfaces.mobilityRPC.services.client.caller.Property_Callers;
import com.consisint.acsele.interseguro.interfaces.mobilityRPC.services.client.caller.Quotation_Callers;
import com.consisint.acsele.interseguro.interfaces.mobilityRPC.services.params.*;
import com.enroquesw.mcs.comm.mobilityRPC.enums.SystemName;
import com.enroquesw.mcs.comm.mobilityRPC.services.exception.ServiceBaseException;
import com.enroquesw.mcs.comm.mobilityRPC.services.factory.CallerRegister;
import com.enroquesw.mcs.comm.mobilityRPC.services.factory.ProcessorRegister;
import com.enroquesw.mcs.comm.mobilityRPC.services.impl.caller.ServicesFactory_Callers;
import com.enroquesw.mcs.comm.mobilityRPC.util.testRunner.interfaces.TestRunnerJC;
import com.esotericsoftware.minlog.Log;
import com.google.common.base.Stopwatch;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Mi Metodo de Prueba
 */
public class MyTestMethod extends TestRunnerJC{
    @Override
    public void run() {
        try {
            if(!Log.DEBUG) Log.DEBUG = true;
            testMain();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void testMain() throws Exception {
        //test_ServicesFactoryProccesor();
        //test_GetProducts();
        //test_boomerang();
        Stopwatch stopwatch = Stopwatch.createStarted();
        //test_ServicesFactoryProccesor();

        //test_StressTestingGetProducts();
        test_GetProducts();
        //int i = 1;
        /*************************************************************************/
        /*test_GetPropertyRPC_Dependencies("CodDepartamento", false, false, "Parent", i++);
        test_GetPropertyRPC_Dependencies("CodDepartamento", true, false, "Parent", i++);
        test_GetPropertyRPC_Dependencies("CodDepartamento", true, true, "Parent", i++);*/
        /*************************************************************************/

        /*test_GetPropertyRPC_Dependencies("CodProvincia", false, false, "Parent", i++);
        test_GetPropertyRPC_Dependencies("CodProvincia", true, false, "Parent", i++);
        test_GetPropertyRPC_Dependencies("CodProvincia", true, true, "Parent", i++);*/
        /*************************************************************************/
        /*test_GetPropertyRPC_Dependencies("CodDistrito", false, false, "Parent", i++);
        test_GetPropertyRPC_Dependencies("CodDistrito", true, false, "Parent", i++);
        test_GetPropertyRPC_Dependencies("CodDistrito", true, true, "Parent", i++);*/
        /*************************************************************************/
        //test_EdadActuarial();
        /*************************************************************************/
        /*************************************************************************/
        //test_CumulusTercero();
        /*************************************************************************/
        //test_GetPropertyRPC_Dependencies("SexoAseg", false, false, "Parent", 0);
        /*************************************************************************/
        stopwatch.stop(); // optional
        stopwatch.elapsed(TimeUnit.MILLISECONDS);
        System.out.println("[testMain] Total time; " + stopwatch);
        //log.log(Level.INFO, "Parate Aqui");
    }

    private void test_CumulusTercero() {
        try {
            long[] lista = new long[]{5811041,5802969,5803002,5803007,5803025,5803034,5802966,5802970,5802985,5802988,5802992,5802994,5803001,5803003,5803005,5803016,5803023,5802964,5802981,5803017,5803027,5803039,5803040,5803041,5803043,5197426,5871655,5839325,5867610,5843375,5855698,5871651,5855696,5855694,5871657,5855484,5843371,5871652,5883762,5827203,5843367,5871650,5843364,5839324,5871843,5839323,5843373,5847404,5855685,5859524,5855687,5843361,5843377,5867614,5855683,5855684,5823364,5843379,5871656};
            Stopwatch t = Stopwatch.createStarted();
            //long idTercero = 0; /*long idProducto = 0; long idMoneda=0;*/
            for (long idTercero : lista) {
                CumulusTerceroRPC ctRPC = Quotation_Callers.getCumulusTercero(SystemName.ACSELE, new CumulusTerceroParameter(idTercero));
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
            Stopwatch t = Stopwatch.createStarted();
            Calendar birthDate = Calendar.getInstance();
            birthDate.set(1974, Calendar.MAY, 23);
            int edad = Quotation_Callers.getEdadActuarial(SystemName.ACSELE, new ActuarialAgeParameter(Calendar.getInstance().getTime(), birthDate.getTime()));
            t.stop(); // optional
            t.elapsed(TimeUnit.MILLISECONDS);
            System.out.println("[test_EdadActuarial]; edad; " + edad);
            System.out.println("[test_EdadActuarial]; Total time; " + t);
            t.reset(); t.start();
        }catch (Exception e){
            Log.debug("ver ", e);
        }
    }

    private void test_Planes(ProductRPC product) {
        try {
            ProductParameter productParameter = new ProductParameter(product.getId());
            Stopwatch stopwatch = Stopwatch.createStarted();
            List<PlanRPC> list = Product_Callers.getPlanes(SystemName.ACSELE, productParameter);
            stopwatch.stop(); // optional
            stopwatch.elapsed(TimeUnit.MILLISECONDS);
            System.out.println("[MyTestMethod.test_Planes]; Total time; " + stopwatch);
            for (PlanRPC planRPC : list) System.out.println(planRPC.toString());
        } catch (ServiceBaseException e) {
            Log.debug("ver ", e);
        }

    }
    private void test_PlanesFinanciamiento(ProductRPC product) {
        try {
            ProductParameter productParameter = new ProductParameter(product.getId());
            Stopwatch stopwatch = Stopwatch.createStarted();
            List<PlanFinanciamientoRPC> list = Product_Callers.getPlanesFinanciamiento(SystemName.ACSELE, productParameter);
            stopwatch.stop(); // optional
            stopwatch.elapsed(TimeUnit.MILLISECONDS);
            System.out.println("[test_PlanesFinanciamiento]; Total time; " + stopwatch);
            System.out.println("[test_PlanesFinanciamiento] " + list.size());
        } catch (ServiceBaseException e) {
            Log.debug("ver ", e);
        }

    }
    private void test_Coberturas(ProductRPC product) {
        try {
            ProductParameter productParameter = new ProductParameter(product.getId());
            Stopwatch stopwatch = Stopwatch.createStarted();
            List<CoberturaRPC> list_ccv = Product_Callers.getCoberturas(SystemName.ACSELE, productParameter);
            stopwatch.stop(); // optional
            stopwatch.elapsed(TimeUnit.MILLISECONDS);
            System.out.println("[test_Coberturas]; Total time; " + stopwatch);
            System.out.println("[test_Coberturas] list_ccv.size: "+list_ccv.size());
        } catch (ServiceBaseException e) {
            Log.debug("ver ", e);
        }
    }


    private void test_GetPropertyRPC_Dependencies(String propertyName, boolean fetchDependence, boolean fetchDependenceChilds, String level, int numeroTest) {
        try {
            PropertyParameter parameter = new PropertyParameter(0, propertyName, fetchDependence);
            Stopwatch stopwatch = Stopwatch.createStarted();
            PropertyValuesRPC rpc = Property_Callers.getPropertyValues(SystemName.ACSELE, parameter);
            stopwatch.stop(); // optional
            stopwatch.elapsed(TimeUnit.MILLISECONDS);
            System.out.println("[test_GetPropertyRPC_Dependencies_"+numeroTest+"] property :"+rpc.getPropertyId()+"-"+rpc.getPropertyName()+"; CurrentLevel : "+level+";"+(fetchDependence? "CON": "SIN")+" DependenciaDirecta ;"+(fetchDependenceChilds? "CON": "SIN")+" DependenciaEnChilds ; Total time; " + stopwatch);
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

    private void test_GetProducts() throws Exception {
        try {
            Stopwatch t = Stopwatch.createStarted();
            List<ProductRPC> products = Product_Callers.getProducts(SystemName.ACSELE);
            t.stop(); // optional
            t.elapsed(TimeUnit.MILLISECONDS);
            System.out.println("[test_GetProducts]; Total time; " + t);
            t.reset(); t.start();
            for (ProductRPC product : products) {
                /*test_GetProduct(product);
                test_PlanesFinanciamiento(product);
                test_Planes(product);
                test_Coberturas(product);
                test_PeriodosCoberturas(product);*/
                test_Tarifas(product);
                /*test_ExigenciasMedicas(product);*/
                //if(product.getId()==49183)
                //System.out.println("[test_GetProducts] " + product.getName());
            }
            t.stop(); // optional
            t.elapsed(TimeUnit.MILLISECONDS);
            System.out.println("[test_GetProducts]; Total time; " + t);
        }catch (Exception e){
            Log.debug("ver ", e);
        }
    }

    private void test_ExigenciasMedicas(ProductRPC product) {
        Calendar instance = Calendar.getInstance();
        instance.set(1990, Calendar.JANUARY, 1);
        ExigenciasMedicaParameter exiParameter = new ExigenciasMedicaParameter(product.getId(), instance.getTime());
        Stopwatch stopwatch = Stopwatch.createStarted();
        ExigenciasMedicaRPC exigRPC = Product_Callers.getExigenciasMedicas(SystemName.ACSELE, exiParameter);
        stopwatch.stop(); // optional
        stopwatch.elapsed(TimeUnit.MILLISECONDS);
        System.out.println("[test_ExigenciasMedicas]; Total time; " + stopwatch);
        System.out.println("idProducto: "+product.getId()+"; Producto:"+product.getName()+"; Exigencias size: "+exigRPC.getRenglonList().size());
        System.out.println("Exigencia: " + exigRPC.toString());
    }

    private void test_Tarifas(ProductRPC product) {
        Calendar instance = Calendar.getInstance();
        instance.set(1995, Calendar.JANUARY, 1);
        TarifaParameter tarifaParameter = new TarifaParameter(product.getId(), 717, 0, instance.getTime());
        Stopwatch stopwatch = Stopwatch.createStarted();
        List<TarifaRPC> list = Product_Callers.getTarifas(SystemName.ACSELE, tarifaParameter);
        stopwatch.stop(); // optional
        stopwatch.elapsed(TimeUnit.MILLISECONDS);
        System.out.println("[test_Planes]; Total time; " + stopwatch);
        System.out.println("idProducto: "+product.getId()+"; Producto:"+product.getName()+"; Tarifas size: "+list.size());
        for (TarifaRPC t : list) {
            System.out.println("RenglonesTarifa size: "+t.getRenglonList().size());
        }
    }

    private void test_PeriodosCoberturas(ProductRPC product) {
        ProductParameter productParameter = new ProductParameter(product.getId());
        Stopwatch stopwatch = Stopwatch.createStarted();
        List<VigenciaRPC> list = Product_Callers.getPeriodosCoberturas(SystemName.ACSELE, productParameter);
        stopwatch.stop(); // optional
        stopwatch.elapsed(TimeUnit.MILLISECONDS);
        System.out.println("[test_Planes]; Total time; " + stopwatch);
        System.out.println("[test_Planes] "+list.size());
    }


    private void test_GetProduct(ProductRPC product) {
        try {
            ProductParameter productParameter = new ProductParameter(product.getId());
            Stopwatch stopwatch = Stopwatch.createStarted();
            ProductRPC rpc = Product_Callers.getProduct(SystemName.ACSELE, productParameter);
            stopwatch.stop(); // optional
            stopwatch.elapsed(TimeUnit.MILLISECONDS);
            System.out.println("[test_GetProduct]; Total time; " + stopwatch);
            System.out.println("[test_GetProduct] "+rpc.getName());
        } catch (ServiceBaseException e) {
            Log.debug("ver ", e);
        }
    }

    private void test_ServicesFactoryProccesor() throws Exception {
        for (CallerRegister register : ServicesFactory_Callers.fetchCallerRegistersFromServer(SystemName.ACSELE)) {
            Log.debug("******** CallerRegister :    ****************\n".concat(register.toString()));
        }
        for (ProcessorRegister register : ServicesFactory_Callers.fetchProcessorRegistersFromServer(SystemName.ACSELE)) {
            Log.debug("******** ProcessorRegister : ****************\n".concat(register.toString()));
        }
    }

}
