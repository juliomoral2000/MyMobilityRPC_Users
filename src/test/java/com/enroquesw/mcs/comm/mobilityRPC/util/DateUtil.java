package com.enroquesw.mcs.comm.mobilityRPC.util;

import java.util.Calendar;

/**
 * La clase <code>DateUtil</code> es una clase utilitaria de funciones de fechas
 */
public class DateUtil {
    public static long getTime(int ano, int mes, int dia) {
        Calendar instance = Calendar.getInstance();
        int month = mes - 1;
        instance.set(Calendar.YEAR,ano);
        instance.set(Calendar.MONTH,month);
        instance.set(Calendar.DAY_OF_MONTH,dia);
        instance.set(Calendar.HOUR_OF_DAY, 0);
        instance.set(Calendar.MINUTE, 0);
        instance.set(Calendar.SECOND, 0);
        instance.set(Calendar.MILLISECOND, 0);
        return instance.getTimeInMillis();
    }
}
