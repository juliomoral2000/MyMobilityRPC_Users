package com.consisint.acsele.interseguro.interfaces.mobilityRPC.services.server.processor;

import com.consisint.acsele.interseguro.interfaces.mobilityRPC.services.beans.EventNotificationResponseRPC;
import com.consisint.acsele.interseguro.interfaces.mobilityRPC.services.params.EventNotificationQuotationParameter;
import com.enroquesw.mcs.comm.mobilityRPC.enums.SystemName;
import com.enroquesw.mcs.comm.mobilityRPC.services.exception.ServiceBaseException;
import com.enroquesw.mcs.comm.mobilityRPC.services.parameter.ProcessParameter;
import com.enroquesw.mcs.comm.mobilityRPC.services.processor.CallProcessor;
import com.enroquesw.mcs.comm.mobilityRPC.services.processor.ExternalCallProcessor;

/**
 * Created by Julio on 06/04/2016.
 */
public class EventNotification_Processors extends CallProcessor<EventNotification_Processors, ProcessParameter, Object, ExternalCallProcessor> {
    /*public static void preProcessCall(){ }*/
    /*public static void postProcessCall(){ }*/

    public static EventNotificationResponseRPC processEventNotification(EventNotificationQuotationParameter parameter) throws ServiceBaseException {
        return invokeExternalProcessor(SystemName.ACSELE, EventNotification_Processors.class, "processEventNotification", parameter);
    }

}
