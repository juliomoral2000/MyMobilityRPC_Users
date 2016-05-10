package com.consisint.acsele.interseguro.interfaces.mobilityRPC.services.beans;

import java.util.ArrayList;
import java.util.List;

/**
 * La clase <code>EdadProductoRPC</code> representa el wrapper de las Edades Maximas y Minimas del Producto [Tabla Dinamica TDEDADESPROD]
 * de Acsele para los servicios del MobilityRPC.
 */
public class EdadProductoRPC {
    long idProducto;    // Id del Producto
    List<RenglonEdadProductoRPC> renglonList = new ArrayList<RenglonEdadProductoRPC>();

    public EdadProductoRPC(long idProducto, List<RenglonEdadProductoRPC> renglonList) {
        this.idProducto = idProducto;
        this.renglonList = renglonList;
    }

    public long getIdProducto() {
        return idProducto;
    }

    public List<RenglonEdadProductoRPC> getRenglonList() {
        return renglonList;
    }

    @Override
    public String toString() {
        StringBuilder out = new StringBuilder("EdadProductoRPC{").append("idProducto=").append( idProducto);
        if(!renglonList.isEmpty()){
            out.append(", renglonList:\n{");
            for (RenglonEdadProductoRPC j : renglonList) out.append(j.toString()).append("\n");
            out.append("}\n");
        }
        out.append('}').toString();
        return out.toString();
    }
}
