package com.eurosys.converter.domain;

import com.eurosys.converter.repository.Scrapper;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class ExchangeTest {

    @Test
    void converter() {
        var euro = new Currency("Euro","EUR",new BigDecimal("0.96831164"));
        var real = new Currency("Real","BRL",new BigDecimal("0.19273661"));
        var nzd = new Currency("Dolar NZ","NZD", null);
        var usd = new Currency("Dolar US","USD", null);
        var result = Exchange.converter(Scrapper.getCurrency(euro),Scrapper.getCurrency(usd),new BigDecimal("10"));
        assertEquals(new BigDecimal("1.99043990"), result);
    }
}