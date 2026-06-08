package com.example.apisistemanotas.Service;


import com.example.apisistemanotas.DTO.RequestCreacionTask;
import com.example.apisistemanotas.DTO.ResponseCreacionTask;
import com.example.apisistemanotas.Excepciones.IdUsuarioNoEncontradoException;
import com.example.apisistemanotas.Model.Task;
import com.example.apisistemanotas.Model.User;
import com.example.apisistemanotas.Repository.TaskRepository;
import com.example.apisistemanotas.Repository.UserRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class TaskService {

    private TaskRepository taskRepository;
    private UserRepository userRepository;
    public TaskService(TaskRepository repository,UserRepository userRepository){
        this.taskRepository=repository;
        this.userRepository=userRepository;
    }

    public ResponseCreacionTask crearTask(RequestCreacionTask dto){
        Optional<User> var_optional=userRepository.findById(dto.getUserId());

        if(var_optional.isPresent()){
            User var_user=var_optional.get();
            Task var_task=new Task();

            var_task.setUsuario(var_user);
            var_task.setTarea(dto.getTarea());
            var_task.setNivel(dto.getNivel());
            var_task.setCreatedAt(LocalDateTime.now());

            Task answer=taskRepository.save(var_task);

            ResponseCreacionTask respuesta=new ResponseCreacionTask();

            respuesta.setId(answer.getId());
            respuesta.setTarea(answer.getTarea());
            respuesta.setNivel(answer.getNivel());
            respuesta.setId_usuario(answer.getUsuario().getId());
            return respuesta;
        }

        throw new IdUsuarioNoEncontradoException("id de usuario no existe");


    }


}
