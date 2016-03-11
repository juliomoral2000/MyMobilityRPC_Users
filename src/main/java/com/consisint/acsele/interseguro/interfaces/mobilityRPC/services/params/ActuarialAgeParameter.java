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

    public ActuarialAgeParameter(Date fechaCotiza, Date fechaNacimiento) {
        this.fechaCotiza = fechaCotiza.getTime();
        this.fechaNacimiento = fechaNacimiento.getTime();
    }
}
