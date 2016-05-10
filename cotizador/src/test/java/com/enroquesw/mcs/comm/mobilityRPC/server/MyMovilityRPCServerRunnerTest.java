package com.enroquesw.mcs.comm.mobilityRPC.server;

import com.enroquesw.mcs.comm.mobilityRPC.SetUpBase;
import org.junit.Before;
import org.junit.Test;

import java.util.logging.Level;

/**
 * <code>MyMovilityRPCServerRunnerTest</code> prueba de la entidad <code>MyMovilityRPCServerRunner</code>
 */
public class MyMovilityRPCServerRunnerTest extends SetUpBase {
    @Before
    public void setUp() throws Exception {
        super.setUp();
    }

    @Test
    public void testMain() throws Exception {
        try {
            log.log(Level.INFO, "MyMovilityRPCServerRunnerTest");
            /*MyMovilityRPCCommRunner running = MyMovilityRPCCommRunner.startMyMovilityRPCCommRunner(hostIp, hostPort, mapClients, isDebugEnabled, serverSystemName);
            running.start();
            log.log(Level.INFO,"[MyMovilityRPCCommRunner] Inicio el contexto de MyMovilityRPCComm ");
            running.join();*/
        } catch (Exception e) {
            throw new Exception("Cant start de MovilityRPCServer ", e);
        }
    }

}