package com.enroquesw.mcs.comm.mobilityRPC.client;

import com.consisint.acsele.interseguro.interfaces.mobilityRPC.services.beans.ProductRPC;
import com.consisint.acsele.interseguro.interfaces.mobilityRPC.services.client.caller.Product_Callers;
import com.enroquesw.mcs.comm.mobilityRPC.enums.SystemName;
import com.google.common.base.Stopwatch;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * Created by Julio on 27/01/2016.
 */
public class Stresstesting {
    public static void stressTestingGetProducts(int numThread){
        try {
            class StressTask implements Callable<List<ProductRPC>> {
                @Override
                public List<ProductRPC> call() {
                    try {
                        String name = Thread.currentThread().getName();
                        //Stopwatch stopwatch = Stopwatch.createStarted();
                        System.out.println(name+"; ini;"+System.currentTimeMillis());
                        List<ProductRPC> products = Product_Callers.getProducts(SystemName.ACSELE);
                        System.out.println(name+"; fin;"+System.currentTimeMillis());
                        //stopwatch.stop(); // optional
                        //long millis = stopwatch.elapsed(TimeUnit.MILLISECONDS);
                        //System.out.println(name + " time: " + stopwatch);
                        return products;
                    }catch (Exception e){
                        System.out.println("ver "+ e.getMessage());
                        return new ArrayList<ProductRPC>();
                    }
                }
            }
            Future<List<ProductRPC>> result = null;
            List<Future<List<ProductRPC>>> list = new ArrayList<Future<List<ProductRPC>>>();

            Stopwatch stopwatch = Stopwatch.createStarted();
            ExecutorService executorService = Executors.newFixedThreadPool(numThread);
            for (int i = 0; i < numThread; i++) {
                result = executorService.submit(new StressTask());
                list.add(result);
            }
            executorService.shutdown();
            executorService.awaitTermination(Long.MAX_VALUE, TimeUnit.MILLISECONDS);
            stopwatch.stop(); // optional
            long millis = stopwatch.elapsed(TimeUnit.MILLISECONDS);
            System.out.println("Total time: " + stopwatch);
            System.out.println("Finalizado. El resultado final fue tama#o lista : " + list.size());
            /*for (Future<List<ProductRPC>> future : list) {
                System.out.println(future.get().size());
            }*/
        } catch (InterruptedException e1) {
            e1.printStackTrace();
        }/* catch (ExecutionException e) {
            e.printStackTrace();
        }*/
    }

    public static void stressTestingGetProducts_2(int numThread, int testNro){
        try {
            class StressTask extends Thread {
                @Override
                public void run() {
                    try {
                        List<ProductRPC> products = Product_Callers.getProducts(SystemName.ACSELE);
                    }catch (Exception e){
                        System.out.println("ver "+ e.getMessage());
                    }
                }
            }
            Thread[] threads = new Thread[numThread];
            Stopwatch stopwatch = Stopwatch.createStarted();
            for (int i = 0; i < numThread; i++) {
                StressTask stressTask = new StressTask();
                threads[i] = stressTask;
                stressTask.start();
            }
            for(int i=0; i<threads.length; i++) {
                threads[i].join();
            }
            stopwatch.stop(); // optional
            long millis = stopwatch.elapsed(TimeUnit.MILLISECONDS);
            System.out.println("Numero Prueba; "+testNro+"; Total time; " + stopwatch);
        } catch (InterruptedException e1) {
            e1.printStackTrace();
        }
    }
}
