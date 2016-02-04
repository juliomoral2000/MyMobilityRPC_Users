package com.consisint.acsele.interseguro.interfaces.mobilityRPC.services.params;

import com.enroquesw.mcs.comm.mobilityRPC.services.parameter.ProcessParameter;

/**
 * Created by Julio on 03/02/2016.
 */
public class PropertyParameter implements ProcessParameter {
    public long propertyId;
    public String propertyName;

    public PropertyParameter(long propertyId, String propertyName) {
        this.propertyId = propertyId;
        this.propertyName = propertyName;
    }
}
