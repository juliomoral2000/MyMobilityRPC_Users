package com.consisint.acsele.interseguro.interfaces.mobilityRPC.services.beans;

import java.util.Date;

/**
 * La clase <code>AseguradoRPC</code> representa el wrapper de los datos del Asegurado
 * extraido del Cotizador el cual sera utilizado por los servicios de Cotizacion.
 */
public class AseguradoRPC {
    long idTercero;         // Id del Tercero [si en dado caso lo poseen]
    long fechaNacimiento;   // Fecha de Nacimiento [IO.fechaNacimientoCOT]
    double idSexo = -1;          // Id o valor de Sexo [IO.SexoCOT]  - Puede ser 0 en su valor
    double idFumador = -1;  // Id o valor de Fumador [IO.CondicionFumador] - Puede ser 0 en su valor
    double idProfesion;     // Id o valor de Profesion [POL.ProfesionActividad] -- Cambios de Chang
    double idClaseAccPers;  // Id o valor de Clase [POL.ClaseAccPers]    -- Cambios de Chang
    double idTipoAsegurado; // Id o valor de Tipo de Asegurado [IO.TipoAseguradoAccCOT]       -- TODO: usos en IO.TipoAseguradoAcc y en varias TDs.TipoAseguradoAcc [TITULAR, CONYUGUE, ETC]

    /**
     * Constructor
     * @param fechaNacimiento   Fecha de Nacimiento
     * @param idSexo            Id o valor de Sexo
     * @param idFumador         Id o valor de Fumador
     * @param idProfesion       Id o valor de Profesion
     * @param idClaseAccPers    Id o valor de Clase
     * @param idTipoAsegurado   Id o valor de Tipo de Asegurado
     */
    public AseguradoRPC(long fechaNacimiento, double idSexo, double idFumador, double idProfesion, double idClaseAccPers, double idTipoAsegurado) {
        this.fechaNacimiento = fechaNacimiento;
        this.idSexo = idSexo;
        this.idFumador = idFumador;
        this.idProfesion = idProfesion;
        this.idClaseAccPers = idClaseAccPers;
        this.idTipoAsegurado = idTipoAsegurado;
    }

    /**
     * Constructor
     * @param idTercero         Id del Tercero
     * @param fechaNacimiento   Fecha de Nacimiento
     * @param idSexo            Id o valor de Sexo
     * @param idFumador         Id o valor de Fumador
     * @param idProfesion       Id o valor de Profesion
     * @param idClaseAccPers    Id o valor de Clase
     * @param idTipoAsegurado   Id o valor de Tipo de Asegurado
     */
    public AseguradoRPC(long idTercero, long fechaNacimiento, double idSexo, double idFumador, double idProfesion, double idClaseAccPers, double idTipoAsegurado) {
        this(fechaNacimiento, idSexo, idFumador, idProfesion, idClaseAccPers, idTipoAsegurado);
        this.idTercero = idTercero;
    }

    public long getIdTercero() {
        return idTercero;
    }

    public long getFechaNacimiento() {
        return fechaNacimiento;
    }

    public double getIdSexo() {
        return idSexo;
    }

    public double getIdFumador() {
        return idFumador;
    }

    public double getIdProfesion() {
        return idProfesion;
    }

    public double getIdClaseAccPers() {
        return idClaseAccPers;
    }

    public double getIdTipoAsegurado() {
        return idTipoAsegurado;
    }

    @Override
    public String toString() {
        StringBuilder out = new StringBuilder("AseguradoRPC{").append("idTercero=").append(String.valueOf(idTercero))
                .append(", fechaNacimiento=").append(String.valueOf(new Date(fechaNacimiento)))
                .append(", idSexo=").append(String.valueOf(idSexo))
                .append(", idFumador=").append(String.valueOf(idFumador))
                .append(", idProfesion=").append(String.valueOf(idProfesion))
                .append(", idClaseAccPers=").append(String.valueOf(idClaseAccPers))
                .append(", idTipoAsegurado=").append(String.valueOf(idTipoAsegurado))
                ;
        out.append("}");
        return out.toString();
    }
}
