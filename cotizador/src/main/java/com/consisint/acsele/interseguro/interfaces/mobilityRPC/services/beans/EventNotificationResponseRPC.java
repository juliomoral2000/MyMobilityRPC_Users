package com.consisint.acsele.interseguro.interfaces.mobilityRPC.services.beans;

/**
 * La clase <code>EventNotificationResponseRPC</code> es la respuesta generica de la recepcion de una
 * Notificacion Enviada por Acsel-e hacia un Sistema Remoto.
 *
 */
public class EventNotificationResponseRPC {
    public boolean isReceived;     // Se recibio correctamente la notificacion? . true = ok, false = error.
    public String code;            // En caso de error codigo del Error.
    public String msg;             // En caso de error mensaje de Error.

    /**
     * Constructor
     * @param isReceived    Se recibio correctamente la notificacion? . true = ok, false = error.
     * @param code  En caso de error codigo del Error.
     * @param msg   En caso de error mensaje de Error.
     */
    public EventNotificationResponseRPC(boolean isReceived, String code, String msg) {
        this(isReceived);
        this.code = code;
        this.msg = msg;
    }

    public EventNotificationResponseRPC(boolean isReceived) {
        this.isReceived = isReceived;
    }

    @Override
    public String toString() {
        StringBuilder out = new StringBuilder("EventNotificationResponseRPC{").append("isReceived=").append(String.valueOf(isReceived));
        if(!isReceived) out.append(", code=").append(code).append(", msg=").append(msg);
        out.append("}");
        return out.toString();
    }
}
