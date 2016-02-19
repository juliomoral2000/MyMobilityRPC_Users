package com.enroquesw.mcs.comm.mobilityRPC;

import com.enroquesw.mcs.comm.mobilityRPC.enums.SystemName;
import com.enroquesw.mcs.comm.mobilityRPC.util.enums.AcseleIPs;
import com.googlecode.mobilityrpc.network.ConnectionId;
import com.googlecode.mobilityrpc.quickstart.EmbeddedMobilityServer;

import java.util.Hashtable;
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
        clients.put(SystemName.ACSELE.getSystemName(), new ConnectionId(ipByName.getIp(), EmbeddedMobilityServer.DEFAULT_PORT));
        return clients;
    }

    public void tearDown() throws Exception {
        if(MyMovilityRPCComm.isServerRunning()) MyMovilityRPCComm.destroy();
    }
}
