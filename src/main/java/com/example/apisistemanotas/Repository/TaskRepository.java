package com.example.apisistemanotas.Repository;

import com.example.apisistemanotas.Model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task,Long> {

}
