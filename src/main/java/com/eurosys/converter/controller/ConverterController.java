package com.eurosys.converter.controller;

import com.eurosys.converter.repository.Scrapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class ConverterController {

    @GetMapping("/get-rate/{code}")
    public ResponseEntity getRate(@PathVariable String code) {

        return new ResponseEntity(Scrapper.getCurrency(code), HttpStatus.OK);
    }
}
