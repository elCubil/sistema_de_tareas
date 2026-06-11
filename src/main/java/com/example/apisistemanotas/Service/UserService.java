package com.example.apisistemanotas.Service;


import com.example.apisistemanotas.DTO.RequestCreacionUser;
import com.example.apisistemanotas.DTO.ResponseCreacionUser;
import com.example.apisistemanotas.DTO.ResponseListaTareas;
import com.example.apisistemanotas.DTO.ResponseListaTareasMasPerfilUsuario;
import com.example.apisistemanotas.Excepciones.IdUsuarioNoEncontradoException;
import com.example.apisistemanotas.Excepciones.NicknameExistenteException;
import com.example.apisistemanotas.Model.Task;
import com.example.apisistemanotas.Model.User;
import com.example.apisistemanotas.Repository.UserRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private UserRepository userRepository;

    public UserService(UserRepository userRepository){
        this.userRepository=userRepository;
    }

    public ResponseCreacionUser crearUser(RequestCreacionUser dto){

        if(userRepository.existsByNickname(dto.getNickname())){
            throw new NicknameExistenteException("escoge otro nickname, este ya existe");
        }

        User var_user=new User();

        var_user.setNickname(dto.getNickname());
        var_user.setNombre(dto.getNombre());
        var_user.setApellido(dto.getApellido());
        var_user.setEdad(dto.getEdad());
        var_user.setCreatedAt(LocalDateTime.now());

        User answer=userRepository.save(var_user);

        ResponseCreacionUser respuesta=new ResponseCreacionUser();
        respuesta.setId(answer.getId());
        respuesta.setNickname(answer.getNickname());

        return respuesta;

    }

    public List<ResponseListaTareas> tareasPorUsuario(Long id){
        Optional<User> var_optional=userRepository.findById(id);
        if(var_optional.isPresent()){
            User var_user=var_optional.get();
            List<ResponseListaTareas> salida=new ArrayList<>();
            for(Task tarea:var_user.getTareas())
            {
                ResponseListaTareas input=new ResponseListaTareas();
                input.setId(tarea.getId());
                input.setTarea(tarea.getTarea());
                input.setNivel(tarea.getNivel());

                salida.add(input);

            }
            return salida;


        }
        throw new IdUsuarioNoEncontradoException("id no encontrado");
    }

    public ResponseListaTareasMasPerfilUsuario tareasPorUsuarioMasPerfilUsuario(Long id){
        Optional<User> var_optional_user=userRepository.findById(id);
        if(var_optional_user.isPresent()){
            User var_user=var_optional_user.get();
            ResponseListaTareasMasPerfilUsuario perfil_user=new ResponseListaTareasMasPerfilUsuario();
            perfil_user.setId(var_user.getId());
            perfil_user.setNickname(var_user.getNickname());

            List<ResponseListaTareas> listaTareas=new ArrayList<>();
            for(Task tarea:var_user.getTareas()){
                ResponseListaTareas var_response=new ResponseListaTareas();
                var_response.setId(tarea.getId());
                var_response.setTarea(tarea.getTarea());
                var_response.setNivel(tarea.getNivel());
                listaTareas.add(var_response);
            }
            perfil_user.setTareas(listaTareas);

            return perfil_user;
        }
        else{
            throw new IdUsuarioNoEncontradoException("id de usuario no encontrado");
        }
    }
}
