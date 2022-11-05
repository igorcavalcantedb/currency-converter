package com.eurosys.converter.domain;

import java.math.BigDecimal;

public class Exchange {
    private Exchange() {
    }

    public static BigDecimal converter(Currency from, Currency to, BigDecimal value) {
        var vFrom = from.getValue();
        var vTo = to.getValue();

        //var rate = vFrom.divide(vTo, RoundingMode.HALF_UP);
        var rate = vFrom.multiply(vTo);
        return value.multiply(rate);

    }

}
