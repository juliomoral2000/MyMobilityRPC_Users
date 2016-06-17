package com.consisint.acsele.interseguro.interfaces.mobilityRPC.services.beans;

import java.util.ArrayList;
import java.util.List;

/**
 * La clase <code>TablaValorGarantizadoRPC</code> representa el wrapper de la Tabla de Valores Garantizados de una Cotizacion dada
 * de Acsele para los servicios del MobilityRPC.
 */
public class TablaValorGarantizadoRPC {
    long idPoliza;
    List<ValorGarantizadoRenglonRPC> renglones = new ArrayList<ValorGarantizadoRenglonRPC>();     // Renglones de la Tabla de proyeccion de Valores Garantizados
    List<String> errors;


    public TablaValorGarantizadoRPC(long idPoliza) { this.idPoliza = idPoliza; }

    public TablaValorGarantizadoRPC(long idPoliza, List<ValorGarantizadoRenglonRPC> renglones) {
        this.idPoliza = idPoliza;
        this.renglones = renglones;
    }

    public long getIdPoliza() { return idPoliza; }

    public List<ValorGarantizadoRenglonRPC> getRenglones() { return renglones; }

    public void setIdPoliza(long idPoliza) { this.idPoliza = idPoliza; }

    public void setRenglones(List<ValorGarantizadoRenglonRPC> renglones) { this.renglones = renglones; }

    public List<String> getErrors() { return errors; }

    public void setErrors(List<String> errors) { this.errors = errors; }

    @Override
    public String toString() {
        StringBuilder out = new StringBuilder("TablaValorGarantizadoRPC:{\n").append(" idPoliza=").append(String.valueOf(idPoliza));
        if(!renglones.isEmpty()){
            out.append(",\nrenglones:{\n[");
            for (ValorGarantizadoRenglonRPC z : renglones) out.append(z.toString()).append(",\n");
            out.append("]}\n");
        }
        if(errors != null && !errors.isEmpty()){
            out.append(",\nerrores:{\n[");
            for (String z : errors) out.append(z).append(",\n");
            out.append("]}\n");
        }
        out.append("}");
        return out.toString();
    }
}
