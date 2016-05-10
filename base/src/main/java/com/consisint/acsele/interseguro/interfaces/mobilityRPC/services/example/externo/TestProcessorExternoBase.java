package com.consisint.acsele.interseguro.interfaces.mobilityRPC.services.example.externo;

/**
 * La clase <code>TestProcessorExternoBase</code> es una clase de Pruebas
 */
public class TestProcessorExternoBase /* implements ExternalCallProcessor<EventNotification_Processors, EventNotificationQuotationParameter, EventNotificationResponseRPC>*/{

    /*@Override
    public EventNotificationResponseRPC processCall(EventNotificationQuotationParameter parameter) throws ServiceBaseException {
        System.out.println(parameter.toString());
        return new EventNotificationResponseRPC(true);
    }

    *//**
     * Este metodo Invocarlo luego de Iniciado el Servidor
     *//*
    @SuppressWarnings("unchecked")
    public static void setExternalProcessor() {
        List<ProcessorRegister> list = ServicesFactory.getProcessorRegister(SystemName.ACSELE, EventNotification_Processors.class, "processEventNotification");
        if(!list.isEmpty()) list.get(0).setExternalCallProcessor(new TestProcessorExternoBase());
    }*/
}
