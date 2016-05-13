package com.consisint.acsele.interseguro.interfaces.mobilityRPC.services.client.caller;

import com.consisint.acsele.interseguro.interfaces.mobilityRPC.services.beans.CotizacionRPC;
import com.consisint.acsele.interseguro.interfaces.mobilityRPC.services.beans.CumulusTerceroRPC;
import com.consisint.acsele.interseguro.interfaces.mobilityRPC.services.params.ActuarialAgeParameter;
import com.consisint.acsele.interseguro.interfaces.mobilityRPC.services.params.CotizacionParameter;
import com.consisint.acsele.interseguro.interfaces.mobilityRPC.services.params.CumulusTerceroParameter;
import com.consisint.acsele.interseguro.interfaces.mobilityRPC.services.params.ProductParameter;
import com.enroquesw.mcs.comm.mobilityRPC.enums.SystemName;
import com.enroquesw.mcs.comm.mobilityRPC.services.ServicesBaseExecutor;
import com.enroquesw.mcs.comm.mobilityRPC.services.callable.CallerOfProcess;
import com.enroquesw.mcs.comm.mobilityRPC.services.exception.ServiceBaseException;
import com.enroquesw.mcs.comm.mobilityRPC.services.parameter.ProcessParameter;

import java.util.List;

/**
 * La clase <code>Quotation_Callers</code> es el contenedor de callers asociados a los servicios de cotizacion.
 */
public class Quotation_Callers <P extends ProcessParameter> {
/**************************** METODOS A SER INVOCADOS DESDE EL CLIENTE ************************************************/

    /**
     * Metodo para obtener la edad actuarial a traves de la invocacion Remota
     * @param remoteSystemName Sistema remoto
     * @param parameter Parametro de entrada
     * @return Integer
     * @throws ServiceBaseException
     */
    public static Integer getEdadActuarial(SystemName remoteSystemName, ActuarialAgeParameter parameter) throws ServiceBaseException {
        return ServicesBaseExecutor.executeCalling(GetEdadActuarial.class, parameter, remoteSystemName);
    }

    /**
     * Metodo para obtener el cumulus del tercero a traves de la invocacion Remota
     * @param remoteSystemName Sistema remoto
     * @param parameter Parametro de entrada
     * @return CumulusTerceroRPC
     * @throws ServiceBaseException
     */
    public static CumulusTerceroRPC getCumulusTercero(SystemName remoteSystemName, CumulusTerceroParameter parameter) throws ServiceBaseException {
        return ServicesBaseExecutor.executeCalling(GetCumulusTercero.class, parameter, remoteSystemName);
    }

    /**
     * Metodo para obtener el calculo de la cotizacion a traves de la invocacion Remota
     * @param remoteSystemName Sistema remoto
     * @param parameter Parametro de entrada
     * @return CotizacionRPC
     * @throws ServiceBaseException
     */
    public static CotizacionRPC calcularCotizacion(SystemName remoteSystemName, CotizacionParameter parameter) throws ServiceBaseException {
        return ServicesBaseExecutor.executeCalling(CalcularCotizacion.class, parameter, remoteSystemName);
    }

    /**
     * Metodo utilitario para cargar una lista de Cotizaciones desde el core por producto
     * a traves de la invocacion Remota
     * @param remoteSystemName Sistema remoto
     * @param parameter Parametro de entrada
     * @return List < CotizacionRPC >
     * @throws ServiceBaseException
     */
    public static List<CotizacionRPC> getCotizaciones(SystemName remoteSystemName, ProductParameter parameter) throws ServiceBaseException {
        return ServicesBaseExecutor.executeCalling(GetCotizaciones.class, parameter, remoteSystemName);
    }

/****************************** DECLARACION DE CLASES CallerOfProcess *************************************************/

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

    /**
     * La clase <code>CalcularCotizacion</code> es Caller del metodo calcularCotizacion del servidor o Maquina Remota
     */
    public static class CalcularCotizacion extends CallerOfProcess<CalcularCotizacion, CotizacionParameter, CotizacionRPC> {
        public CalcularCotizacion(CotizacionParameter parameter) throws Exception { super(parameter); }
    }

    public static class GetCotizaciones extends CallerOfProcess<GetCotizaciones, ProductParameter, List<CotizacionRPC>> {
        public GetCotizaciones(ProductParameter parameter) throws Exception { super(parameter); }
    }
}
