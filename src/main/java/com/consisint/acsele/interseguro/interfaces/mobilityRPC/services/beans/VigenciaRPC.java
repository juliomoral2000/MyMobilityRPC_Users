package com.consisint.acsele.interseguro.interfaces.mobilityRPC.services.beans;

/**
 * La clase <code>VigenciaRPC</code> representa el wrapper del Validity (Vigencia)
 * de Acsele para los servicios del MobilityRPC. (para Interseguro es el PERIODO COBERTURA)
 */
public class VigenciaRPC {
    long idProducto;    // Id del Producto
    String nombre;      // Input de la Vigencia
    double valor;       // Valor de la Vigencia

    /**
     * Constructor
     * @param idProducto    Id del Producto
     * @param nombre        Nombre [Input] de la Vigencia
     * @param valor         Valor de la Vigencia
     */
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
        return "VigenciaRPC{" + "idProducto=" + idProducto + ", nombre='" + nombre + '\'' + ", valor=" + valor + '}';
    }
}
