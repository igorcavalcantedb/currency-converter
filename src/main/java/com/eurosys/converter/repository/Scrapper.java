package com.eurosys.converter.repository;

import com.eurosys.converter.domain.Currency;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;

public  class Scrapper {
    public static Currency getCurrency(Currency currency){
        if(currency.getCode().equalsIgnoreCase("USD")){
            return new Currency(currency.getName(),currency.getCode(),BigDecimal.ONE);
        }
        //TODO -melhorar a forma de obter os valores; deixar mais generico; obter de mais fontes
        RestTemplate restTemplate = new RestTemplate();
        String fooResourceUrl
                = "https://economia.awesomeapi.com.br/last/USD-";
        ResponseEntity<String> response
                = restTemplate.getForEntity(fooResourceUrl + currency.getCode(), String.class);
        String procurada = "bid\":\"";
        int pos = response.getBody().indexOf(procurada) + procurada.length();
        String StrValue = response.getBody().substring(pos,pos+6);
        BigDecimal bigValue;
        try {
            bigValue = new BigDecimal(StrValue.replace("\"","0"));
        }catch (Exception e){
            return currency;
        }

        return new Currency(currency.getName(),currency.getCode(),bigValue);

    }
    public static String getCurrency(String code){
        Currency currency = new Currency("",code,null);
        return getCurrency(currency).getValue().toString();
    }
}
