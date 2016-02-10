package com.consisint.acsele.interseguro.interfaces.mobilityRPC.services.persister;

import com.consisint.acsele.interseguro.interfaces.mobilityRPC.services.persister.memory.ServiceFactoryRegisterMemPersister;
import com.enroquesw.mcs.comm.mobilityRPC.services.factory.CallerRegister;
import com.enroquesw.mcs.comm.mobilityRPC.services.factory.ProcessorRegister;

import java.util.List;

/**
 * Persistidor de los Registros de Servicios o ServiceFactoryRegister
 */
public interface ServiceFactoryRegisterPersister {
    String PROP_CLASS_NAME = "className.ServiceFactoryRegister";
    List<ProcessorRegister> getProcessorRegisters();
    List<CallerRegister> getCallerRegisters();
    class Impl{
        private static ServiceFactoryRegisterPersister instance;
        public static ServiceFactoryRegisterPersister getInstance(){
            String className = System.getProperty(PROP_CLASS_NAME);
            className = (className != null && className.length() > 0)? className : ServiceFactoryRegisterMemPersister.class.getName();
            try {
                instance = (ServiceFactoryRegisterPersister) Class.forName(className).newInstance();
            } catch (Exception e) {
                instance = new ServiceFactoryRegisterMemPersister();
            }
            return instance;
        }
    }
}
