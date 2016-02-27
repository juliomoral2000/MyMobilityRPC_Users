package com.consisint.acsele.interseguro.interfaces.mobilityRPC.services.beans;

/**
 * La clase <code>VigenciaRPC</code> representa el wrapper del Validity (Vigencia)
 * de Acsele para los servicios del MobilityRPC. (para Interseguro es el PERIODO COBERTURA)
 */
public class VigenciaRPC {
    long idProducto;
    String nombre;
    double valor;

    public VigenciaRPC(long idProducto, String nombre, double valor) {
        this.idProducto = idProducto;
        this.nombre = nombre;
        this.valor = valor;
    }

    public long getIdProducto() {
        return idProducto;
    }

    public String getNombre() {
        return nombre;
    }

    public double getValor() {
        return valor;
    }

    @Override
    public String toString() {
        return new StringBuilder("VigenciaRPC{").append("idProducto=").append( idProducto).append(", nombre='").append( nombre).append( '\'').append(", valor=").append( valor).append('}').toString();
    }
}
