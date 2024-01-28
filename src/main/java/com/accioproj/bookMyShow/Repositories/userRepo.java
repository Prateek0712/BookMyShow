package com.accioproj.bookMyShow.Repositories;

import com.accioproj.bookMyShow.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface userRepo extends JpaRepository<User,Integer> {

}
