package com.consisint.acsele.interseguro.interfaces.mobilityRPC.services.beans;

import java.util.ArrayList;
import java.util.List;

/**
 * La clase <code>ObjetoAsegCotizaRPC</code> representa el wrapper de los datos del Objeto Asegurado [los asegurados] de la Cotizacion (Acsele)
 * extraido del Cotizador el cual sera utilizado por los servicios de Cotizacion.
 *
 */
public class ObjetoAsegCotizaRPC {
    int numOA;                          // Numero de Objeto Asegurado
    long idInsuranceObjectType;         // Id de AgregInsObjectType si se llegara a requerir
    AseguradoRPC aseg = null;           // El Asegurado
    List<CoberturaCotizaRPC> covsCot = new ArrayList<CoberturaCotizaRPC>(); //Lista de Coberturas

    /**
     *
     * @param numOA                     Numero/Posicion de registro del Objeto Asegurado
     * @param idInsuranceObjectType     Id de AgregInsObjectType si se llegara a requerir
     * @param aseg                      El Asegurado
     * @param covsCot                   Las Coberturas
     */
    public ObjetoAsegCotizaRPC(int numOA, long idInsuranceObjectType, AseguradoRPC aseg, List<CoberturaCotizaRPC> covsCot) {
        this.numOA = numOA;
        this.idInsuranceObjectType = idInsuranceObjectType;
        this.aseg = aseg;
        this.covsCot = covsCot;
    }

    public List<CoberturaCotizaRPC> getCovsCot() {
        return covsCot;
    }

    public AseguradoRPC getAseg() {
        return aseg;
    }

    public int getNumOA() {
        return numOA;
    }

    public long getIdInsuranceObjectType() {
        return idInsuranceObjectType;
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
