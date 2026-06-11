package com.example.apisistemanotas.Controller;

import com.example.apisistemanotas.DTO.RequestCreacionUser;
import com.example.apisistemanotas.DTO.ResponseCreacionUser;
import com.example.apisistemanotas.DTO.ResponseListaTareas;
import com.example.apisistemanotas.DTO.ResponseListaTareasMasPerfilUsuario;
import com.example.apisistemanotas.Service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/{id}")
    public ResponseEntity<List<ResponseListaTareas>> tareasPorUsuario(@PathVariable Long id){
        List<ResponseListaTareas> output=userService.tareasPorUsuario(id);
        return ResponseEntity.status(HttpStatus.OK)
                .body(output);
    }


    @GetMapping("/users/{id}/tasks")
    public ResponseEntity<ResponseListaTareasMasPerfilUsuario> perfilUserMasTareas(
            @PathVariable(name="id") Long id){
        ResponseListaTareasMasPerfilUsuario rpta=userService
                .tareasPorUsuarioMasPerfilUsuario(id);
        return ResponseEntity.status(HttpStatus.OK).body(rpta);

    }





}
