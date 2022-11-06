package com.eurosys.converter.repository;

import com.eurosys.converter.domain.Currency;
import com.eurosys.converter.repository.util.AwesomeApiBody;
import com.eurosys.converter.repository.util.AwesomeApi;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.Optional;

public class Scrapper {

    public static Currency getCurrency(Currency currency) {
        if (currency.getCode().equalsIgnoreCase("USD")) {
            return new Currency(currency.getName(), currency.getCode(), BigDecimal.ONE);
        }
        //TODO obter de mais fontes
        RestTemplate restTemplate = new RestTemplate();
        String fooResourceUrl
                = "https://economia.awesomeapi.com.br/last/USD-";
        ResponseEntity<String> response
                = restTemplate.getForEntity(fooResourceUrl + currency.getCode(), String.class);
        Optional<AwesomeApiBody> valores;
        try {
            AwesomeApi awesomeApi = new ObjectMapper().readerFor(AwesomeApi.class).readValue(response.getBody());
            valores = awesomeApi.getProperties().values().stream().findFirst();
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        var strValue = valores.isPresent() ? valores.get().getBid() : "0.00";
        BigDecimal bigValue;
        try {
            bigValue = new BigDecimal(strValue);
        } catch (Exception e) {
            return currency;
        }
        return new Currency(currency.getName(), currency.getCode(), bigValue);

    }

    public static String getCurrency(String code) {
        Currency currency = new Currency("", code, null);
        return getCurrency(currency).getValue().toString();
    }

    public static BigDecimal getCurrencyBig(String code) {
        Currency currency = new Currency("", code, null);
        return getCurrency(currency).getValue();
    }

}
