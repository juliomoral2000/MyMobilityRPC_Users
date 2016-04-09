package com.consisint.acsele.interseguro.interfaces.mobilityRPC.services.example.externo;

import com.consisint.acsele.interseguro.interfaces.mobilityRPC.services.beans.EventNotificationResponseRPC;
import com.consisint.acsele.interseguro.interfaces.mobilityRPC.services.params.EventNotificationQuotationParameter;
import com.consisint.acsele.interseguro.interfaces.mobilityRPC.services.server.processor.EventNotification_Processors;
import com.enroquesw.mcs.comm.mobilityRPC.services.exception.ServiceBaseException;
import com.enroquesw.mcs.comm.mobilityRPC.services.processor.ExternalCallProcessor;

/**
 * Created by Julio on 07/04/2016.
 */
public class TestProcessorExterno implements ExternalCallProcessor<EventNotification_Processors, EventNotificationQuotationParameter, EventNotificationResponseRPC>{

    @Override
    public EventNotificationResponseRPC processCall(EventNotificationQuotationParameter parameter) throws ServiceBaseException {
        System.out.println(parameter.toString());
        return new EventNotificationResponseRPC(true);
    }

}
