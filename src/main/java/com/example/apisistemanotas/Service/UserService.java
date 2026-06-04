package com.example.apisistemanotas.Service;


import com.example.apisistemanotas.DTO.RequestCreacionUser;
import com.example.apisistemanotas.DTO.ResponseCreacionUser;
import com.example.apisistemanotas.Excepciones.nicknameExistenteException;
import com.example.apisistemanotas.Model.User;
import com.example.apisistemanotas.Repository.UserRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class UserService {
    private UserRepository userRepository;

    public UserService(UserRepository userRepository){
        this.userRepository=userRepository;
    }

    public ResponseCreacionUser crearUser(RequestCreacionUser dto){

        if(userRepository.existsByNickname(dto.getNickname())){
            throw new nicknameExistenteException("escoge otro nickname, este ya existe");
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
}
