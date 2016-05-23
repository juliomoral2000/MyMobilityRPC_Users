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
public class MyTestRunnerSAPN extends Thread {
    public static final String DEF_CLASS = "com.enroquesw.mcs.comm.mobilityRPC.client.MyTestMethodSAPN";
    boolean finishThis = false;
    static int poolSize = 1;    //define el numero de Hilos del Pool a procesar
    static ExecutorService service = Executors.newFixedThreadPool(poolSize);
    static List<Future<Thread>> futures = new ArrayList<Future<Thread>>();


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
                    try {
                        Future f = service.submit(o);
                        futures.add(f);
                        for (Future<Thread> ff : futures) ff.get();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (ExecutionException e) {
                        e.printStackTrace();
                    }
                    service.shutdownNow();
                    System.out.println("Si espera por la finalizacion !!!!!!!");
                    final int size = futures.size();
                    for(int i = size - 1; i >= 0; --i) futures.remove(i);
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
