package com.consisint.acsele.interseguro.interfaces.mobilityRPC.services.params;

import com.enroquesw.mcs.comm.mobilityRPC.services.parameter.ProcessParameter;

/**
 * La clase <code>PropertyParameter</code> representa el Parametro de entrada Para los Servicios de Propiedades y Transformadores.
 */
public class PropertyParameter implements ProcessParameter {
    public long propertyId;
    public String propertyName;
    public boolean fetchDepends;

    public PropertyParameter(long propertyId, String propertyName, boolean fetchDepends) {
        this.propertyId = propertyId;
        this.propertyName = propertyName;
        this.fetchDepends = fetchDepends;
    }
}
