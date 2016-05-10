package com.consisint.acsele.interseguro.interfaces.mobilityRPC.services.persister.memory;

import com.consisint.acsele.interseguro.interfaces.mobilityRPC.services.beans.EventNotificacionRPC;
import com.consisint.acsele.interseguro.interfaces.mobilityRPC.services.beans.EventNotificationResponseRPC;
import com.consisint.acsele.interseguro.interfaces.mobilityRPC.services.persister.ServiceFactoryRegisterPersister;
import com.consisint.acsele.interseguro.interfaces.mobilityRPC.services.server.processor.EventNotification_Processors;
import com.enroquesw.mcs.comm.mobilityRPC.enums.SystemName;
import com.enroquesw.mcs.comm.mobilityRPC.services.factory.CallerRegister;
import com.enroquesw.mcs.comm.mobilityRPC.services.factory.ProcessorRegister;

import java.util.ArrayList;
import java.util.List;

/**
 * La clase <code>ServiceFactoryRegisterMemPersister</code>
 */
public class ServiceFactoryRegisterMemPersister implements ServiceFactoryRegisterPersister {
    @Override
    public List<ProcessorRegister> getProcessorRegisters() {
        List<ProcessorRegister> list = new ArrayList<ProcessorRegister>();
        try {
            list.add(new ProcessorRegister(SystemName.ACSELE, SystemName.SAPN, "processEventNotification", EventNotification_Processors.class, EventNotificacionRPC.class, EventNotificationResponseRPC.class)); // 09/05/2016
        } catch (Exception e) {
            list = null;
        }
        return list;
    }

    @Override
    public List<CallerRegister> getCallerRegisters() {
        List<CallerRegister> list = new ArrayList<CallerRegister>();
        return list;
    }
}
