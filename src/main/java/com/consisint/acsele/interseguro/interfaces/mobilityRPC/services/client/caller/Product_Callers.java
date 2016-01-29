package com.consisint.acsele.interseguro.interfaces.mobilityRPC.services.client.caller;

import com.consisint.acsele.interseguro.interfaces.mobilityRPC.services.beans.ProductRPC;
import com.enroquesw.mcs.comm.mobilityRPC.enums.SystemName;
import com.enroquesw.mcs.comm.mobilityRPC.services.ServicesBaseExecutor;
import com.enroquesw.mcs.comm.mobilityRPC.services.callable.CallerOfProcess;
import com.enroquesw.mcs.comm.mobilityRPC.services.exception.ServiceBaseException;
import com.enroquesw.mcs.comm.mobilityRPC.services.parameter.ProcessParameter;
import com.enroquesw.mcs.comm.mobilityRPC.services.parameter.VoidParameter;

import java.util.List;

/**
 * Created by Julio on 24/01/2016.
 */
public class Product_Callers <P extends ProcessParameter>{
    /**
     *
     * @param remoteSystemName
     * @return
     * @throws Exception
     */
    public static List<ProductRPC> getProducts(SystemName remoteSystemName) throws ServiceBaseException {
        return ServicesBaseExecutor.executeCalling(GetProducts.class, new VoidParameter(), remoteSystemName);
    }

    /**
     *
     */
    public static class GetProducts extends CallerOfProcess<GetProducts, VoidParameter, List<ProductRPC>> {
        public GetProducts(VoidParameter parameter) throws Exception {
            super(parameter);
        }
    }
}
