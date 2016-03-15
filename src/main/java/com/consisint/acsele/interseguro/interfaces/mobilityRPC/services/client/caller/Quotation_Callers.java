package com.consisint.acsele.interseguro.interfaces.mobilityRPC.services.client.caller;

import com.consisint.acsele.interseguro.interfaces.mobilityRPC.services.beans.CumulusTerceroRPC;
import com.consisint.acsele.interseguro.interfaces.mobilityRPC.services.params.ActuarialAgeParameter;
import com.consisint.acsele.interseguro.interfaces.mobilityRPC.services.params.CumulusTerceroParameter;
import com.enroquesw.mcs.comm.mobilityRPC.enums.SystemName;
import com.enroquesw.mcs.comm.mobilityRPC.services.ServicesBaseExecutor;
import com.enroquesw.mcs.comm.mobilityRPC.services.callable.CallerOfProcess;
import com.enroquesw.mcs.comm.mobilityRPC.services.exception.ServiceBaseException;
import com.enroquesw.mcs.comm.mobilityRPC.services.parameter.ProcessParameter;

/**
 * La clase <code>Quotation_Callers</code> es el contenedor de callers asociados a los servicios de cotizacion.
 */
public class Quotation_Callers <P extends ProcessParameter> {

    public static Integer getEdadActuarial(SystemName remoteSystemName, ActuarialAgeParameter parameter) throws ServiceBaseException {
        return ServicesBaseExecutor.executeCalling(GetEdadActuarial.class, parameter, remoteSystemName);
    }

    public static CumulusTerceroRPC getCumulusTercero(SystemName remoteSystemName, CumulusTerceroParameter parameter) throws ServiceBaseException {
        return ServicesBaseExecutor.executeCalling(GetCumulusTercero.class, parameter, remoteSystemName);
    }


    /**
     * La clase <code>GetEdadActuarial</code> es Caller del metodo getEdadActuarial del servidor o Maquina Remota
     */
    public static class GetEdadActuarial extends CallerOfProcess<GetEdadActuarial, ActuarialAgeParameter, Integer> {
        public GetEdadActuarial( ActuarialAgeParameter parameter) throws Exception { super(parameter); }
    }

    /**
     * La clase <code>GetCumulusTercero</code> es Caller del metodo getCumulusTercero del servidor o Maquina Remota
     */
    public static class GetCumulusTercero extends CallerOfProcess<GetCumulusTercero, CumulusTerceroParameter, CumulusTerceroRPC> {
        public GetCumulusTercero( CumulusTerceroParameter parameter) throws Exception { super(parameter); }
    }

}
