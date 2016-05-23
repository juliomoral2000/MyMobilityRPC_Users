package com.enroquesw.mcs.comm.mobilityRPC;

import com.enroquesw.mcs.comm.mobilityRPC.util.testRunner.MyTestRunnerCOT;
import com.enroquesw.mcs.comm.mobilityRPC.server.MyMovilityRPCCommRunner;
import com.google.common.base.Joiner;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.logging.Level;

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
        while(!MyMovilityRPCCommRunner.isRun){
            MyMovilityRPCComm.sleep(1);
            if(MyMovilityRPCCommRunner.isFail){
                Joiner joiner = Joiner.on("; ").skipNulls();
                String join = joiner.join(MyMovilityRPCCommRunner.errors.values());
                throw new Exception(join);
            }
        }
        setExternalProcessor();
        log.log(Level.INFO, "[MyMovilityRPCCommTest_COT] Espero por la finalizacion del Hilo "+thread.getName());
        MyTestRunnerCOT myTestRunner = new MyTestRunnerCOT();
        myTestRunner.start();
        thread.join();
        System.out.println("[" + t.getName() + "] All threads have finished.");
    }


}