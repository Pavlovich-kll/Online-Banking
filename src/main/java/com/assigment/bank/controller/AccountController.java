package com.assigment.bank.controller;

import com.assigment.bank.dto.AccountDto;
import com.assigment.bank.service.implServices.AccountServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "account", produces = MediaType.APPLICATION_JSON_VALUE)
@Api(tags = {"Account operation endpoints"})
public class AccountController {

    @Autowired
    private AccountServiceImpl accountService;

    @PostMapping(path = "/create")
    @ApiOperation(value = "Creating an account with a user", notes = "Gets details of users account")
    @ApiResponses(value = {@ApiResponse(code = 201, message = "Created"),
            @ApiResponse(code = 400, message = "Bad Request"),
            @ApiResponse(code = 500, message = "Internal Server Error")})

    public ResponseEntity<Void> createAccount(@RequestBody AccountDto account) {
        accountService.createUsersAccount(account);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
