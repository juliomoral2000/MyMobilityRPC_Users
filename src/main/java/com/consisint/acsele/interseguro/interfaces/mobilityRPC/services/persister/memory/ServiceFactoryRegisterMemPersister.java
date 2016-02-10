package com.consisint.acsele.interseguro.interfaces.mobilityRPC.services.persister.memory;

import com.consisint.acsele.interseguro.interfaces.mobilityRPC.services.beans.ProductRPC;
import com.consisint.acsele.interseguro.interfaces.mobilityRPC.services.beans.PropertyValuesRPC;
import com.consisint.acsele.interseguro.interfaces.mobilityRPC.services.client.caller.Product_Callers;
import com.consisint.acsele.interseguro.interfaces.mobilityRPC.services.client.caller.Property_Callers;
import com.consisint.acsele.interseguro.interfaces.mobilityRPC.services.params.ProductParameter;
import com.consisint.acsele.interseguro.interfaces.mobilityRPC.services.params.PropertyParameter;
import com.consisint.acsele.interseguro.interfaces.mobilityRPC.services.persister.ServiceFactoryRegisterPersister;
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
        /*list.add(new ProcessorRegister(
                SystemName.getById(Integer.parseInt(o.getProperty("SYSNM_ID_CALLER"))),
                SystemName.getById(Integer.parseInt(o.getProperty("SYSNM_ID_PROCESSOR"))),
                o.getProperty("METHOD_NAME"),
                Class.forName(o.getProperty("PROCESSOR_CLASS")),
                Class.forName(o.getProperty("PARAMETER_CLASS")),
                Class.forName(o.getProperty("RESULT_CLASS"))
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


        return list;


    }
}
