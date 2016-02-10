package com.enroquesw.mcs.comm.mobilityRPC.client;

import com.consisint.acsele.interseguro.interfaces.mobilityRPC.services.beans.*;
import com.consisint.acsele.interseguro.interfaces.mobilityRPC.services.client.caller.Product_Callers;
import com.consisint.acsele.interseguro.interfaces.mobilityRPC.services.client.caller.Property_Callers;
import com.consisint.acsele.interseguro.interfaces.mobilityRPC.services.params.ProductParameter;
import com.consisint.acsele.interseguro.interfaces.mobilityRPC.services.params.PropertyParameter;
import com.consisint.acsele.interseguro.interfaces.mobilityRPC.services.persister.ServiceFactoryRegisterPersister;
import com.enroquesw.mcs.comm.mobilityRPC.MyMovilityRPCComm;
import com.enroquesw.mcs.comm.mobilityRPC.MyMovilityRPCCommTest;
import com.enroquesw.mcs.comm.mobilityRPC.enums.SystemName;
import com.enroquesw.mcs.comm.mobilityRPC.server.MyMovilityRPCCommRunner;
import com.enroquesw.mcs.comm.mobilityRPC.services.exception.ServiceBaseException;
import com.enroquesw.mcs.comm.mobilityRPC.services.factory.CallerRegister;
import com.enroquesw.mcs.comm.mobilityRPC.services.factory.ProcessorRegister;
import com.enroquesw.mcs.comm.mobilityRPC.services.impl.caller.ServicesFactory_Callers;
import com.esotericsoftware.minlog.Log;
import com.google.common.base.Stopwatch;
import com.googlecode.mobilityrpc.network.ConnectionId;
import com.googlecode.mobilityrpc.session.MobilitySession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Pruebas Unitarias de invocaciones a una Maquina Remoto o Servidor Remoto.
 *
 * @author Julio Morales
 */
public class MyMovilityRPCClientTest {
    private transient static final Logger log = Logger.getLogger(MyMovilityRPCClientTest.class.getName());
    private transient MobilitySession session;
    private transient ConnectionId remoteEndpointId;
    private transient String hostIp;
    private transient Integer hostPort;
    private transient Map<String, ConnectionId> mapClients = new Hashtable<String, ConnectionId>();
    private transient boolean isDebugEnabled;
    private SystemName serverSystemName;

    @Before
    public void setUp() throws Exception {
        mapClients = MyMovilityRPCCommTest.getMapClients();
        hostIp = "127.0.0.1";   // LocalIp
        hostPort = 5749;        //LocalPort
        isDebugEnabled = true;
        serverSystemName = SystemName.COTIZADOR;
        /******************************************************/
        System.setProperty(ServiceFactoryRegisterPersister.PROP_CLASS_NAME,"com.consisint.acsele.interseguro.interfaces.mobilityRPC.services.persister.memory.ServiceFactoryRegisterMemPersister_2"); // Con este ejemplo podria extender a la interfaz e implementar la forma de extraer los registros - esta propiedad la utiliza el ServiceFactoryRegisterPersister para identificar la instancia de la clase que se desea cargar.
        /******************************************************/
        ServiceFactoryRegisterPersister instance = ServiceFactoryRegisterPersister.Impl.getInstance();
        List<ProcessorRegister> processorRegisters = instance.getProcessorRegisters();
        List<CallerRegister> callerRegisters = instance.getCallerRegisters();
        /****************************************************/
        MyMovilityRPCCommRunner.startMyMovilityRPCCommRunner(hostIp, hostPort, mapClients, isDebugEnabled, serverSystemName, processorRegisters, callerRegisters);
        while(!MyMovilityRPCComm.isServerRunning()) MyMovilityRPCComm.sleep(1); // Esperamos x que inicie el servidor
        remoteEndpointId = MyMovilityRPCClient.getEndPointByRemoteName("Acsel-e");
        /****************************************************/
        /****************************************************/
        session = MyMovilityRPCClient.controller.newSession();
        /****************************************************/
    }

    @After
    public void tearDown() throws Exception {
        if(MyMovilityRPCComm.isServerRunning()) MyMovilityRPCComm.destroy();

    }

    @Test
    public void testMain() throws Exception {
        //test_ServicesFactoryProccesor();
        //test_GetProducts();
        //test_boomerang();
        Stopwatch stopwatch = Stopwatch.createStarted();
        //test_StressTestingGetProducts();
        //test_GetProducts();
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

        /*************************************************************************/
        stopwatch.stop(); // optional
        test_GetProducts();
        stopwatch.elapsed(TimeUnit.MILLISECONDS);
        System.out.println("[testMain] Total time; " + stopwatch);
        log.log(Level.INFO, "Parate Aqui");
    }

    private void test_Planes(ProductRPC product) {
        try {
            ProductParameter productParameter = new ProductParameter(product.getId());
            Stopwatch stopwatch = Stopwatch.createStarted();
            List<PlanRPC> list = Product_Callers.getPlanes(SystemName.ACSELE, productParameter);
            stopwatch.stop(); // optional
            stopwatch.elapsed(TimeUnit.MILLISECONDS);
            System.out.println("[test_Planes]; Total time; " + stopwatch);
            System.out.println("[test_Planes] "+list.size());
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

    /** private void test_boomerang() {
        long ini = System.currentTimeMillis();
        BoomerangObject boomerangObject = QuickTask.execute(remoteEndpointId, new BoomerangObject());
        System.out.println(Thread.currentThread().getName() + "; fin;" + System.currentTimeMillis() + "; ini;" + ini);
        System.out.println(boomerangObject.getSomeData());
        System.out.println(boomerangObject.getSomeOtherData());
    }*/

    private void test_StressTestingGetProducts() {
        int numThread = 1;   // llamadas concurrentes
        //Stresstesting.stressTestingGetProducts(numThread);
        for(int i = 0; i < 100; i++ ) {
            Stresstesting.stressTestingGetProducts_2(numThread, i);
        }

    }

    private void test_GetProducts() throws Exception {
        try {
            List<ProductRPC> products = Product_Callers.getProducts(SystemName.ACSELE);
            Stopwatch stopwatch = Stopwatch.createStarted();
            for (ProductRPC product : products) {
                //test_GetProduct(product);
                //test_PlanesFinanciamiento(product);
                test_Planes(product);
                System.out.println("[test_GetProducts] "+product.getName());
            }
            stopwatch.stop(); // optional
            stopwatch.elapsed(TimeUnit.MILLISECONDS);
            System.out.println("[test_GetProducts]; Total time; " + stopwatch);
        }catch (Exception e){
            Log.debug("ver ", e);
        }
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
        List<CallerRegister> list = ServicesFactory_Callers.fetchCallerRegistersFromServer(null);
        Log.debug("" + list.size());
        List<ProcessorRegister> lis_t = ServicesFactory_Callers.fetchProcessorRegistersFromServer(null);
        Log.debug("" + lis_t.size());
    }


    /*public class BoomerangObject implements Callable<BoomerangObject> {

        private Properties someData;
        private InetAddress someOtherData;

        public BoomerangObject call() throws Exception {
            someData = System.getProperties();
            someOtherData = InetAddress.getLocalHost();
            return this;
        }

        public Properties getSomeData() {
            return someData;
        }

        public InetAddress getSomeOtherData() {
            return someOtherData;
        }
    }*/
}
