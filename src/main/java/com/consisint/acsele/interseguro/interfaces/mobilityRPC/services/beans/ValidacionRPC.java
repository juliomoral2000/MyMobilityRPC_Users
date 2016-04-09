package com.consisint.acsele.interseguro.interfaces.mobilityRPC.services.beans;

/**
 * Created by Julio on 05/04/2016.
 */
public class ValidacionRPC {
    String code;
    String msg;

    public ValidacionRPC(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    @Override
    public String toString() {
        StringBuilder out = new StringBuilder("ValidacionRPC{").append("code=").append(code).append(", msg=").append(msg).append("}");
        return out.toString();
    }
}
