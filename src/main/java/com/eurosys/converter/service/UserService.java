package com.eurosys.converter.service;

import com.eurosys.converter.api.UsersApiDelegate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class UserService implements UsersApiDelegate {
    @Override
    public ResponseEntity<Void> usersGet() {
        System.out.println("Service sendo chamado....");
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
