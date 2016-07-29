package com.enroquesw.mcs.comm.mobilityRPC.client;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Julio on 27/07/2016.
 */
public class BaseData {
    @SerializedName("idProducto")
    long idProducto;
    @SerializedName("idPoliza")
    long idPoliza;

    public BaseData() { }

    public BaseData(long idProducto, long idPoliza) {
        this.idProducto = idProducto;
        this.idPoliza = idPoliza;
    }

    public long getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(long idProducto) {
        this.idProducto = idProducto;
    }

    public long getIdPoliza() {
        return idPoliza;
    }

    public void setIdPoliza(long idPoliza) {
        this.idPoliza = idPoliza;
    }
}
