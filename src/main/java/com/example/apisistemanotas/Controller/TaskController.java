package com.example.apisistemanotas.Controller;


import com.example.apisistemanotas.DTO.RequestCreacionTask;
import com.example.apisistemanotas.DTO.ResponseCreacionTask;
import com.example.apisistemanotas.DTO.ResponseListaTaskPorNivel;
import com.example.apisistemanotas.Model.Dificultad;
import com.example.apisistemanotas.Service.TaskService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/task")
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

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarTarea(@PathVariable(name = "id") Long identificador){
        taskservice.eliminarTarea(identificador);
        return ResponseEntity.noContent().build();

    }
    @GetMapping
    public ResponseEntity<List<ResponseListaTaskPorNivel>> listaTareasPorNivel(
            @RequestParam Dificultad nivel
            ){
        List<ResponseListaTaskPorNivel> answer=taskservice.listaTaskPorNivel(nivel);
        return ResponseEntity.status(HttpStatus.OK).body(answer);
    }


    @GetMapping
    public ResponseEntity<List<ResponseListaTaskPorNivel>>
    listaDeTareasPorUsuarioyNivel(
            @RequestParam Long userId,@RequestParam Dificultad nivel){

        List<ResponseListaTaskPorNivel> output=
                taskservice.listaDeTareasPorUserAndNivel(userId,nivel);
        return ResponseEntity.status(HttpStatus.OK).body(output);

    }
}
