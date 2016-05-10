package com.consisint.acsele.interseguro.interfaces.mobilityRPC.services.client.caller;

import com.consisint.acsele.interseguro.interfaces.mobilityRPC.services.beans.PropertyValuesRPC;
import com.consisint.acsele.interseguro.interfaces.mobilityRPC.services.params.PropertyParameter;
import com.enroquesw.mcs.comm.mobilityRPC.enums.SystemName;
import com.enroquesw.mcs.comm.mobilityRPC.services.ServicesBaseExecutor;
import com.enroquesw.mcs.comm.mobilityRPC.services.callable.CallerOfProcess;
import com.enroquesw.mcs.comm.mobilityRPC.services.exception.ServiceBaseException;
import com.enroquesw.mcs.comm.mobilityRPC.services.parameter.ProcessParameter;

/**
 * La clase <code>Property_Callers</code> es el contenedor de callers asociados a los servicios de las propiedades de Acsele.
 */
public class Property_Callers<P extends ProcessParameter> {
/**************************** METODOS A SER INVOCADOS DESDE EL CLIENTE ************************************************/
    /**
     * Metodo para obtener la propiedad de Acsele con su lista de Valores
     *
     * @param remoteSystemName Sistema remoto
     * @param parameter Parametro de entrada
     * @return PropertyValuesRPC
     * @throws ServiceBaseException
     */
    public static PropertyValuesRPC getPropertyValues(SystemName remoteSystemName, PropertyParameter parameter) throws ServiceBaseException {
        return ServicesBaseExecutor.executeCalling(GetPropertyValues.class, parameter, remoteSystemName);
    }

/****************************** DECLARACION DE CLASES CallerOfProcess *************************************************/

    /**
     *  La clase <code>GetPropertyValues</code> es Caller del metodo getPropertyValues del servidor o Maquina Remota
     */
    public static class GetPropertyValues extends CallerOfProcess<GetPropertyValues, PropertyParameter, PropertyValuesRPC> {
        public GetPropertyValues(PropertyParameter parameter) throws Exception {
            super(parameter);
        }
    }

}
