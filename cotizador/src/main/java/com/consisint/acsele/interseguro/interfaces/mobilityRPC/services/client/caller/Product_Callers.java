package com.consisint.acsele.interseguro.interfaces.mobilityRPC.services.client.caller;

import com.consisint.acsele.interseguro.interfaces.mobilityRPC.services.beans.*;
import com.consisint.acsele.interseguro.interfaces.mobilityRPC.services.params.ExigenciasMedicaParameter;
import com.consisint.acsele.interseguro.interfaces.mobilityRPC.services.params.ProductParameter;
import com.consisint.acsele.interseguro.interfaces.mobilityRPC.services.params.TarifaParameter;
import com.enroquesw.mcs.comm.mobilityRPC.enums.SystemName;
import com.enroquesw.mcs.comm.mobilityRPC.services.ServicesBaseExecutor;
import com.enroquesw.mcs.comm.mobilityRPC.services.callable.CallerOfProcess;
import com.enroquesw.mcs.comm.mobilityRPC.services.exception.ServiceBaseException;
import com.enroquesw.mcs.comm.mobilityRPC.services.parameter.ProcessParameter;
import com.enroquesw.mcs.comm.mobilityRPC.services.parameter.VoidParameter;

import java.util.List;

/**
 * La clase <code>Product_Callers</code> es el contenedor de callers asociados a los servicios del producto.
 */
public class Product_Callers <P extends ProcessParameter>{
/**************************** METODOS A SER INVOCADOS DESDE EL CLIENTE ************************************************/

    /**
     * Metodo para obtener la lista de Productos de Vida a traves de la invocacion Remota
     * @param remoteSystemName Sistema remoto
     * @return  List<ProductRPC>
     * @throws ServiceBaseException
     */
    public static List<ProductRPC> getProducts(SystemName remoteSystemName) throws ServiceBaseException {
        return ServicesBaseExecutor.executeCalling(GetProducts.class, new VoidParameter(), remoteSystemName, new StringBuffer());
    }

    /**
     * Metodo para obtener el Producto de Vida a traves de la invocacion Remota
     * @param remoteSystemName Sistema remoto
     * @param parameter Parametro de entrada
     * @return ProductRPC
     * @throws ServiceBaseException
     */
    public static ProductRPC getProduct(SystemName remoteSystemName, ProductParameter parameter) throws ServiceBaseException {
        return ServicesBaseExecutor.executeCalling(GetProduct.class, parameter, remoteSystemName, new StringBuffer());
    }

    /**
     * Metodo para obtener la lista de Planes de Financiamiento [PERIODO DE PAGO en el cotizador] a traves de la invocacion Remota
     * @param remoteSystemName Sistema remoto
     * @param parameter Parametro de entrada
     * @return List<PlanFinanciamientoRPC>
     * @throws ServiceBaseException
     */
    public static List<PlanFinanciamientoRPC> getPlanesFinanciamiento(SystemName remoteSystemName, ProductParameter parameter) throws ServiceBaseException {
        return ServicesBaseExecutor.executeCalling(GetPlanesFinanciamiento.class, parameter, remoteSystemName, new StringBuffer());
    }

    /**
     *  Metodo para obtener la lista de Planes del Producto [SIN REFERENCIA en el cotizador] a traves de la invocacion Remota
     * @param remoteSystemName Sistema remoto
     * @param parameter Parametro de entrada
     * @return List<PlanRPC>
     */
    public static List<PlanRPC> getPlanes(SystemName remoteSystemName, ProductParameter parameter) throws ServiceBaseException {
        return ServicesBaseExecutor.executeCalling(GetPlanes.class, parameter, remoteSystemName, new StringBuffer());
    }

    /**
     *  Metodo para obtener la lista de Coberturas Configuradas del Producto [Coberturas en el cotizador] a traves de la invocacion Remota
     * @param remoteSystemName Sistema remoto
     * @param parameter Parametro de entrada
     * @return List<CoberturaRPC>
     */
    public static List<CoberturaRPC> getCoberturas(SystemName remoteSystemName, ProductParameter parameter) throws ServiceBaseException {
        return ServicesBaseExecutor.executeCalling(GetCoberturas.class, parameter, remoteSystemName, new StringBuffer());
    }

    /**
     *  Metodo para obtener la lista de Vigencias Producto [PERIODO DE COBERTURA en el cotizador] a traves de la invocacion Remota
     * @param remoteSystemName Sistema remoto
     * @param parameter Parametro de entrada
     * @return List<VigenciaRPC>
     */
    public static List<VigenciaRPC> getPeriodosCoberturas(SystemName remoteSystemName, ProductParameter parameter) throws ServiceBaseException {
        return ServicesBaseExecutor.executeCalling(GetPeriodosCoberturas.class, parameter, remoteSystemName, new StringBuffer());
    }

    /**
     *  Metodo para obtener la lista de Tarifas [Tarifas en el cotizador(contiene: PLAN o OPCION de PRODUCTO, PERIODO DE PAGO PRIMA)] a traves de la invocacion Remota
     * @param remoteSystemName Sistema remoto
     * @param parameter Parametro de entrada
     * @return List<TarifaRPC>
     */
    public static List<TarifaRPC> getTarifas(SystemName remoteSystemName, TarifaParameter parameter) throws ServiceBaseException {
        return ServicesBaseExecutor.executeCalling(GetTarifas.class, parameter, remoteSystemName, new StringBuffer());
    }

    /**
     *  Metodo para obtener la lista de Requesitos de Asegurabilidad del Producto [EXIGENCIAS MEDICAS en el cotizador] a traves de la invocacion Remota
     * @param remoteSystemName Sistema remoto
     * @param parameter Parametro de entrada
     * @return ExigenciasMedicaRPC
     */
    public static ExigenciasMedicaRPC getExigenciasMedicas (SystemName remoteSystemName, ExigenciasMedicaParameter parameter) throws ServiceBaseException {
        return ServicesBaseExecutor.executeCalling(GetExigenciasMedicas.class, parameter, remoteSystemName, new StringBuffer());
    }

    /**
     *  Metodo para obtener la lista de Edades del Producto a traves de la invocacion Remota
     * @param remoteSystemName Sistema remoto
     * @param parameter Parametro de entrada
     * @return ExigenciasMedicaRPC
     */
    public static EdadProductoRPC getEdadProducto (SystemName remoteSystemName, ProductParameter parameter) throws ServiceBaseException {
        return ServicesBaseExecutor.executeCalling(GetEdadProducto.class, parameter, remoteSystemName, new StringBuffer());
    }

    /**
     * Metodo para obtener la lista de Productos de Vida a traves de la invocacion Remota
     * @param remoteSystemName Sistema remoto
     * @param requestIdOut     Parametro de salida con el Identificador del request
     * @return  List<ProductRPC>
     * @throws ServiceBaseException
     */
    public static List<ProductRPC> getProducts(SystemName remoteSystemName, StringBuffer requestIdOut) throws ServiceBaseException {
        return ServicesBaseExecutor.executeCalling(GetProducts.class, new VoidParameter(), remoteSystemName, requestIdOut);
    }

    /**
     * Metodo para obtener el Producto de Vida a traves de la invocacion Remota
     * @param remoteSystemName Sistema remoto
     * @param parameter Parametro de entrada
     * @param requestIdOut     Parametro de salida con el Identificador del request
     * @return ProductRPC
     * @throws ServiceBaseException
     */
    public static ProductRPC getProduct(SystemName remoteSystemName, ProductParameter parameter, StringBuffer requestIdOut) throws ServiceBaseException {
        return ServicesBaseExecutor.executeCalling(GetProduct.class, parameter, remoteSystemName, requestIdOut);
    }

    /**
     * Metodo para obtener la lista de Planes de Financiamiento [PERIODO DE PAGO en el cotizador] a traves de la invocacion Remota
     * @param remoteSystemName Sistema remoto
     * @param parameter Parametro de entrada
     * @param requestIdOut     Parametro de salida con el Identificador del request
     * @return List<PlanFinanciamientoRPC>
     * @throws ServiceBaseException
     */
    public static List<PlanFinanciamientoRPC> getPlanesFinanciamiento(SystemName remoteSystemName, ProductParameter parameter, StringBuffer requestIdOut) throws ServiceBaseException {
        return ServicesBaseExecutor.executeCalling(GetPlanesFinanciamiento.class, parameter, remoteSystemName, requestIdOut);
    }

    /**
     *  Metodo para obtener la lista de Planes del Producto [SIN REFERENCIA en el cotizador] a traves de la invocacion Remota
     * @param remoteSystemName Sistema remoto
     * @param parameter Parametro de entrada
     * @param requestIdOut     Parametro de salida con el Identificador del request
     * @return List<PlanRPC>
     */
    public static List<PlanRPC> getPlanes(SystemName remoteSystemName, ProductParameter parameter, StringBuffer requestIdOut) throws ServiceBaseException {
        return ServicesBaseExecutor.executeCalling(GetPlanes.class, parameter, remoteSystemName, requestIdOut);
    }

    /**
     *  Metodo para obtener la lista de Coberturas Configuradas del Producto [Coberturas en el cotizador] a traves de la invocacion Remota
     * @param remoteSystemName Sistema remoto
     * @param parameter Parametro de entrada
     * @param requestIdOut     Parametro de salida con el Identificador del request
     * @return List<CoberturaRPC>
     */
    public static List<CoberturaRPC> getCoberturas(SystemName remoteSystemName, ProductParameter parameter, StringBuffer requestIdOut) throws ServiceBaseException {
        return ServicesBaseExecutor.executeCalling(GetCoberturas.class, parameter, remoteSystemName, requestIdOut);
    }

    /**
     *  Metodo para obtener la lista de Vigencias Producto [PERIODO DE COBERTURA en el cotizador] a traves de la invocacion Remota
     * @param remoteSystemName Sistema remoto
     * @param parameter Parametro de entrada
     * @param requestIdOut     Parametro de salida con el Identificador del request
     * @return List<VigenciaRPC>
     */
    public static List<VigenciaRPC> getPeriodosCoberturas(SystemName remoteSystemName, ProductParameter parameter, StringBuffer requestIdOut) throws ServiceBaseException {
        return ServicesBaseExecutor.executeCalling(GetPeriodosCoberturas.class, parameter, remoteSystemName, requestIdOut);
    }

    /**
     *  Metodo para obtener la lista de Tarifas [Tarifas en el cotizador(contiene: PLAN o OPCION de PRODUCTO, PERIODO DE PAGO PRIMA)] a traves de la invocacion Remota
     * @param remoteSystemName Sistema remoto
     * @param parameter Parametro de entrada
     * @param requestIdOut     Parametro de salida con el Identificador del request
     * @return List<TarifaRPC>
     */
    public static List<TarifaRPC> getTarifas(SystemName remoteSystemName, TarifaParameter parameter, StringBuffer requestIdOut) throws ServiceBaseException {
        return ServicesBaseExecutor.executeCalling(GetTarifas.class, parameter, remoteSystemName, requestIdOut);
    }

    /**
     *  Metodo para obtener la lista de Requesitos de Asegurabilidad del Producto [EXIGENCIAS MEDICAS en el cotizador] a traves de la invocacion Remota
     * @param remoteSystemName Sistema remoto
     * @param parameter Parametro de entrada
     * @param requestIdOut     Parametro de salida con el Identificador del request
     * @return ExigenciasMedicaRPC
     */
    public static ExigenciasMedicaRPC getExigenciasMedicas (SystemName remoteSystemName, ExigenciasMedicaParameter parameter, StringBuffer requestIdOut) throws ServiceBaseException {
        return ServicesBaseExecutor.executeCalling(GetExigenciasMedicas.class, parameter, remoteSystemName, requestIdOut);
    }

    /**
     *  Metodo para obtener la lista de Edades del Producto a traves de la invocacion Remota
     * @param remoteSystemName Sistema remoto
     * @param parameter Parametro de entrada
     * @param requestIdOut     Parametro de salida con el Identificador del request
     * @return ExigenciasMedicaRPC
     */
    public static EdadProductoRPC getEdadProducto (SystemName remoteSystemName, ProductParameter parameter, StringBuffer requestIdOut) throws ServiceBaseException {
        return ServicesBaseExecutor.executeCalling(GetEdadProducto.class, parameter, remoteSystemName, requestIdOut);
    }

/****************************** DECLARACION DE CLASES CallerOfProcess *************************************************/

    /**
     * La clase <code>GetProducts</code> es Caller del metodo getProducts del servidor o Maquina Remota
     */
    public static class GetProducts extends CallerOfProcess<GetProducts, VoidParameter, List<ProductRPC>> {
        public GetProducts(VoidParameter parameter) throws Exception {
            super(parameter);
        }
    }

    /**
     * La clase <code>GetProduct</code> es Caller del metodo getProduct del servidor o Maquina Remota
     */
    public static class GetProduct extends CallerOfProcess<GetProduct, ProductParameter, ProductRPC> {
        public GetProduct(ProductParameter parameter) throws Exception { super(parameter); }
    }

    /**
     * La clase <code>GetPlanesFinanciamiento</code> es Caller del metodo getPlanesFinanciamiento del servidor o Maquina Remota
     */
    public static class GetPlanesFinanciamiento extends CallerOfProcess<GetPlanesFinanciamiento, ProductParameter, List<PlanFinanciamientoRPC>> {
        public GetPlanesFinanciamiento(ProductParameter parameter) throws Exception { super(parameter);}
    }

    /**
     * La clase <code>GetPlanes</code> es Caller del metodo getPlanes del servidor o Maquina Remota
     */
    public static class GetPlanes extends CallerOfProcess<GetPlanes, ProductParameter, List<PlanRPC>> {
        public GetPlanes(ProductParameter parameter) throws Exception { super(parameter);}
    }

    /**
     * La clase <code>GetCoberturas</code> es Caller del metodo getCoberturas del servidor o Maquina Remota
     */
    public static class GetCoberturas extends CallerOfProcess<GetCoberturas, ProductParameter, List<CoberturaRPC>>{
        public GetCoberturas(ProductParameter parameter) throws Exception { super(parameter); }
    }

    /**
     * La clase <code>GetPeriodosCoberturas</code> es Caller del metodo getPeriodosCoberturas del servidor o Maquina Remota
     */
    public static class GetPeriodosCoberturas extends CallerOfProcess<GetPeriodosCoberturas, ProductParameter, List<VigenciaRPC>>{
        public GetPeriodosCoberturas(ProductParameter parameter) throws Exception {
            super(parameter);
        }
    }

    /**
     * La clase <code>GetTarifas</code> es Caller del metodo getTarifas del servidor o Maquina Remota
     */
    public static class GetTarifas extends CallerOfProcess<GetTarifas, TarifaParameter, List<TarifaRPC>>{
        public GetTarifas(TarifaParameter parameter) throws Exception {
            super(parameter);
        }
    }

    /**
     * La clase <code>GetExigenciasMedicas</code> es Caller del metodo getExigenciasMedicas del servidor o Maquina Remota
     */
    public static class GetExigenciasMedicas extends CallerOfProcess<GetExigenciasMedicas, ExigenciasMedicaParameter, ExigenciasMedicaRPC>{
        public GetExigenciasMedicas(ExigenciasMedicaParameter parameter) throws Exception {
            super(parameter);
        }
    }

 /**
     * La clase <code>GetExigenciasMedicas</code> es Caller del metodo getExigenciasMedicas del servidor o Maquina Remota
     */
    public static class GetEdadProducto extends CallerOfProcess<GetEdadProducto, ProductParameter, EdadProductoRPC>{
        public GetEdadProducto(ProductParameter parameter) throws Exception {
            super(parameter);
        }
    }

}
