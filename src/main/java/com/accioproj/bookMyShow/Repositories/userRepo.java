package com.accioproj.bookMyShow.Repositories;

import com.accioproj.bookMyShow.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface userRepo extends JpaRepository<User,Integer> {
    Optional<User> findByEmailId(String emailId);

}
