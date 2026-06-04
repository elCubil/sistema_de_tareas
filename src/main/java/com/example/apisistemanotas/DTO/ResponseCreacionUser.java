package com.example.apisistemanotas.DTO;

import com.example.apisistemanotas.Model.Task;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;
@NoArgsConstructor
@Setter
@Getter
public class ResponseCreacionUser {

    private Long id;


    private String nickname;


}
