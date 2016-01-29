package com.enroquesw.mcs.comm.mobilityRPC.client;

import com.consisint.acsele.interseguro.interfaces.mobilityRPC.services.beans.ProductRPC;
import com.consisint.acsele.interseguro.interfaces.mobilityRPC.services.client.caller.Product_Callers;
import com.consisint.acsele.interseguro.interfaces.mobilityRPC.services.persister.ServiceFactoryRegisterPersister;
import com.enroquesw.mcs.comm.mobilityRPC.MyMovilityRPCComm;
import com.enroquesw.mcs.comm.mobilityRPC.MyMovilityRPCCommTest;
import com.enroquesw.mcs.comm.mobilityRPC.enums.SystemName;
import com.enroquesw.mcs.comm.mobilityRPC.server.MyMovilityRPCCommRunner;
import com.enroquesw.mcs.comm.mobilityRPC.services.factory.CallerRegister;
import com.enroquesw.mcs.comm.mobilityRPC.services.factory.ProcessorRegister;
import com.enroquesw.mcs.comm.mobilityRPC.services.impl.caller.ServicesFactory_Callers;
import com.enroquesw.mcs.comm.mobilityRPC.util.TimerHelper;
import com.esotericsoftware.minlog.Log;
import com.googlecode.mobilityrpc.network.ConnectionId;
import com.googlecode.mobilityrpc.quickstart.QuickTask;
import com.googlecode.mobilityrpc.session.MobilitySession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.net.InetAddress;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.Callable;
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
        test_StressTestingGetProducts();
        log.log(Level.INFO, "Parate Aqui");
    }

    private void test_boomerang() {
        long ini = System.currentTimeMillis();
        BoomerangObject boomerangObject = QuickTask.execute(remoteEndpointId, new BoomerangObject());
        System.out.println(Thread.currentThread().getName()+"; fin;"+System.currentTimeMillis()+"; ini;"+ini);
        System.out.println(boomerangObject.getSomeData());
        System.out.println(boomerangObject.getSomeOtherData());
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
            TimerHelper t = new TimerHelper();
            t.setIni(TimerHelper.Time_M.NANOS);
            List<ProductRPC> products = Product_Callers.getProducts(SystemName.ACSELE);
            t.getOutTime(" [Product_Callers.getProducts] ");
            for (ProductRPC product : products) {
                System.out.println(product.getName());
            }
        }catch (Exception e){
            Log.debug("ver ", e);
        }
    }

    private void test_ServicesFactoryProccesor() throws Exception {
        List<CallerRegister> list = ServicesFactory_Callers.fetchCallerRegistersFromServer(null);
        Log.debug("" + list.size());
        List<ProcessorRegister> lis_t = ServicesFactory_Callers.fetchProcessorRegistersFromServer(null);
        Log.debug("" + lis_t.size());
    }


    public class BoomerangObject implements Callable<BoomerangObject> {

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
    }
}
