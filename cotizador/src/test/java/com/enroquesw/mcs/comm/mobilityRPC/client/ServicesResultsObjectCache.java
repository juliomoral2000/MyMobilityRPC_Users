package com.enroquesw.mcs.comm.mobilityRPC.client;

import com.consisint.acsele.interseguro.interfaces.mobilityRPC.services.beans.*;
import com.consisint.acsele.interseguro.interfaces.mobilityRPC.services.client.caller.Product_Callers;
import com.consisint.acsele.interseguro.interfaces.mobilityRPC.services.client.caller.Property_Callers;
import com.consisint.acsele.interseguro.interfaces.mobilityRPC.services.params.ProductParameter;
import com.consisint.acsele.interseguro.interfaces.mobilityRPC.services.params.PropertyParameter;
import com.enroquesw.mcs.comm.mobilityRPC.enums.SystemName;
import com.enroquesw.mcs.comm.mobilityRPC.services.exception.ServiceBaseException;
import com.esotericsoftware.minlog.Log;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.FastArrayList;
import org.apache.commons.collections.Predicate;
import org.apache.commons.collections.Transformer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by Julio on 12/05/2016.
 */
public class ServicesResultsObjectCache {
    public static ConcurrentHashMap<Long, ProductRPC> products = new ConcurrentHashMap<Long, ProductRPC>();
    public static ConcurrentHashMap<Long, List<PlanRPC>> planes = new ConcurrentHashMap<Long, List<PlanRPC>>();

    public static ProductRPC getProduct(long idProducto) {
        try {
            if(!products.containsKey(idProducto)) products.put(idProducto, Product_Callers.getProduct(SystemName.ACSELE, new ProductParameter(idProducto)));
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
            final PropertyValuesRPC planVida = Property_Callers.getPropertyValues(SystemName.ACSELE, new PropertyParameter(0, "PlanVida", true));
            final List<TRDataRPC> trDatas = new FastArrayList(Arrays.asList(planVida.getTrsArr()));
            ((FastArrayList)trDatas).setFast(true);
            List<TRDataRPC> result = new FastArrayList();
            final Predicate predicateParent = new Predicate() {
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
            collect = (List<TRDataRPC>) CollectionUtils.collect(trDatas, transformerHijo);
        } catch (ServiceBaseException e) {
            Log.debug("ver ", e);
        }
        return collect;
    }

    public static List<CoberturaRPC> getListaCoberturas(long idProducto) {
        ProductParameter productParameter = new ProductParameter(idProducto);
        return Product_Callers.getCoberturas(SystemName.ACSELE, productParameter);
    }

}