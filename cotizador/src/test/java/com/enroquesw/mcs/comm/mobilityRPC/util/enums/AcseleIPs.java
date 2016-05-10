package com.enroquesw.mcs.comm.mobilityRPC.util.enums;

import com.googlecode.mobilityrpc.quickstart.EmbeddedMobilityServer;

/**
 * <code>AcseleIPs</code> enumera las ips opcionales segun el contexto donde se ejecute las pruebas
 */
public enum AcseleIPs {
    LOCAL("127.0.0.1", EmbeddedMobilityServer.DEFAULT_PORT), DESA("130.30.11.9", EmbeddedMobilityServer.DEFAULT_PORT);
    String ip;
    int port;

    AcseleIPs(String ip, int port) {
        this.ip = ip;
        this.port = port;
    }

    public String getIp() { return ip; }

    public int getPort() { return port; }

    public static AcseleIPs getByName(String name){
        for (AcseleIPs o : values()) {
            if(o.name().equals(name)) return o;
        }
        return AcseleIPs.LOCAL;
    }
}
