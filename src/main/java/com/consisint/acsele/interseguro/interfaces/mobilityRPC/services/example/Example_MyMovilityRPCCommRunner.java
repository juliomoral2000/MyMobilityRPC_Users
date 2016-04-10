package com.consisint.acsele.interseguro.interfaces.mobilityRPC.services.example;

import com.consisint.acsele.interseguro.interfaces.mobilityRPC.services.example.externo.TestProcessorExterno;
import com.consisint.acsele.interseguro.interfaces.mobilityRPC.services.persister.ServiceFactoryRegisterPersister;
import com.consisint.acsele.interseguro.interfaces.mobilityRPC.services.server.processor.EventNotification_Processors;
import com.enroquesw.mcs.comm.mobilityRPC.MyMovilityRPCComm;
import com.enroquesw.mcs.comm.mobilityRPC.enums.SystemName;
import com.enroquesw.mcs.comm.mobilityRPC.server.MyMovilityRPCCommRunner;
import com.enroquesw.mcs.comm.mobilityRPC.services.factory.CallerRegister;
import com.enroquesw.mcs.comm.mobilityRPC.services.factory.ProcessorRegister;
import com.enroquesw.mcs.comm.mobilityRPC.services.factory.ServicesFactory;
import com.enroquesw.mcs.comm.mobilityRPC.services.processor.ExternalCallProcessor;
import com.googlecode.mobilityrpc.network.ConnectionId;
import com.googlecode.mobilityrpc.quickstart.EmbeddedMobilityServer;

import java.util.Arrays;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

/**
 * Clase de ejemplo de como fijar el Servidor MyMovilityRPC y iniciarlo
 */
public class Example_MyMovilityRPCCommRunner {
    public static void main(String[] args) {
        /**
         * El siguiente Procedimiento podria ser invocado en un metodo contextInitialized() de una implementacion
         * de ServletContextListener en la aplicacion Web cliente
         */
        /****************************************************/
        String hostIp = "127.0.0.1";    // LocalIp o null para tomar todas las interfaces de red de la maquina a utilizar para el servidor
        Integer hostPort = 5749;        // LocalPort o null para tomar el puerto por defecto a utilizar para el servidor
        Map<String, ConnectionId> mapClients = getMapClients();
        //boolean isDebugEnabled = true;  // si se desea habilitar los log a nivel de debug para la libreria
        SystemName serverSystemName = SystemName.COTIZADOR;     // Nombre de Sistema que identifica a la Maquina Local
        /****************************************************/
        System.setProperty(ServiceFactoryRegisterPersister.PROP_CLASS_NAME,"com.consisint.acsele.interseguro.interfaces.mobilityRPC.services.persister.memory.ServiceFactoryRegisterMemPersister"); // Fijando esta propiedad se puede extender a la interfaz e implementar la forma de extraer los registros [si existe alguna excepcion al tratar de cargar la clase aqui definida el persistidor cargara la instancia por defecto ServiceFactoryRegisterMemPersister.java] - esta propiedad la utiliza el ServiceFactoryRegisterPersister para identificar la instancia de la clase que se desea cargar.
        ServiceFactoryRegisterPersister instance = ServiceFactoryRegisterPersister.Impl.getInstance();
        List<ProcessorRegister> processorRegisters = instance.getProcessorRegisters();  // Aqui se cargan los x defecto los desarrollados por Acsele Si se requiere agregar processors adicionales --> processorRegisters.add(new ProcessorRegister(....)) [ver: ServiceFactoryRegisterPersister.java]
        List<CallerRegister> callerRegisters = instance.getCallerRegisters(); // Aqui se cargan los x defecto los desarrollados por Acsele Si se requiere agregar processors adicionales --> processorRegisters.add(new ProcessorRegister(....)) [ver: ServiceFactoryRegisterPersister.java]
        /****************************************************/
        try {
            MyMovilityRPCCommRunner.startMyMovilityRPCCommRunner(hostIp, hostPort, mapClients, true, serverSystemName, processorRegisters, callerRegisters);
            while(!MyMovilityRPCCommRunner.isRun){
                MyMovilityRPCComm.sleep(1);
                if(MyMovilityRPCCommRunner.isFail) throw new Exception("Fallo el arranque del Servidor:\n"+Arrays.asList(MyMovilityRPCCommRunner.errors.values().toArray()).toString().replaceAll("(^\\[|\\]$)", "").replace(", ", ","));
            }
            setExternalProcessor(); // Seteamos a los Processors externos
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * En este Metodo se setean todos los sistemas clientes con sus ip y puertos
     * @return Map
     */
    public static Map<String, ConnectionId> getMapClients() {
        Map<String, ConnectionId> clients = new Hashtable<String, ConnectionId>();
        // Aqui se setean todos los sistemas clientes con sus ip y puertos
        clients.put(SystemName.ACSELE.getSystemName(), new ConnectionId("127.0.0.1", EmbeddedMobilityServer.DEFAULT_PORT));
        return clients;
    }

    /**
     *  En este metodo Seteamos a los Processors externos
     */
    @SuppressWarnings("unchecked")
    public static <Z extends ExternalCallProcessor> void setExternalProcessor() {
        List<ProcessorRegister> list = ServicesFactory.getProcessorRegister(SystemName.ACSELE, EventNotification_Processors.class, "processEventNotification");
        if(!list.isEmpty()){
            list.get(0).setExternalCallProcessor(new TestProcessorExterno());
        }
    }
}
