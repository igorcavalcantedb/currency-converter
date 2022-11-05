package com.eurosys.converter.domain;

import java.math.BigDecimal;

public class Currency {
    private final String name;
    private final String code;
    private final BigDecimal value;

    public Currency(String name, String code, BigDecimal value) {
        this.name = name;
        this.code = code;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public String getCode() {
        return code;
    }

    public BigDecimal getValue() {
        return value;
    }
}
