package com.example.apisistemanotas.Service;


import com.example.apisistemanotas.DTO.RequestCreacionTask;
import com.example.apisistemanotas.DTO.ResponseCreacionTask;
import com.example.apisistemanotas.DTO.ResponseListaTaskPorNivel;
import com.example.apisistemanotas.DTO.ResponseReasignarTareaOtroUsuario;
import com.example.apisistemanotas.Excepciones.IdTaskNoEncontradoException;
import com.example.apisistemanotas.Excepciones.IdTaskOIdUsuarioNoEncontrado;
import com.example.apisistemanotas.Excepciones.IdUsuarioNoEncontradoException;
import com.example.apisistemanotas.Excepciones.IdUsuarioOrigenNoAsignadoIdTask;
import com.example.apisistemanotas.Model.Dificultad;
import com.example.apisistemanotas.Model.Task;
import com.example.apisistemanotas.Model.User;
import com.example.apisistemanotas.Repository.TaskRepository;
import com.example.apisistemanotas.Repository.UserRepository;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
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

    public void eliminarTarea(Long id){
        Optional<Task> var_optional_task=taskRepository.findById(id);
        if(var_optional_task.isPresent()){
            taskRepository.deleteById(id);
        }
        else{
            throw new IdTaskNoEncontradoException("el id no existe");
        }

    }

    public List<ResponseListaTaskPorNivel> listaTaskPorNivel(Dificultad nivel){

        List<Task> var_lista=taskRepository.findByNivel(nivel);
        List<ResponseListaTaskPorNivel> respuesta=new ArrayList<>();

        for(Task tarea:var_lista){
            ResponseListaTaskPorNivel var_response=new ResponseListaTaskPorNivel();
            var_response.setId(tarea.getId());
            var_response.setTarea(tarea.getTarea());
            respuesta.add(var_response);
        }
        return respuesta;
    }

    public List<ResponseListaTaskPorNivel> listaDeTareasPorUserAndNivel(Long id,Dificultad nivel){
        Optional<User> var_optional_user=userRepository.findById(id);
        if(var_optional_user.isPresent()){
            User var_user=var_optional_user.get();
            List<Task> listaTareas=taskRepository.findByUsuarioIdAndNivel(id,nivel);
            List<ResponseListaTaskPorNivel> respuesta=new ArrayList<>();
            for(Task tarea:listaTareas){
                ResponseListaTaskPorNivel output=new ResponseListaTaskPorNivel();
                output.setId(tarea.getId());
                output.setTarea(tarea.getTarea());
                respuesta.add(output);
            }
            return respuesta;

        }

        throw new IdUsuarioNoEncontradoException("no se encontro id usuario");

    }

    public ResponseReasignarTareaOtroUsuario reasignarTareaUsuario(
            Long idTarea,Long idUsuarioOrigen,Long idUsuarioFinal){
        Optional<Task> var_optional_task=taskRepository.findById(idTarea);
        Optional<User> var_optional_user_origen=userRepository.findById(idUsuarioOrigen);
        Optional<User> var_optional_user_final=userRepository.findById(idUsuarioFinal);
        if(var_optional_task.isPresent() && var_optional_user_origen.isPresent() && var_optional_user_final.isPresent()){
            Task var_task=var_optional_task.get();
            User var_user_origen=var_optional_user_origen.get();
            User var_user_final=var_optional_user_final.get();
            if(var_task.getUsuario().getId().equals(var_user_origen.getId())){
                var_task.setUsuario(var_user_final);
                Task tarea_actualizada=taskRepository.save(var_task);
                ResponseReasignarTareaOtroUsuario respuesta=new ResponseReasignarTareaOtroUsuario();
                respuesta.setId(tarea_actualizada.getId());
                respuesta.setTarea(tarea_actualizada.getTarea());
                respuesta.setUserId(tarea_actualizada.getUsuario().getId());
                return respuesta;
            }
            throw new IdUsuarioOrigenNoAsignadoIdTask("el usuario origen no presenta asignada la tarea");
        }
        throw new IdTaskOIdUsuarioNoEncontrado("el id de tarea o id de usuario no se encontraron");
    }











//    public List<ResponseListaTaskPorNivel> tareasPorUsuarioPornivel(Long id,Dificultad nivel){
//        Optional<User> var_optional_user=userRepository.findById(id);
//        if(var_optional_user.isPresent()){
//            User var_user=var_optional_user.get();
//            List<ResponseListaTaskPorNivel> respuesta=new ArrayList<>();
//            if(!var_user.getTareas().isEmpty()){
//                for(Task tarea:var_user.getTareas()){
//                    if(tarea.getNivel()==nivel){
//                        ResponseListaTaskPorNivel input=new ResponseListaTaskPorNivel();
//                        input.setId(tarea.getId());
//                        input.setTarea(tarea.getTarea());
//                        respuesta.add(input);
//                    }
//                }
//            }
//
//            return respuesta;
//        }
//        throw new IdUsuarioNoEncontradoException("id de usuario no encontrado");
//
//    }




}
