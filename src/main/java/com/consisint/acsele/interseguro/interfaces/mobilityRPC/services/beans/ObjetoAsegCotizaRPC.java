package com.consisint.acsele.interseguro.interfaces.mobilityRPC.services.beans;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Julio on 01/04/2016.
 */
public class ObjetoAsegCotizaRPC {
    int numOA;                      // Numero de Objeto Asegurado
    AseguradoRPC aseg = null;       // El Asegurado
    List<CoberturaCotizaRPC> covsCot = new ArrayList(); //Lista de Coberturas

    public ObjetoAsegCotizaRPC(int numOA, AseguradoRPC aseg, List<CoberturaCotizaRPC> covsCot) {
        this.numOA = numOA;
        this.aseg = aseg;
        this.covsCot = covsCot;
    }

    public List<CoberturaCotizaRPC> getCovsCot() {
        return covsCot;
    }

    public AseguradoRPC getAseg() {
        return aseg;
    }

    @Override
    public String toString() {
        StringBuilder out = new StringBuilder("ObjetoAsegCotizaRPC{").append("numOA=").append(String.valueOf(numOA))
                .append(", aseg=").append(aseg.toString()).append(", covsCot:\n{");
        for (CoberturaCotizaRPC o : covsCot) {
            out.append(o.toString()).append("\n");
        }
        out.append("}\n}");
        return out.toString();
    }
}
