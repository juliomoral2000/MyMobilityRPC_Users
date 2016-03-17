package com.consisint.acsele.interseguro.interfaces.mobilityRPC.services.beans;

import java.util.Map;

/**
 * La clase <code>CumulusTerceroRPC</code> representa el wrapper del cumulus del Tercero
 * de Acsele para los servicios del MobilityRPC.
 */
public class CumulusTerceroRPC {
    long idTercero;
    Map<Long, Double> montos;   // Id de Moneda, Monto cumulus

    public CumulusTerceroRPC(long idTercero, Map<Long, Double> montos) {
        this.idTercero = idTercero;
        this.montos = montos;
    }

    public long getIdTercero() {
        return idTercero;
    }

    public Map<Long, Double> getMontos() {
        return montos;
    }

    @Override
    public String toString() {
        StringBuilder out = new StringBuilder("CumulusTerceroRPC{").append("idTercero=").append( idTercero);
        if(!montos.isEmpty()){
            out.append(", Cumulus:\n{");
            for (Map.Entry<Long, Double> entry : montos.entrySet()) {
                out.append("idMoneda=").append(entry.getKey()).append(", monto=").append(entry.getValue());
            }
            out.append("}\n");
        }
        return out.toString();
    }
}
