package com.enroquesw.mcs.comm.mobilityRPC;

import com.enroquesw.mcs.comm.mobilityRPC.server.MyMovilityRPCCommRunner;
import com.enroquesw.mcs.comm.mobilityRPC.util.testRunner.MyTestRunner;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * <code>MyMovilityRPCCommTest</code> es una clase de prueba de iniciar una conexion
 * y adicional dejar esta conexion escuchando por conexiones externas o llamadas remotas.
 */
public class MyMovilityRPCCommTest extends SetUpBase {
    @Before
    public void setUp() throws Exception {
        super.setUp();
        super.setServiceFactoryRegister();
    }

    @After
    public void tearDown() throws Exception {
        super.tearDown();
    }

    @Test
    public void testMain() throws Exception {
        Thread t = Thread.currentThread();
        /*MyMovilityRPCCommRunner thread = MyMovilityRPCCommRunner.startMyMovilityRPCCommRunner(hostIp, hostPort, mapClients, isDebugEnabled, serverSystemName);*/
        MyMovilityRPCCommRunner thread = MyMovilityRPCCommRunner.startMyMovilityRPCCommRunner(hostIp, hostPort, mapClients, isDebugEnabled, serverSystemName, processorRegisters, callerRegisters);
        log.log(Level.INFO, "Espero por la finalizacion del Hilo "+thread.getName());
        MyTestRunner myTestRunner = new MyTestRunner();
        myTestRunner.start();
        thread.join();
        System.out.println("[" + t.getName() + "] All threads have finished.");
    }


}