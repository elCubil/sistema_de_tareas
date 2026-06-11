package com.example.apisistemanotas.Repository;

import com.example.apisistemanotas.Model.Dificultad;
import com.example.apisistemanotas.Model.Task;
import com.example.apisistemanotas.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TaskRepository extends JpaRepository<Task,Long> {

    List<Task> findByNivel(Dificultad level);
    List<Task> findByUsuarioIdAndNivel(Long id, Dificultad level);

}
