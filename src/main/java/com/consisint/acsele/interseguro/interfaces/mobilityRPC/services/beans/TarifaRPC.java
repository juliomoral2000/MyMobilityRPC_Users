package com.consisint.acsele.interseguro.interfaces.mobilityRPC.services.beans;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * La clase <code>TarifaRPC</code> representa el wrapper de las Tarifas de los productos de Vida
 * de Acsele para los servicios del MobilityRPC. (para Interseguro es el )

 */
public class TarifaRPC {
    long idProducto;    // Id del Producto
    long idPlanVida;    // Value del Transformador de la propiedad 'PlanVida'
    long idCobertura;   // Id de la Cobertura Configurada (el Value de la Propiedad CODCOBERTURA o cargarlo desde el input de la Propiedad COBERTURAVIDA )
    //long idMoneda;      // Id de Moneda (el Value de la Propiedad MONEDATD)
    List<RenglonTarifaRPC> renglonList = new ArrayList<RenglonTarifaRPC>();

    public TarifaRPC(long idProducto, long idPlanVida, long idCobertura, List<RenglonTarifaRPC> renglonList) {
        this.idProducto = idProducto;
        this.idPlanVida = idPlanVida;
        this.idCobertura = idCobertura;
        this.renglonList = renglonList;
    }

    public long getIdProducto() {
        return idProducto;
    }

    public long getIdPlanVida() {
        return idPlanVida;
    }

    public long getIdCobertura() {
        return idCobertura;
    }

    public List<RenglonTarifaRPC> getRenglonList() {
        return renglonList;
    }

    @Override
    public String toString() {
        StringBuilder out = new StringBuilder("TarifaRPC{").append("idProducto=").append( idProducto).append(", idPlanVida=").append( idPlanVida).append(", idCobertura=").append( idCobertura);
        if(!renglonList.isEmpty()){
            out.append(", renglonList:\n{");
            for (RenglonTarifaRPC j : renglonList) out.append(j.toString()).append("\n");
            out.append("}\n");
        }
        out.append('}').toString();
        return out.toString();
    }
}
