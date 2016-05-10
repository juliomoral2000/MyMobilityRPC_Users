package com.consisint.acsele.interseguro.interfaces.mobilityRPC.services.server.processor;

import com.consisint.acsele.interseguro.interfaces.mobilityRPC.services.beans.EventNotificacionRPC;
import com.consisint.acsele.interseguro.interfaces.mobilityRPC.services.beans.EventNotificationResponseRPC;
import com.enroquesw.mcs.comm.mobilityRPC.enums.SystemName;
import com.enroquesw.mcs.comm.mobilityRPC.services.exception.ServiceBaseException;
import com.enroquesw.mcs.comm.mobilityRPC.services.parameter.ProcessParameter;
import com.enroquesw.mcs.comm.mobilityRPC.services.processor.CallProcessor;
import com.enroquesw.mcs.comm.mobilityRPC.services.processor.ExternalCallProcessor;

/**
 * La clase <code>EventNotification_Processors</code> es el procesor
 * de la libreria por defecto para procesar las notificaciones de Eventos enviadas desde el Acsele
 */
public class EventNotification_Processors extends CallProcessor<EventNotification_Processors, ProcessParameter, Object, ExternalCallProcessor> {
    /*public static void preProcessCall(){ }*/
    /*public static void postProcessCall(){ }*/

    public static EventNotificationResponseRPC processEventNotification(EventNotificacionRPC parameter) throws ServiceBaseException {
        return invokeExternalProcessor(SystemName.ACSELE, EventNotification_Processors.class, "processEventNotification", parameter);
    }

}
