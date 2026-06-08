package com.example.apisistemanotas.Controller;


import com.example.apisistemanotas.DTO.RequestCreacionTask;
import com.example.apisistemanotas.DTO.ResponseCreacionTask;
import com.example.apisistemanotas.Service.TaskService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class TaskController {

    private final TaskService taskservice;

    public TaskController(TaskService service){
        this.taskservice=service;
    }

    @PostMapping
    public ResponseEntity<ResponseCreacionTask> crearTask
            (@Valid @RequestBody RequestCreacionTask dto){
        ResponseCreacionTask salida=taskservice.crearTask(dto);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(salida);
    }
}
