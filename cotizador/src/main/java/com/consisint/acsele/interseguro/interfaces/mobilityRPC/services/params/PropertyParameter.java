package com.consisint.acsele.interseguro.interfaces.mobilityRPC.services.params;

import com.enroquesw.mcs.comm.mobilityRPC.services.parameter.ProcessParameter;

/**
 * La clase <code>PropertyParameter</code> representa el Parametro de entrada Para los Servicios de Propiedades y Transformadores.
 */
public class PropertyParameter implements ProcessParameter {
    public long propertyId;         // Id de Propiedad de Acsele
    public String propertyName;     // Nombre de la Propiedad de Acsele [Simbolo]
    public boolean fetchDepends;    // Se extraen las Dependencias? [relaciones Padre-Hijo]
    private Long timeOutMax;

    /**
     * Constructor
     * @param propertyId    Id de Propiedad de Acsele
     * @param propertyName  Nombre de la Propiedad de Acsele [Simbolo]
     * @param fetchDepends  Se extraen las Dependencias? [relaciones Padre-Hijo]
     */
    public PropertyParameter(long propertyId, String propertyName, boolean fetchDepends) {
        this.propertyId = propertyId;
        this.propertyName = propertyName;
        this.fetchDepends = fetchDepends;
    }

    @Override
    public String toString() {
        StringBuilder out = new StringBuilder("PropertyParameter{")
                .append("propertyId=").append(String.valueOf(propertyId))
                .append(",propertyName=").append(propertyName)
                .append(",fetchDepends=").append(String.valueOf(fetchDepends))
                .append("}");
        return out.toString();
    }

    public void setTimeOutMax(Long timeOutMax) { this.timeOutMax = timeOutMax; }

    @Override
    public Long getTimeOutMax() { return timeOutMax; }
}
