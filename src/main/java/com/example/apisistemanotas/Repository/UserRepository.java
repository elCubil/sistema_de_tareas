package com.example.apisistemanotas.Repository;

import com.example.apisistemanotas.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User,Long> {

}
