package com.enroquesw.mcs.comm.mobilityRPC.util.enums;

/**
 * <code>AcseleIPs</code> enumera las ips opcionales segun el contexto donde se ejecute las pruebas
 */
public enum AcseleIPs {
    LOCAL("127.0.0.1"), DESA("130.30.11.82");
    String ip;

    AcseleIPs(String ip) {
        this.ip = ip;
    }

    public String getIp() {
        return ip;
    }

    public static AcseleIPs getByName(String name){
        for (AcseleIPs o : values()) {
            if(o.name().equals(name)) return o;
        }
        return AcseleIPs.LOCAL;
    }
}
