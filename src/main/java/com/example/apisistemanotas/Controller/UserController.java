package com.example.apisistemanotas.Controller;

import com.example.apisistemanotas.DTO.RequestCreacionUser;
import com.example.apisistemanotas.DTO.ResponseCreacionUser;
import com.example.apisistemanotas.Service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class UserController {

    private final UserService userService;

    public UserController(UserService service){
        this.userService=service;
    }

    @PostMapping
    public ResponseEntity<ResponseCreacionUser> crearUser(@Valid @RequestBody RequestCreacionUser dto){
        ResponseCreacionUser var =userService.crearUser(dto);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(var);

    }




}
