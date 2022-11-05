package com.eurosys.converter.repository;

import com.eurosys.converter.domain.Currency;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class ScrapperTest {

    @Test
    void getCurrency() {
        Scrapper scrapper = new Scrapper();
        var euro = new Currency("Euro", "EUR", new BigDecimal("0.96831164"));
        var real = new Currency("Real", "BRL", new BigDecimal("0.19273661"));
        var x = scrapper.getCurrency(real);
//todo add assertion
    }
}