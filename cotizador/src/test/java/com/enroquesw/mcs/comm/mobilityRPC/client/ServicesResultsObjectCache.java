package com.enroquesw.mcs.comm.mobilityRPC.client;

import com.consisint.acsele.interseguro.interfaces.mobilityRPC.services.beans.*;
import com.consisint.acsele.interseguro.interfaces.mobilityRPC.services.client.caller.Product_Callers;
import com.consisint.acsele.interseguro.interfaces.mobilityRPC.services.client.caller.Property_Callers;
import com.consisint.acsele.interseguro.interfaces.mobilityRPC.services.client.caller.Quotation_Callers;
import com.consisint.acsele.interseguro.interfaces.mobilityRPC.services.params.ActuarialAgeParameter;
import com.consisint.acsele.interseguro.interfaces.mobilityRPC.services.params.CotizacionParameter;
import com.consisint.acsele.interseguro.interfaces.mobilityRPC.services.params.ProductParameter;
import com.consisint.acsele.interseguro.interfaces.mobilityRPC.services.params.PropertyParameter;
import com.enroquesw.mcs.comm.mobilityRPC.enums.SystemName;
import com.enroquesw.mcs.comm.mobilityRPC.services.exception.ServiceBaseException;
import com.esotericsoftware.minlog.Log;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.FastArrayList;
import org.apache.commons.collections.Predicate;
import org.apache.commons.collections.Transformer;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentSkipListSet;

import static com.enroquesw.mcs.comm.mobilityRPC.enums.SystemName.ACSELE;

/**
 * Created by Julio on 12/05/2016.
 */
public class ServicesResultsObjectCache {
    public static ConcurrentHashMap<Long, ProductRPC> products = new ConcurrentHashMap<Long, ProductRPC>();
    public static ConcurrentHashMap<Long, List<PlanRPC>> planes = new ConcurrentHashMap<Long, List<PlanRPC>>();
    public static ConcurrentHashMap<Long, List<TRDataRPC>> planesVidaPorProducto = new ConcurrentHashMap<Long, List<TRDataRPC>>();
    public static PropertyValuesRPC planVida;

    public static List<ProductRPC> getListaProductos() {
        try {
            return Product_Callers.getProducts(SystemName.ACSELE);
        } catch (ServiceBaseException e) {
            Log.debug("ver ", e);
        }
        return new ArrayList<ProductRPC>();
    }

    public static ProductRPC getProduct(long idProducto) {
        try {
            final ProductParameter productParameter = new ProductParameter(idProducto);
            productParameter.setTimeOutMax((long) (60000*10));
            if(!products.containsKey(idProducto)) products.put(idProducto, Product_Callers.getProduct(SystemName.ACSELE, productParameter ));
            return products.get(idProducto);
        } catch (ServiceBaseException e) {
            Log.debug("ver ", e);
        }
        return null;
    }

    public static List<PlanRPC> getPlanRPC(long idProducto) {
        try {
            if(!planes.containsKey(idProducto)) planes.put(idProducto, Product_Callers.getPlanes(SystemName.ACSELE, new ProductParameter(idProducto)));
            return planes.get(idProducto);
        } catch (Exception e) {
            Log.debug("ver ", e);
        }
        return null;
    }

    public static List<TRDataRPC> getPlanVida(final long idProducto) {
        List<TRDataRPC> collect = new ArrayList<TRDataRPC>();
        try{
            collect = getCachedPlanesVida(idProducto);
            /*final PropertyValuesRPC planVida = Property_Callers.getPropertyValues(SystemName.ACSELE, new PropertyParameter(0, "PlanVida", true));
            final List<TRDataRPC> trDatas = new FastArrayList(Arrays.asList(planVida.getTrsArr()));
            ((FastArrayList)trDatas).setFast(true);
            List<TRDataRPC> result = new FastArrayList();
            for (TRDataRPC trData : trDatas) {
                for (TRDataRPC trDataParent : trData.getTrsArrParent()) if(trDataParent.getValue()== idProducto) collect.add(trData);
            }*/
            /*final Predicate predicateParent = new Predicate() {
                @Override public boolean evaluate(Object o) {
                    return ((TRDataRPC) o).getValue() == idProducto;
                }
            };
            final Transformer transformerHijo = new Transformer() {
                @Override public Object transform(Object o) {
                    final List<TRDataRPC> trDatasParent = new FastArrayList(Arrays.asList(((TRDataRPC) o).getTrsArrParent()));
                    ((FastArrayList) trDatasParent).setFast(true);
                    TRDataRPC padre = (TRDataRPC) CollectionUtils.find(trDatasParent, predicateParent);
                    return padre;
                }
            };
            collect = (List<TRDataRPC>) CollectionUtils.collect(trDatas, transformerHijo);*/
        } catch (ServiceBaseException e) {
            Log.debug("ver ", e);
        }
        return collect;
    }

    public static List<CoberturaRPC> getListaCoberturas(long idProducto) {
        ProductParameter productParameter = new ProductParameter(idProducto, (new Date()));
        return Product_Callers.getCoberturas(SystemName.ACSELE, productParameter);
    }

    public static List<VigenciaRPC> getPeriodosCoberturas(long idProducto) {
        ProductParameter productParameter = new ProductParameter(idProducto);
        return Product_Callers.getPeriodosCoberturas(SystemName.ACSELE, productParameter);
    }

    public static EdadProductoRPC getEdadProducto(long idProducto) {
        ProductParameter productParameter = new ProductParameter(idProducto);
        return Product_Callers.getEdadProducto(SystemName.ACSELE, productParameter);
    }

    public static CotizacionRPC calcularCotizacion(boolean isDirecta, long timeOut, CotizacionParameter parameter) {
        return Quotation_Callers.calcularCotizacion(ACSELE, parameter);
    }

    public static CotizacionRPC calcularCotizacion(CotizacionParameter parameter) {
        return Quotation_Callers.calcularCotizacion(ACSELE, parameter);
    }

    public static Integer getEdadActuarial(ActuarialAgeParameter parameter) {
        return Quotation_Callers.getEdadActuarial(ACSELE, parameter);
    }

    public static List<CotizacionRPC> getListaCotizaciones(ProductParameter parameter) {
        return Quotation_Callers.getCotizaciones(ACSELE, parameter);
    }

    public static List<TRDataRPC> getCachedPlanesVida(long idProducto) {
        if(planesVidaPorProducto.isEmpty() || !planesVidaPorProducto.containsKey(idProducto)){
            planVida = planVida == null? Property_Callers.getPropertyValues(SystemName.ACSELE, new PropertyParameter(0, "PlanVida", true)) : planVida;
            final List<TRDataRPC> trDatas = new FastArrayList(Arrays.asList(planVida.getTrsArr()));
            ((FastArrayList)trDatas).setFast(true);
            for (TRDataRPC trData : trDatas) {
                final List<TRDataRPC> trDatasParent = new FastArrayList(Arrays.asList(trData.getTrsArrParent()));
                ((FastArrayList)trDatasParent).setFast(true);
                for (TRDataRPC trDataParent : trDatasParent) {
                    final double productParent = trDataParent.getValue();
                    final boolean exist = planesVidaPorProducto.containsKey(productParent);
                    addToplanesVidaPorProducto((long) productParent, trData, exist);
                }
            }
            for (Map.Entry<Long, List<TRDataRPC>> entry : planesVidaPorProducto.entrySet())  ((FastArrayList)entry.getValue()).setFast(true);
        }
        return planesVidaPorProducto.get(idProducto);
    }

    private static void addToplanesVidaPorProducto(long productParent, TRDataRPC trData, boolean exist) {
        final List<TRDataRPC> trDataRPCs = exist ? planesVidaPorProducto.get(productParent) : new FastArrayList();
        trDataRPCs.add(trData);
        if(!exist) planesVidaPorProducto.put(productParent, trDataRPCs);
    }
}
