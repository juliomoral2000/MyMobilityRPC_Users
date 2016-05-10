package com.enroquesw.mcs.comm.mobilityRPC;


import com.consisint.acsele.interseguro.interfaces.mobilityRPC.services.example.externo.TestProcessorExterno;
import com.consisint.acsele.interseguro.interfaces.mobilityRPC.services.persister.ServiceFactoryRegisterPersister;
import com.consisint.acsele.interseguro.interfaces.mobilityRPC.services.server.processor.EventNotification_Processors;
import com.enroquesw.mcs.comm.mobilityRPC.enums.SystemName;
import com.enroquesw.mcs.comm.mobilityRPC.services.factory.CallerRegister;
import com.enroquesw.mcs.comm.mobilityRPC.services.factory.ProcessorRegister;
import com.enroquesw.mcs.comm.mobilityRPC.services.factory.ServicesFactory;
import com.enroquesw.mcs.comm.mobilityRPC.util.enums.AcseleIPs;
import com.googlecode.mobilityrpc.network.ConnectionId;

import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

/**
 * <code>SetUpBase</code> super clase para setear el contexto de las pruebas unitarias
 */
public class SetUpBase {
    protected final Logger log = Logger.getLogger(getClass().getName());
    protected String hostIp;
    protected Integer hostPort;
    protected Map<String, ConnectionId> mapClients = new Hashtable<String, ConnectionId>();
    protected boolean isDebugEnabled;
    protected SystemName serverSystemName;
    protected List<ProcessorRegister> processorRegisters;
    protected List<CallerRegister> callerRegisters;

    public void setUp() throws Exception {
        /****************************************************/
        hostIp = "127.0.0.1";
        hostPort = 5749;
        mapClients = getMapClients();
        isDebugEnabled = true;
        serverSystemName = SystemName.COTIZADOR;
        /****************************************************/
    }

    public static Map<String, ConnectionId> getMapClients() {
        AcseleIPs ipByName = AcseleIPs.getByName(System.getProperty("acsele.ip"));
        Map<String, ConnectionId> clients = new Hashtable<String, ConnectionId>();
        clients.put(SystemName.ACSELE.getSystemName(), new ConnectionId(ipByName.getIp(), ipByName.getPort()));
        return clients;
    }

    public void tearDown() throws Exception {
        if(MyMovilityRPCComm.isServerRunning()) MyMovilityRPCComm.destroy();
    }

    public void setServiceFactoryRegister() throws Exception {
        /******************************************************/
        /** Test de setear la implementacion personalizada del ServiceFactoryRegister :
         System.setProperty(ServiceFactoryRegisterPersister.PROP_CLASS_NAME,"com.consisint.acsele.interseguro.interfaces.mobilityRPC.services.persister.memory.ServiceFactoryRegisterMemPersister_2"); // Con este ejemplo podria extender a la interfaz e implementar la forma de extraer los registros - esta propiedad la utiliza el ServiceFactoryRegisterPersister para identificar la instancia de la clase que se desea cargar. */
        /******************************************************/
        ServiceFactoryRegisterPersister instance = ServiceFactoryRegisterPersister.Impl.getInstance();
        processorRegisters = instance.getProcessorRegisters();
        callerRegisters = instance.getCallerRegisters();
        /****************************************************/
        /*MyMovilityRPCCommRunner.startMyMovilityRPCCommRunner(hostIp, hostPort, mapClients, isDebugEnabled, serverSystemName, processorRegisters, callerRegisters);*/

    }

    /**
     * FIXME_JULIO: esto como ejemplo para los chicos del Cotizador
     */
    public static void setExternalProcessor() {
        List<ProcessorRegister> list = ServicesFactory.getProcessorRegister(SystemName.ACSELE, EventNotification_Processors.class, "processEventNotification");
        if(!list.isEmpty()) list.get(0).setExternalCallProcessor(new TestProcessorExterno());
    }
}
