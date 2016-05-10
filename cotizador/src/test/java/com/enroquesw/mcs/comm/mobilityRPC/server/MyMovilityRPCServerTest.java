package com.enroquesw.mcs.comm.mobilityRPC.server;

import com.enroquesw.mcs.comm.mobilityRPC.SetUpBase;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * <code>MyMovilityRPCServerTest</code> prueba de la entidad <code>MyMovilityRPCServer</code>
 */
public class MyMovilityRPCServerTest extends SetUpBase {
    @Before
    public void setUp() throws Exception {
        super.setUp();
    }

    @After
    public void tearDown() throws Exception {
        super.tearDown();
    }

    @Test
    public void testInit() throws Exception {
        /*Thread t = Thread.currentThread();
        MobilityController mobilityController = MyMovilityRPCServer.init(null, null, SystemName.OTHER);
        Log.DEBUG= true;
        Log.debug("Pararte aqui");
        Log.debug("Pararte aqui 2");
        Log.debug(mobilityController.toString());
        //noinspection SynchronizationOnLocalVariableOrMethodParameter
        synchronized (t) {
            while (MyMovilityRPCServer.isRunning()) {
                Thread.sleep(10000);
            }
        }
        Log.debug("[MyMovilityRPCServerTest] Aqui termino la ejecucion del Hilo "+t.getName());*/
    }
}