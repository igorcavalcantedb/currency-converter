package com.eurosys.converter.controller;

import com.eurosys.converter.api.OpenApiApi;
import com.eurosys.converter.model.Rate;
import com.eurosys.converter.repository.Scrapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.UUID;

@Controller
public class OpenApiConverterController implements OpenApiApi {
   /* @Override
    public ResponseEntity<Void> usersGet() {
        Logger logger = Logger.getLogger(OpenApiConverterController.class.getName());
        logger.warning("TEste warning");
        logger.log(Level.INFO, "");
        System.out.println("Passando pelo controller");
        return new ResponseEntity<>(HttpStatus.OK);
    }*/

    @Override
    public ResponseEntity<Rate> getRate(String code) {

        Rate rate = new Rate();
        rate.setId(1L);
        rate.setCode(code);
        rate.setValue(Scrapper.getCurrency(code));
        return new ResponseEntity<>(rate,HttpStatus.OK);
    }
}


