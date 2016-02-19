package com.enroquesw.mcs.comm.mobilityRPC;

import com.enroquesw.mcs.comm.mobilityRPC.server.MyMovilityRPCCommRunner;
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
    }

    @After
    public void tearDown() throws Exception {
        super.tearDown();
    }

    @Test
    public void testMain() throws Exception {
        /*Thread t = Thread.currentThread();
        MyMovilityRPCCommRunner thread = MyMovilityRPCCommRunner.startMyMovilityRPCCommRunner(hostIp, hostPort, mapClients, isDebugEnabled, serverSystemName);
        log.log(Level.INFO, "Espero por la finalizacion del Hilo "+thread.getName());
        thread.join();
        System.out.println("[" + t.getName() + "] All threads have finished.");*/
    }


}