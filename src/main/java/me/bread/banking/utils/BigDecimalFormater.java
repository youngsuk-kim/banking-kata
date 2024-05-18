package me.bread.banking.utils;

import java.math.BigDecimal;
import java.text.DecimalFormat;

public class BigDecimalFormater {
    public static String toViewString(BigDecimal number) {
        DecimalFormat df = new DecimalFormat("0.00");
        return df.format(number);
    }
}
