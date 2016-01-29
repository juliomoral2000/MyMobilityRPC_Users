package com.consisint.acsele.interseguro.interfaces.mobilityRPC.services.persister;

import com.consisint.acsele.interseguro.interfaces.mobilityRPC.services.persister.memory.ServiceFactoryRegisterMemPersister;
import com.enroquesw.mcs.comm.mobilityRPC.services.factory.CallerRegister;
import com.enroquesw.mcs.comm.mobilityRPC.services.factory.ProcessorRegister;

import java.util.List;

/**
 * Created by Julio on 25/01/2016.
 */
public interface ServiceFactoryRegisterPersister {
    List<ProcessorRegister> getProcessorRegisters();
    List<CallerRegister> getCallerRegisters();
    public static class Impl{
        private static ServiceFactoryRegisterPersister instance;
        public static ServiceFactoryRegisterPersister getInstance(){
            return instance == null? new ServiceFactoryRegisterMemPersister(): instance;
        }
    }
}
