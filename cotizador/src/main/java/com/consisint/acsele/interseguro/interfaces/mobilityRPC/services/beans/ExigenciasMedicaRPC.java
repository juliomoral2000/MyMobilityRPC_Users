package com.consisint.acsele.interseguro.interfaces.mobilityRPC.services.beans;

import java.util.ArrayList;
import java.util.List;

/**
 * La clase <code>ExigenciasMedicaRPC</code> representa el wrapper de los Requisitos de Asegurabilidad [Tabla Dinamica TDREQASEG]
 * de Acsele para los servicios del MobilityRPC. (para Interseguro es el EXIGENCIAS MÉDICAS)
 */
public class ExigenciasMedicaRPC {
    long idProducto;    // Id del Producto
    List<RenglonExigenciasMedicaRPC> renglonList = new ArrayList<RenglonExigenciasMedicaRPC>();

    public ExigenciasMedicaRPC(long idProducto, List<RenglonExigenciasMedicaRPC> renglonList) {
        this.idProducto = idProducto;
        this.renglonList = renglonList;
    }

    public long getIdProducto() {
        return idProducto;
    }

    public List<RenglonExigenciasMedicaRPC> getRenglonList() {
        return renglonList;
    }

    @Override
    public String toString() {
        StringBuilder out = new StringBuilder("ExigenciasMedicaRPC{").append("idProducto=").append( idProducto);
        if(!renglonList.isEmpty()){
            out.append(", renglonList:\n{");
            for (RenglonExigenciasMedicaRPC j : renglonList) out.append(j.toString()).append("\n");
            out.append("}\n");
        }
        out.append('}').toString();
        return out.toString();
    }
}
