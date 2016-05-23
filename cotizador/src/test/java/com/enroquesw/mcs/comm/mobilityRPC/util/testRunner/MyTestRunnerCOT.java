package com.enroquesw.mcs.comm.mobilityRPC.util.testRunner;

import com.enroquesw.mcs.comm.mobilityRPC.util.testRunner.interfaces.TestRunnerJC;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Created by Julio on 24/02/2016.
 */
public class MyTestRunnerCOT extends Thread {
    public static final String DEF_CLASS = "com.enroquesw.mcs.comm.mobilityRPC.client.MyTestMethodCOT";
    boolean finishThis = false;
    static int poolSize = 1;    //define el numero de Hilos del Pool a procesar
    static ExecutorService service = Executors.newFixedThreadPool(poolSize);
    static List<Future<Thread>> futures = new ArrayList<Future<Thread>>();

    //static boolean isProcessChild

    @Override
    public synchronized void start() {
        super.start();
    }

    @Override
    public void run() {
        while(!finishThis){
            try {
                sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            String classToRun = "";// classToRun = DEF_CLASS;
            if(classToRun != null && classToRun.length() > 0){
                try {
                    Class callerClass = Class.forName(classToRun);
                    TestRunnerJC o = (TestRunnerJC) callerClass.newInstance();
                    o.start();
                } catch (InstantiationException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
                classToRun = "";
            }
        }
    }
}
