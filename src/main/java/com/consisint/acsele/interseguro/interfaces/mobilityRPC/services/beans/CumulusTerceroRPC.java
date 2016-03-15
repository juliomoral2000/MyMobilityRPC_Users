package com.consisint.acsele.interseguro.interfaces.mobilityRPC.services.beans;

/**
 * Created by Julio on 14/03/2016.
 */
public class CumulusTerceroRPC {
    long idTercero;
    long idProduct;
    long idMoneda;
    double monto;

    public CumulusTerceroRPC(long idTercero, long idProduct, long idMoneda, double monto) {
        this.idTercero = idTercero;
        this.idProduct = idProduct;
        this.idMoneda = idMoneda;
        this.monto = monto;
    }

    public long getIdTercero() {
        return idTercero;
    }

    public long getIdProduct() {
        return idProduct;
    }

    public long getIdMoneda() {
        return idMoneda;
    }

    public double getMonto() {
        return monto;
    }
    @Override
    public String toString() {
        return new StringBuilder("CumulusTerceroRPC{").append("idTercero=").append( idTercero).append(", idProduct='").append( idProduct).append( '\'').append(", idMoneda=").append(idMoneda).append(", monto=").append(monto).append('}').toString();
    }
}
