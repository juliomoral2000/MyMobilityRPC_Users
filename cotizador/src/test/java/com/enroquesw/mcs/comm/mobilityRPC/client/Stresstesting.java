package com.enroquesw.mcs.comm.mobilityRPC.client;

import com.consisint.acsele.interseguro.interfaces.mobilityRPC.services.beans.CotizacionRPC;
import com.consisint.acsele.interseguro.interfaces.mobilityRPC.services.beans.ProductRPC;
import com.consisint.acsele.interseguro.interfaces.mobilityRPC.services.client.caller.Product_Callers;
import com.consisint.acsele.interseguro.interfaces.mobilityRPC.services.client.caller.Quotation_Callers;
import com.consisint.acsele.interseguro.interfaces.mobilityRPC.services.params.ActuarialAgeParameter;
import com.consisint.acsele.interseguro.interfaces.mobilityRPC.services.params.CotizacionParameter;
import com.consisint.acsele.interseguro.interfaces.mobilityRPC.services.params.ProductParameter;
import com.enroquesw.mcs.comm.mobilityRPC.client.cotizacion.CreateCotizacion;
import com.enroquesw.mcs.comm.mobilityRPC.enums.SystemName;
import com.google.common.base.Stopwatch;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

import static com.enroquesw.mcs.comm.mobilityRPC.enums.SystemName.ACSELE;

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

    public static void stressTestingCalcularCotizacion(int numThread, int testNro) {
        System.out.println("[stressTestingCalcularCotizacion] Numero de Prueba: "+testNro);
        try {
            final CotizacionParameter parameter = CreateCotizacion.createParameterFromMap(true, MyTestMethodCOT.createMap());
            //parameter.setTimeOutMax(timeOut); Default TimeOut
            System.out.println("[test_CalcularCotizacion]; parametro de entrada:\n" + parameter.toString());
            class StressTask implements Callable<CotizacionRPC> {
                @Override
                public CotizacionRPC call() {
                    try {
                        String name = Thread.currentThread().getName();
                        System.out.println(name+"; ini;"+System.currentTimeMillis());
                        CotizacionRPC cRPC = ServicesResultsObjectCache.calcularCotizacion(parameter);
                        System.out.println(name+"; fin;"+System.currentTimeMillis());
                        return cRPC;
                    }catch (Exception e){
                        System.out.println("ver "+ e.getMessage());
                        return null;
                    }
                }
            }
            //Future<CotizacionRPC> result = null;
            List<Future<CotizacionRPC>> list = new ArrayList<Future<CotizacionRPC>>();

            Stopwatch stopwatch = Stopwatch.createStarted();
            ExecutorService executorService = Executors.newFixedThreadPool(numThread);
            for (int i = 0; i < numThread; i++) {
                //result = executorService.submit(new StressTask());
                list.add(executorService.submit(new StressTask()));
            }
            executorService.shutdown();
            executorService.awaitTermination(Long.MAX_VALUE, TimeUnit.MILLISECONDS);
            stopwatch.stop(); // optional
            long millis = stopwatch.elapsed(TimeUnit.MILLISECONDS);
            System.out.println("[stressTestingCalcularCotizacion] Numero de Prueba: " + testNro + ", Total time: " + stopwatch);
            //System.out.println("Finalizado. El resultado final fue tama#o lista : " + list.size());
            for (Future<CotizacionRPC> future : list) {
                try { System.out.println("[stressTestingCalcularCotizacion] Respuesta :\n"+future.get().toString()); } catch (ExecutionException e) { e.printStackTrace(); }
            }
        } catch (InterruptedException e1) {
            e1.printStackTrace();
        }
    }

    public static void stressTestingGetEdadActuarial(int numThread, int testNro) {
        System.out.println("[stressTestingGetEdadActuarial] Numero de Prueba: "+testNro);
        try {

            class StressTask implements Callable<Integer> {
                @Override
                public Integer call() {
                    try {
                        String name = Thread.currentThread().getName();
                        final Random randomGenerator = new Random();
                        int anInt = randomGenerator.nextInt(100);
                        int anInt_2 = randomGenerator.nextInt(12);
                        Calendar birthDate = Calendar.getInstance();
                        birthDate.set(1900+anInt, anInt_2/*Calendar.JANUARY*/, 01);
                        final ActuarialAgeParameter parameter = new ActuarialAgeParameter(Calendar.getInstance().getTime(), birthDate.getTime());
                        System.out.println("[stressTestingGetEdadActuarial]; parametro de entrada:\n" + parameter.toString());

                        System.out.println(name+"; ini;"+System.currentTimeMillis());
                        Integer edad = ServicesResultsObjectCache.getEdadActuarial(parameter);
                        System.out.println(name+"; fin;"+System.currentTimeMillis());
                        return edad;
                    }catch (Exception e){
                        System.out.println("ver "+ e.getMessage());
                        return null;
                    }
                }
            }
            List<Future<Integer>> list = new ArrayList<Future<Integer>>();

            Stopwatch stopwatch = Stopwatch.createStarted();
            ExecutorService executorService = Executors.newFixedThreadPool(numThread);
            for (int i = 0; i < numThread; i++) {
                list.add(executorService.submit(new StressTask()));
            }
            executorService.shutdown();
            executorService.awaitTermination(Long.MAX_VALUE, TimeUnit.MILLISECONDS);
            stopwatch.stop(); // optional
            long millis = stopwatch.elapsed(TimeUnit.MILLISECONDS);
            System.out.println("[stressTestingGetEdadActuarial] Numero de Prueba: "+testNro+", Total time: " + stopwatch);
            for (Future<Integer> future : list) {
                try { System.out.println("[stressTestingGetEdadActuarial] Respuesta :\n"+future.get().toString()); } catch (ExecutionException e) { e.printStackTrace(); }
            }
        } catch (InterruptedException e1) {
            e1.printStackTrace();
        }
    }

    public static void stressTestingGetProduct(int numThread, int testNro, List<ProductRPC> productRPCList){
        final int totalthread = numThread * productRPCList.size();   // numero de hilos por producto es numero total de hilos a manejar, ej numThread= 1 es un hilo por producto
        System.out.println("[stressTestingGetProduct] INICIO .... Numero Prueba: "+testNro+"; Total de Productos: " + productRPCList.size()+"; Hilos x Producto: " + numThread+"; Total de Hilos: " + totalthread);
        try {
            class StressTask extends Thread {
                long idProduct;
                public StressTask(long idProduct){
                    super();
                    this.idProduct = idProduct;
                }
                @Override
                public void run() {
                    try {
                        final StringBuffer requestIdOut = new StringBuffer();
                        ProductRPC product = Product_Callers.getProduct(SystemName.ACSELE, new ProductParameter(idProduct), requestIdOut);
                        final StringBuilder out = new StringBuilder("[StressTask]; threadId: ").append(this.getId()).append("; requestIdOut: ").append(requestIdOut).append("\nproduct: ").append(new Gson().toJson(product));
                        System.out.println(out);
                    }catch (Exception e){
                        System.out.println("ver "+ e.getMessage());
                    }
                }
            }

            Thread[] threads = new Thread[totalthread];
            Stopwatch stopwatch = Stopwatch.createStarted();
            int j = 0;
            for (ProductRPC productRPC : productRPCList) {
                for (int i = 0; i < numThread; i++) {
                    StressTask stressTask = new StressTask(productRPC.getId());
                    threads[j++] = stressTask;
                    //stressTask.start();
                }
            }
            for(int i=0; i<threads.length; i++) {
                try {
                    threads[i].start();
                    threads[i].join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            stopwatch.stop(); // optional
            long millis = stopwatch.elapsed(TimeUnit.MILLISECONDS);
            System.out.println("[stressTestingGetProduct] FINAl... Numero Prueba; "+testNro+"; Total time; " + stopwatch);
        } catch (Exception e1) {
            e1.printStackTrace();
        }
    }
}
