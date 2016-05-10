package com.consisint.acsele.interseguro.interfaces.mobilityRPC.services.example.externo;

import com.consisint.acsele.interseguro.interfaces.mobilityRPC.services.beans.EventNotificacionRPC;
import com.consisint.acsele.interseguro.interfaces.mobilityRPC.services.beans.EventNotificationResponseRPC;
import com.consisint.acsele.interseguro.interfaces.mobilityRPC.services.server.processor.EventNotification_Processors;
import com.enroquesw.mcs.comm.mobilityRPC.enums.SystemName;
import com.enroquesw.mcs.comm.mobilityRPC.services.exception.ServiceBaseException;
import com.enroquesw.mcs.comm.mobilityRPC.services.factory.ProcessorRegister;
import com.enroquesw.mcs.comm.mobilityRPC.services.factory.ServicesFactory;
import com.enroquesw.mcs.comm.mobilityRPC.services.processor.ExternalCallProcessor;

import java.util.List;

/**
 * La clase <code>TestProcessorExterno</code> es una clase de Pruebas
 */
public class TestProcessorExterno implements ExternalCallProcessor<EventNotification_Processors, EventNotificacionRPC, EventNotificationResponseRPC>{

    @Override
    public EventNotificationResponseRPC processCall(EventNotificacionRPC parameter) throws ServiceBaseException {
        System.out.println(parameter.toString());
        return new EventNotificationResponseRPC(true);
    }

    /**
     * Este metodo Invocarlo luego de Iniciado el Servidor
     */
    @SuppressWarnings("unchecked")
    public static void setExternalProcessor() {
        List<ProcessorRegister> list = ServicesFactory.getProcessorRegister(SystemName.ACSELE, EventNotification_Processors.class, "processEventNotification");
        if(!list.isEmpty()) list.get(0).setExternalCallProcessor(new TestProcessorExterno());
    }
}
