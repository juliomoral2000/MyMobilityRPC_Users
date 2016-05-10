package com.enroquesw.mcs.comm.mobilityRPC.util.testRunner;

import com.enroquesw.mcs.comm.mobilityRPC.util.testRunner.interfaces.TestRunnerJC;

/**
 * Created by Julio on 24/02/2016.
 */
public class MyTestRunner extends Thread {
    public static final String DEF_CLASS = "com.enroquesw.mcs.comm.mobilityRPC.client.MyTestMethod";
    boolean finishThis = false;

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
            if(System.console()!= null) System.out.println("Si hay consola");
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
