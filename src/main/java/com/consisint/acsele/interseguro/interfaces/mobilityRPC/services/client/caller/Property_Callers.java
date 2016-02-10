package com.consisint.acsele.interseguro.interfaces.mobilityRPC.services.client.caller;

import com.consisint.acsele.interseguro.interfaces.mobilityRPC.services.beans.PropertyValuesRPC;
import com.consisint.acsele.interseguro.interfaces.mobilityRPC.services.params.PropertyParameter;
import com.enroquesw.mcs.comm.mobilityRPC.enums.SystemName;
import com.enroquesw.mcs.comm.mobilityRPC.services.ServicesBaseExecutor;
import com.enroquesw.mcs.comm.mobilityRPC.services.callable.CallerOfProcess;
import com.enroquesw.mcs.comm.mobilityRPC.services.exception.ServiceBaseException;
import com.enroquesw.mcs.comm.mobilityRPC.services.parameter.ProcessParameter;

/**
 * Created by Julio on 03/02/2016.
 */
public class Property_Callers<P extends ProcessParameter> {
    /**
     * Retorna la propiedad con su lista de Valores
     *
     * @param remoteSystemName
     * @param parameter
     * @return
     * @throws ServiceBaseException
     */
    public static PropertyValuesRPC getPropertyValues(SystemName remoteSystemName, PropertyParameter parameter) throws ServiceBaseException {
        return ServicesBaseExecutor.executeCalling(GetPropertyValues.class, parameter, remoteSystemName);
    }


    /**
     *
     */
    public static class GetPropertyValues extends CallerOfProcess<GetPropertyValues, PropertyParameter, PropertyValuesRPC> {
        public GetPropertyValues(PropertyParameter parameter) throws Exception {
            super(parameter);
        }
    }

}
