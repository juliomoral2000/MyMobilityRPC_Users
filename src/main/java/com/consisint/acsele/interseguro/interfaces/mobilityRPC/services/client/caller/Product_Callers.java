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
    /**
     * Retorna la lista de Productos
     * @param remoteSystemName
     * @return
     * @throws Exception
     */
    public static List<ProductRPC> getProducts(SystemName remoteSystemName) throws ServiceBaseException {
        return ServicesBaseExecutor.executeCalling(GetProducts.class, new VoidParameter(), remoteSystemName);
    }
    public static ProductRPC getProduct(SystemName remoteSystemName, ProductParameter parameter) throws ServiceBaseException {
        return ServicesBaseExecutor.executeCalling(GetProduct.class, parameter, remoteSystemName);
    }

    public static List<PlanFinanciamientoRPC> getPlanesFinanciamiento(SystemName remoteSystemName, ProductParameter parameter) throws ServiceBaseException {
        return ServicesBaseExecutor.executeCalling(GetPlanesFinanciamiento.class, parameter, remoteSystemName);
    }

    public static List<PlanRPC> getPlanes(SystemName remoteSystemName, ProductParameter parameter) {
        return ServicesBaseExecutor.executeCalling(GetPlanes.class, parameter, remoteSystemName);
    }

    public static List<CoberturaRPC> getCoberturas(SystemName remoteSystemName, ProductParameter parameter) {
        return ServicesBaseExecutor.executeCalling(GetCoberturas.class, parameter, remoteSystemName);
    }

    public static List<VigenciaRPC> getPeriodosCoberturas(SystemName remoteSystemName, ProductParameter parameter) {
        return ServicesBaseExecutor.executeCalling(GetPeriodosCoberturas.class, parameter, remoteSystemName);
    }

    public static List<TarifaRPC> getTarifas(SystemName remoteSystemName, TarifaParameter parameter) {
        try {
            List<TarifaRPC> tarifaRPCs = ServicesBaseExecutor.executeCalling(GetTarifas.class, parameter, remoteSystemName);
            return tarifaRPCs;
        } catch (ServiceBaseException e) {
            throw e;
        }
    }

    public static ExigenciasMedicaRPC getExigenciasMedicas (SystemName remoteSystemName, ExigenciasMedicaParameter parameter) {
        try {
            ExigenciasMedicaRPC exigenciaMedicaRPC = ServicesBaseExecutor.executeCalling(GetExigenciasMedicas.class, parameter, remoteSystemName);
            return exigenciaMedicaRPC;
        } catch (ServiceBaseException e) {
            throw e;
        }
    }

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

}
