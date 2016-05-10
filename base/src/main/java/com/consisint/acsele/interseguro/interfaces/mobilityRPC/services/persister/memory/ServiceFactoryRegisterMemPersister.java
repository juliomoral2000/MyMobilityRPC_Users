package com.consisint.acsele.interseguro.interfaces.mobilityRPC.services.persister.memory;

import com.consisint.acsele.interseguro.interfaces.mobilityRPC.services.persister.ServiceFactoryRegisterPersister;
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
        return list;
    }

    @Override
    public List<CallerRegister> getCallerRegisters() {
        List<CallerRegister> list = new ArrayList<CallerRegister>();
        return list;
    }
}
