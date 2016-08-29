package com.enroquesw.mcs.comm.mobilityRPC.util;

import com.consisint.acsele.interseguro.interfaces.mobilityRPC.services.beans.CotizacionRPC;
import com.enroquesw.mcs.comm.mobilityRPC.client.BaseData;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.stream.JsonReader;

import java.io.*;
import java.nio.charset.Charset;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by Julio on 26/08/2016.
 */
public class FileUtil {
    public static final Map<String, File> filesLogByProduct = new ConcurrentHashMap<String, File>(); // Map de Producto, Archivo de Salida
    public final static String PATH_TEST_JSON = "D:\\Git_Repo\\ServiciosWebInter\\PruebasJSONs_Cotizaciones";
    public static final Gson gsonPretty = new GsonBuilder().setPrettyPrinting().create();
    public static final Gson gson = new Gson();

    public static BaseData getJSONBaseDataFromFile(String productName) {
        try {
            //Gson gson = new Gson();
            String filePath = PATH_TEST_JSON + "\\JSONCotizaBase_" + productName + ".json";
            JsonReader reader = new JsonReader(new InputStreamReader(new FileInputStream(filePath), Charset.forName("UTF-8")));
            BaseData data = gson.fromJson(reader, BaseData.class); // contains the whole reviews list
            return data;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static CotizacionRPC getJSONFromFileByPolId(BaseData baseData, String productName) {
        try {
            //Gson gson = new Gson();
            File file = getFileByPolId(productName, baseData.getIdPoliza());
            if(file == null) return null;
            JsonReader reader = new JsonReader(new InputStreamReader(new FileInputStream(file), Charset.forName("UTF-8")));
            final CotizacionRPC fromJson = gson.fromJson(reader, CotizacionRPC.class);// contains the whole reviews list
            return fromJson;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    private static File getFileByPolId(String productName, long idPoliza) {
        File file = new File(getFileNameBypolicyId(productName, idPoliza));
        if (file == null || !file.exists()) return null;
        return file;
    }

    private static String getFileNameBypolicyId(String productName, long idPoliza) {
        return PATH_TEST_JSON + "\\EntradaJSON\\JSON_" +productName+"_"+idPoliza+".json";
    }

    public static void writeJSONLogByProduct(String productName, String out, boolean overWrite) {
        try {
            File file = getFileLogByProduct(productName);
            writeToFile(file, out, overWrite);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void writeJSONLogByProduct(String productName, String out) {
        writeJSONLogByProduct(productName, out, true);
    }

    private static void writeToFile(File file, String out, boolean overWrite) {
        BufferedWriter bw = null;
        try {
            synchronized (FileUtil.class) {
                FileWriter fw = new FileWriter(file.getAbsoluteFile(), overWrite);
                bw = new BufferedWriter(fw);
                bw.write(out);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(bw != null) try { bw.close(); } catch (IOException e) { e.printStackTrace(); }
        }
    }

    private static File getFileLogByProduct(String productName) throws IOException {
        if(filesLogByProduct.containsKey(productName)) return filesLogByProduct.get(productName);
        String filePath = PATH_TEST_JSON+"\\Salida\\Test_Out_JSONCotiza_"+productName+".log";
        final File file = checkAndCreateFile(filePath);
        filesLogByProduct.put(productName, file);
        return file;
    }

    private static File checkAndCreateFile(String filePath) throws IOException {
        try {
            File file = new File(filePath);
            if (!file.exists())  file.createNewFile(); // if file doesnt exists, then create it
            return file;
        } catch (IOException e) {
            e.printStackTrace();
            throw e;
        }
    }

    public static void writeJSONByPolIdToFile(String productName, CotizacionRPC cotRPC) {
        try {
            File file = getFileByPolId(productName, cotRPC.getIdPoliza());
            if(file == null) file = checkAndCreateFile(getFileNameBypolicyId(productName, cotRPC.getIdPoliza()));
            writeToFile(file, gsonPretty.toJson(cotRPC), false);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
