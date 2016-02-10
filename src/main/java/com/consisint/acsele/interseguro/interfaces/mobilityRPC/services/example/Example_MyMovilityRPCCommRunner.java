package com.consisint.acsele.interseguro.interfaces.mobilityRPC.services.example;

import com.consisint.acsele.interseguro.interfaces.mobilityRPC.services.persister.ServiceFactoryRegisterPersister;
import com.enroquesw.mcs.comm.mobilityRPC.MyMovilityRPCComm;
import com.enroquesw.mcs.comm.mobilityRPC.enums.SystemName;
import com.enroquesw.mcs.comm.mobilityRPC.server.MyMovilityRPCCommRunner;
import com.enroquesw.mcs.comm.mobilityRPC.services.factory.CallerRegister;
import com.enroquesw.mcs.comm.mobilityRPC.services.factory.ProcessorRegister;
import com.googlecode.mobilityrpc.network.ConnectionId;
import com.googlecode.mobilityrpc.quickstart.EmbeddedMobilityServer;

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
        boolean isDebugEnabled = true;  // si se desea habilitar los log a nivel de debug para la libreria
        SystemName serverSystemName = SystemName.COTIZADOR;     // Nombre de Sistema que identifica a la Maquina Local
        /****************************************************/
        System.setProperty(ServiceFactoryRegisterPersister.PROP_CLASS_NAME,"com.consisint.acsele.interseguro.interfaces.mobilityRPC.services.persister.memory.ServiceFactoryRegisterMemPersister"); // Fijando esta propiedad se puede extender a la interfaz e implementar la forma de extraer los registros [si existe alguna excepcion al tratar de cargar la clase aqui definida el persistidor cargara la instancia por defecto ServiceFactoryRegisterMemPersister.java] - esta propiedad la utiliza el ServiceFactoryRegisterPersister para identificar la instancia de la clase que se desea cargar.
        ServiceFactoryRegisterPersister instance = ServiceFactoryRegisterPersister.Impl.getInstance();
        List<ProcessorRegister> processorRegisters = instance.getProcessorRegisters();  // Aqui se cargan los x defecto los desarrollados por Acsele Si se requiere agregar processors adicionales --> processorRegisters.add(new ProcessorRegister(....)) [ver: ServiceFactoryRegisterPersister.java]
        List<CallerRegister> callerRegisters = instance.getCallerRegisters(); // Aqui se cargan los x defecto los desarrollados por Acsele Si se requiere agregar processors adicionales --> processorRegisters.add(new ProcessorRegister(....)) [ver: ServiceFactoryRegisterPersister.java]
        /****************************************************/
        try {
            MyMovilityRPCCommRunner.startMyMovilityRPCCommRunner(hostIp, hostPort, mapClients, isDebugEnabled, serverSystemName, processorRegisters, callerRegisters);
            while(!MyMovilityRPCComm.isServerRunning()) MyMovilityRPCComm.sleep(1); // Esperamos x que inicie el servidor [opcional]
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Map<String, ConnectionId> getMapClients() {
        Map<String, ConnectionId> clients = new Hashtable<String, ConnectionId>();
        // Aqui se setean todos los sitemas clientes con sus ip y puertos
        clients.put(SystemName.ACSELE.getSystemName(), new ConnectionId("127.0.0.1", EmbeddedMobilityServer.DEFAULT_PORT));
        return clients;
    }
}
