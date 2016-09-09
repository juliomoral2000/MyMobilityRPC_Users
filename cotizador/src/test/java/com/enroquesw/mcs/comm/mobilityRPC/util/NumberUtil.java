package com.enroquesw.mcs.comm.mobilityRPC.util;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Created by Julio on 29/08/2016.
 */
public class NumberUtil {
    public static double redondearDosDecimales(double v) {
        BigDecimal bd = new BigDecimal(v);
        bd = bd.setScale(2, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }
}
