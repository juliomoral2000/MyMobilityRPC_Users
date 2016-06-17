package com.consisint.acsele.interseguro.interfaces.mobilityRPC.services.params;

import com.enroquesw.mcs.comm.mobilityRPC.services.parameter.ProcessParameter;

import java.util.Date;

/**
 * La clase <code>ActuarialAgeParameter</code> representa el Parametro de entrada Para el caculo de la edad actuarial segun funciones de Acsele.
 * fechaCotiza          Fecha de la Cotizacion. (Requerido).
 * fechaNacimiento      Fecha de Nacimiento de la Persona. (Requerido)
 */
public class ActuarialAgeParameter implements ProcessParameter {
    public long fechaCotiza;
    public long fechaNacimiento;
    private Long timeOutMax;

    /**
     * Constructor
     * @param fechaCotiza       Fecha de la Cotizacion. (Requerido).
     * @param fechaNacimiento   Fecha de Nacimiento de la Persona. (Requerido)
     */
    public ActuarialAgeParameter(Date fechaCotiza, Date fechaNacimiento) {
        this.fechaCotiza = fechaCotiza.getTime();
        this.fechaNacimiento = fechaNacimiento.getTime();
    }

    @Override
    public String toString() {
        StringBuilder out = new StringBuilder("ActuarialAgeParameter{").append("fechaCotiza=").append( new Date(fechaCotiza).toString()).append(", fechaNacimiento=").append( new Date(fechaNacimiento).toString()).append("}\n");
        return out.toString();
    }

    public void setTimeOutMax(Long timeOutMax) { this.timeOutMax = timeOutMax; }

    @Override
    public Long getTimeOutMax() { return timeOutMax; }
}
