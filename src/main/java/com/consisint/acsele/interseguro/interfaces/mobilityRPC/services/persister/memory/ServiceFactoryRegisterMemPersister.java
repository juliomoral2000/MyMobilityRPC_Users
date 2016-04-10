package com.consisint.acsele.interseguro.interfaces.mobilityRPC.services.persister.memory;

import com.consisint.acsele.interseguro.interfaces.mobilityRPC.services.beans.*;
import com.consisint.acsele.interseguro.interfaces.mobilityRPC.services.client.caller.Product_Callers;
import com.consisint.acsele.interseguro.interfaces.mobilityRPC.services.client.caller.Property_Callers;
import com.consisint.acsele.interseguro.interfaces.mobilityRPC.services.client.caller.Quotation_Callers;
import com.consisint.acsele.interseguro.interfaces.mobilityRPC.services.params.*;
import com.consisint.acsele.interseguro.interfaces.mobilityRPC.services.persister.ServiceFactoryRegisterPersister;
import com.consisint.acsele.interseguro.interfaces.mobilityRPC.services.server.processor.EventNotification_Processors;
import com.enroquesw.mcs.comm.mobilityRPC.enums.SystemName;
import com.enroquesw.mcs.comm.mobilityRPC.services.factory.CallerRegister;
import com.enroquesw.mcs.comm.mobilityRPC.services.factory.ProcessorRegister;
import com.enroquesw.mcs.comm.mobilityRPC.services.parameter.VoidParameter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Julio on 25/01/2016.
 */
public class ServiceFactoryRegisterMemPersister implements ServiceFactoryRegisterPersister {
    @Override
    public List<ProcessorRegister> getProcessorRegisters() {
        List<ProcessorRegister> list = new ArrayList<ProcessorRegister>();
        try {
            list.add(new ProcessorRegister( SystemName.ACSELE,SystemName.COTIZADOR, "processEventNotification", EventNotification_Processors.class, EventNotificationQuotationParameter.class, EventNotificationResponseRPC.class)); // 07/04/2016
        } catch (Exception e) {
            list = null;
        }
        /*list.add(new ProcessorRegister( SystemName.getById(Integer.parseInt(o.getProperty("SYSNM_ID_CALLER"))), SystemName.getById(Integer.parseInt(o.getProperty("SYSNM_ID_PROCESSOR"))), o.getProperty("METHOD_NAME"), Class.forName(o.getProperty("PROCESSOR_CLASS")), Class.forName(o.getProperty("PARAMETER_CLASS")), Class.forName(o.getProperty("RESULT_CLASS"))
        ));*/
        return list;
    }

    @Override
    public List<CallerRegister> getCallerRegisters() {
        List<CallerRegister> list = new ArrayList<CallerRegister>();
        list.add(new CallerRegister(SystemName.COTIZADOR, SystemName.ACSELE, "getProducts", "Product_Processors", VoidParameter.class, List.class, Product_Callers.GetProducts.class));
        list.add(new CallerRegister(SystemName.COTIZADOR, SystemName.ACSELE, "getProduct", "Product_Processors", ProductParameter.class, ProductRPC.class, Product_Callers.GetProduct.class));
        list.add(new CallerRegister(SystemName.COTIZADOR, SystemName.ACSELE, "getPropertyValues", "Property_Processors", PropertyParameter.class, PropertyValuesRPC.class, Property_Callers.GetPropertyValues.class));
        list.add(new CallerRegister(SystemName.COTIZADOR, SystemName.ACSELE, "getPlanesFinanciamiento", "Product_Processors", ProductParameter.class, List.class, Product_Callers.GetPlanesFinanciamiento.class));
        list.add(new CallerRegister(SystemName.COTIZADOR, SystemName.ACSELE, "getPlanes", "Product_Processors", ProductParameter.class, List.class, Product_Callers.GetPlanes.class));
        list.add(new CallerRegister(SystemName.COTIZADOR, SystemName.ACSELE, "getCoberturas", "Product_Processors", ProductParameter.class, List.class, Product_Callers.GetCoberturas.class));
        list.add(new CallerRegister(SystemName.COTIZADOR, SystemName.ACSELE, "getPeriodosCoberturas", "Product_Processors", ProductParameter.class, List.class, Product_Callers.GetPeriodosCoberturas.class));
        list.add(new CallerRegister(SystemName.COTIZADOR, SystemName.ACSELE, "getTarifas", "Product_Processors", TarifaParameter.class, List.class, Product_Callers.GetTarifas.class));
        list.add(new CallerRegister(SystemName.COTIZADOR, SystemName.ACSELE, "getEdadActuarial", "Quotation_Processors", ActuarialAgeParameter.class, Integer.class, Quotation_Callers.GetEdadActuarial.class));    //  10/03/2016
        list.add(new CallerRegister(SystemName.COTIZADOR, SystemName.ACSELE, "getExigenciasMedicas", "Product_Processors", ExigenciasMedicaParameter.class, ExigenciasMedicaRPC.class, Product_Callers.GetExigenciasMedicas.class));    //  10/03/2016
        list.add(new CallerRegister(SystemName.COTIZADOR, SystemName.ACSELE, "getCumulusTercero", "Quotation_Processors", CumulusTerceroParameter.class, CumulusTerceroRPC.class, Quotation_Callers.GetCumulusTercero.class)); //14/03/2016
        list.add(new CallerRegister(SystemName.COTIZADOR, SystemName.ACSELE, "calcularCotizacion", "Quotation_Processors", CotizacionParameter.class, CotizacionRPC.class, Quotation_Callers.CalcularCotizacion.class)); // 08/04/2016
        return list;
    }
}
