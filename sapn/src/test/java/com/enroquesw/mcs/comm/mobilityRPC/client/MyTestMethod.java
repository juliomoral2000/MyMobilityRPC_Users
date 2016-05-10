package com.enroquesw.mcs.comm.mobilityRPC.client;

import com.enroquesw.mcs.comm.mobilityRPC.util.testRunner.interfaces.TestRunnerJC;
import com.esotericsoftware.minlog.Log;
import com.google.common.base.Stopwatch;

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
        Stopwatch stopwatch = Stopwatch.createStarted();
        /*************************************************************************/
        //long idProducto = 49183;                // Educacion Garantizada
        stopwatch.stop(); // optional
        stopwatch.elapsed(TimeUnit.MILLISECONDS);
        System.out.println("[testMain] Total time; " + stopwatch);
        System.out.println("Termine ............................... ");
    }

}
