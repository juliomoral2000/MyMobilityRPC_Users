package com.consisint.acsele.interseguro.interfaces.mobilityRPC.services.beans;

/**
 * La clase <code>RenglonEdadProductoRPC</code> representa el wrapper de los registros de las Tablas de Edades del producto [tablas dinamicas] de los productos de Vida
 * de Acsele para los servicios del MobilityRPC.
 */
public class RenglonEdadProductoRPC {
    long id;                // Id del DCO
    long idCobetura;        // Id de la Cobertura Configurada
    int edadMinIngreso;     // Edad Maxima de
    int edadMaxIngreso;     // Edad Maxima de
    int edadMaxPermanencia; // Edad Maxima de
    double idTipoAsegurado; // Id o valor de Tipo de Asegurado [TipoAseguradoAcc]       -- TODO: usos en IO.TipoAseguradoAcc y en varias TDs.TipoAseguradoAcc [NINGUNO/NOAPLICA, TITULAR, CONYUGUE, ETC]
    long date;              // Fecha del DCO

    public RenglonEdadProductoRPC(long id, long idCobetura, int edadMinIngreso, int edadMaxIngreso, int edadMaxPermanencia, double idTipoAsegurado, long date) {
        this.id = id;
        this.idCobetura = idCobetura;
        this.edadMinIngreso = edadMinIngreso;
        this.edadMaxIngreso = edadMaxIngreso;
        this.edadMaxPermanencia = edadMaxPermanencia;
        this.idTipoAsegurado = idTipoAsegurado;
        this.date = date;
    }

    public long getId() { return id; }

    public long getIdCobetura() { return idCobetura; }

    public int getEdadMinIngreso() { return edadMinIngreso; }

    public int getEdadMaxIngreso() { return edadMaxIngreso; }

    public int getEdadMaxPermanencia() { return edadMaxPermanencia; }

    public double getIdTipoAsegurado() { return idTipoAsegurado; }

    public long getDate() { return date; }

    @Override
    public String toString() {
        return "RenglonEdadProductoRPC{" + "id=" + id + ", idCobetura=" + idCobetura + ", edadMinIngreso=" + edadMinIngreso + ", edadMaxIngreso=" + edadMaxIngreso +
                ", edadMaxPermanencia=" + edadMaxPermanencia + ", idTipoAsegurado=" + idTipoAsegurado + ", date=" + date + '}';
    }
}
